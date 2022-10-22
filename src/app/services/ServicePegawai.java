package app.services;

import app.configurations.koneksi;
import app.model.ModelPegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServicePegawai {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public void getData(JTable table) throws SQLException{
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("ID Pegawai");
       model.addColumn("Nama");
       model.addColumn("Alamat");
       model.addColumn("No HP");
       model.addColumn("Email");
       model.addColumn("Jabatan");
       try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM karyawan");
            int no =0;
            while(rs.next()){
            no++;
            int IdPegawai = rs.getInt("IdKaryawan");
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String noHp = rs.getString("NoHp");
            String email = rs.getString("Email");
            String jabatan = rs.getString("Jabatan");
             model.addRow(new Object[]{no,IdPegawai,nama,alamat,noHp,email,jabatan});
             table.setModel(model);
            }
        }catch(SQLException e){
            System.err.println(e);
        } 
    }
    public void addPegawai(ModelPegawai data)throws SQLException{
        try{
           sql= "INSERT INTO karyawan (Nama, Alamat, NoHP,Email,Jabatan) values (?,?,?,?,?)";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getAlamat());
            pst.setString(3, data.getNoHp());
            pst.setString(4, data.getEmail());
            pst.setString(5, data.getJabatan());
        rs = pst.getGeneratedKeys();
        rs.first();
        pst.execute();
        int IdPegawai = rs.getInt(1);
        data.setPegawaiID(IdPegawai);
        System.out.println("Keys : "+IdPegawai);
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void updatePegawai(ModelPegawai data)throws SQLException{
        try{
           sql= "Update karyawan Set Nama=?, Alamat=?, NoHP=?, Email=?, Jabatan=? WHERE IdKaryawan="+data.getPegawaiID()+" limit 1";
           pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getNama());
            pst.setString(2, data.getAlamat());
            pst.setString(3, data.getNoHp());
            pst.setString(4, data.getEmail());
            pst.setString(5, data.getJabatan());
        pst.execute();
        rs.close();
        pst.close();   
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void deletePegawai(int pegawaiID){
        try{
            sql="DELETE FROM karyawan WHERE IdKaryawan = "+pegawaiID+"";
            pst = CC.prepareStatement(sql);
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
}
