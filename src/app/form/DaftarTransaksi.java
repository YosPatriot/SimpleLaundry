package app.form;

import app.component.Form;
import app.services.ServiceTransaksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaftarTransaksi extends Form {

   ServiceTransaksi st = new ServiceTransaksi();
    public DaftarTransaksi() throws SQLException {
        initComponents();
        st.getData(table);
        st.getDataSelesai(table1);
        btnLunas.setEnabled(false);
    }
    int idTransaksi;
    String status;
    private void update() throws SQLException{
        int response = JOptionPane.showConfirmDialog(this, "Apakah Transkasi Telah Selsai?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            st.update(idTransaksi);
             st.getData(table);
            st.getDataSelesai(table1);
        }else if(response==JOptionPane.NO_OPTION){
            System.err.println("Failed");
                  
        }
            st.getData(table);
            st.getDataSelesai(table1);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnLunas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "ID Cucian", "Nama", "Jenis Cuci", "Sub Total", "Diskon", "Total Bayar", "Tanggal", "Status"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 27, 184));
        jLabel4.setText("Transaksi ");

        btnLunas.setText("Selesai");
        btnLunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 27, 184));
        jLabel5.setText("Transaksi Selesai ");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "ID Cucian", "Nama", "Jenis Cuci", "Sub Total", "Diskon", "Total Bayar", "Tanggal", "Status"
            }
        ));
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLunas)
                    .addComponent(jLabel5))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLunas)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        idTransaksi = Integer.parseInt((table.getModel().getValueAt(row,0)).toString());
        status = (String) table.getModel().getValueAt(row,8);
        if(status.equals(("Belum Lunas"))){
        btnLunas.setEnabled(true);   
        }else{
        btnLunas.setEnabled(false);
        }
    }//GEN-LAST:event_tableMouseReleased

    private void btnLunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunasActionPerformed
       try {
           // TODO add your handling code here:
           update();
            st.getData(table);
            st.getDataSelesai(table1);
       } catch (SQLException ex) {
           Logger.getLogger(DaftarTransaksi.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnLunasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLunas;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
