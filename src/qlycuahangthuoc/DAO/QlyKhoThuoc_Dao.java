package qlycuahangthuoc.DAO;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlycuahangthuoc.DTO.KhoThuoc;

public class QlyKhoThuoc_Dao extends KetNoiCSDL {

    public boolean loadTableData(JTable table) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = KetNoiCSDL.getConnection();
            stm = conn.prepareStatement("""
                                        select kt.MaKho, kt.MaThuoc, t.TenThuoc, t.GiaBan, kt.SoLuongMoiLoai, t.HanSuDung
                                        from KHOTHUOC kt, THUOC t
                                        where kt.MaThuoc = t.MaThuoc""");
            rs = stm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String maKho = rs.getString("MaKho");
                String maThuoc = rs.getString("MaThuoc");
                String tenThuoc = rs.getString("TenThuoc");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");
                int soLuongMoiLoai = rs.getInt("SoLuongMoiLoai");
                java.util.Date hanSuDung = rs.getDate("HanSuDung");

                KhoThuoc khoThuoc = new KhoThuoc(maKho, maThuoc, tenThuoc, giaBan, soLuongMoiLoai, hanSuDung);

                Object[] row = {maKho, maThuoc, tenThuoc, giaBan, soLuongMoiLoai, hanSuDung};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QlyKhoThuoc_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
        return true;
    }
    
    public boolean themThuoc(KhoThuoc khoThuoc) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "INSERT INTO KHOTHUOC (MaKho, MaThuoc, SoLuongMoiLoai, HanSuDung) VALUES (?, ?, ?, ?)";
            stm = conn.prepareStatement(query);
            stm.setString(1, khoThuoc.getMaKho());
            stm.setString(2, khoThuoc.getMaThuoc());
            stm.setInt(3, khoThuoc.getSoluong());
            stm.setDate(4, new java.sql.Date(khoThuoc.getHSD().getTime()));
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean suaThuoc(KhoThuoc khoThuoc) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "UPDATE KHOTHUOC SET SoLuongMoiLoai = ?, HanSuDung = ? WHERE MaThuoc = ?";
            stm = conn.prepareStatement(query);
            stm.setInt(1, khoThuoc.getSoluong());
            stm.setDate(2, new java.sql.Date(khoThuoc.getHSD().getTime()));
            stm.setString(3, khoThuoc.getMaThuoc());
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

    public boolean xoaThuoc(String maThuoc) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = KetNoiCSDL.getConnection();
            String query = "DELETE FROM KHOTHUOC WHERE MaThuoc = ?";
            stm = conn.prepareStatement(query);
            stm.setString(1, maThuoc);
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            KetNoiCSDL.Closeconnection(conn);
        }
    }

}