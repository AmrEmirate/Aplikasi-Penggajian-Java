package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pekerjaan {
    private String kodePekerjaan, namaPekerjaan;
    private int jumlahTugas;
    private String pesan;
    private Object[][] list;
    private final Koneksi koneksi = new Koneksi();
    
    public String getKodePekerjaan() { return kodePekerjaan; }
    public void setKodePekerjaan(String kodePekerjaan) { this.kodePekerjaan = kodePekerjaan; }
    public String getNamaPekerjaan() { return namaPekerjaan; }
    public void setNamaPekerjaan(String namaPekerjaan) { this.namaPekerjaan = namaPekerjaan; }
    public int getJumlahTugas() { return jumlahTugas; }
    public void setJumlahTugas(int jumlahTugas) { this.jumlahTugas = jumlahTugas; }
    public String getPesan() { return pesan; }
    public Object[][] getList() { return list; }
    public void setList(Object[][] list) { this.list = list; }

    public boolean simpan() {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            boolean simpan = false;
            String SQLStatemen;
            PreparedStatement preparedStatement = null;
            try {
                SQLStatemen = "select * from tbpekerjaan where kodepekerjaan=?";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, kodePekerjaan);
                ResultSet rset = preparedStatement.executeQuery();
                
                if (rset.next()) {
                    if (JOptionPane.showConfirmDialog(null, "Kode pekerjaan sudah ada\nApakah data diperbaharui?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        simpan = true;
                        SQLStatemen = "update tbpekerjaan set namapekerjaan=?, jumlahtugas=? where kodepekerjaan=?";
                        preparedStatement = connection.prepareStatement(SQLStatemen);
                        preparedStatement.setString(1, namaPekerjaan);
                        preparedStatement.setInt(2, jumlahTugas);
                        preparedStatement.setString(3, kodePekerjaan);
                        jumlahSimpan = preparedStatement.executeUpdate();
                    }
                } else {
                    simpan = true;
                    SQLStatemen = "insert into tbpekerjaan(kodepekerjaan, namapekerjaan, jumlahtugas) values (?,?,?)";
                    preparedStatement = connection.prepareStatement(SQLStatemen);
                    preparedStatement.setString(1, kodePekerjaan);
                    preparedStatement.setString(2, namaPekerjaan);
                    preparedStatement.setInt(3, jumlahTugas);
                    jumlahSimpan = preparedStatement.executeUpdate();
                }
                if (simpan) {
                    if (jumlahSimpan < 1) {
                        adaKesalahan = true;
                        pesan = "Gagal menyimpan data pekerjaan";
                    }
                }
                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean baca(String kodePekerjaan) {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            PreparedStatement preparedStatement;
            ResultSet rset;
            try {
                String SQLStatemen = "select * from tbpekerjaan where kodepekerjaan=?";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, kodePekerjaan);
                rset = preparedStatement.executeQuery();
                
                if (rset.next()) {
                    this.kodePekerjaan = rset.getString("kodepekerjaan");
                    this.namaPekerjaan = rset.getString("namapekerjaan");
                    this.jumlahTugas = rset.getInt("jumlahtugas");
                } else {
                    adaKesalahan = true;
                    pesan = "Kode pekerjaan \"" + kodePekerjaan + "\" tidak ditemukan";
                }
                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean bacaData() {
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];
        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatemen;
            PreparedStatement preparedStatement;
            ResultSet rset;
            try {
                SQLStatemen = "select kodepekerjaan, namapekerjaan from tbpekerjaan";
                preparedStatement = connection.prepareStatement(SQLStatemen, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rset = preparedStatement.executeQuery();
                
                rset.last();
                list = new Object[rset.getRow()][2];
                if (rset.getRow() > 0) {
                    rset.first();
                    int i = 0;
                    do {
                        list[i] = new Object[]{rset.getString("kodepekerjaan"), rset.getString("namapekerjaan")};
                        i++;
                    } while (rset.next());
                }
                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean hapus(String kodePekerjaan) {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahHapus;
            PreparedStatement preparedStatement;
            try {
                String SQLStatemen = "delete from tbpekerjaan where kodepekerjaan=?";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, kodePekerjaan);
                jumlahHapus = preparedStatement.executeUpdate();
                
                if (jumlahHapus < 1) {
                    pesan = "Kode pekerjaan tidak ditemukan";
                    adaKesalahan = true;
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpekerjaan\n" + ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }
}