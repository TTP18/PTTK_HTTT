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
import qlycuahangthuoc.DTO.KhachHang;
import java.time.LocalDate;


public class QlyKhachHang_Dao {
    public List<KhachHang> getListKhachHangFromData() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<KhachHang> listKhachHang = new ArrayList<>();
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select kh.MaKH, kh.HoTen, kh.NgaySinh, kh.DiaChi, kh.SDT
                                        from KHACHHANG kh  
                                        """);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                String Makh = rs.getString("MaKH");
                String Tenkh = rs.getString("Hoten");
                Date Ngsinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String Sdt = rs.getString("SDT");
                
                
                KhachHang khachHang = new KhachHang(Makh, Tenkh, diaChi, Sdt, Ngsinh);
                listKhachHang.add(khachHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        
        return listKhachHang;
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
     
    public boolean deleteKH(String maKH) {
        String sql = "DELETE FROM KHACHHANG WHERE MaKH = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, maKH);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateKhachHang(KhachHang kh) {
        String sql = "UPDATE KHACHHANG SET HoTen = ?, NgaySinh = ?, DiaChi = ?, SDT = ? WHERE MaKH = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kh.getTenkh());
            ps.setDate(2, new java.sql.Date(kh.getNgaysinh().getTime()));
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getMakh());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean addKhachHang(KhachHang kh) {
        String sql = "INSERT INTO KHACHHANG (MaKH, HoTen, NgaySinh, DiaChi, SDT) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, kh.getMakh());
            ps.setString(2, kh.getTenkh());
            ps.setDate(3, new java.sql.Date(kh.getNgaysinh().getTime())); 
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getSdt());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
     public List<KhachHang> searchKhachHang(String loaiTimKiem, String duLieu) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<KhachHang> resultList = new ArrayList<>();

        try {
            conn = KetNoiCSDL.getConnection();
            String query = "";

            switch (loaiTimKiem) {
                case "Mã KH":
                    query = "SELECT MaKH, HoTen, NgaySinh, DiaChi, SDT " +
                            "FROM KHACHHANG " +
                            "WHERE MaKH LIKE ?";
                    break;
                case "Tên KH":
                    query = "SELECT MaKH, HoTen, NgaySinh, DiaChi, SDT " +
                            "FROM KHACHHANG " +
                            "WHERE HoTen LIKE ?";
                    break;
                default:
                    // Xử lý trường hợp khác (nếu cần)
                    break;
            }

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + duLieu + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String Makh = rs.getString("MaKH");
                String Tenkh = rs.getString("HoTen");
                Date Ngsinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String Sdt = rs.getString("SDT");

                KhachHang khachHang = new KhachHang(Makh, Tenkh, diaChi, Sdt, Ngsinh);
                resultList.add(khachHang);
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
