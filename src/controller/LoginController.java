package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Koneksi;

public class LoginController {
    
    private final Koneksi koneksi = new Koneksi();
    private final Enkripsi enkripsi = new Enkripsi();

    public boolean validasiLogin(String username, String password) {
        boolean valid = false;
        Connection conn = koneksi.getConnection();
        
        try {
            if (conn != null) {
                // Mengenkripsi password yang diketik agar cocok dengan di database
                String hashPassword = enkripsi.hashMD5(password);
                
                // Mencari data di database
                String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, hashPassword);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    valid = true; // Jika data ditemukan, login sukses
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal:\n" + koneksi.getPesanKesalahan(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return valid;
    }
}