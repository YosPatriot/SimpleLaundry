
package app.form;

import app.component.Form;
import app.model.ModelCucian;
import app.model.ModelCustomer;
import app.model.ModelTransaksi;
import app.services.ServiceCucian;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        //sc.setNominal(comboCucian.getSelectedItem().toString());

        //sc.setNominal(lblNominal, comboCucian.getSelectedItem().toString());
    }
    private void addCucian() throws SQLException{
       if(sc.isMember()==true){ 
        String nama = txtNama.getText();
        String noHP = txtNoHP.getText();
        String alamat = txtAlamat.getText();
        String jenis = (String) comboCucian.getSelectedItem();
        int berat = Integer.parseInt(txtBerat.getText());
        int id=0;
        double sub = Double.parseDouble(lblTotal.getText());
        double diskon = sc.getDiskon();
        double grandTotal = sub-(sub*diskon);
        ModelCucian mc = new ModelCucian();
        sc.add(new ModelCucian(id,new ModelCustomer(id,nama,alamat,noHP),jenis,berat, new ModelTransaksi(sub,diskon,grandTotal)));
       }else{
        String nama = txtNama.getText();
        String noHP = txtNoHP.getText();
        String alamat = txtAlamat.getText();
        String jenis = (String) comboCucian.getSelectedItem();
        int berat = Integer.parseInt(txtBerat.getText());
        int id=0;
        double sub = Double.parseDouble(lblTotal.getText());
        double diskon = 0;
        double grandTotal = Double.parseDouble(lblTotal.getText());
        ModelCucian mc = new ModelCucian();
        sc.add(new ModelCucian(id,new ModelCustomer(id,nama,alamat,noHP),jenis,berat, new ModelTransaksi(sub,diskon,grandTotal)));
       }
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        checkBox = new javax.swing.JCheckBox();
        lblMember = new javax.swing.JLabel();
        txtMember = new javax.swing.JTextField();
        radioNanti = new javax.swing.JRadioButton();
        radioSekarang = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNominal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

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

        comboCucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Cucian" }));
        comboCucian.setToolTipText("");
        comboCucian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCucianActionPerformed(evt);
            }
        });

        jLabel5.setText("Berat/Meter/Qty");

        txtBerat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //txtBeratKeyReleased(evt);
            }
        });

        jLabel6.setText("Total Bayar");

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

        jLabel7.setText("Rp");

        jLabel8.setText("Harga");

        jLabel9.setText("Rp");

        jButton5.setText("Hitung");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioSekarang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioNanti))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(67, 67, 67)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblNominal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(102, 102, 102)
                                    .addComponent(comboCucian, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2))
                                            .addComponent(lblMember)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel6)))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton3)
                                    .addComponent(jButton5)
                                    .addComponent(checkBox))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(comboCucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNominal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioSekarang)
                            .addComponent(radioNanti))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(checkBox, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMember))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addGap(22, 22, 22))
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
        try {
            // TODO add your handling code here:
            addCucian();
            sc.getData(table1);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarCucian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioSekarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSekarangActionPerformed
        // TODO add your handling code here:
        radioNanti.setSelected(false);
        sc.setStatusBayar(radioSekarang);
    }//GEN-LAST:event_radioSekarangActionPerformed

    private void radioNantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNantiActionPerformed
        // TODO add your handling code here:
        radioSekarang.setSelected(false);
        sc.setStatusBayar(radioNanti);
    }//GEN-LAST:event_radioNantiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            sc.isMember(Integer.parseInt(txtMember.getText()), lblTotal);
            if(sc.isMember()==true){
                JOptionPane.showMessageDialog(null, "Kode Member Benar");
                txtNama.setText(sc.dataCustomer.getNama());
                txtNoHP.setText(sc.dataCustomer.getNoHP());
                txtAlamat.setText(sc.dataCustomer.getAlamat());
            }else{
                JOptionPane.showMessageDialog(null, "Kode Member Salah");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarCucian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboCucianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCucianActionPerformed
       //lblNominal.setText(comboCucian.getSelectedItem().toString());
       Object isSelected = comboCucian.getSelectedItem();
       comboCucian.removeItem("Pilih Jenis Cucian");
        if(!comboCucian.getSelectedItem().equals("Pilih Jenis Cucian")){
            sc.setNominal(isSelected.toString());
            lblNominal.setText(String.valueOf((long) sc.mt.getSubTotal()));
        }
        System.out.println(sc.mt.getSubTotal());
    }//GEN-LAST:event_comboCucianActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int harga = Integer.parseInt(lblNominal.getText());
        int qty = Integer.parseInt(txtBerat.getText());
        int total = harga*qty;
        lblTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton5ActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JComboBox<String> comboCucian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblNominal;
    private javax.swing.JLabel lblTotal;
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
