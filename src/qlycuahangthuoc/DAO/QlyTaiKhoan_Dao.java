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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.DTO.TaiKhoan;

/**
 *
 * @author vanqu
 */
public class QlyTaiKhoan_Dao {
    
    
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
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    // Phương thức để lấy danh sách tài khoản từ cơ sở dữ liệu
    public List<TaiKhoan> getListTaiKhoanFromData() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<TaiKhoan> listTK = new ArrayList<>();
        
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("SELECT * FROM TAIKHOAN");
            rs = stm.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("UserName");
                String pass = rs.getString("Pass");
                String idNV = rs.getString("idNhanVien");
                String idTK = rs.getString("idTaiKhoan");
                int loaitk = rs.getInt("loaitk");
                
                TaiKhoan TK = new TaiKhoan(username, pass, idNV, idTK, loaitk);
                listTK.add(TK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        
        return listTK;
    }
    
    // Phương thức để thêm tài khoản vào cơ sở dữ liệu
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "INSERT INTO TAIKHOAN (UserName, Pass, idNhanVien, idTaiKhoan, loaitk) VALUES (?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);

            stm.setString(1, taiKhoan.getUsername());
            stm.setString(2, taiKhoan.getPass());
            stm.setString(3, taiKhoan.getIdNV());
            stm.setString(4, taiKhoan.getIdTK()); // Thiết lập giá trị cho idTK
            stm.setInt(5, taiKhoan.getLoaitk());

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    // Phương thức để cập nhật thông tin tài khoản trong cơ sở dữ liệu
    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "UPDATE TAIKHOAN SET UserName=?, Pass=?, idNhanVien=?, loaitk=? WHERE idTaiKhoan=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, taiKhoan.getUsername());
            stm.setString(2, taiKhoan.getPass());
            stm.setString(3, taiKhoan.getIdNV());
            stm.setInt(4, taiKhoan.getLoaitk());
            stm.setString(5, taiKhoan.getIdTK());

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    // Phương thức để xóa tài khoản từ cơ sở dữ liệu
    public boolean deleteTaiKhoan(String idTaiKhoan) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = KetNoiCSDL.getConnection();
            String sql = "DELETE FROM TAIKHOAN WHERE idTaiKhoan=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, idTaiKhoan);

            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(QlyTaiKhoan_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }
    
    public boolean searchTaiKhoanByOption(JTable table, String searchText, String searchOption) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "";
            if (searchOption.equals("Username")) {
                query = "SELECT * FROM TaiKhoan WHERE Username LIKE ?";
            } else if (searchOption.equals("Mã TK")) {
                query = "SELECT * FROM TaiKhoan WHERE idTaiKhoan LIKE ?";
            } else if (searchOption.equals("Mã NV")) {
                query = "SELECT * FROM TaiKhoan WHERE idNhanVien LIKE ?";
            } else {
                // Không có lựa chọn hợp lệ
                return false;
            }

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchText + "%");
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            boolean foundData = false; // Biến để kiểm tra xem có dữ liệu được tìm thấy không

            while (rs.next()) {
                foundData = true; // Đã tìm thấy dữ liệu
                Object[] row = new Object[5];
                row[0] = rs.getString("Username");
                row[1] = rs.getString("Pass");
                row[2] = rs.getString("idNhanVien");
                row[3] = rs.getString("idTaiKhoan");
                row[4] = rs.getInt("LoaiTK");
                model.addRow(row);
            }

            if (!foundData) {
                // Hiển thị thông báo khi không tìm thấy dữ liệu
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu phù hợp.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }

    
    
}
