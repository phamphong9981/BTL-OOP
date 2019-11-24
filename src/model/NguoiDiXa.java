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
public class NguoiDiXa extends NhanKhau{
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;

    public NguoiDiXa() {
        super();
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}
