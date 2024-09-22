package qlycuahangthuoc.DTO;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    
     private String Makh , Tenkh , diaChi , Sdt ;
     private Date ngaysinh;

    public KhachHang(String Makh, String Tenkh, String diaChi, String Sdt, Date ngaysinh) {
        this.Makh = Makh;
        this.Tenkh = Tenkh;
        this.diaChi = diaChi;
        this.Sdt = Sdt;
        this.ngaysinh = ngaysinh;
    }

    public String getMakh() {
        return Makh;
    }

    public void setMakh(String Makh) {
        this.Makh = Makh;
    }

    public String getTenkh() {
        return Tenkh;
    }

    public void setTenkh(String Tenkh) {
        this.Tenkh = Tenkh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
     
     
    
}
