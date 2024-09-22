package DTO;

import java.sql.Date;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private int giaBan;
	private int soLuong;
	private Date hanSuDung;
	private String maNCC;
	private String maLoai;
	
	public Thuoc()
	{
		
	}
	public Thuoc(String maThuoc, String tenThuoc, int giaBan, int soLuong, Date hanSuDung, String maNCC,
			String maLoai) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.hanSuDung = hanSuDung;
		this.maNCC = maNCC;
		this.maLoai = maLoai;
	}
	
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public Date getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	
	
}
