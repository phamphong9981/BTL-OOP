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
public class HoKhauChuyen extends HoKhau{
    private String noiChuyenDen;
    private Date ngayChuyenDi;

    public HoKhauChuyen() {
        super();
    }

    public String getNoiChuyenDen() {
        return noiChuyenDen;
    }

    public Date getNgayChuyenDi() {
        return ngayChuyenDi;
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }
    
}
