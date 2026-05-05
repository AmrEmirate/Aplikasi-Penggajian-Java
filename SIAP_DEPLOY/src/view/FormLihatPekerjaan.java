package view;

import javax.swing.table.DefaultTableModel;

public class FormLihatPekerjaan extends javax.swing.JDialog {

    private DefaultTableModel tableModel;
    private String kodePekerjaanDipilih = "";

    public FormLihatPekerjaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(500, 300);
        setLocationRelativeTo(parent);
        
        tableModel = (DefaultTableModel) table.getModel();
    }

    public void tampilkanData(Object[][] list) {
        tableModel.setRowCount(0);
        if (list != null) {
            for (Object[] row : list) {
                tableModel.addRow(row);
            }
        }
    }

    public String getKodePekerjaanDipilih() {
        return kodePekerjaanDipilih;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lihat Pekerjaan");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pekerjaan", "Nama Pekerjaan", "Jumlah Tugas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = table.getSelectedRow();
            if (row != -1) {
                kodePekerjaanDipilih = table.getValueAt(row, 0).toString();
                dispose();
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
