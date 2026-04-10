package controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Karyawan;

public class GajiController {
    
    private final Karyawan karyawan = new Karyawan();

    // 1. Fungsi untuk tombol Simpan (Menyimpan data dari Tabel)
    public void simpan(JTextField ktpTextField, JTable gajiTable) {
        if (!ktpTextField.getText().isEmpty() && gajiTable.getRowCount() > 0) {
            // (Nanti di sini kita buat logika simpan ke database-nya)
            JOptionPane.showMessageDialog(null, "Data Gaji untuk KTP: " + ktpTextField.getText() + " Berhasil Disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
            // Otomatis mengosongkan tabel setelah berhasil disimpan
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) gajiTable.getModel();
            model.setRowCount(0);
            ktpTextField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "KTP atau Tabel Gaji tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // 2. Fungsi saat tombol Enter ditekan di kotak KTP
    public void cariKaryawan(JTextField ktpTextField) {
        if (!ktpTextField.getText().isEmpty()) {
            if (karyawan.baca(ktpTextField.getText())) {
                JOptionPane.showMessageDialog(null, "Karyawan Ditemukan: " + karyawan.getNama(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Karyawan dengan KTP " + ktpTextField.getText() + " tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 3. Fungsi untuk tombol Lihat
    public void tampilkanFormLihatKaryawan() {
        JOptionPane.showMessageDialog(null, "Membuka daftar karyawan...", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}