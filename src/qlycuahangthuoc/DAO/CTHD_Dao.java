/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import qlycuahangthuoc.DTO.CTHD_DTO;

/**
 *
 * @author vanqu
 */
public class CTHD_Dao {
    
    
    // Phương thức để tải Mã hóa đơn vào JComboBox
    public boolean loadcboxMaHD(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT MaHD FROM HOADON");
            rs = stm.executeQuery();

            comboBox.removeAllItems();

            while (rs.next()) {                
                String maHD = rs.getString("MaHD");
                comboBox.addItem(maHD);
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CTHD_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    // Phương thức để tải Mã Thuốc vào JComboBox
    public boolean loadCboxMaThuoc(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = KetNoiCSDL.getConnection(); // Thay thế bằng phương thức kết nối CSDL của bạn
            stm = conn.prepareStatement("SELECT MaThuoc FROM THUOC");
            rs = stm.executeQuery();
            
            comboBox.removeAllItems(); // Xóa tất cả các mục trước khi tải mới
            
            while (rs.next()) {                
                String maThuoc = rs.getString("MaThuoc");
                comboBox.addItem(maThuoc); // Thêm Mã Thuốc vào JComboBox
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CTHD_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Đóng kết nối sau khi sử dụng xong
            KetNoiCSDL.Closeconnection(conn); // Thay thế bằng phương thức đóng kết nối của bạn
        }
    }
    
    public List<CTHD_DTO> getListCTHD() {
        List<CTHD_DTO> listCTHD = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT MaHD, MaThuoc, SoLuong, Thanhtien FROM CTHD");
            rs = ps.executeQuery();

            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maThuoc = rs.getString("MaThuoc");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal thanhTien = rs.getBigDecimal("Thanhtien");

                CTHD_DTO cthd = new CTHD_DTO(maHD, maThuoc, soLuong, thanhTien);
                listCTHD.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        return listCTHD;
    }
    
    public List<CTHD_DTO> getListCTHDByMaHD(String maHD) {
        List<CTHD_DTO> listCTHD = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT MaHD, MaThuoc, SoLuong, Thanhtien FROM CTHD WHERE MaHD = ?");
            ps.setString(1, maHD);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maHDResult = rs.getString("MaHD");
                String maThuoc = rs.getString("MaThuoc");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal thanhTien = rs.getBigDecimal("Thanhtien");

                CTHD_DTO cthd = new CTHD_DTO(maHDResult, maThuoc, soLuong, thanhTien);
                listCTHD.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        return listCTHD;
    }
    
    // Phương thức để lấy giá tiền từ CSDL dựa trên mã thuốc
    public static BigDecimal layGiaTien(String maThuoc) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        BigDecimal giaTien = null;

        try {
            connection = KetNoiCSDL.getConnection();
            String query = "SELECT GiaBan FROM THUOC WHERE MaThuoc = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, maThuoc);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                giaTien = resultSet.getBigDecimal("GiaBan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, tuyệt đối cần phải đóng kết nối sau khi sử dụng xong
            KetNoiCSDL.Closeconnection(connection);
        }

        return giaTien;
    }
    
    // Thêm một chi tiết hóa đơn mới
    public boolean themCTHD(CTHD_DTO cthd) {
        Connection connection = KetNoiCSDL.getConnection();
        String query = "INSERT INTO CTHD (MaHD, MaThuoc, SoLuong, ThanhTien) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cthd.getMahd());
            ps.setString(2, cthd.getMathuoc());
            ps.setInt(3, cthd.getSoluong());
            ps.setBigDecimal(4, cthd.getThanhtien());
            JOptionPane.showMessageDialog(null,"Thêm thành công");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin của một chi tiết hóa đơn
    public boolean suaCTHD(CTHD_DTO cthd) {
        Connection connection = KetNoiCSDL.getConnection();
        String query = "UPDATE CTHD SET SoLuong = ?, ThanhTien = ? WHERE MaHD = ? AND MaThuoc = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, cthd.getSoluong());
            ps.setBigDecimal(2, cthd.getThanhtien());
            ps.setString(3, cthd.getMahd());
            ps.setString(4, cthd.getMathuoc());
            JOptionPane.showMessageDialog(null,"Cập nhật thành công");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Xóa một chi tiết hóa đơn dựa trên mã hóa đơn và mã thuốc
    public boolean xoaCTHD(String maHD, String maThuoc) {
        Connection connection = KetNoiCSDL.getConnection();
        String query = "DELETE FROM CTHD WHERE MaHD = ? AND MaThuoc = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, maHD);
            ps.setString(2, maThuoc);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<CTHD_DTO> timKiemCTHDTheoMaHD(String tuKhoa) {
        List<CTHD_DTO> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            connection = KetNoiCSDL.getConnection();

            // Chuẩn bị câu lệnh SQL để tìm kiếm theo mã hóa đơn
            String query = "SELECT * FROM CTHD WHERE MaHD LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + tuKhoa + "%");

            // Thực thi câu lệnh SQL
            resultSet = preparedStatement.executeQuery();

            // Duyệt qua kết quả và thêm vào danh sách kết quả
            while (resultSet.next()) {
                String maHD = resultSet.getString("MaHD");
                String maThuoc = resultSet.getString("MaThuoc");
                int soLuong = resultSet.getInt("SoLuong");
                BigDecimal thanhTien = resultSet.getBigDecimal("Thanhtien");

                CTHD_DTO cthd = new CTHD_DTO(maHD, maThuoc, soLuong, thanhTien);
                resultList.add(cthd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối, statement và result set
            KetNoiCSDL.Closeconnection(connection);
        }

        return resultList;
    }

    public List<CTHD_DTO> timKiemCTHDTheoMaThuoc(String tuKhoa) {
        List<CTHD_DTO> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            connection = KetNoiCSDL.getConnection();

            // Chuẩn bị câu lệnh SQL để tìm kiếm theo mã thuốc
            String query = "SELECT * FROM CTHD WHERE MaThuoc LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + tuKhoa + "%");

            // Thực thi câu lệnh SQL
            resultSet = preparedStatement.executeQuery();

            // Duyệt qua kết quả và thêm vào danh sách kết quả
            while (resultSet.next()) {
                String maHD = resultSet.getString("MaHD");
                String maThuoc = resultSet.getString("MaThuoc");
                int soLuong = resultSet.getInt("SoLuong");
                BigDecimal thanhTien = resultSet.getBigDecimal("Thanhtien");

                CTHD_DTO cthd = new CTHD_DTO(maHD, maThuoc, soLuong, thanhTien);
                resultList.add(cthd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối, statement và result set
            KetNoiCSDL.Closeconnection(connection);
        }

        return resultList;
    }
  
}
