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
public class ThayDoiChuHo extends HoKhau{
    private String tenChuHoMoi;
    private Date ngayThayDoi;

    public ThayDoiChuHo() {
    }

    public String getTenChuHoMoi() {
        return tenChuHoMoi;
    }

    public Date getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setTenChuHoMoi(String tenChuHoMoi) {
        this.tenChuHoMoi = tenChuHoMoi;
    }

    public void setNgayThayDoi(Date ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }
    
}
