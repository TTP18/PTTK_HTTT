package BUS;

import java.util.ArrayList;

import DAO.DAOncc;
import DTO.NhaCungCap;

public class BUSncc {

	DAOncc daoncc = new DAOncc();
	
	public ArrayList<NhaCungCap> getListNCC()
	{
		return daoncc.getListNCC();
	}
	
	public String addNCC(NhaCungCap ncc)
	{
		if(daoncc.checkMaNCC(ncc.getMaNCC()) || daoncc.checkSDT(ncc.getPhoneNumber()) )
		{
			return "Mã Id / Số Điện Thoại đã tồn tại";
		}
		if(daoncc.addNCC(ncc))
		{
			  return "Thêm Thành Công";
		}
		 return "Thêm Thất Bại"; 
	}
	
	public String deleteNCC (NhaCungCap ncc ) {
		if(daoncc.deleteNCC(ncc.getMaNCC()))
		{
			 return "Xóa Thành Công";
		}
		return "Xóa Thất Bại";
	}
	
	public String updateNCC(NhaCungCap ncc) {
	    if (daoncc.checkMaNCC(ncc.getMaNCC())) {
	        if (daoncc.checkSDT(ncc.getPhoneNumber())) {
	            // Gọi DAO để cập nhật thông tin nhà cung cấp
	            if (daoncc.updateNCC(ncc)) {
	                return "Cập nhật thông tin nhà cung cấp thành công";
	            } else {
	                return "Cập nhật thông tin nhà cung cấp thất bại";
	            }
	        } else {
	            return "Số điện thoại đã tồn tại";
	        }
	    }
	    else {
	        return "Mã nhà cung cấp không tồn tại";
	    }
	}
	
	public ArrayList<NhaCungCap> findNCCByNameOrId(String searchKeyword)
	{
		
			return daoncc.findNCCByNameOrId(searchKeyword);
		
	}
	
	public String getTenNCC(String maNCC)
	{
		return daoncc.getTenNCC(maNCC);
	}
	
}
