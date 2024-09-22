/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DTO;

import java.util.Date;

/**
 *
 * @author Mai
 */
public class NhanVien {
    private String MaNV, Hoten, DiaChi, Sdt, Cmnd ;
    private Date NgaySinh;

    public NhanVien(String MaNV, String Hoten, String DiaChi, String Sdt, String Cmnd, Date NgaySinh) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.Cmnd = Cmnd;
        this.NgaySinh = NgaySinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String Cmnd) {
        this.Cmnd = Cmnd;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    
}
