/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlycuahangthuoc.DTO;

/**
 *
 * @author vanqu
 */
public class TaiKhoan {
    String username,pass,idNV,idTK;
    int loaitk;

    public TaiKhoan(String username, String pass, String idNV, String idTK, int loaitk) {
        this.username = username;
        this.pass = pass;
        this.idNV = idNV;
        this.idTK = idTK;
        this.loaitk = loaitk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdTK() {
        return idTK;
    }

    public void setIdTK(String idTK) {
        this.idTK = idTK;
    }

    public int getLoaitk() {
        return loaitk;
    }

    public void setLoaitk(int loaitk) {
        this.loaitk = loaitk;
    }
    
    
}
