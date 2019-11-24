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
public class HoKhau {
    private int id;
    private String ten;
    private String soNha;
    private String duong;
    private String phuong;
    private String thanhPho;

    public HoKhau() {
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getSoNha() {
        return soNha;
    }

    public String getDuong() {
        return duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
    
}
