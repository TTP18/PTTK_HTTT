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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.DAO.KetNoiCSDL;
import qlycuahangthuoc.DAO.QlyTaiKhoan_Dao;
import qlycuahangthuoc.DTO.TaiKhoan;

/**
 *
 * @author vanqu
 */
public class QlyTaiKhoan_Bus {
    
    QlyTaiKhoan_Dao taiKhoan_Dao = new QlyTaiKhoan_Dao();
    
    // Phương thức để tải Mã nhân viên vào JComboBox
    public boolean loadcboxMaNV(JComboBox<String> comboBox) {
        return taiKhoan_Dao.loadcboxMaNV(comboBox);
    }
    
    // Phương thức để lấy danh sách tài khoản từ cơ sở dữ liệu
    public List<TaiKhoan> getListTaiKhoanFromData() {
        return taiKhoan_Dao.getListTaiKhoanFromData();
    }
    
    public void loadDataTable(JTable table){
        List<TaiKhoan> listTK = getListTaiKhoanFromData();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for(TaiKhoan TK : listTK){
            Object [] row = {TK.getUsername(),TK.getPass(),TK.getIdNV(),TK.getIdTK(),TK.getLoaitk()};
            model.addRow(row);
        }
    }
    
    // Phương thức để thêm tài khoản vào cơ sở dữ liệu
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        return taiKhoan_Dao.addTaiKhoan(taiKhoan);
    }

    // Phương thức để cập nhật thông tin tài khoản trong cơ sở dữ liệu
    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        return taiKhoan_Dao.updateTaiKhoan(taiKhoan);
    }

    // Phương thức để xóa tài khoản từ cơ sở dữ liệu
    public boolean deleteTaiKhoan(String idTaiKhoan) {
        return taiKhoan_Dao.deleteTaiKhoan(idTaiKhoan);
    }
    
    // Kiểm tra sự tồn tại của username trong cơ sở dữ liệu
    public boolean isUsernameExists(String username) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "SELECT * FROM TAIKHOAN WHERE UserName = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            return rs.next(); // Trả về true nếu tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    // Kiểm tra sự tồn tại của idTK trong cơ sở dữ liệu
    public boolean isIdTKExists(String idTK) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "SELECT * FROM TAIKHOAN WHERE idTaiKhoan = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, idTK);
            rs = stm.executeQuery();
            return rs.next(); // Trả về true nếu tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    // Kiểm tra sự tồn tại của idNV trong cơ sở dữ liệu
    public boolean isIdNVExists(String idNV) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "SELECT * FROM TAIKHOAN WHERE idNhanVien = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, idNV);
            rs = stm.executeQuery();
            return rs.next(); // Trả về true nếu tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean searchTaiKhoanByOption(JTable table, String searchText, String searchOption) {
        return taiKhoan_Dao.searchTaiKhoanByOption(table, searchText, searchOption);
    }
}
