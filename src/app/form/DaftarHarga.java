/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.form;

import app.component.Form;
import app.model.ModelDaftarHarga;
import app.services.ServiceDaftarHarga;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yos Patriot
 */
public class DaftarHarga extends Form {

    /**
     * Creates new form DaftarHarga
     */
    int idHarga;
     ServiceDaftarHarga sd = new ServiceDaftarHarga();
    public DaftarHarga() throws SQLException {
        initComponents();
        sd.getData(table1);
    }
    private void addHarga() throws SQLException{
       try{ 
        String jenis = txtJenis.getText();
        int harga = Integer.parseInt(txtHarga.getText());
        int id=0;
        sd.add(new ModelDaftarHarga(id,jenis,harga));
       }catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null, "Input Harga tidak sesuai !!");
       }
    }
    private void updateHarga() throws SQLException{
        try{
        String jenis = txtJenis.getText();
        int harga = Integer.parseInt(txtHarga.getText());
        sd.update(new ModelDaftarHarga(idHarga,jenis,harga));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Input Harga tidak sesuai !!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Jenis Cucian", "Jenis Cucian", "Harga Berat/Meter/Qty"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel1.setText("Jenis Cucian");

        jLabel2.setText("Harga Berat/Meter/Qty");

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJenis)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                        .addGap(0, 389, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             // TODO add your handling code here:
             addHarga();
             sd.getData(table1);
         } catch (SQLException ex) {
             Logger.getLogger(DaftarHarga.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseReleased
        // TODO add your handling code here:
        int row = table1.getSelectedRow();
        idHarga = Integer.parseInt((table1.getModel().getValueAt(row,1)).toString());
        String jenis = (table1.getModel().getValueAt(row,2)).toString();
        String harga = (table1.getModel().getValueAt(row,3)).toString();
        txtJenis.setText(jenis);
        txtHarga.setText(harga);
    }//GEN-LAST:event_table1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            updateHarga();
            sd.getData(table1);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarHarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        sd.delete(idHarga);
        try {
            sd.getData(table1);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarHarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJenis;
    // End of variables declaration//GEN-END:variables
}
