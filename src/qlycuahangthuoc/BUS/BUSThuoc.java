package BUS;

import java.util.ArrayList;

import DAO.DAOThuoc;
import DTO.Thuoc;


public class BUSThuoc {
	DAOThuoc daoth = new DAOThuoc();
	
	public ArrayList<Thuoc> getListTh(){
        return daoth.getListThuoc();
    }

	public ArrayList<Thuoc> findbyName(String name) {
		// TODO Auto-generated method stub
		return daoth.findbyName(name);
	}
	
	public String getGiaThuoc(String maThuoc)
	{
		return daoth.getGiaThuoc(maThuoc);
	}
	
}
