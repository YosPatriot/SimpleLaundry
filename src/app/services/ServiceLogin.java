
package app.services;

import app.configurations.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import app.main.Dashboard;


public class ServiceLogin {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    
    public void checkConnection(){
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM accounts");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public void Auth(String Username, String Password, JFrame frame){
        try{
            sql="SELECT * FROM accounts WHERE Username = '"+Username+
            "' and Password = '"+Password+"'";
            pst = CC.prepareStatement(sql);
            rs = pst.executeQuery();
            
        if(rs.next()){
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                int RoleId = rs.getInt("RoleId");
         if (Password.equals(pass) && Username.equals(user)){
                    JOptionPane.showMessageDialog(frame, "Login Berhasil");
                    UserSession.setUserId(RoleId);
                    UserSession.setUserLogin(user);
                    
                    if(RoleId == 1){
                        //noti.showNotification();
                        Dashboard a = new Dashboard();
                        a.setVisible(true); 
                        frame.dispose();
                    }
                    else{
                        //noti.showNotification();
                        Dashboard mu=new Dashboard();
                        mu.setVisible(true);
                        frame.dispose();
         
             
                    }
                }
                else
                JOptionPane.showMessageDialog(null, "Username atau Password anda salah");  
                //err.showNotification();
            }        
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
