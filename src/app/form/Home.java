package app.form;

import app.component.Form;
import app.model.ModelDashboard;
import app.services.ServiceDashboard;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Home extends Form {
    int idCucian,idSelesai;
    String status,statusSelesai,statusBayar;
    
    ServiceDashboard sd = new ServiceDashboard();
    public Home() throws SQLException {
        initComponents();
        getTable();
        txtPemesan.setText(sd.getCucian());
        txtPemasukan.setText(sd.getPemasukan());
        txtMember.setText(sd.getMember());
        System.out.println(sd.getMember());
        btnProses.setEnabled(false);
        btnCucian.setEnabled(false);
        btnAmbil.setEnabled(false);
    }
    
    private void getTable(){
        try {
            sd.getData(table);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sd.getDataSelesai(table1);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void prosesCucian(){
        ModelDashboard data = new ModelDashboard(idCucian,"","","",status);
        sd.prosesCucian(data);
        JOptionPane.showMessageDialog(null,"Cucian Di Proses !!");
    }
    private void prosesSelesai(){
        int response = JOptionPane.showConfirmDialog(this, "Apakah Cucian Telah Siap ?", "Konfirmasi Cucian", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
        String result = null;
            if(statusBayar.equals("Belum Lunas")){
            result="Menunggu Pembayaran";
            }else if(statusBayar.equals("Lunas")){
                result="Cucian Siap Diambil";
            }
            ModelDashboard data = new ModelDashboard(idCucian,"","","",result);
            sd.selesaiCucian(data);
        }else if(response==JOptionPane.NO_OPTION){
            System.err.println("Failed");
        }
    }
    private void prosesAmbil(){
        String result = null;
            if(statusSelesai.equals("Cucian Siap Diambil")){
                result="Selesai";
            ModelDashboard data = new ModelDashboard(idSelesai,"","","",result);
            sd.ambilCucian(data);
            JOptionPane.showMessageDialog(null, "Cucian Berhasil Diambil !");
            }else if(statusSelesai.equals("Menunggu Pembayaran")){
               JOptionPane.showMessageDialog(null, "Silahkan lakukan pembayaran terlebih dahulu !");
            }
           
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new app.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPemasukan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        roundPanel2 = new app.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPemesan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roundPanel3 = new app.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMember = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        btnCucian = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnAmbil = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 688));

        roundPanel1.setBackground(new java.awt.Color(85, 194, 239));
        roundPanel1.setPreferredSize(new java.awt.Dimension(279, 151));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icon/money.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pemasukan Hari Ini");

        txtPemasukan.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtPemasukan.setForeground(new java.awt.Color(255, 255, 255));
        txtPemasukan.setText("000");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rp");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addComponent(jLabel1)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtPemasukan)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(68, 30, 182));
        roundPanel2.setPreferredSize(new java.awt.Dimension(279, 148));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icon/pesanan.png"))); // NOI18N

        txtPemesan.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtPemesan.setForeground(new java.awt.Color(255, 255, 255));
        txtPemesan.setText("000");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cucian Hari Ini");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPemesan))
                .addGap(24, 24, 24))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtPemesan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(191, 80, 233));
        roundPanel3.setPreferredSize(new java.awt.Dimension(265, 151));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icon/member.png"))); // NOI18N

        txtMember.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtMember.setForeground(new java.awt.Color(255, 255, 255));
        txtMember.setText("000");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Member Aktif");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtMember))
                .addGap(17, 17, 17))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(txtMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cucian", "Nama", "Alamat", "No HP", "Tanggal Masuk", "Jenis Cucian", "Berat/Qty/Meter", "Status Cucian", "Status Bayar"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 27, 184));
        jLabel4.setText("Daftar Antrian");

        btnProses.setText("Proses Cucian");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnCucian.setText("Cucian Selesai");
        btnCucian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCucianActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 27, 184));
        jLabel5.setText("Daftar Cucian Selesai");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cucian", "Nama", "Alamat", "No HP", "Selesai", "Keluar", "Jenis Cucian", "Status Cucian"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        btnAmbil.setText("Ambil Cucian");
        btnAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCucian)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(btnAmbil))
                                .addGap(795, 795, 795)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProses)
                    .addComponent(btnCucian))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAmbil)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        idCucian = Integer.parseInt((table.getModel().getValueAt(row,0)).toString());
        String jenis = (table.getModel().getValueAt(row,2)).toString();
        status = (table.getModel().getValueAt(row,7)).toString();
        statusBayar = (table.getModel().getValueAt(row,8)).toString();
        if(status.equals("Menunggu Antrian")){
            btnProses.setEnabled(true);
            btnCucian.setEnabled(false);
        }else if(status.equals("Di Proses")){
            btnProses.setEnabled(false);
            btnCucian.setEnabled(true);
        }
        System.out.println("ID Cucian : "+idCucian);
        System.out.println("Status : "+idCucian);
    }//GEN-LAST:event_tableMouseReleased

    private void table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseReleased
        // TODO add your handling code here:
        int row = table1.getSelectedRow();
        idSelesai = Integer.parseInt((table1.getModel().getValueAt(row,0)).toString());
        String jenis = (table1.getModel().getValueAt(row,2)).toString();
        String harga = (table1.getModel().getValueAt(row,3)).toString();
        statusSelesai = (table1.getModel().getValueAt(row,7)).toString();
        btnAmbil.setEnabled(true);
        System.out.println("ID Cucian : "+idCucian);
        System.out.println("Status : "+idCucian);
    }//GEN-LAST:event_table1MouseReleased

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
       
        try {
             prosesCucian();
            sd.getData(table);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnCucianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCucianActionPerformed
        // TODO add your handling code here:
        
        try {
            prosesSelesai();
            sd.getData(table);
            sd.getDataSelesai(table1);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCucianActionPerformed

    private void btnAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilActionPerformed
        // TODO add your handling code here:
        
         try {
             prosesAmbil();
            sd.getData(table);
            sd.getDataSelesai(table1);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAmbilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbil;
    private javax.swing.JButton btnCucian;
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private app.swing.RoundPanel roundPanel1;
    private app.swing.RoundPanel roundPanel2;
    private app.swing.RoundPanel roundPanel3;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JLabel txtMember;
    private javax.swing.JLabel txtPemasukan;
    private javax.swing.JLabel txtPemesan;
    // End of variables declaration//GEN-END:variables
}
