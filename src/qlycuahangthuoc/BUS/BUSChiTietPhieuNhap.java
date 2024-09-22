package BUS;

import java.util.ArrayList;

import DAO.DAOChiTietPhieuNhap;
import DTO.ChiTietPhieuNhap;

public class BUSChiTietPhieuNhap {
	DAOChiTietPhieuNhap daoctpn = new DAOChiTietPhieuNhap();
	
//	public String getMaChiTiet()
//	{
//		return daoctpn.generateNewCTPN();
//	}
	
	public ArrayList<ChiTietPhieuNhap> getListChiTietPhieuNhap(String maPhieuNhap){
		try {
			ArrayList<ChiTietPhieuNhap> ctpn = daoctpn.getListChiTietPhieuNhap(maPhieuNhap);
			return ctpn;
        } catch (Exception ex) { 
            ex.printStackTrace();
            return new ArrayList<>(); 
        }
	}
	
	public String addChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) { 
		if(daoctpn.addChiTietPhieuNhap(chiTietPhieuNhap))
		{
			return "Thêm Thành Công";
		}
		return "Thêm thất bại";
	}
	
	public String deleteChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap ){
		if(daoctpn.deleteChiTietPhieuNhap(chiTietPhieuNhap))
		{
			return "Xóa Thành Công";
		}
		return "Xóa Thất Bại";
		
	}
	
	public ArrayList<ChiTietPhieuNhap> findChiTietPhieuNhap(String searchKeyword) {
		return daoctpn.findChiTietPhieuNhap(searchKeyword);
	}

	public String getTenThuoc(String maThuoc)
	{
		return daoctpn.getTenThuoc(maThuoc);
	}
	
	public void updateSoLuongChiTiet(String maThuoc, int soLuong)
	{
		 daoctpn.updateSoLuongChiTiet(maThuoc, soLuong);
	}

	public void updateThanhTien(String maPhieuNhap) {
		// TODO Auto-generated method stub
		
	}

//	public void updateThanhTien(String maPhieuNhap) {
//		
//		daoctpn.updateThanhTien(maPhieuNhap);
//	}
	
}
