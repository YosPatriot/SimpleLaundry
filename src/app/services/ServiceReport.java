package app.services;

import app.configurations.koneksi;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ServiceReport {
    ResultSet rs = null;
    Connection CC = new koneksi().connect();;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    ServiceCucian sc = new ServiceCucian();
    public void reportCucian(String dari, String sampai){
        String a = null;
        String b = null;
        int count = 0;
        Date from = Date.valueOf(dari);
        Date to = Date.valueOf(sampai);
        HashMap param = new HashMap();
             param.put("dari", dari);
            param.put("sampai",sampai);
        SimpleDateFormat ex = new SimpleDateFormat("dd-M-yyyy");
        try{
            stt = CC.createStatement();
            //sql = "SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status ='Cucian Siap Diambil' OR cucian.Status = 'Menunggu Pembayaran' OR cucian.Status='Selesai' ORDER BY cucian.Selesai AND Selesai>='"+dari+"' AND Selesai <='"+sampai+"'";
           // rs = stt.executeQuery(sql);
           //while (rs.next()){
                a = "Simply Fresh Laundry";
                b = "Jl. Drs. Esau Sesa Sowi, Manokwari Selatan, Kab. Manokwari, Papua Barat";
                //selesai = rs.getDate("Selesai");
               // param.put("selesai", ex.format(selesai));
           //}
            String icon = "src/app/report/logo.png";
            
            param.put("instansi", a);
            param.put("alamat", b);
            param.put("img", icon);
            
           
            InputStream file = new FileInputStream(new File("src/app/report/ReportCuci.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    public void reportTrx(String dari, String sampai){
        String a = null;
        String b = null;
        int count = 0;
        Date from = Date.valueOf(dari);
        Date to = Date.valueOf(sampai);
        HashMap param = new HashMap();
             param.put("dari", dari);
            param.put("sampai",sampai);
        SimpleDateFormat ex = new SimpleDateFormat("dd-M-yyyy");
        try{
            stt = CC.createStatement();
            //sql = "SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status ='Cucian Siap Diambil' OR cucian.Status = 'Menunggu Pembayaran' OR cucian.Status='Selesai' ORDER BY cucian.Selesai AND Selesai>='"+dari+"' AND Selesai <='"+sampai+"'";
           // rs = stt.executeQuery(sql);
           //while (rs.next()){
                a = "Simply Fresh Laundry";
                b = "Jl. Drs. Esau Sesa Sowi, Manokwari Selatan, Kab. Manokwari, Papua Barat";
                //selesai = rs.getDate("Selesai");
               // param.put("selesai", ex.format(selesai));
           //}
            String icon = "src/app/report/logo.png";
            
            param.put("instansi", a);
            param.put("alamat", b);
            param.put("img", icon);
            
           
            InputStream file = new FileInputStream(new File("src/app/report/ReportTransaksi.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void reportMember(String dari, String sampai){
        String a = null;
        String b = null;
        int count = 0;
        Date from = Date.valueOf(dari);
        Date to = Date.valueOf(sampai);
        HashMap param = new HashMap();
             param.put("dari", dari);
            param.put("sampai",sampai);
        SimpleDateFormat ex = new SimpleDateFormat("dd-M-yyyy");
        try{
            stt = CC.createStatement();
            //sql = "SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status ='Cucian Siap Diambil' OR cucian.Status = 'Menunggu Pembayaran' OR cucian.Status='Selesai' ORDER BY cucian.Selesai AND Selesai>='"+dari+"' AND Selesai <='"+sampai+"'";
           // rs = stt.executeQuery(sql);
           //while (rs.next()){
                a = "Simply Fresh Laundry";
                b = "Jl. Drs. Esau Sesa Sowi, Manokwari Selatan, Kab. Manokwari, Papua Barat";
                //selesai = rs.getDate("Selesai");
               // param.put("selesai", ex.format(selesai));
           //}
            String icon = "src/app/report/logo.png";
            
            param.put("instansi", a);
            param.put("alamat", b);
            param.put("img", icon);
            
           
            InputStream file = new FileInputStream(new File("src/app/report/ReportMember.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void reportNonMember(String dari, String sampai){
        String a = null;
        String b = null;
        int count = 0;
        Date from = Date.valueOf(dari);
        Date to = Date.valueOf(sampai);
        HashMap param = new HashMap();
             param.put("dari", dari);
            param.put("sampai",sampai);
        SimpleDateFormat ex = new SimpleDateFormat("dd-M-yyyy");
        try{
            stt = CC.createStatement();
            //sql = "SELECT * FROM Cucian INNER JOIN customer ON customer.IdCustomer = Cucian.IdCustomer INNER JOIN jeniscuci ON jeniscuci.IdJenisCuci = Cucian.IdJenisCuci JOIN transaksi ON transaksi.IdCucian=cucian.IdCucian WHERE cucian.Status ='Cucian Siap Diambil' OR cucian.Status = 'Menunggu Pembayaran' OR cucian.Status='Selesai' ORDER BY cucian.Selesai AND Selesai>='"+dari+"' AND Selesai <='"+sampai+"'";
           // rs = stt.executeQuery(sql);
           //while (rs.next()){
                a = "Simply Fresh Laundry";
                b = "Jl. Drs. Esau Sesa Sowi, Manokwari Selatan, Kab. Manokwari, Papua Barat";
                //selesai = rs.getDate("Selesai");
               // param.put("selesai", ex.format(selesai));
           //}
            String icon = "src/app/report/logo.png";
            
            param.put("instansi", a);
            param.put("alamat", b);
            param.put("img", icon);
            InputStream file = new FileInputStream(new File("src/app/report/ReportNonMember.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void cardMember(int id){
        try{
            HashMap param = new HashMap();
            param.put("id",id);
            String icon = "src/app/report/logo1.jpg";
            param.put("img", icon);
            InputStream file = new FileInputStream(new File("src/app/report/MemberCard.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
}
