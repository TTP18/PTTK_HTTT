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
import qlycuahangthuoc.DAO.QlyHoaDon_Dao;
import qlycuahangthuoc.DAO.QlyTaiKhoan_Dao;
import qlycuahangthuoc.DTO.HoaDon;

/**
 *
 * @author vanqu
 */
public class QlyHoaDon_Bus {
    
    QlyHoaDon_Dao qlyHoaDon_Dao= new QlyHoaDon_Dao();
    
    // Phương thức để tải Mã nhân viên vào JComboBox
    public boolean loadcboxMaNV(JComboBox<String> comboBox) {
        return qlyHoaDon_Dao.loadcboxMaNV(comboBox);
    }
    
    // Phương thức để tải Mã khach hang vào JComboBox
    public boolean loadcboxMaKH(JComboBox<String> comboBox) {
        return qlyHoaDon_Dao.loadcboxMaKH(comboBox);
    }
    
    public List<HoaDon> getListHoaDonFromData() {
        return qlyHoaDon_Dao.getListHoaDonFromData();
    }
    
    public String getTenKHByMaKH(String maKH) {
        return qlyHoaDon_Dao.getTenKHByMaKH(maKH);
    }

    public String getTenNVByMaNV(String maNV) {
        return qlyHoaDon_Dao.getTenNVByMaNV(maNV);
    }
    
    public boolean isMaHoaDonExists(String maHD) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            con = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) AS count FROM HOADON WHERE MaHD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maHD);
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
    
    public boolean deleteHoaDon(String maHD) {
        return qlyHoaDon_Dao.deleteHoaDon(maHD);
    }

    public boolean updateHoaDon(HoaDon hd) {
        return qlyHoaDon_Dao.updateHoaDon(hd);
    }

    public boolean addHoaDon(HoaDon hd) {
        return qlyHoaDon_Dao.addHoaDon(hd);
    }
    
    public List<HoaDon> searchHoaDon(String loaiTimKiem, String duLieu) {
        return qlyHoaDon_Dao.searchHoaDon(loaiTimKiem, duLieu);
    }
}
