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
public class ThayDoiKhac extends HoKhau{
    private String noiDung;
    private Date ngayDate;

    public ThayDoiKhac() {
    }

    public String getNoiDung() {
        return noiDung;
    }

    public Date getNgayDate() {
        return ngayDate;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setNgayDate(Date ngayDate) {
        this.ngayDate = ngayDate;
    }
    
    
}
