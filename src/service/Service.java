/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.HoKhau;
import model.HoKhauChuyen;
import model.NguoiChet;
import model.NguoiChuyenDi;
import model.NguoiCon;
import model.NguoiTamVang;
import model.NguoiTamTru;
import model.NhanKhau;
import model.TachHo;

/**
 *
 * @author Pham Phong
 */
public interface Service {
    public ArrayList<NhanKhau> getNhanKhauList(int id);//Lấy danh sách nhân khẩu của hộ khẩu 
    public boolean khaiSinh(int id, NguoiCon nguoiCon);
    public boolean khaiTu(NguoiChet nguoiChet);
    public boolean tamVang(NguoiTamVang nguoiTamVang);
    public boolean tamTru(NguoiTamTru nguoiTamTru);
    public boolean chuyenDi(NguoiChuyenDi nguoiChuyenDi);
    public ArrayList<HoKhau> getHoKhauList(String key);//Tìm kiếm hộ khẩu theo từ khóa-tên chủ hộ
    public void tachHo(ArrayList<NhanKhau> list,HoKhau hoKhau);
    public void thayDoiKhac(int id,model.ThayDoiKhac thayDoiKhac);
    public void chuyenHoKhau(HoKhauChuyen hoKhauChuyen);
    public int soThanhVien(int id);
    //Lấy danh sách nhân khẩu theo tiêu chí tuổi và giới tính để thống kê
    public ArrayList<NhanKhau> getNhanKhauListByCriteria(String ageString, String sexString);
    public ArrayList<NhanKhau> getTamVang();
    public ArrayList<NhanKhau> getTamTru();
    public ArrayList<NguoiCon> getSinhCon(int id);
    public ArrayList<TachHo> getTachHo(int id);
    public ArrayList<NguoiChet> getNguoiChet(int id);
    public ArrayList<NguoiChuyenDi> getNguoiChuyenDi(int id);
    public ArrayList<NguoiTamTru> getNguoiTamTru(int id);
    public ArrayList<NguoiTamVang> getNguoiTamVang(int id);
    public String getDiaChiThuongTru(int id);

}