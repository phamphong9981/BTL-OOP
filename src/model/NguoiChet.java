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
    private Date ngayChet;
    private String lyDo;

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
