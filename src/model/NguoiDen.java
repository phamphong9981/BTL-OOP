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
public class NguoiDen extends NhanKhau{
    private Date ngayChuyenDen;
    private String noiChuyenDen;
    private String lyDo;

    public NguoiDen() {
        super();
    }

    public Date getNgayChuyenDen() {
        return ngayChuyenDen;
    }

    public String getNoiChuyenDen() {
        return noiChuyenDen;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setNgayChuyenDen(Date ngayChuyenDen) {
        this.ngayChuyenDen = ngayChuyenDen;
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}
