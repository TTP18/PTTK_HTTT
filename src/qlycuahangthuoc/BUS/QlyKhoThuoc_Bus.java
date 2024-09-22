
package qlycuahangthuoc.BUS;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.DAO.KetNoiCSDL;
import qlycuahangthuoc.DAO.QlyKhoThuoc_Dao;
import qlycuahangthuoc.DTO.KhoThuoc;

/**
 *
 * @author vanqu
 */
public class QlyKhoThuoc_Bus {
    
    QlyKhoThuoc_Dao qlyKhoThuoc_Dao = new QlyKhoThuoc_Dao();
    
    public boolean loadTableData(JTable table) {
        return qlyKhoThuoc_Dao.loadTableData(table);
    }
    
    public boolean themThuoc(KhoThuoc khoThuoc) {
        return qlyKhoThuoc_Dao.themThuoc(khoThuoc);
    }

    public boolean suaThuoc(KhoThuoc khoThuoc) {
        return qlyKhoThuoc_Dao.suaThuoc(khoThuoc);
    }

    public boolean xoaThuoc(String maThuoc) {
        return qlyKhoThuoc_Dao.xoaThuoc(maThuoc);
    }
    
    public List<KhoThuoc> timThuocTheoMaKho(String maKho) {
        Connection connection = null;
        List<KhoThuoc> danhSachThuoc = new ArrayList<>();
        try {
            connection = KetNoiCSDL.getConnection();
            String query = """
                           select kt.MaKho, kt.MaThuoc, t.TenThuoc, t.GiaBan, kt.SoLuongMoiLoai, t.HanSuDung
                                                                   from KHOTHUOC kt, THUOC t
                                                                   where kt.MaThuoc = t.MaThuoc and kt.MaKho = ? """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, maKho);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Tạo đối tượng KhoThuoc từ dữ liệu trong ResultSet
                KhoThuoc thuoc = new KhoThuoc(
                    resultSet.getString("MaKho"),
                    resultSet.getString("MaThuoc"),
                    resultSet.getString("TenThuoc"),
                    resultSet.getBigDecimal("GiaBan"),
                    resultSet.getInt("SoLuongMoiLoai"),
                    resultSet.getDate("HanSuDung")
                );
                danhSachThuoc.add(thuoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachThuoc;
    }
    
    public List<KhoThuoc> timThuocTheoMa(String maThuoc) {
        Connection connection = null;
        List<KhoThuoc> danhSachThuoc = new ArrayList<>();
        try {
            connection = KetNoiCSDL.getConnection();
            String query = """
                           select kt.MaKho, kt.MaThuoc, t.TenThuoc, t.GiaBan, kt.SoLuongMoiLoai, t.HanSuDung
                           from KHOTHUOC kt, THUOC t
                           where kt.MaThuoc = t.MaThuoc and t.MaThuoc = ?""";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + maThuoc + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Tạo đối tượng KhoThuoc từ dữ liệu trong ResultSet
                KhoThuoc thuoc = new KhoThuoc(
                    resultSet.getString("MaKho"),
                    resultSet.getString("MaThuoc"),
                    resultSet.getString("TenThuoc"),
                    resultSet.getBigDecimal("GiaBan"),
                    resultSet.getInt("SoLuongMoiLoai"),
                    resultSet.getDate("HanSuDung")
                );
                danhSachThuoc.add(thuoc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachThuoc;
    }

    public boolean kiemTraMaKhoTonTai(String makho) {
        // Kết nối cơ sở dữ liệu và thực hiện truy vấn
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;

        try {
            // Thực hiện truy vấn kiểm tra mã kho
            String query = "SELECT COUNT(*) FROM khothuoc WHERE makho = ?";
            connection = KetNoiCSDL.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, makho);
            resultSet = statement.executeQuery();

            // Xác định kết quả kiểm tra
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    // Mã kho đã tồn tại
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    
    public List<KhoThuoc> locThuocTheoDieuKien(Date dateHSDstart, Date dateHSDfinish, BigDecimal giaBanStart, BigDecimal giaBanFinish) {
        List<KhoThuoc> danhSachKhoThuoc = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        SELECT kt.MaKho, kt.MaThuoc, t.TenThuoc, t.GiaBan, kt.SoLuongMoiLoai, t.HanSuDung
                                        FROM KHOTHUOC kt, THUOC t
                                        WHERE kt.MaThuoc = t.MaThuoc
                                        AND t.HanSuDung BETWEEN ? AND ?
                                        AND t.GiaBan BETWEEN ? AND ?""");
            stm.setDate(1, new java.sql.Date(dateHSDstart.getTime()));
            stm.setDate(2, new java.sql.Date(dateHSDfinish.getTime()));
            stm.setBigDecimal(3, giaBanStart);
            stm.setBigDecimal(4, giaBanFinish);
            rs = stm.executeQuery();

            while (rs.next()) {
                String maKho = rs.getString("MaKho");
                String maThuoc = rs.getString("MaThuoc");
                String tenThuoc = rs.getString("TenThuoc");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");
                int soLuongMoiLoai = rs.getInt("SoLuongMoiLoai");
                java.util.Date hanSuDung = rs.getDate("HanSuDung");

                KhoThuoc khoThuoc = new KhoThuoc(maKho, maThuoc, tenThuoc, giaBan, soLuongMoiLoai, hanSuDung);
                danhSachKhoThuoc.add(khoThuoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyKhoThuoc_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return danhSachKhoThuoc;
    }

}
