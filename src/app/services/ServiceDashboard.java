package app.services;

import app.configurations.koneksi;
import app.model.ModelDashboard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ServiceDashboard {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    ModelDashboard md = new ModelDashboard();
    
    public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel() ;
       model.addColumn("ID Cucian");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
       model.addColumn("Tanggal Masuk");
       model.addColumn("Jenis Cucian");
       model.addColumn("Berat/Qty/Meter");
       model.addColumn("Status Cucian");
       model.addColumn("Status Bayar");
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer"
                    + " INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status='Menunggu Antrian' OR cucian.Status='Di Proses' ORDER by Tgl_Masuk");
            int no =0;
              while(rs.next()){
                no++;
                int id = rs.getInt("cucian.IdCucian");
                String nama = rs.getString("Nama");
                String alamat = rs.getString("Alamat");
                String noHp = rs.getString("NoHP");
                Date tglMasuk = rs.getDate("Tgl_Masuk");
                String jenis = rs.getString("JenisCuci");
                String status = rs.getString("Status"); 
                int pemasukan = rs.getInt("transaksi.GrandTotal");
                int qty = rs.getInt("Berat");
                String statusBayar = rs.getString("transaksi.StatusTransaksi");
                model.addRow(new Object[]{id,nama,alamat,noHp,tglMasuk,jenis,qty,status,statusBayar});
                table.setModel(model);
              }
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
    }
    public void getDataSelesai(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel() ;
     
       model.addColumn("ID Cucian");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
       model.addColumn("Selesai");
       model.addColumn("Keluar");
       model.addColumn("Jenis Cucian");
       model.addColumn("Status Cucian");
       table.getColumnModel().getColumn(4).setWidth(200);
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer"
                    + " INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status ='Cucian Siap Diambil' OR cucian.Status = 'Menunggu Pembayaran' OR cucian.Status='Selesai' ORDER BY cucian.Selesai");
            int no =0;
              while(rs.next()){
                no++;
                int id = rs.getInt("cucian.IdCucian");
                String nama = rs.getString("Nama");
                String alamat = rs.getString("Alamat");
                String noHp = rs.getString("NoHP");
                Date tglMasuk = rs.getDate("Tgl_Masuk");
                Date selesai = rs.getDate("Selesai");
                Date keluar = rs.getDate("Tgl_Keluar");
                String jenis = rs.getString("JenisCuci");
                String status = rs.getString("Status"); 
                int pemasukan = rs.getInt("transaksi.GrandTotal");
                int qty = rs.getInt("Berat");
                String statusBayar = rs.getString("transaksi.StatusTransaksi");
                model.addRow(new Object[]{id,nama,alamat,noHp,selesai,keluar,jenis,status});
                table.setModel(model);
              }
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
    }
    public String getCucian(){
        String result="";
         try{
            stt=CC.createStatement();
            sql = "SELECT COUNT(IdCucian) AS NumberOfLaundry FROM Cucian WHERE DATE(Tgl_Masuk) = CURDATE()";
            rs = stt.executeQuery(sql);
            if(rs.next()){
                result = rs.getString("NumberOfLaundry");
            }
         }catch(SQLException e){
         
         }
        return result;
    }
    public String getPemasukan(){
        String result="";
         try{
            stt=CC.createStatement();
            sql = "SELECT SUM(GrandTotal) AS Total FROM transaksi WHERE DATE(Tanggal) = CURDATE() AND StatusTransaksi = 'Lunas'";
            rs = stt.executeQuery(sql);
            if(rs.next()){
                result = String.valueOf(rs.getInt("Total"));
            }
         }catch(SQLException e){
         
         }
        return result;
    }
    public String getMember(){
    String result="";
         try{
            stt=CC.createStatement();
            sql = "SELECT COUNT(cucian.IdCustomer) AS NumberOfMember FROM Cucian JOIN Customer ON Cucian.IdCustomer = Customer.IdCustomer WHERE customer.Keterangan ='Member'";
            rs = stt.executeQuery(sql);
            if(rs.next()){
                result = rs.getString("NumberOfMember");
            }
         }catch(SQLException e){
         
         }
        return result;
    }
    public void prosesCucian(ModelDashboard data){
          try{
           sql= "Update cucian Set Status='Di Proses' WHERE IdCucian="+data.getIdCucian()+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           pst.execute();
           rs.close();
           pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    
    }
    public void selesaiCucian(ModelDashboard data){
          try{
           sql= "Update cucian Set Status='"+data.getStatus()+"', Selesai = CURRENT_TIMESTAMP() WHERE IdCucian="+data.getIdCucian()+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           pst.execute();
           rs.close();
           pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    
    }
    public void ambilCucian(ModelDashboard data){
          try{
           sql= "Update cucian Set Status='Selesai',Tgl_Keluar = CURRENT_TIMESTAMP() WHERE IdCucian="+data.getIdCucian()+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           pst.execute();
           rs.close();
           pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    
    }
}
