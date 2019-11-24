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
public class NhanKhau {
    private int id;
    private int stt;
    private String ten;
    private String bietDanh;
    private Date ngaySinh;
    private String noiSinh;
    private String queQuan;
    private String danToc;
    private String ngheNghiep;
    private String noiLamViec;
    private String soCMND;
    private Date ngayCap;
    private String noiCap;
    private Date ngayDangKiThuongTru;
    private String diaChiTruocKhiChuyenDen;
    private String quanHe;

    public NhanKhau() {
    }

    public int getId() {
        return id;
    }

    public int getStt() {
        return stt;
    }

    public String getTen() {
        return ten;
    }

    public String getBietDanh() {
        return bietDanh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public Date getNgayDangKiThuongTru() {
        return ngayDangKiThuongTru;
    }

    public String getDiaChiTruocKhiChuyenDen() {
        return diaChiTruocKhiChuyenDen;
    }

    public String getQuanHe() {
        return quanHe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setBietDanh(String bietDanh) {
        this.bietDanh = bietDanh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public void setNgayDangKiThuongTru(Date ngayDangKiThuongTru) {
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
    }

    public void setDiaChiTruocKhiChuyenDen(String diaChiTruocKhiChuyenDen) {
        this.diaChiTruocKhiChuyenDen = diaChiTruocKhiChuyenDen;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }
    
}
