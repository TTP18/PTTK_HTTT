package DTO;

public class ChiTietPhieuNhap {
	
	private String maPhieuNhap;
	private String maThuoc;
	private int soLuong;
	private float thanhTien;
	
	public ChiTietPhieuNhap()
	{
		
	}
	
	public ChiTietPhieuNhap(String maPhieuNhap, String maThuoc, int soLuong, float thanhTien ) {
		
		this.maPhieuNhap = maPhieuNhap;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	
	

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
//	public float getDonGia() {
//		return donGia;
//	}
//	public void setDonGia(float donGia) {
//		this.donGia = donGia;
//	}
	
	public float getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
	

}
