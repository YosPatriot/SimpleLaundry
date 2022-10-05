package app.services;

import app.configurations.koneksi;
import app.model.ModelMember;
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
    public void addPegawai(ModelMember data)throws SQLException{
        try{
           sql= "INSERT INTO Customer (Nama, Alamat, NoHP,Keterangan) values (?,?,?,'Member')";
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
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
