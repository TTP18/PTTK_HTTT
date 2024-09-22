package BUS;

import java.util.ArrayList;

import DAO.DAOPhieuNhap;
import DTO.PhieuNhap;

public class BUSPhieuNhap {

	DAOPhieuNhap daopn = new DAOPhieuNhap();
	
	public ArrayList<PhieuNhap> getListPhieuNhap(){
		return daopn.getListPhieuNhap();
	}
	
	public String showMa()
	{
		return daopn.generateNewPN();
	}
	
	public String addPhieuNhap(PhieuNhap phieuNhap) {
        // Tạo mã phiếu nhập mới tự động
        String newPN = daopn.generateNewPN();
        if (newPN == null) {
            return "Không thể tạo mã phiếu nhập mới";
        }

        // Gán mã phiếu nhập mới cho đối tượng phieuNhap
        phieuNhap.setMaPhieuNhap(newPN);

        // Thực hiện thêm mới phiếu nhập
        if (daopn.addPhieuNhap(phieuNhap)) {
            return "Thêm Phiếu Nhập Thành Công";
        } else {
            return "Thêm Phiếu Nhập Thất Bại";
        }
    }

	
	public String deletePhieuNhap(PhieuNhap phieuNhap ){
		if(daopn.deletePhieuNhap(phieuNhap.getMaPhieuNhap()))
		{
			return "Xóa Thành Công";
		}
		return "Xóa Thất Bại";
	}
	
	public ArrayList<PhieuNhap> findPhieuNhap(String searchKeyword) {
		return daopn.findPhieuNhap(searchKeyword);
	}

	public String updatePhieuNhap(PhieuNhap phieuNhap) {
		if(daopn.updatePhieuNhap(phieuNhap))
		{
			return "Sữa Thành Công";
		}
		return "Sữa Thất Bại";
    }
	
}
