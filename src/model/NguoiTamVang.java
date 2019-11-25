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
public class NguoiTamVang extends NhanKhau{
    private Date denNgay;

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public Date getTuNgay() {
        return tuNgay;
    }
    private Date tuNgay;
    private String noiChuyenDen;
    private String lyDo;

    public NguoiTamVang() {
        super();
    }

    

    public String getNoiChuyenDen() {
        return noiChuyenDen;
    }

    public String getLyDo() {
        return lyDo;
    }


    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}
