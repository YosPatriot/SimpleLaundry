package app.services;

import app.configurations.koneksi;
import app.model.ModelDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServiceDashboard {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    
    public List<ModelDashboard> getData() throws SQLException{
        List<ModelDashboard> list = new ArrayList<>();
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM cucian INNER JOIN customer ON customer.IdCustomer = cucian.IdCustomer"
                    + " INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = cucian.IdJenisCuci");
            int no =0;
            while(rs.next()){
            no++;
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String noHp = rs.getString("NoHP");
            String status = rs.getString("Status");
            
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
        rs.close();
        pst.close();
        return list;
    }
}
