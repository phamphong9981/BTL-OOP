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
public class NguoiChet extends NhanKhau{
    private String noiChet;
    private String gioiTinh;
    private Date ngayChet;
    private String lyDo;
    private String noiDangKi;
    private Date ngayDangKi;

    public void setNoiChet(String noiChet) {
        this.noiChet = noiChet;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNoiDangKi(String noiDangKi) {
        this.noiDangKi = noiDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public String getNoiChet() {
        return noiChet;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNoiDangKi() {
        return noiDangKi;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public NguoiChet() {
        super();
    }

    public Date getNgayChet() {
        return ngayChet;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setNgayChet(Date ngayChet) {
        this.ngayChet = ngayChet;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
    
}