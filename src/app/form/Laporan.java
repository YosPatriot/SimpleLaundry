
package app.form;

import app.component.Form;
import app.services.ServiceReport;

public class Laporan extends Form{
    ServiceReport sr = new ServiceReport();
    public Laporan() {
        initComponents();
        txtDari.setEnabled(false);
        txtSampai.setEnabled(false);
        btnCetak.setEnabled(false);
    }
        
    private void setLaporan(){
        if(!comboLaporan.getSelectedItem().equals("Pilih Laporan")){
            txtDari.setEnabled(true);
            txtSampai.setEnabled(true);
            btnCetak.setEnabled(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new app.swing.datechooser.DateChooser();
        dateChooser2 = new app.swing.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtDari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSampai = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        comboLaporan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtDari);

        dateChooser2.setName(""); // NOI18N
        dateChooser2.setTextRefernce(txtSampai);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Dari :");

        jLabel2.setText("Sampai :");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        comboLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Laporan", "Cucian", "Transaksi", "Member", "Non-Member" }));
        comboLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLaporanActionPerformed(evt);
            }
        });

        jLabel3.setText("Pilih :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboLaporan, 0, 143, Short.MAX_VALUE)
                    .addComponent(txtDari))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak))
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        String dari=txtDari.getText();
        String sampai=txtSampai.getText();
        if(comboLaporan.getSelectedItem().equals("Cucian")){
            sr.reportCucian(dari,sampai);
        }else if (comboLaporan.getSelectedItem().equals("Transaksi")){
            sr.reportTrx(dari, sampai);
        }else if (comboLaporan.getSelectedItem().equals("Member")){
            sr.reportMember(dari, sampai);
        }else if (comboLaporan.getSelectedItem().equals("Non-Member")){
            sr.reportNonMember(dari, sampai);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void comboLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLaporanActionPerformed
        // TODO add your handling code here:
        setLaporan();
    }//GEN-LAST:event_comboLaporanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JComboBox<String> comboLaporan;
    private app.swing.datechooser.DateChooser dateChooser1;
    private app.swing.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDari;
    private javax.swing.JTextField txtSampai;
    // End of variables declaration//GEN-END:variables
}
