
package qlycuahangthuoc.DTO;

import java.util.Date;

/**
 *
 * @author vanqu
 */
public class HoaDon {
    
    String mahd,makh,hotenKH,manv,hotenNV;
    Date ngaylap;

    public HoaDon(String mahd, String makh, String hotenKH, String manv, String hotenNV, Date ngaylap) {
        this.mahd = mahd;
        this.makh = makh;
        this.hotenKH = hotenKH;
        this.manv = manv;
        this.hotenNV = hotenNV;
        this.ngaylap = ngaylap;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHotenKH() {
        return hotenKH;
    }

    public void setHotenKH(String hotenKH) {
        this.hotenKH = hotenKH;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHotenNV() {
        return hotenNV;
    }

    public void setHotenNV(String hotenNV) {
        this.hotenNV = hotenNV;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }
    
    
}
