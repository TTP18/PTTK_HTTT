
package qlycuahangthuoc.DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author vanqu
 */
public class KhoThuoc {
    
    private String MaKho,MaThuoc,TenThuoc;
    private BigDecimal GiaBan;
    private int soluong;
    private Date HSD;

    public KhoThuoc(String MaKho, String MaThuoc, String TenThuoc, BigDecimal GiaBan, int soluong, Date HSD) {
        this.MaKho = MaKho;
        this.MaThuoc = MaThuoc;
        this.TenThuoc = TenThuoc;
        this.GiaBan = GiaBan;
        this.soluong = soluong;
        this.HSD = HSD;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String TenThuoc) {
        this.TenThuoc = TenThuoc;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }
    
    
    
}
