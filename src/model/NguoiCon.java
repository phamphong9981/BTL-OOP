/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pham Phong
 */
public class NguoiCon extends NhanKhau{
    private String hoTenCha;
    private String danTocCha;
    private String quocTichCha;
    private String hoTenMe;
    private String danTocMe;
    private String quocTichMe;
    private String hoTenNguoiKhaiSinh;
    private String quanHeVoiNguoiDuocKhaiSinh;
    private String ngaySinhChu;
    private String quocTich;
    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setNgaySinhChu(String ngaySinhChu) {
        this.ngaySinhChu = ngaySinhChu;
    }

    public String getNgaySinhChu() {
        return ngaySinhChu;
    }

    public void setHoTenNguoiKhaiSinh(String hoTenNguoiKhaiSinh) {
        this.hoTenNguoiKhaiSinh = hoTenNguoiKhaiSinh;
    }

    public void setQuanHeVoiNguoiDuocKhaiSinh(String quanHeVoiNguoiDuocKhaiSinh) {
        this.quanHeVoiNguoiDuocKhaiSinh = quanHeVoiNguoiDuocKhaiSinh;
    }

    public String getHoTenNguoiKhaiSinh() {
        return hoTenNguoiKhaiSinh;
    }

    public String getQuanHeVoiNguoiDuocKhaiSinh() {
        return quanHeVoiNguoiDuocKhaiSinh;
    }

    public NguoiCon() {
        super();
    }

    public String getHoTenCha() {
        return hoTenCha;
    }

    public String getDanTocCha() {
        return danTocCha;
    }

    public String getQuocTichCha() {
        return quocTichCha;
    }

    public String getHoTenMe() {
        return hoTenMe;
    }

    public String getDanTocMe() {
        return danTocMe;
    }

    public String getQuocTichMe() {
        return quocTichMe;
    }

    public void setHoTenCha(String hoTenCha) {
        this.hoTenCha = hoTenCha;
    }

    public void setDanTocCha(String danTocCha) {
        this.danTocCha = danTocCha;
    }

    public void setQuocTichCha(String quocTichCha) {
        this.quocTichCha = quocTichCha;
    }

    public void setHoTenMe(String hoTenMe) {
        this.hoTenMe = hoTenMe;
    }

    public void setDanTocMe(String danTocMe) {
        this.danTocMe = danTocMe;
    }

    public void setQuocTichMe(String quocTichMe) {
        this.quocTichMe = quocTichMe;
    }
    
}