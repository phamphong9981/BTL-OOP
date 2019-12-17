/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Pham Phong
 */
public class NguoiTamTru extends NhanKhau{
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;
    private String tamTruTai;

    public void setTamTruTai(String tamTruTai) {
        this.tamTruTai = tamTruTai;
    }

    public String getTamTruTai() {
        return tamTruTai;
    }
    public NguoiTamTru() {
        super();
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }
    
}
