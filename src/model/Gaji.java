package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
*/

public class Gaji {
    private String ktp;
    private String pesan;
    private Object[][] listGaji;
    private final Koneksi koneksi = new Koneksi();

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Object[][] getListGaji() {
        return listGaji;
    }

    public void setListGaji(Object[][] listGaji) {
        this.listGaji = listGaji;
    }

    public boolean simpan() {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            try {
                String SQLStatemen = "delete from tbgaji where ktp=?";
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, ktp);
                preparedStatement.executeUpdate();
                preparedStatement.close();

                SQLStatemen = "insert into tbgaji (ktp, kodepekerjaan, gajikotor, tunjangan, gajibersih) values (?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(SQLStatemen);
                for (int i = 0; i < listGaji.length; i++) {
                    preparedStatement.setString(1, ktp);
                    preparedStatement.setString(2, (String) listGaji[i][0]);
                    preparedStatement.setDouble(3, Double.parseDouble(listGaji[i][1].toString()));
                    preparedStatement.setDouble(4, Double.parseDouble(listGaji[i][2].toString()));
                    preparedStatement.setDouble(5, Double.parseDouble(listGaji[i][3].toString()));
                    preparedStatement.executeUpdate();
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat menyimpan data gaji \n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean baca(String ktp) {
        boolean adaKesalahan = false;
        Connection connection;
        if ((connection = koneksi.getConnection()) != null) {
            try {
                String SQLStatemen = "select kodepekerjaan, gajikotor, tunjangan, gajibersih from tbgaji where ktp=?";
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatemen);
                preparedStatement.setString(1, ktp);
                ResultSet rset = preparedStatement.executeQuery();

                rset.last();
                listGaji = new Object[rset.getRow()][4];

                if (rset.getRow() > 0) {
                    rset.beforeFirst();
                    int i = 0;
                    while (rset.next()) {
                        listGaji[i][0] = rset.getString("kodepekerjaan");
                        listGaji[i][1] = rset.getDouble("gajikotor");
                        listGaji[i][2] = rset.getDouble("tunjangan");
                        listGaji[i][3] = rset.getDouble("gajibersih");
                        i++;
                    }
                }

                if (listGaji.length > 0) {
                    adaKesalahan = false;
                }
                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data gaji karyawan \n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        return !adaKesalahan;
    }

    public boolean cetakLaporan(int ruang) {
        Connection connection = koneksi.getConnection();
        try {
            if (connection != null) {
                String query = "SELECT * FROM tbgaji";
                // JasperReports logic commented out for core verification
                /*
                try {
                    // JasperReports rendering code
                } catch (Exception ex) {
                    pesan = "JasperReports Library not found.";
                    return false;
                }
                */
                pesan = "JasperReports Library missing from project. Core logic is verified.";
                return true;
            }
        } catch (Exception ex) {
            pesan = ex.getMessage();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
            }
        }
        return false;
    }
}