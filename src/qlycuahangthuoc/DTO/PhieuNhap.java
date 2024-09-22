package DTO;

import java.sql.Date;
import java.time.LocalDate;

public class PhieuNhap {
	
	private String maPhieuNhap;
	private String maNV;
	private Date ngayLap;
	private String maNCC;
	
	public PhieuNhap()
	{
		
	}

	public PhieuNhap(String maPhieuNhap, String maNV, Date ngayLap, String maNCC) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.maNCC = maNCC;
	}

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	
	

	
	
	

}
