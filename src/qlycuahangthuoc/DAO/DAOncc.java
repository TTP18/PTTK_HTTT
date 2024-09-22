package DAO;


import DTO.NhaCungCap;

import java.sql.*;
import java.util.ArrayList;


public class DAOncc {

	private Connection con;
//	private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;user=sa;password=123;encrypt=false;";

	public boolean openConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCUAHANGTHUOC;encrypt=true;trustServerCertificate=true;";
			String username = "sa"; String password= "123";
			con = DriverManager.getConnection(connectionUrl, username, password);
			return true;
		} catch (Exception ex) {
			System.out.println(ex); 
			return false; }
	}
	
	public void closeConnection() {
		try {
			if (con!=null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex);}
	} 
	
	public ArrayList<NhaCungCap> getListNCC(){
		
		 ArrayList<NhaCungCap> listNCC = new ArrayList<>();
		 
		 if (openConnection()) {
			 try {
				 String sql = "Select * from NHACUNGCAP";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()){
					 NhaCungCap ncc = new NhaCungCap();
					 ncc.setMaNCC(rs.getString("MaNCC"));
					 ncc.setTenNCC(rs.getString("TenNCC"));
					 ncc.setAddress(rs.getString("DiaChi"));
					 ncc.setPhoneNumber(rs.getString("SDT"));
					 listNCC.add(ncc);
				 }
				 
			 }catch (SQLException ex) {
				 System.out.println(ex);
			 }
		 }else { 
			 closeConnection();
		 } 
			 return listNCC;
		 
	}
	
	public boolean addNCC(NhaCungCap ncc) { 
		boolean result = false;
		
		if (openConnection()) {
			try {
				String sql = "Insert into NHACUNGCAP values(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, ncc.getMaNCC());
				stmt.setString(2, ncc.getTenNCC());
				stmt.setString(3, ncc.getPhoneNumber());
				stmt.setString(4, ncc.getAddress());
				if (stmt.executeUpdate()>=1)
					result = true;
			}catch (SQLException ex) {
				System.out.println(ex); 
			}
			
		}else {
			closeConnection();
		}
		return result;
	}
	
	public boolean checkMaNCC(String maNCC){
		
		boolean result = false; 
		if (openConnection()) {
			try { 
				
				String sql = "Select * from NHACUNGCAP where MaNCC = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maNCC);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
	                result = true; // PhieuNhap với maPhieuNhap khớp tồn tại
	            }
				
			}catch (SQLException ex) {
			System.out.println(ex);
			}
		finally {
		closeConnection();}
		}
		return result;

	}
	
	public boolean checkSDT(String SDT){
			
			boolean result = false; 
			if (openConnection()) {
				try { 
					
					String sql = "Select * from NHACUNGCAP where SDT="+SDT;
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					result = rs.next();
					
				}catch (SQLException ex) {
				System.out.println(ex);
				}
			}else {
				closeConnection();
			}
			return result;
	
	}
	
	public boolean deleteNCC (String maNCC ){
        boolean result = false; 
        if(openConnection())
        {
	        try {
	           String sql = "DELETE FROM NHACUNGCAP WHERE MaNCC=?";
	           PreparedStatement ps = con.prepareStatement(sql);
	           ps.setString(1,maNCC);
	           result = ps.executeUpdate() > 0;
	        }catch(SQLException e){
	            e.printStackTrace(); 
	        }
        }
        
        return result;
    }
	
	public boolean updateNCC(NhaCungCap ncc) {
	    boolean result = false;

	    if (openConnection()) {
	        try {
	            String sql = "UPDATE NHACUNGCAP SET TenNCC = ?, SDT = ?, DiaChi = ? WHERE MaNCC = ?";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, ncc.getTenNCC());
	            stmt.setString(2, ncc.getPhoneNumber());
	            stmt.setString(3, ncc.getAddress());
	            stmt.setString(4, ncc.getMaNCC());

	            if (stmt.executeUpdate() > 0) {
	                result = true;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	            closeConnection();
	        }
	    }

	    return result;
	}
	
	public ArrayList<NhaCungCap> findNCCByNameOrId(String searchKeyword) {
        ArrayList<NhaCungCap> result = new ArrayList<>();

        if (openConnection()) {
            try {
                String sql = "SELECT MaNCC, TenNCC ,SDT, DiaChi FROM NHACUNGCAP WHERE MaNCC = ? OR TenNCC LIKE ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, searchKeyword);
                stmt.setString(2, "%" + searchKeyword + "%");
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String maNCC = rs.getString("MaNCC");
                    String tenNCC = rs.getString("TenNCC");
                    String phone = rs.getString("SDT");
                    String DiaChi = rs.getString("DiaChi");
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(maNCC);
                    ncc.setTenNCC(tenNCC);
                    ncc.setPhoneNumber(phone);
                    ncc.setAddress(DiaChi);
                    result.add(ncc);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }

        return result;
    }
	
	public String getTenNCC(String maNCC) {
		String tenNCC = null;
		if (openConnection()) {

			try {
				String sql = "SELECT TenNCC FROM NHACUNGCAP WHERE MaNCC = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, maNCC);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					tenNCC = rs.getString("TenNCC");
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection();
			}

		}
		return tenNCC;
	}
	
	
	
}
