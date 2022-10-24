package app.services;

import app.configurations.koneksi;
import app.model.ModelDashboard;
import app.model.ModelCustomer;
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
    ServiceCucian sc = new ServiceCucian();
    public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("Customer ID");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
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
             model.addRow(new Object[]{no,CustomerID,nama,alamat,noHp,keterangan});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void add(ModelCustomer data,double diskon)throws SQLException{
        try{
           sql= "INSERT INTO Customer (Nama, Alamat, NoHP,Keterangan) values (?,?,?,'Member')";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getAlamat());
            pst.setString(3, data.getNoHP());
            pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int IdMember = rs.getInt(1);
        data.setMemberID(IdMember);
        System.out.println("Keys : "+IdMember);
        rs.close();
        pst.close();
        sc.mt.setDiskon(diskon);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void delete(int MemberId){
        try{
            sql="DELETE FROM Customer WHERE IdCustomer = "+MemberId+"";
            pst = CC.prepareStatement(sql);
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    public void update(ModelCustomer data, int MemberID)throws SQLException{
        try{
           sql= "Update Customer Set Nama=?, Alamat=?, NoHP=?, Keterangan=? WHERE IdCustomer="+MemberID+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getAlamat());
            pst.setString(3, data.getNoHP());
            pst.setString(4, "Member");
        pst.execute();
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
