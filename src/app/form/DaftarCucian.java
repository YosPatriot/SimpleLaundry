
package app.form;

import app.component.Form;
import app.services.ServiceCucian;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaftarCucian extends Form {
    ServiceCucian sc= new ServiceCucian();
    public DaftarCucian() throws SQLException {
        initComponents();
        radioSekarang.setSelected(true);
        lblMember.setVisible(false);
        txtMember.setVisible(false);
        jButton4.setVisible(false);
        sc.getData(table1);
        sc.getJenis(comboCucian);
    }
    private void addCucian(){
        String nama = txtNama.getText();
        String noHP = txtNoHP.getText();
        String alamat = txtAlamat.getText();
        String jenis = (String) comboCucian.getSelectedItem();
        int berat = Integer.parseInt(txtBerat.getText());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        comboCucian = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtBerat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblNominal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        checkBox = new javax.swing.JCheckBox();
        lblMember = new javax.swing.JLabel();
        txtMember = new javax.swing.JTextField();
        radioNanti = new javax.swing.JRadioButton();
        radioSekarang = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cucian", "Nama", "Alamat", "No HP", "Tipe Customer", "Jenis Cucian", "Tanggal Masuk", "Estimasi", "Berat/Meter/Qty", "Status"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(50);
            table1.getColumnModel().getColumn(2).setPreferredWidth(90);
            table1.getColumnModel().getColumn(4).setPreferredWidth(60);
            table1.getColumnModel().getColumn(9).setPreferredWidth(100);
        }

        jLabel1.setText("Nama");

        jLabel2.setText("No HP");

        jLabel3.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane2.setViewportView(txtAlamat);

        jLabel4.setText("Jenis Cucian");

        comboCucian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCucianActionPerformed(evt);
            }
        });

        jLabel5.setText("Berat/Meter/Qty");

        jLabel6.setText("Total Bayar");

        lblNominal.setText("Nominal");

        jButton1.setText("Tambah Cucian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Cucian");

        jButton3.setText("Hapus");

        checkBox.setText("Member");
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        lblMember.setText("Kode Member");

        radioNanti.setText("Bayar Nanti");
        radioNanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNantiActionPerformed(evt);
            }
        });

        radioSekarang.setText("Bayar Sekarang");
        radioSekarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSekarangActionPerformed(evt);
            }
        });

        jButton4.setText("Check");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNama)
                                .addComponent(txtNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(radioSekarang)
                                    .addComponent(lblMember)
                                    .addComponent(jLabel4))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCucian, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioNanti)
                                    .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkBox))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4)))))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboCucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblNominal)
                            .addComponent(checkBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioSekarang)
                            .addComponent(radioNanti))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMember)
                            .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        // TODO add your handling code here
        if(checkBox.isSelected()){
        lblMember.setVisible(true);
        txtMember.setVisible(true);
        jButton4.setVisible(true);
        }else{
        jButton4.setVisible(false);
        lblMember.setVisible(false);
        txtMember.setVisible(false);
        }
    }//GEN-LAST:event_checkBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioSekarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSekarangActionPerformed
        // TODO add your handling code here:
        radioNanti.setSelected(false);
    }//GEN-LAST:event_radioSekarangActionPerformed

    private void radioNantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNantiActionPerformed
        // TODO add your handling code here:
        radioSekarang.setSelected(false);
    }//GEN-LAST:event_radioNantiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            sc.isMember(Integer.parseInt(txtMember.getText()), lblNominal);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarCucian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboCucianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCucianActionPerformed
        // TODO add your handling code here:
        sc.setNominal(lblNominal, comboCucian);
    }//GEN-LAST:event_comboCucianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JComboBox<String> comboCucian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblNominal;
    private javax.swing.JRadioButton radioNanti;
    private javax.swing.JRadioButton radioSekarang;
    private javax.swing.JTable table1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtMember;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHP;
    // End of variables declaration//GEN-END:variables
}
