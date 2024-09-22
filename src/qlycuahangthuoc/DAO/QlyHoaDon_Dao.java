/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.DTO.HoaDon;
import qlycuahangthuoc.DTO.TaiKhoan;

/**
 *
 * @author vanqu
 */
public class QlyHoaDon_Dao {
    
    // Phương thức để tải Mã nhân viên vào JComboBox
    public boolean loadcboxMaNV(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT MaNV FROM NHANVIEN");
            rs = stm.executeQuery();
            
            comboBox.removeAllItems();
            
            while (rs.next()) {                
                String manv = rs.getString("MaNV");
                comboBox.addItem(manv);
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QlyHoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    // Phương thức để tải Mã khach hang vào JComboBox
    public boolean loadcboxMaKH(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select KH.MaKH
                                        from KHACHHANG KH""");
            rs = stm.executeQuery();
            
            comboBox.removeAllItems();
            
            
            while (rs.next()) {                
                String makh = rs.getString("MaKH");
                comboBox.addItem(makh);
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QlyHoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public List<HoaDon> getListHoaDonFromData() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<HoaDon> listHoaDon = new ArrayList<>();
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select hd.MaHD,kh.MaKH,kh.HoTen as HotenKH,nv.MaNV,nv.HoTen as HotenNV,hd.NgayLap
                                        from HOADON hd , KHACHHANG kh , NHANVIEN nv
                                        where hd.MaKH=kh.MaKH and hd.MaNV=nv.MaNV""");
            rs = stm.executeQuery();
            
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String MaKH = rs.getString("MaKH");
                String HotenKH = rs.getString("HotenKH");
                String MaNV = rs.getString("MaNV");
                String HotenNV = rs.getString("HotenNV");
                Date NgayLap = rs.getDate("NgayLap");
                
                HoaDon hoaDon = new HoaDon(MaHD, MaKH, HotenKH, MaNV, HotenNV, NgayLap);
                listHoaDon.add(hoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        
        return listHoaDon;
    }
    
    public String getTenKHByMaKH(String maKH) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tenKH = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT HoTen FROM KHACHHANG WHERE MaKH = ?");
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            if (rs.next()) {
                tenKH = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
            KetNoiCSDL.Closeconnection(con);
        }
        
        return tenKH;
    }

    public String getTenNVByMaNV(String maNV) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tenNV = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT HoTen FROM NHANVIEN WHERE MaNV = ?");
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            if (rs.next()) {
                tenNV = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
            KetNoiCSDL.Closeconnection(con);
        }
        
        return tenNV;
    }
    
    public boolean deleteHoaDon(String maHD) {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, maHD);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateHoaDon(HoaDon hd) {
        String sql = "UPDATE HoaDon SET MaKH = ?, MaNV = ?, NgayLap = ? WHERE MaHD = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, hd.getMakh());
            ps.setString(2, hd.getManv());
            ps.setDate(3, new java.sql.Date(hd.getNgaylap().getTime()));
            ps.setString(4, hd.getMahd());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addHoaDon(HoaDon hd) {
        String sql = "INSERT INTO HoaDon (MaHD, MaKH, MaNV, NgayLap) VALUES (?, ?, ?, ?)";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, hd.getMahd());
            ps.setString(2, hd.getMakh());
            ps.setString(3, hd.getManv());
            ps.setDate(4, new java.sql.Date(hd.getNgaylap().getTime()));
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
   public List<HoaDon> searchHoaDon(String loaiTimKiem, String duLieu) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<HoaDon> resultList = new ArrayList<>();

        try {
            conn = KetNoiCSDL.getConnection();
            String query = "";

            switch (loaiTimKiem) {
                case "Mã hóa đơn":
                    query = "SELECT hd.MaHD, kh.MaKH, kh.HoTen AS HotenKH, nv.MaNV, nv.HoTen AS HotenNV, hd.NgayLap " +
                            "FROM HOADON hd " +
                            "JOIN KHACHHANG kh ON hd.MaKH = kh.MaKH " +
                            "JOIN NHANVIEN nv ON hd.MaNV = nv.MaNV " +
                            "WHERE hd.MaHD LIKE ?";
                    break;
                case "Mã khách hàng":
                    query = "SELECT hd.MaHD, kh.MaKH, kh.HoTen AS HotenKH, nv.MaNV, nv.HoTen AS HotenNV, hd.NgayLap " +
                            "FROM HOADON hd " +
                            "JOIN KHACHHANG kh ON hd.MaKH = kh.MaKH " +
                            "JOIN NHANVIEN nv ON hd.MaNV = nv.MaNV " +
                            "WHERE kh.MaKH LIKE ?";
                    break;
                case "Mã nhân viên":
                    query = "SELECT hd.MaHD, kh.MaKH, kh.HoTen AS HotenKH, nv.MaNV, nv.HoTen AS HotenNV, hd.NgayLap " +
                            "FROM HOADON hd " +
                            "JOIN KHACHHANG kh ON hd.MaKH = kh.MaKH " +
                            "JOIN NHANVIEN nv ON hd.MaNV = nv.MaNV " +
                            "WHERE nv.MaNV LIKE ?";
                    break;
                default:
                    // Xử lý trường hợp khác (nếu cần)
                    break;
            }

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + duLieu + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String MaKH = rs.getString("MaKH");
                String HotenKH = rs.getString("HotenKH");
                String MaNV = rs.getString("MaNV");
                String HotenNV = rs.getString("HotenNV");
                Date NgayLap = rs.getDate("NgayLap");

                HoaDon hoaDon = new HoaDon(MaHD, MaKH, HotenKH, MaNV, HotenNV, NgayLap);
                resultList.add(hoaDon);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý exception nếu cần
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }

        return resultList;
    }





}
