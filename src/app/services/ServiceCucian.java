package app.services;

import app.configurations.config;
import app.configurations.koneksi;
import app.model.ModelCucian;
import app.model.ModelCustomer;
import app.model.ModelDaftarHarga;
import app.model.ModelTransaksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServiceCucian {

    /**
     * @return the statusBayar
     */
    public JRadioButton getStatusBayar() {
        return statusBayar;
    }

    /**
     * @param statusBayar the statusBayar to set
     */
    public void setStatusBayar(JRadioButton statusBayar) {
        this.statusBayar = statusBayar;
    }

    public double getDiskon() {
        return diskon;
    }
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public boolean isMember() {
        return Member;
    }
    public void setMember(boolean Member) {
        this.Member = Member;
    }

    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
    private boolean Member;
    private JRadioButton statusBayar;
    private double diskon;
    public ModelCustomer dataCustomer;
    config con = new config();
    public ModelTransaksi mt = new ModelTransaksi();
     public void getData(JTable table) throws SQLException{
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM cucian INNER JOIN customer ON customer.IdCustomer = cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = cucian.IdJenisCuci "
                    + "INNER JOIN transaksi on transaksi.IdCucian = cucian.IdCucian");
            int no =0;
            while(rs.next()){
            int cucianID = rs.getInt("Cucian.IdCucian");
            String nama = rs.getString("customer.Nama");
            String alamat = rs.getString("customer.Alamat");
            String noHP = rs.getString("customer.NoHP");
            String tipe = rs.getString("customer.Keterangan");
            String jenis = rs.getString("jeniscuci.JenisCuci");
            Date tglMasuk = rs.getDate("Cucian.Tgl_Masuk");
            String Estimasi = rs.getString("Cucian.Estimasi");
            String tglKeluar = rs.getString("Cucian.Tgl_Keluar");
            int berat = rs.getInt("Cucian.Berat");
            String status = rs.getString("Cucian.Status");
            int total = rs.getInt("transaksi.GrandTotal");
             model.addRow(new Object[]{cucianID,nama,alamat,noHP,tipe,jenis,tglMasuk,Estimasi,berat,status});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void add(ModelCucian data)throws SQLException{
        if(isMember()==true){
        try{
           sql= "INSERT INTO Cucian (IdCustomer,IdJenisCuci,Estimasi,Berat,Status) values ((SELECT IdCustomer FROM Customer WHERE Nama='"+data.getCustomer().getNama()+"'),"
                   + "(SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"'),DATE_ADD(CURDATE(),INTERVAL 3 DAY),"+data.getBerat()+",'Menunggu Antrian')";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int cucianID = rs.getInt(1);
        data.setCucianID(cucianID);
        System.out.println("Keys : "+cucianID);
        rs.close();
        pst.close();
        addTransaksi(data);
        }catch(SQLException e){
            System.err.println(e);
        }
        }else{
         addCustomer(data); 
             try{
           sql= "INSERT INTO Cucian (IdCustomer,IdJenisCuci,Estimasi,Berat,Status) values ((SELECT IdCustomer FROM Customer WHERE Nama='"+data.getCustomer().getNama()+"'),"
                   + "(SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"'),DATE_ADD(CURDATE(),INTERVAL 3 DAY),"+data.getBerat()+",'Menunggu Antrian')";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int cucianID = rs.getInt(1);
        data.setCucianID(cucianID);
        System.out.println("Keys : "+cucianID);
        rs.close();
        pst.close();   
        addTransaksi(data);
        }catch(SQLException e){
            System.err.println(e);
        }
       }
    }
    public void addCustomer(ModelCucian data) throws SQLException{
        String sql = "INSERT INTO customer (Nama, Alamat, NoHP, Keterangan) VALUES (?,?,?,?)";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getCustomer().getNama());
            pst.setString(2, data.getCustomer().getAlamat());
            pst.setString(3, data.getCustomer().getNoHP());
            pst.setString(4, "Non-Member");
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int CustomerId = rs.getInt(1);
        data.getCustomer().setMemberID(CustomerId);
        System.out.println("Keys : "+CustomerId);
        rs.close();
        pst.close();
    }
    public void addTransaksi(ModelCucian data){
        try{      
         String status = getStatusBayar().getText();
          if(status.equals("Bayar Sekarang")){
              String result="Lunas";
               sql= "INSERT INTO transaksi (IdCucian, Subtotal, Diskon, GrandTotal,StatusTransaksi) values (?,?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getCucianID());
            pst.setDouble(2, data.getTransaksi().getSubTotal());
            pst.setDouble(3, data.getTransaksi().getDiskon());
            pst.setDouble(4, data.getTransaksi().getGrandTotal());
            pst.setString(5, result);
          }else if(status.equals("Bayar Nanti")){
              String result="Belum Lunas";
               sql= "INSERT INTO transaksi (IdCucian, Subtotal, Diskon, GrandTotal,StatusTransaksi) values (?,?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getCucianID());
            pst.setDouble(2, data.getTransaksi().getSubTotal());
            pst.setDouble(3, data.getTransaksi().getDiskon());
            pst.setDouble(4, data.getTransaksi().getGrandTotal());
            pst.setString(5, result);
          } 
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int transaksiID = rs.getInt(1);
        data.getTransaksi().setTransaksiID(transaksiID);
        System.out.println("Keys : "+transaksiID);
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void getJenis(JComboBox paket){
         try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM jeniscuci");
            while(rs.next()){

                paket.addItem(rs.getString("JenisCuci"));  
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void setNominal(String select){
         try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM jeniscuci WHERE JenisCuci='"+select+"'");
           if(rs.next()){
              double sub = rs.getDouble("Harga");
              mt = new ModelTransaksi();
              mt.setSubTotal(sub);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void isMember(int kode, JLabel nominal) throws SQLException{
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM Customer WHERE IdCustomer ="+kode+"");
            if(rs.next()){
                String status = rs.getString("Keterangan");
                if(status.equals("Member")){
                setMember(true);
                String nama = rs.getString("Nama");
                String alamat = rs.getString("Alamat");
                String noHP = rs.getString("NoHP");
                mt.setGrandTotal(mt.getSubTotal()-(mt.getSubTotal()*con.getDiskon()));
                nominal.setText(String.valueOf((double) mt.getGrandTotal()));
                System.out.println(con.getDiskon());
                dataCustomer = new ModelCustomer(kode,nama,alamat,noHP);
               }else if (status.equals("Non-Member")){
                String nama = rs.getString("Nama");
                String alamat = rs.getString("Alamat");
                String noHP = rs.getString("NoHP");
                setMember(false);
                nominal.setText(String.valueOf((double) mt.getSubTotal()));
                dataCustomer = new ModelCustomer(kode,nama,alamat,noHP);
               }           
            }else{
                setMember(false);
                nominal.setText(String.valueOf((double) mt.getSubTotal()));
                
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Format Kode Member Salah");
        }
    }
    public void delete(int idCucian){
        try{
            sql="DELETE FROM cucian WHERE IdCucian = "+idCucian+"";
            pst = CC.prepareStatement(sql);
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    public void update(ModelDaftarHarga data)throws SQLException{
        try{
           sql= "Update jeniscuci Set JenisCuci=?, Harga=? WHERE IdJenisCuci="+data.getIdJenis()+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getJenisCuci());
            pst.setInt(2, data.getHarga());
        pst.execute();
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
