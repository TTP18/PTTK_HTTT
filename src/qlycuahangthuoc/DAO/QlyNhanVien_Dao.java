/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DAO;

import java.security.interfaces.RSAKey;
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
import java.time.LocalDate;
import qlycuahangthuoc.DTO.NhanVien;


public class QlyNhanVien_Dao {
    public List<NhanVien> getListNhanVienFromData() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<NhanVien> listNhanVien = new ArrayList<>();
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select MaNV, HoTen, NgaySinh, DiaChi, SDT, CMND
                                        from NHANVIEN   
                                        """);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String TenNV = rs.getString("Hoten");
                Date Ngsinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String Sdt = rs.getString("SDT");
                String Cmnd = rs.getString("CMND");
                
                
                NhanVien nv = new NhanVien(MaNV,TenNV, diaChi, Sdt, Cmnd, Ngsinh);
                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        
        return listNhanVien;
    }
    
     public String getTenNVbyMaNV(String maNV) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tenKH = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("SELECT HoTen FROM NHANVIEN WHERE MaNV = ?");
            ps.setString(1, maNV);
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
     
    public boolean deleteNV(String maNV) {
        String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, maNV);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateNhanVien(NhanVien nv) {
        String sql = "UPDATE NHANVIEN SET HoTen = ?, NgaySinh = ?, DiaChi = ?, SDT = ?, CMND = ? WHERE MaNV = ?";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
  
            ps.setString(1, nv.getHoten());
            ps.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getCmnd());
            ps.setString(6, nv.getMaNV());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException ex) {
            System.out.println("Lỗi khi cập nhật nhân viên: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean addNhanVien(NhanVien nv) {
        String sql = "INSERT INTO NHANVIEN (MaNV, HoTen, NgaySinh, DiaChi, SDT, CMND) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = KetNoiCSDL.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoten());
            ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime())); 
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getCmnd());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
     public List<NhanVien> searchNhanVien(String loaiTimKiem, String duLieu) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<NhanVien> resultList = new ArrayList<>();

        try {
            conn = KetNoiCSDL.getConnection();
            String query = "";

            switch (loaiTimKiem) {
                case "Mã NV":
                    query = "SELECT MaNV, HoTen, NgaySinh, DiaChi, SDT, CMND " +
                            "FROM NHANVIEN " +
                            "WHERE MaNV LIKE ?";
                    break;
                case "Tên NV":
                    query = "SELECT MaNV, HoTen, NgaySinh, DiaChi, SDT, CMND " +
                            "FROM NHANVIEN " +
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
                String MaNV = rs.getString("MaNV");
                String TenNV = rs.getString("HoTen");
                Date Ngsinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String Sdt = rs.getString("SDT");
                String Cmnd = rs.getString("CMND");

                NhanVien nv = new NhanVien(MaNV, TenNV, diaChi, Sdt, Cmnd, Ngsinh);
                resultList.add(nv);
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
