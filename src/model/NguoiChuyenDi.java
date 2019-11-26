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
public class NguoiChuyenDi extends NhanKhau{
    private Date tuNgay;
    private String noiChuyenDen;
    private String lyDo;

    public NguoiChuyenDi() {
        super();
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public String getNoiChuyenDen() {
        return noiChuyenDen;
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
    }

    

    public String getLyDo() {
        return lyDo;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}
