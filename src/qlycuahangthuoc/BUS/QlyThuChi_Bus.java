/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.BUS;

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
import qlycuahangthuoc.DAO.KetNoiCSDL;
import qlycuahangthuoc.DAO.QlyThuChi_Dao;

/**
 *
 * @author vanqu
 */
public class QlyThuChi_Bus {
    
    QlyThuChi_Dao qlyThuChi_Dao = new QlyThuChi_Dao();
    
    public boolean loadTableDoanhThuData(JTable table) {
        return qlyThuChi_Dao.loadTableDoanhThuData(table);
    }
    
    public boolean loadTableNhapHangData(JTable table) {
        return qlyThuChi_Dao.loadTableNhapHangData(table);
    }
    
    public boolean thongKeDoanhThu(JTable table, Date startDate, Date endDate) {
        return qlyThuChi_Dao.thongKeDoanhThu(table, startDate, endDate);
    }
    
    public boolean thongKeNhapHang(JTable table, Date startDate, Date endDate) {
        return qlyThuChi_Dao.thongKeNhapHang(table, startDate, endDate);
    }
    
    private boolean loadDataToTable(JTable table, String query) {
        return loadDataToTable(table, query);
    }
    
}
