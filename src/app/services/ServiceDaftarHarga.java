package app.services;

import app.configurations.koneksi;
import app.model.ModelDaftarHarga;
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

public class ServiceDaftarHarga {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("ID Jenis Cucian");
       model.addColumn("Jenis Cucian");
       model.addColumn("Harga Berat/Meter/Qty");
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM jeniscuci");
            int no =0;
            while(rs.next()){
            no++;
            int idJenisCuci = rs.getInt("IdJenisCuci");
            String jenisCuci = rs.getString("JenisCuci");
            int harga = rs.getInt("Harga");
             model.addRow(new Object[]{no,idJenisCuci,jenisCuci,harga});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void add(ModelDaftarHarga data)throws SQLException{
        try{
           sql= "INSERT INTO jeniscuci (JenisCuci,Harga) values (?,?)";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getJenisCuci());
            pst.setInt(2, data.getHarga());
        rs = pst.getGeneratedKeys();
        rs.first();
        pst.execute();
        int idHarga = rs.getInt(1);
        data.setIdJenis(idHarga);
        System.out.println("Keys : "+idHarga);
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void delete(int idHarga){
        try{
            sql="DELETE FROM jeniscuci WHERE IdJenisCuci = "+idHarga+"";
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
