/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DTO;

import java.math.BigDecimal;

/**
 *
 * @author vanqu
 */
public class CTHD_DTO {
    
    String mahd,mathuoc;
    int soluong;
    BigDecimal thanhtien;

    public CTHD_DTO(String mahd, String mathuoc, int soluong, BigDecimal thanhtien) {
        this.mahd = mahd;
        this.mathuoc = mathuoc;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
