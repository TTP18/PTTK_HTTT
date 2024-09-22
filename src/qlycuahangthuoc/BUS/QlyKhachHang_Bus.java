/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.BUS;

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
import qlycuahangthuoc.DAO.KetNoiCSDL;
import qlycuahangthuoc.DAO.QlyKhachHang_Dao;
import qlycuahangthuoc.DTO.KhachHang;

public class QlyKhachHang_Bus {
    QlyKhachHang_Dao qlyKhachHang_Dao= new QlyKhachHang_Dao();
    
     public List<KhachHang> getListKhachHangFromData() {
        return qlyKhachHang_Dao.getListKhachHangFromData();
    }
    
    public String getTenKHByMaKH(String maKH) {
        return qlyKhachHang_Dao.getTenKHByMaKH(maKH);
    }
    
    public boolean isMaKHExists(String maKH) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            con = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) AS count FROM KHACHHANG WHERE MaKH = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                exists = (count > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
            // Đảm bảo phải đóng tất cả các tài nguyên sau khi sử dụng
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return exists;
    }
    
     public boolean deleteKhachHang(String maKH) {
        return qlyKhachHang_Dao.deleteKH(maKH);
    }

    public boolean updateKhachHang(KhachHang kh) {
        return qlyKhachHang_Dao.updateKhachHang(kh);
    }

    public boolean addKhachHang(KhachHang kh) {
        return qlyKhachHang_Dao.addKhachHang(kh);
    }
    
    public List<KhachHang> searchKhachHang(String loaiTimKiem, String duLieu) {
        return qlyKhachHang_Dao.searchKhachHang(loaiTimKiem, duLieu);
    }
}
