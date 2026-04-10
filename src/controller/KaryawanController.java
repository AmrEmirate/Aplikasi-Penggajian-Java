package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Karyawan;

public class KaryawanController {
    private final Karyawan karyawan = new Karyawan();

    // Fungsi untuk tombol Simpan
    public void simpan(JTextField ktp, JTextField nama, JTextField ruang, JPasswordField password) {
        if (!ktp.getText().isEmpty()) {
            karyawan.setKtp(ktp.getText());
            karyawan.setNama(nama.getText());
            // Jika ruang kosong, otomatis diisi 0 agar tidak error
            karyawan.setRuang(Integer.parseInt(ruang.getText().isEmpty() ? "0" : ruang.getText()));
            karyawan.setPassword(new String(password.getPassword()));
            
            if (karyawan.simpan()) {
                JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil Disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Fungsi untuk tombol Hapus
    public void hapus(JTextField ktp) {
        if (!ktp.getText().isEmpty()) {
            if (karyawan.hapus(ktp.getText())) {
                JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil Dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Fungsi saat Enter ditekan di kotak KTP (Mencari data)
    public void cari(JTextField ktp, JTextField nama, JTextField ruang, JPasswordField password) {
        if (!ktp.getText().isEmpty()) {
            if (karyawan.baca(ktp.getText())) {
                nama.setText(karyawan.getNama());
                ruang.setText(String.valueOf(karyawan.getRuang()));
                password.setText(karyawan.getPassword());
            } else {
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
                nama.setText("");
                ruang.setText("");
                password.setText("");
            }
        }
    }
}