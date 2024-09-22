/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.BUS;

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
import qlycuahangthuoc.DAO.CTHD_Dao;
import qlycuahangthuoc.DAO.KetNoiCSDL;
import qlycuahangthuoc.DTO.CTHD_DTO;

/**
 *
 * @author vanqu
 */
public class CTHD_Bus {
    
    CTHD_Dao cthdd = new CTHD_Dao();
    
    // Phương thức để tải Mã hóa đơn vào JComboBox
    public boolean loadcboxMaHD(JComboBox<String> comboBox) {
        return cthdd.loadcboxMaHD(comboBox);
    }
    
    // Phương thức để tải Mã Thuốc vào JComboBox
    public boolean loadCboxMaThuoc(JComboBox<String> comboBox) {
        return cthdd.loadCboxMaThuoc(comboBox);
    }
    
    public List<CTHD_DTO> getListCTHD() {
        return cthdd.getListCTHD();
    }
    
    public List<CTHD_DTO> getListCTHDByMaHD(String maHD) {
        return cthdd.getListCTHDByMaHD(maHD);
    }
    
    // Phương thức để lấy giá tiền từ CSDL dựa trên mã thuốc
    public static BigDecimal layGiaTien(String maThuoc) {
        return CTHD_Dao.layGiaTien(maThuoc);
    }
    
    // Thêm một chi tiết hóa đơn mới
    public boolean themCTHD(CTHD_DTO cthd) {
        return cthdd.themCTHD(cthd);
    }

    // Cập nhật thông tin của một chi tiết hóa đơn
    public boolean suaCTHD(CTHD_DTO cthd) {
        return cthdd.suaCTHD(cthd);
    }

    // Xóa một chi tiết hóa đơn dựa trên mã hóa đơn và mã thuốc
    public boolean xoaCTHD(String maHD, String maThuoc) {
        return  cthdd.xoaCTHD(maHD, maThuoc);
    }
    
     public List<CTHD_DTO> timKiemCTHDTheoMaHD(String tuKhoa) {
        return cthdd.timKiemCTHDTheoMaHD(tuKhoa);
    }

    public List<CTHD_DTO> timKiemCTHDTheoMaThuoc(String tuKhoa) {
        return cthdd.timKiemCTHDTheoMaThuoc(tuKhoa);
    }
}
