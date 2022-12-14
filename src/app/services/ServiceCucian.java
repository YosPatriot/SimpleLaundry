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
    public ModelCustomer dataCustomer;
    public ModelCucian dataCucian = new ModelCucian();
    public int berat;
    config con = new config();
    public ModelTransaksi mt = new ModelTransaksi();
     public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Cucian");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
       model.addColumn("Customer");
       model.addColumn("Jenis Cucian");
       model.addColumn("Tanggal Masuk");
       model.addColumn("Berat/Meter/Qty");
       model.addColumn("Status");
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM cucian INNER JOIN customer ON customer.IdCustomer = cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = cucian.IdJenisCuci "
                    + "INNER JOIN transaksi on transaksi.IdCucian = cucian.IdCucian WHERE cucian.Status='Menunggu Antrian'");
            int no =0;
            while(rs.next()){
            int cucianID = rs.getInt("Cucian.IdCucian");
            String nama = rs.getString("customer.Nama");
            String alamat = rs.getString("customer.Alamat");
            String noHP = rs.getString("customer.NoHP");
            String tipe = rs.getString("customer.Keterangan");
            String jenis = rs.getString("jeniscuci.JenisCuci");
            Date tglMasuk = rs.getDate("Cucian.Tgl_Masuk");
            String tglKeluar = rs.getString("Cucian.Tgl_Keluar");
            int berat = rs.getInt("Cucian.Berat");
            String status = rs.getString("Cucian.Status");
            int total = rs.getInt("transaksi.GrandTotal");
             model.addRow(new Object[]{cucianID,nama,alamat,noHP,tipe,jenis,tglMasuk,berat,status});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void add(ModelCucian data)throws SQLException{
        if(isMember()==true){
        try{
           sql= "INSERT INTO Cucian (IdCustomer,IdJenisCuci,Berat,Status) values ((SELECT IdCustomer FROM Customer WHERE Nama='"+data.getCustomer().getNama()+"' AND Alamat='"+data.getCustomer().getAlamat()+"' AND NoHP='"+data.getCustomer().getNoHP()+"'),"
                   + "(SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"'),"+data.getBerat()+",'Menunggu Antrian')";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int cucianID = rs.getInt(1);
        berat = data.getBerat();
        data.setCucianID(cucianID);
        dataCucian.setBerat(berat);
        //System.out.println("berat "+berat);
        System.out.println("Keys : "+cucianID);
        addTransaksi(data);
        rs.close();
        pst.close();
        }catch(SQLException e){
            System.err.println(e);
        }
        }else{
         addCustomer(data); 
             try{
           sql= "INSERT INTO Cucian (IdCustomer,IdJenisCuci,Berat,Status) values ((SELECT IdCustomer FROM Customer WHERE Nama='"+data.getCustomer().getNama()+"'),"
                   + "(SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"'),"+data.getBerat()+",'Menunggu Antrian')";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int cucianID = rs.getInt(1);                                                                                                        
        data.setCucianID(cucianID);
        System.out.println("Keys : "+cucianID);
        addTransaksi(data);
        rs.close();
        pst.close();   
         }catch(SQLException e){
            System.err.println(e);
        }
       }
    }
    public void addCustomer(ModelCucian data) throws SQLException{
        String sql = "INSERT INTO customer (Nama, Alamat, NoHP, Keterangan) SELECT * FROM (SELECT '"+data.getCustomer().getNama()+"', '"+data.getCustomer().getAlamat()+"', '"+data.getCustomer().getNoHP()+"', 'Non-Member') AS tmp "
                + "WHERE NOT EXISTS ( SELECT Nama,Alamat,NoHP,Keterangan FROM customer WHERE "
                + "Nama = '"+data.getCustomer().getNama()+"' AND Alamat = '"+data.getCustomer().getAlamat()+"' AND NoHP='"+data.getCustomer().getNoHP()+"' AND Keterangan='Non-Member' ) LIMIT 1;";
        pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        rs.close();
        pst.close();
    }
    public void addTransaksi(ModelCucian data){
        try{ 
            System.out.println(data.getTransaksi().getStatus());
          if(data.getTransaksi().getStatus().equals("Bayar Sekarang")){
              String result="Lunas";
               sql= "INSERT INTO transaksi (IdCucian, Subtotal, Diskon, GrandTotal,StatusTransaksi) values (?,?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getCucianID());
            pst.setDouble(2, data.getTransaksi().getSubTotal());
            pst.setDouble(3, data.getTransaksi().getDiskon());
            pst.setDouble(4, data.getTransaksi().getGrandTotal());
            pst.setString(5, result);
              System.out.println(data.getCucianID());
              System.out.println(data.getTransaksi().getSubTotal());
            pst.execute();       
            rs = pst.getGeneratedKeys();
            rs.first();
            int transaksiID = rs.getInt(1);
            data.getTransaksi().setTransaksiID(transaksiID);
            System.out.println("Keys : "+transaksiID);
              System.out.println("");
              System.out.println("Sub total ="+data.getTransaksi().getSubTotal());
              System.out.println("diskon total ="+data.getTransaksi().getDiskon());
              System.out.println("grand total ="+data.getTransaksi().getGrandTotal());
            rs.close();
            pst.close();   
          }else if(data.getTransaksi().getStatus().equals("Bayar Nanti")){
              String result="Belum Lunas";
               sql= "INSERT INTO transaksi (IdCucian, Subtotal, Diskon, GrandTotal,StatusTransaksi) values (?,?,?,?,?)";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, data.getCucianID());
            pst.setDouble(2, data.getTransaksi().getSubTotal());
            pst.setDouble(3, data.getTransaksi().getDiskon());
            pst.setDouble(4, data.getTransaksi().getGrandTotal());
            pst.setString(5, result);
            pst.execute();
            rs = pst.getGeneratedKeys();
            rs.first();
            int transaksiID = rs.getInt(1);
            data.getTransaksi().setTransaksiID(transaksiID);
            System.out.println("Keys : "+transaksiID);
            rs.close();
            pst.close();   
          } 
       
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
        int berat = dataCucian.getBerat();
        System.out.println(berat);
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
                dataCustomer = new ModelCustomer(kode,nama,alamat,noHP);
               }else if (status.equals("Non-Member")){
                String nama = rs.getString("Nama");
                String alamat = rs.getString("Alamat");
                String noHP = rs.getString("NoHP");
                setMember(false);
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
            sql="DELETE cucian,transaksi FROM cucian INNER JOIN transaksi ON cucian.IdCucian = transaksi.IdCucian WHERE cucian.IdCucian = "+idCucian+"";
            pst = CC.prepareStatement(sql);
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    public void updateCucian(ModelCucian data)throws SQLException{
        try{
           sql= "UPDATE cucian,jeniscuci,customer,transaksi\n" +
                "SET customer.Nama = '"+data.getCustomer().getNama()+"',\n"+
                "    customer.Alamat = '"+data.getCustomer().getAlamat()+"',\n"+
                "    customer.NoHP = '"+data.getCustomer().getNoHP()+"',\n"+
                "    cucian.IdJenisCuci= (SELECT IdJenisCuci FROM jeniscuci WHERE JenisCuci='"+data.getJenisCucian()+"'),\n"+
                "    cucian.Berat = "+data.getBerat()+",\n"+
                "    transaksi.Subtotal = "+data.getTransaksi().getSubTotal()+",\n"+
                "    transaksi.Diskon = "+data.getTransaksi().getDiskon()+",\n"+
                "    transaksi.GrandTotal = "+data.getTransaksi().getGrandTotal()+"\n"+
                "WHERE\n" +
                "    cucian.IdCucian = transaksi.IdCucian\n" +
                "    AND cucian.IdJenisCuci = jeniscuci.IdJenisCuci AND cucian.IdCustomer = customer.IdCustomer limit 1";
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs.close();
            pst.close(); 
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
