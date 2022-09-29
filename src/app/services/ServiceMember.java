package app.services;

import app.configurations.koneksi;
import app.model.ModelDashboard;
import app.model.ModelMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ServiceMember {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public void getData(JTable table) throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("Customer ID");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
       model.addColumn("Kode Member");
       model.addColumn("Keterangan");
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM customer");
            int no =0;
            while(rs.next()){
            no++;
            int CustomerID = rs.getInt("IdCustomer");
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String noHp = rs.getString("NoHP");
            String keterangan = rs.getString("Keterangan");
            int kodeMember = rs.getInt("KodeMember");
             model.addRow(new Object[]{no,CustomerID,nama,alamat,noHp,kodeMember,keterangan});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void addMember(ModelMember data)throws SQLException{
        try{
           sql= "INSERT INTO Customer (Nama, Alamat, NoHP) values (?,?,?)";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getAlamat());
            pst.setString(3, data.getNoHP());
        rs = pst.getGeneratedKeys();
        rs.first();
        pst.execute();
        int IdMember = rs.getInt(1);
        data.setMemberID(IdMember);
        System.out.println("Keys : "+IdMember);
        rs.close();
        pst.close();   
        String sql1 = "INSERT INTO Member (CustomerID) Values (?)";
        PreparedStatement pstt = CC.prepareStatement(sql1);
        pstt.setInt(1, IdMember);
        ResultSet rst = pstt.getGeneratedKeys();
        pstt.execute();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
