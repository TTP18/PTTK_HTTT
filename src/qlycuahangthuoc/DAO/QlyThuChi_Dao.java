/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vanqu
 */
public class QlyThuChi_Dao {
    
    public boolean loadTableDoanhThuData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select hd.MaHD , hd.NgayLap, cthd.SoLuong, cthd.Thanhtien
                                        from HOADON hd , CTHD cthd
                                        where hd.MaHD = cthd.MaHD""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                
                Object[] row = new Object[4]; // Số cột trong bảng
                String mahd = rs.getString("MaHD");
                String ngaylap = rs.getString("NgayLap");
                String soluong = rs.getString("SoLuong");
                String thanhtien = rs.getString("Thanhtien");
                
                                
                row[0] = mahd;
                row[1] = ngaylap;
                row[2] = soluong;
                row[3] = thanhtien;
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyThuChi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean loadTableNhapHangData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select nt.MaPhieuNhap , nt.NgayNhap, ctpn.MaThuoc, ctpn.SoLuongNhap, ctpn.Thanhtien
                                        from NHAPTHUOC nt, CTPNHAP ctpn
                                        where nt.MaPhieuNhap = ctpn.MaPhieuNhap""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                
                Object[] row = new Object[5]; // Số cột trong bảng
                String mapn = rs.getString("MaPhieuNhap");
                String ngaynhap = rs.getString("NgayNhap");
                String mathuoc = rs.getString("MaThuoc");
                String soluongnhap = rs.getString("SoLuongNhap");
                String thanhtien = rs.getString("Thanhtien");

                                
                row[0] = mapn;
                row[1] = ngaynhap;
                row[2] = mathuoc;
                row[3] = soluongnhap;
                row[4] = thanhtien;
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyThuChi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean thongKeDoanhThu(JTable table, Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = sdf.format(startDate);
        String endDateStr = sdf.format(endDate);

        String query = "SELECT hd.MaHD, hd.NgayLap, cthd.SoLuong, cthd.Thanhtien " +
                       "FROM HOADON hd, CTHD cthd " +
                       "WHERE hd.MaHD = cthd.MaHD " +
                       "AND hd.NgayLap BETWEEN '" + startDateStr + "' AND '" + endDateStr + "'";

        return loadDataToTable(table, query);
    }

    public boolean thongKeNhapHang(JTable table, Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr = sdf.format(startDate);
        String endDateStr = sdf.format(endDate);

        String query = "SELECT nt.MaPhieuNhap, nt.NgayNhap, ctpn.MaThuoc, ctpn.SoLuongNhap, ctpn.Thanhtien " +
                       "FROM NHAPTHUOC nt, CTPNHAP ctpn " +
                       "WHERE nt.MaPhieuNhap = ctpn.MaPhieuNhap " +
                       "AND nt.NgayNhap BETWEEN '" + startDateStr + "' AND '" + endDateStr + "'";

        return loadDataToTable(table, query);
    }

    
    private boolean loadDataToTable(JTable table, String query) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean success = false;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[model.getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getString(i + 1);
                }
                model.addRow(row);
            }
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }
    
}
