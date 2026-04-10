package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Pekerjaan;

public class PekerjaanController {
    private final Pekerjaan pekerjaan = new Pekerjaan();

    // Fungsi untuk tombol Simpan
    public void simpan(JTextField kode, JTextField nama, JTextField tugas) {
        if (!kode.getText().isEmpty()) {
            pekerjaan.setKodePekerjaan(kode.getText());
            pekerjaan.setNamaPekerjaan(nama.getText());
            pekerjaan.setJumlahTugas(Integer.parseInt(tugas.getText().isEmpty() ? "0" : tugas.getText()));
            
            if (pekerjaan.simpan()) {
                JOptionPane.showMessageDialog(null, "Data Pekerjaan Berhasil Disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, pekerjaan.getPesan(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kode Pekerjaan tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Fungsi untuk tombol Hapus
    public void hapus(JTextField kode) {
        if (!kode.getText().isEmpty()) {
            if (pekerjaan.hapus(kode.getText())) {
                JOptionPane.showMessageDialog(null, "Data Pekerjaan Berhasil Dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, pekerjaan.getPesan(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Fungsi saat Enter ditekan di kotak Kode (Mencari data)
    public void cari(JTextField kode, JTextField nama, JTextField tugas) {
        if (!kode.getText().isEmpty()) {
            if (pekerjaan.baca(kode.getText())) {
                nama.setText(pekerjaan.getNamaPekerjaan());
                tugas.setText(String.valueOf(pekerjaan.getJumlahTugas()));
            } else {
                JOptionPane.showMessageDialog(null, pekerjaan.getPesan(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
                nama.setText("");
                tugas.setText("");
            }
        }
    }
}