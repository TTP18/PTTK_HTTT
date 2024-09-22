package DTO;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String phoneNumber;
	private String address;
	
	public NhaCungCap()
	{
		
	}
	
	public NhaCungCap(String maNCC, String tenNCC, String phoneNumber, String address) {
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
