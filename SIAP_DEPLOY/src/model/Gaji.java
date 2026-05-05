package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

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
                    if (listGaji[i][0] == null || listGaji[i][0].toString().isEmpty()) continue;
                    
                    preparedStatement.setString(1, ktp);
                    preparedStatement.setString(2, (String) listGaji[i][0]);
                    
                    double kotor = 0, tunjangan = 0, bersih = 0;
                    try {
                        if (listGaji[i][1] != null) kotor = Double.parseDouble(listGaji[i][1].toString());
                        if (listGaji[i][2] != null) tunjangan = Double.parseDouble(listGaji[i][2].toString());
                        if (listGaji[i][3] != null) bersih = Double.parseDouble(listGaji[i][3].toString());
                    } catch (Exception e) {}

                    preparedStatement.setDouble(3, kotor);
                    preparedStatement.setDouble(4, tunjangan);
                    preparedStatement.setDouble(5, bersih);
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
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatemen, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
                String query = "SELECT tbkaryawan.`ktp` AS tbkaryawan_ktp, "
                        + "tbkaryawan.`nama` AS tbkaryawan_nama, "
                        + "tbkaryawan.`ruang` AS tbkaryawan_ruang, "
                        + "tbpekerjaan.`kodepekerjaan` AS tbpekerjaan_kodepekerjaan, "
                        + "tbpekerjaan.`namapekerjaan` AS tbpekerjaan_namapekerjaan, "
                        + "tbgaji.`gajikotor` AS tbgaji_gajikotor, "
                        + "tbgaji.`tunjangan` AS tbgaji_tunjangan, "
                        + "tbgaji.`gajibersih` AS tbgaji_gajibersih "
                        + "FROM `tbkaryawan` tbkaryawan INNER JOIN `tbgaji` tbgaji ON tbkaryawan.`ktp` = tbgaji.`ktp` "
                        + "INNER JOIN `tbpekerjaan` tbpekerjaan ON tbgaji.`kodepekerjaan` = tbpekerjaan.`kodepekerjaan` ";
                
                if (ruang > 0) {
                    query += "WHERE tbkaryawan.`ruang` = " + ruang;
                }

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                JasperDesign jasperDesign = JRXmlLoader.load("src/report/GajiReport.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), new JRResultSetDataSource(resultSet));
                JasperViewer.viewReport(jasperPrint, false);
                return true;
            }
        } catch (JRException | SQLException ex) {
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