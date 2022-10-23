package app.services;

import app.configurations.koneksi;
import app.model.ModelCucian;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServiceCucian {

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
    private double diskon;
    ModelTransaksi mt = new ModelTransaksi();
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
            int berat = rs.getInt("Cucian.Berat/Qty/Meter");
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
        try{
           sql= "INSERT INTO Cucian (IdCustomer,IdJenisCuci,Tgl_Masuk,Estimasi,Berat/Qty/Meter,Status) values (?,?,?,?,?,?)";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, Integer.parseInt("(SELECT IdCustomer FROM Customer WHERE Nama='"+data.getCustomer().getNama()+"')"));
            pst.setInt(2, Integer.parseInt("(SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"')"));
            pst.setDate(3, data.getTglMasuk());
            pst.setDate(4, data.getEstimasi());
            pst.setInt(5, data.getBerat());
            pst.setInt(6, data.getBerat());
            pst.setString(7, data.getStatus());
        rs = pst.getGeneratedKeys();
        rs.first();
        pst.execute();
        int cucianID = rs.getInt(1);
        data.setCucianID(cucianID);
        System.out.println("Keys : "+cucianID);
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void addTransaksi(ModelTransaksi data){
         try{
           sql= "INSERT INTO transaksi (IdCucian, Subtotal, Diskon, GrandTotal,) values (?,?,?,?)";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getCucian().getCucianID());
            pst.setDouble(2, data.getSubTotal());
            pst.setDouble(3, data.getDiskon());
            pst.setDouble(4, data.getGrandTotal());
        rs = pst.getGeneratedKeys();
        rs.first();
        pst.execute();
        int transaksiID = rs.getInt(1);
        data.setTransaksiID(transaksiID);
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
    public void setNominal(JLabel nominal,JComboBox paket){
         try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM jeniscuci WHERE JenisCuci='"+paket.getSelectedItem()+"'");
            while(rs.next()){
               DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
               DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
                formatRp.setCurrencySymbol("Rp. ");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');
               kursIndonesia.setDecimalFormatSymbols(formatRp);   
               nominal.setText(kursIndonesia.format(rs.getInt("Harga")));
               mt.setSubTotal(rs.getInt("Harga"));
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void isMember(int kode, JLabel nominal) throws SQLException{
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM Customer WHERE IdCustomer ="+kode+" AND Keterangan ='Member'");
            if(rs.next()){
                setMember(true);
                System.out.println(mt.getSubTotal());
                mt.setDiskon(diskon=0.05*mt.getSubTotal());
                mt.setGrandTotal(mt.getSubTotal() - mt.getDiskon());
                nominal.setText(String.valueOf(mt.getGrandTotal()));
            }else{
                setMember(false);
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
