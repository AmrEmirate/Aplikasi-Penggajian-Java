/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
public class FormUtama extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormUtama.class.getName());
    
    public static FormKaryawan formKaryawan;
    public static FormPekerjaan formPekerjaan;
    public static FormGaji formGaji;

    /**
     * Creates new form FormUtama
     */
    public FormUtama() {
        initComponents();
        setUkuranLokasiFrame(0.8, true);
        setEnableMenu(false);
    }

    @SuppressWarnings("unchecked")
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mdiDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        aplikasiMenu = new javax.swing.JMenu();
        deskripsiMenuItem = new javax.swing.JMenuItem();
        aksesMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        keluarMenuItem = new javax.swing.JMenuItem();
        masterDataMenu = new javax.swing.JMenu();
        karyawanMenuItem = new javax.swing.JMenuItem();
        pekerjaanMenuItem = new javax.swing.JMenuItem();
        transaksiMenu = new javax.swing.JMenu();
        gajiMenuItem = new javax.swing.JMenuItem();
        laporanMenu = new javax.swing.JMenu();
        gajiLaporanMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        karyawanLaporanMenuItem = new javax.swing.JMenuItem();
        pekerjaanLaporanMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Gaji Karyawan PT Sintory.");

        javax.swing.GroupLayout mdiDesktopPaneLayout = new javax.swing.GroupLayout(mdiDesktopPane);
        mdiDesktopPane.setLayout(mdiDesktopPaneLayout);
        mdiDesktopPaneLayout.setHorizontalGroup(
            mdiDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mdiDesktopPaneLayout.setVerticalGroup(
            mdiDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        aplikasiMenu.setText("Aplikasi");

        deskripsiMenuItem.setText("Deskripsi");
        deskripsiMenuItem.addActionListener(this::deskripsiMenuItemActionPerformed);
        aplikasiMenu.add(deskripsiMenuItem);

        aksesMenuItem.setText("Login");
        aksesMenuItem.addActionListener(this::aksesMenuItemActionPerformed);
        aplikasiMenu.add(aksesMenuItem);
        aplikasiMenu.add(jSeparator1);

        keluarMenuItem.setText("Keluar");
        keluarMenuItem.addActionListener(this::keluarMenuItemActionPerformed);
        aplikasiMenu.add(keluarMenuItem);

        jMenuBar1.add(aplikasiMenu);

        masterDataMenu.setText("Master Data");

        karyawanMenuItem.setText("Karyawan");
        karyawanMenuItem.addActionListener(this::karyawanMenuItemActionPerformed);
        masterDataMenu.add(karyawanMenuItem);

        pekerjaanMenuItem.setText("Pekerjaan");
        pekerjaanMenuItem.addActionListener(this::pekerjaanMenuItemActionPerformed);
        masterDataMenu.add(pekerjaanMenuItem);

        jMenuBar1.add(masterDataMenu);

        transaksiMenu.setText("Transaksi");

        gajiMenuItem.setText("Gaji");
        gajiMenuItem.addActionListener(this::gajiMenuItemActionPerformed);
        transaksiMenu.add(gajiMenuItem);

        jMenuBar1.add(transaksiMenu);

        laporanMenu.setText("Laporan");

        gajiLaporanMenuItem.setText("Gaji");
        gajiLaporanMenuItem.addActionListener(this::gajiLaporanMenuItemActionPerformed);
        laporanMenu.add(gajiLaporanMenuItem);
        laporanMenu.add(jSeparator2);

        karyawanLaporanMenuItem.setText("Karyawan");
        laporanMenu.add(karyawanLaporanMenuItem);

        pekerjaanLaporanMenuItem.setText("Pekerjaan");
        laporanMenu.add(pekerjaanLaporanMenuItem);

        jMenuBar1.add(laporanMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mdiDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mdiDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deskripsiMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deskripsiMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deskripsiMenuItemActionPerformed

    private void keluarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarMenuItemActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_keluarMenuItemActionPerformed

    private void aksesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aksesMenuItemActionPerformed
        FormLogin formLogin = new FormLogin(this, true);
        formLogin.setVisible(true);
    }//GEN-LAST:event_aksesMenuItemActionPerformed

    private void gajiLaporanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        FormCetak formCetak = new FormCetak();
        mdiDesktopPane.add(formCetak);
        formCetak.setVisible(true);
        formCetak.toFront();
    }

    private void karyawanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karyawanMenuItemActionPerformed
        if (formKaryawan == null || !formKaryawan.isVisible()) {
            formKaryawan = new FormKaryawan();
            mdiDesktopPane.add(formKaryawan);
        }
        formKaryawan.setVisible(true);
        formKaryawan.toFront();
    }//GEN-LAST:event_karyawanMenuItemActionPerformed

    private void pekerjaanMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pekerjaanMenuItemActionPerformed
        if (formPekerjaan == null || !formPekerjaan.isVisible()) {
            formPekerjaan = new FormPekerjaan();
            mdiDesktopPane.add(formPekerjaan);
        }
        formPekerjaan.setVisible(true);
        formPekerjaan.toFront();
    }//GEN-LAST:event_pekerjaanMenuItemActionPerformed

    private void gajiMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gajiMenuItemActionPerformed
        if (formGaji == null || !formGaji.isVisible()) {
            formGaji = new FormGaji();
            mdiDesktopPane.add(formGaji);
        }
        formGaji.setVisible(true);
        formGaji.toFront();
    }//GEN-LAST:event_gajiMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormUtama().setVisible(true));
    }

    public void setEnableMenu(boolean aktif) {
        masterDataMenu.setEnabled(aktif);
        transaksiMenu.setEnabled(aktif);
        laporanMenu.setEnabled(aktif);
    }

    private void setUkuranLokasiFrame(double skala, boolean tengah) {
        java.awt.Dimension dimensi = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (skala * dimensi.getWidth()), (int) (skala * dimensi.getHeight()));

        if (tengah) {
            setLocation((int) ((dimensi.getWidth() - getWidth()) / 2),
                    (int) ((dimensi.getHeight() - getHeight()) / 2));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aksesMenuItem;
    private javax.swing.JMenu aplikasiMenu;
    private javax.swing.JMenuItem deskripsiMenuItem;
    private javax.swing.JMenuItem gajiLaporanMenuItem;
    private javax.swing.JMenuItem gajiMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem karyawanLaporanMenuItem;
    private javax.swing.JMenuItem karyawanMenuItem;
    private javax.swing.JMenuItem keluarMenuItem;
    private javax.swing.JMenu laporanMenu;
    private javax.swing.JMenu masterDataMenu;
    private javax.swing.JDesktopPane mdiDesktopPane;
    private javax.swing.JMenuItem pekerjaanLaporanMenuItem;
    private javax.swing.JMenuItem pekerjaanMenuItem;
    private javax.swing.JMenu transaksiMenu;
    // End of variables declaration//GEN-END:variables
}
