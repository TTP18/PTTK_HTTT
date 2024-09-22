package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;

import DTO.Thuoc;


public class DAOThuoc {

	private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;encrypt=false;";
//    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;user=sa;password=123;encrypt=false;";

    public static Connection getConnection (){
        Connection conn = null ;
        try {
            conn = DriverManager.getConnection(connectionUrl, "sa", "123");
            System.out.println("Done");
        } catch (SQLException ex) {
            Logger.getLogger(DAOThuoc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fail");
        }
        return conn;
    }

	public ArrayList<Thuoc> getListThuoc() {
		ArrayList<Thuoc> list = new ArrayList<>();

		try {
			Connection conn = getConnection();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM THUOC");

			while (rs.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(rs.getString("MaThuoc"));
				thuoc.setTenThuoc(rs.getString("TenThuoc"));
				thuoc.setGiaBan(rs.getInt("GiaBan"));
				thuoc.setSoLuong(rs.getInt("SoLuong"));
				thuoc.setHanSuDung(rs.getDate("HanSuDung"));
				thuoc.setMaNCC(rs.getString("MaNCC"));
				thuoc.setMaLoai(rs.getString("MaLoai"));
				list.add(thuoc);
			}

		} catch (SQLException ex) {
			Logger.getLogger(DAOThuoc.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}

	public ArrayList<Thuoc> findbyName(String name) {

		ArrayList<Thuoc> list = new ArrayList<>();
		String sql = "SELECT * FROM tblThuoc WHERE TENTHUOC like ?";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(rs.getString("MaThuoc"));
				thuoc.setTenThuoc(rs.getString("TenThuoc"));
				thuoc.setGiaBan(rs.getInt("GiaBan"));
				thuoc.setSoLuong(rs.getInt("SoLuong"));
				thuoc.setHanSuDung(rs.getDate("HanSuDung"));
				thuoc.setMaNCC(rs.getString("MaNCC"));
				thuoc.setMaLoai(rs.getString("MaLoai"));
				list.add(thuoc);
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public String getGiaThuoc(String maThuoc)
	{
		String tenThuoc = null;
		try {
			
			Connection conn = getConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT TenThuoc FROM THUOC Where MaThuoc = ?");
			stm.setString(1, maThuoc);			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				tenThuoc = rs.getString("TenThuoc");
			}

		} catch (SQLException ex) {
			Logger.getLogger(DAOThuoc.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tenThuoc;
		
	}

}
