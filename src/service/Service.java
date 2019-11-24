/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.HoKhau;
import model.NguoiChet;
import model.NguoiChuyenDi;
import model.NguoiCon;
import model.NguoiTamVang;
import model.NguoiTamTru;
import model.NhanKhau;

/**
 *
 * @author Pham Phong
 */
public interface Service {
    public ArrayList<NhanKhau> getNhanKhauList(HoKhau hoKhau);//Lấy danh sách nhân khẩu của hộ khẩu
    public boolean khaiSinh(int id, NguoiCon nguoiCon);
    public boolean khaiTu(NguoiChet nguoiChet);
    public boolean tamVang(NguoiTamVang nguoiTamVang);
    public boolean tamTru(NguoiTamTru nguoiTamTru);
    public boolean chuyenDi(NguoiChuyenDi nguoiChuyenDi);
    public ArrayList<HoKhau> getHoKhauList(String key);//Tìm kiếm hộ khẩu theo từ khóa-tên chủ hộ
    public boolean tachHo();
    public boolean thayDoiChuHo();
    public boolean chuyenHoKhau();
    public int soThanhVien(int id);
}