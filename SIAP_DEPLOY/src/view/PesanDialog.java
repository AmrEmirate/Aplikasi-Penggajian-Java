package view;

import javax.swing.JOptionPane;

/**
 * PesanDialog adalah class pembantu untuk menampilkan OptionDialog.
 * Kini diintegrasikan dengan .form agar kompatibel dengan NetBeans GUI Builder.
 */
public class PesanDialog extends javax.swing.JDialog {

    public PesanDialog() {
        super((java.awt.Frame)null, true);
        initComponents();
    }

    public int tampilkanPilihan(String pesan, String judul, Object[] pilihan) {
        return JOptionPane.showOptionDialog(
            null,
            pesan,
            judul,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            pilihan,
            pilihan[0]
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
