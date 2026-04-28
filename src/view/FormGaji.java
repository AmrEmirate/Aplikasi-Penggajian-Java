/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

/**
 *
 * @author amrem
 */
public class FormGaji extends javax.swing.JInternalFrame {

    // --- 1. TAMBAHKAN 2 BARIS INI ---
    private final javax.swing.table.DefaultTableModel gajiDefaultTableModel;
    private final controller.GajiController gajiController = new controller.GajiController();

    public FormGaji() { 
        initComponents();
        // --- 2. TAMBAHKAN 1 BARIS INI DI DALAM SINI ---
        gajiDefaultTableModel = (javax.swing.table.DefaultTableModel) gajiTable.getModel();
    }

    public void setKtp(String ktp) {
        ktpTextField.setText(ktp);
    }

    public void setNama(String nama) {
        namaTextField.setText(nama);
    }

    public void setRuang(String ruang) {
        ruangTextField.setText(ruang);
    }

    public void setNamaPekerjaan(String nama) {
        gajiTable.setValueAt(nama, gajiTable.getSelectedRow(), 1);
    }

    public void hapusGaji() {
        for (int i = 2; i <= 4; i++) {
            gajiTable.setValueAt("", gajiTable.getSelectedRow(), i);
        }
    }

    public void setTambahGaji(Object[] gajiPekerjaan) {
        int noRecord;
        if ((noRecord = gajiDefaultTableModel.getRowCount() - 1) >= 0) {
            while (((gajiTable.getValueAt(noRecord, 0) == null) || gajiTable.getValueAt(noRecord, 0).equals("")) && (noRecord > 0)) {
                noRecord--;
            }
            if (!((gajiTable.getValueAt(noRecord, 0) == null) || gajiTable.getValueAt(noRecord, 0).equals(""))) {
                noRecord++;
            }
        }
        if (noRecord == gajiDefaultTableModel.getRowCount()) {
            if ((gajiTable.getValueAt(noRecord - 1, 0) == null) || gajiTable.getValueAt(noRecord - 1, 0).equals("")) {
                gajiDefaultTableModel.removeRow(noRecord - 1);
            }
        } else {
            noRecord--;
        }
        gajiDefaultTableModel.insertRow(++noRecord, gajiPekerjaan);
    }

    public void clearGajiTable() {
        gajiDefaultTableModel.setRowCount(0);
    }

    private void klikKananTabel(java.awt.event.MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pekerjaanPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pekerjaanPopupMenu = new javax.swing.JPopupMenu();
        tambahMenuItem = new javax.swing.JMenuItem();
        hapusMenuItem = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ktpTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        ruangTextField = new javax.swing.JTextField();
        lihatButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        tutupButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gajiTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tambahMenuItem.setText("Tambah");
        tambahMenuItem.addActionListener(this::tambahMenuItemActionPerformed);
        pekerjaanPopupMenu.add(tambahMenuItem);

        hapusMenuItem.setText("Hapus");
        hapusMenuItem.addActionListener(this::hapusMenuItemActionPerformed);
        pekerjaanPopupMenu.add(hapusMenuItem);

        setTitle("Mengelola Gaji Karyawan");

        jLabel1.setText("KTP");

        jLabel2.setText("Nama");

        jLabel3.setText("Ruang");

        ktpTextField.addActionListener(this::ktpTextFieldActionPerformed);
        ktpTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ktpTextFieldKeyPressed(evt);
            }
        });

        lihatButton.setText("Lihat");
        lihatButton.addActionListener(this::lihatButtonActionPerformed);

        simpanButton.setText("Simpan");
        simpanButton.addActionListener(this::simpanButtonActionPerformed);

        tutupButton.setText("Tutup");
        tutupButton.addActionListener(this::tutupButtonActionPerformed);

        gajiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Pekerjaan", "Gaji bersih", "Gaji kotor", "Tunjangan"
            }
        ));
        gajiTable.setComponentPopupMenu(pekerjaanPopupMenu);
        gajiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gajiTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(gajiTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lihatButton)
                        .addGap(39, 39, 39)
                        .addComponent(simpanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(tutupButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ktpTextField)
                            .addComponent(namaTextField)
                            .addComponent(ruangTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ktpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ruangTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanButton)
                    .addComponent(tutupButton)
                    .addComponent(lihatButton))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahMenuItemActionPerformed
        gajiController.tampilkanFormLihatPekerjaan();
    }//GEN-LAST:event_tambahMenuItemActionPerformed

    private void hapusMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusMenuItemActionPerformed
        // TODO add your handling code here:
        if (gajiTable.getSelectedRowCount() > 0) {
    gajiDefaultTableModel.removeRow(gajiTable.getSelectedRow());
        }
    }//GEN-LAST:event_hapusMenuItemActionPerformed

    private void ktpTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ktpTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ktpTextFieldActionPerformed

    private void gajiTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gajiTableMouseReleased
        // TODO add your handling code here:
        klikKananTabel(evt);
    }//GEN-LAST:event_gajiTableMouseReleased

    private void tutupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tutupButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // TODO add your handling code here:
        gajiController.simpan(ktpTextField, gajiTable);
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void lihatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatButtonActionPerformed
        // TODO add your handling code here:
        gajiController.tampilkanFormLihatKaryawan();
    }//GEN-LAST:event_lihatButtonActionPerformed

    private void ktpTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ktpTextFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
    gajiController.cariKaryawan(ktpTextField);
}
    }//GEN-LAST:event_ktpTextFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gajiTable;
    private javax.swing.JMenuItem hapusMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ktpTextField;
    private javax.swing.JButton lihatButton;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JPopupMenu pekerjaanPopupMenu;
    private javax.swing.JTextField ruangTextField;
    private javax.swing.JButton simpanButton;
    private javax.swing.JMenuItem tambahMenuItem;
    private javax.swing.JButton tutupButton;
    // End of variables declaration//GEN-END:variables
}
