package DAO;

import DTO.ChiTietPhieuNhap;
import DTO.PhieuNhap;

import java.sql.*;
import java.util.ArrayList;

public class DAOChiTietPhieuNhap {

	private Connection con;
//    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;user=sa;password=123;encrypt=false;";

	public boolean openConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;encrypt = false;";
			String username = "sa";
			String password = "123";
			con = DriverManager.getConnection(dbUrl, username, password);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

//	public String generateNewCTPN() {
//		String newCTPN = null;
//
//		if (openConnection()) {
//			try {
//				// Truy vấn để lấy mã chi tiết phiếu nhập cuối cùng
//				String sql = "SELECT MAX(MaChiTiet) AS LastCTPN FROM CTPNhap";
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//				if (rs.next()) {
//					String lastCTPN = rs.getString("LastCTPN");
//					if (lastCTPN != null) {
//						// Lấy số cuối cùng của mã chi tiết phiếu nhập và tăng lên 1 để tạo mã mới
//						int lastNumber = Integer.parseInt(lastCTPN);
//						newCTPN = String.valueOf(lastNumber + 1); // Tạo mã mới là số nguyên tiếp theo
//					} else {
//						// Nếu chưa có chi tiết phiếu nhập nào trong CSDL, bắt đầu với số 1
//						newCTPN = "1";
//					}
//				}
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			} finally {
//				closeConnection();
//			}
//		}

//		return newCTPN;
//	}

	public ArrayList<ChiTietPhieuNhap> getListChiTietPhieuNhap(String maPhieuNhap) {

		ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap = new ArrayList<>();

		if (openConnection()) {
			try {
				String sql = "Select * from CTPNhap where MaPhieuNhap = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maPhieuNhap);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
					
					ctpn.setMaPhieuNhap(rs.getString(1));
					ctpn.setMaThuoc(rs.getNString(2));
					ctpn.setSoLuong(rs.getInt(3));
					ctpn.setThanhTien(rs.getFloat(4));
				
					listChiTietPhieuNhap.add(ctpn);
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} else {
			closeConnection();
		}
		return listChiTietPhieuNhap;
	}

	public boolean addChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
		boolean result = false;

		if (openConnection()) {
			try {
				String sql = "Insert into CTPNhap values(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, chiTietPhieuNhap.getMaPhieuNhap());
				stmt.setString(2, chiTietPhieuNhap.getMaThuoc());
				stmt.setInt(3, chiTietPhieuNhap.getSoLuong());
				stmt.setFloat(4, chiTietPhieuNhap.getThanhTien());
		
				if (stmt.executeUpdate() >= 1)
					result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			}

		} else {
			closeConnection();
		}
		return result;
	}

	public boolean deleteChiTietPhieuNhap(ChiTietPhieuNhap phieuNhap) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE FROM CTPNhap WHERE MaPhieuNhap=? and MaThuoc";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, phieuNhap.getMaPhieuNhap());
				ps.setString(2,phieuNhap.getMaThuoc());
				result = ps.executeUpdate() > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<ChiTietPhieuNhap> findChiTietPhieuNhap(String searchKeyword) {
		ArrayList<ChiTietPhieuNhap> result = new ArrayList<>();

		if (openConnection()) {
			try {
				String sql = "SELECT MaPhieuNhap,MaThuoc FROM CTPNhap WHERE MaPhieuNhap = ? OR MaThuoc = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, searchKeyword);
				stmt.setString(2, searchKeyword);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String maPhieuNhap = rs.getString("MaPhieuNhap");
					String MaThuoc = rs.getString("MaThuoc");
					ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
					chiTietPhieuNhap.setMaPhieuNhap(maPhieuNhap);
					chiTietPhieuNhap.setMaThuoc(MaThuoc);
					result.add(chiTietPhieuNhap);
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}
		}

		return result;
	}

	public String getTenThuoc(String MaThuoc) {
		String tenThuoc = null;
		if (openConnection()) {

			try {
				String sql = "SELECT TenThuoc FROM THUOC WHERE MaThuoc = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, MaThuoc);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					tenThuoc = rs.getString("TenThuoc");
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}

		}
		return tenThuoc;
	}

	public void updateSoLuongChiTiet(String MaThuoc, int soLuong) {

		if (openConnection()) {

			try {
				String sql = "UPDATE CTPNhap SET SoLuongNhap = ? WHERE MaThuoc = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, soLuong); // Số lượng thêm
				stmt.setString(2, MaThuoc);
				int rowsAffected = stmt.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Đã cập nhật số lượng thành công.");
				} else {
					System.out.println("Không thể cập nhật số lượng.");
				}

			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}

		}

	}
	
//	public void updateThanhTien(String maPhieuNhap)
//	{
//		
//		if (openConnection()) {
//			try {
//				String sql = "UPDATE CTPNhap SET ThanhTien = SoLuong * DonGia WHERE maPhieuNhap = ?";
//				PreparedStatement ps = con.prepareStatement(sql);
//				ps.setString(1, maPhieuNhap);
//	            if (ps.executeUpdate() > 0);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
//	}
	
}
