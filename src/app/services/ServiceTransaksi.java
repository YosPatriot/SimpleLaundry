
package app.services;

import app.configurations.koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ServiceTransaksi {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql; 
     public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Transaksi");
       model.addColumn("ID Cucian");
       model.addColumn("Nama");
       model.addColumn("Jenis Cuci");
       model.addColumn("Sub Total");
       model.addColumn("Diskon");
       model.addColumn("Total Bayar");
       model.addColumn("Tanggal");
       model.addColumn("Status");
      
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM cucian INNER JOIN customer ON customer.IdCustomer = cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = cucian.IdJenisCuci "
                    + "INNER JOIN transaksi on transaksi.IdCucian = cucian.IdCucian WHERE Transaksi.StatusTransaksi='Belum Lunas'");
            int no =0;
            while(rs.next()){
                int transaksiID = rs.getInt("transaksi.IdTrx");
                int cucianID = rs.getInt("Cucian.IdCucian");
                String nama = rs.getString("customer.Nama");
                String jenis = rs.getString("jeniscuci.JenisCuci");
                int sub = rs.getInt("transaksi.Subtotal");
                int diskon = rs.getInt("transaksi.Diskon");
                int grand = rs.getInt("transaksi.GrandTotal");
                Date tanggal = rs.getDate("transaksi.Tanggal");
                String status = rs.getString("transaksi.StatusTransaksi");
                model.addRow(new Object[]{transaksiID,cucianID,nama,jenis,sub,diskon,grand,tanggal,status});
                table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
}
