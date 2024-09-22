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
import qlycuahangthuoc.DAO.QlyNhanVien_Dao;
import qlycuahangthuoc.DTO.NhanVien;

public class QlyNhanVien_Bus {
    QlyNhanVien_Dao nvDao = new QlyNhanVien_Dao();
     public List<NhanVien> getListNhanVienFromData() {
        return nvDao.getListNhanVienFromData();
    }
    
    public String getTenNVbyMaNV(String maNV) {
        return nvDao.getTenNVbyMaNV(maNV);
    }
    
    public boolean isMaNVExists(String maNV) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            con = KetNoiCSDL.getConnection();
            String query = "SELECT COUNT(*) AS count FROM NHANVIEN WHERE MaNV = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maNV);
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
    
    public boolean isCMNDExist(String CMND){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = KetNoiCSDL.getConnection();
            ps = con.prepareStatement("select count(*) as count from NHANVIEN where CMND = ?");
            ps.setString(1, CMND);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (Exception e) {
        } finally {
            KetNoiCSDL.Closeconnection(con);
        }
        return false;
    }
    
     public boolean deleteNhanVien(String maNV) {
        return nvDao.deleteNV(maNV);
    }

    public boolean updateNhanVien(NhanVien nv) {
        return nvDao.updateNhanVien(nv);
    }

    public boolean addNhanVien(NhanVien nv) {
        return nvDao.addNhanVien(nv);
    }
    
    public List<NhanVien> searchNhanVien(String loaiTimKiem, String duLieu) {
        return nvDao.searchNhanVien(loaiTimKiem, duLieu);
    }
}
