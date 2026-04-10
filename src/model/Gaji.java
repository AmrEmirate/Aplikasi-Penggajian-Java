package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Gaji {
    private String noBukti, tanggal, ktp, kodePekerjaan;
    private int gajiPokok, tunjangan, totalGaji;
    private final Koneksi koneksi = new Koneksi();

    // Setter
    public void setNoBukti(String noBukti) { this.noBukti = noBukti; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public void setKtp(String ktp) { this.ktp = ktp; }
    public void setKodePekerjaan(String kodePekerjaan) { this.kodePekerjaan = kodePekerjaan; }
    public void setGajiPokok(int gajiPokok) { this.gajiPokok = gajiPokok; }
    public void setTunjangan(int tunjangan) { this.tunjangan = tunjangan; }
    public void setTotalGaji(int totalGaji) { this.totalGaji = totalGaji; }

    public boolean simpan() {
        boolean berhasil = false;
        Connection conn = koneksi.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO tbgaji (nobukti, tanggal, ktp, kodepekerjaan, gajipokok, tunjangan, totalgaji) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, noBukti);
                pstmt.setString(2, tanggal); // Format YYYY-MM-DD
                pstmt.setString(3, ktp);
                pstmt.setString(4, kodePekerjaan);
                pstmt.setInt(5, gajiPokok);
                pstmt.setInt(6, tunjangan);
                pstmt.setInt(7, totalGaji);
                
                pstmt.executeUpdate();
                berhasil = true;
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Simpan Gaji: " + ex.getMessage());
            }
        }
        return berhasil;
    }
}