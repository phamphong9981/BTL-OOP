/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoKhau;
import model.NguoiChet;
import model.NguoiChuyenDi;
import model.NguoiCon;
import model.NguoiTamTru;
import model.NguoiTamVang;
import model.NhanKhau;

/**
 *
 * @author Pham Phong
 */
public class DAO implements service.Service{
    private Connection connection;
    public DAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=sa;password=emsehanhphuc");
            //login với database trên máy Điệp
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=username;password=emsehanhphuc");
           // connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=sa;password=emsehanhphuc");
   
            //connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=username;password=emsehanhphuc");
            //login với database trên máy Điệp
//            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=username;password=emsehanhphuc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<NhanKhau> getNhanKhauList(int id) {
        ArrayList<NhanKhau> list=new ArrayList<>();
        String sql="SELECT * FROM dbo.NhanKhau WHERE ID='"+id+"'";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return list;
    }    
    public ArrayList<NhanKhau> getNhanKhauList(HoKhau hoKhau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public boolean khaiSinh(int id, NguoiCon nguoiCon) {
        String sql1="INSERT INTO dbo.NhanKhau (ID,STT,TEN,NGAYSINH,NOISINH,NGUYENQUAN,DANTOC,QUANHE) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql1);
            ps.setInt(1, nguoiCon.getId());
            ps.setInt(2, nguoiCon.getStt());
            ps.setString(3, nguoiCon.getTen());
            ps.setDate(4, nguoiCon.getNgaySinh());
            ps.setString(5, nguoiCon.getNoiSinh());
            ps.setString(6, nguoiCon.getQueQuan());
            ps.setString(7, nguoiCon.getDanToc() );
            ps.setString(8, nguoiCon.getQuanHe());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String sql2="INSERT INTO dbo.SinhCon (ID,STT,HOTENCHA,DANTOCCHA,QUOCTICHCHA,HOTENME,DANTOCME,QUOCTICHME) VLAUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql2);
            ps.setInt(1, nguoiCon.getId());
            ps.setInt(2, nguoiCon.getStt());
            ps.setString(3, nguoiCon.getHoTenCha());
            ps.setString(4, nguoiCon.getDanTocCha());
            ps.setString(5, nguoiCon.getQuocTichCha());
            ps.setString(6, nguoiCon.getHoTenMe());
            ps.setString(7, nguoiCon.getDanTocMe());
            ps.setString(8, nguoiCon.getQuocTichMe());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean khaiTu(NguoiChet nguoiChet) {
        String sql="INSERT INTO dbo.KhaiTu (TEN,GIOITINH,NGAYSINH,DANTOC,QUOCTICH,DIACHITHUONGTRU,SOCMND,NGAYCHET,NOICHET,LYDO,NOIDANGKI,NGAYDANGKI) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, nguoiChet.getTen());
            ps.setString(2, nguoiChet.getGioiTinh());
            ps.setDate(3, nguoiChet.getNgaySinh());
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean tamVang(NguoiTamVang nguoiTamVang) {
        String sql="INSERT INTO dbo.CoNguoiDiXa (ID,STT,TUNGAY,DENNGAY,LYDO) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, nguoiTamVang.getId());
            ps.setInt(2, nguoiTamVang.getStt());
            ps.setDate(4, nguoiTamVang.getTuNgay());
            ps.setDate(5, nguoiTamVang.getDenNgay());
            ps.setString(3, nguoiTamVang.getNoiChuyenDen());
            ps.setString(6, nguoiTamVang.getLyDo());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean tamTru(NguoiTamTru nguoiTamTru) {
        String sql="INSERT INTO dbo.TamTru (ID,STT,TUNGAY,DENNGAY,LYDO) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, nguoiTamTru.getId());
            ps.setInt(2, nguoiTamTru.getStt());
            ps.setDate(3, nguoiTamTru.getTuNgay());
            ps.setDate(4, nguoiTamTru.getDenNgay());
            ps.setString(5, nguoiTamTru.getLyDo());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean chuyenDi(NguoiChuyenDi nguoiChuyenDi) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HoKhau> getHoKhauList(String key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<HoKhau> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.HoKhau WHERE TEN LIKE '%" + key + "%'";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoKhau hk = new HoKhau();
                hk.setId(rs.getInt("ID"));
                hk.setTen(rs.getString("TEN"));
                hk.setSoNha(rs.getString("SONHA"));
                hk.setDuong(rs.getString("DUONG"));
                hk.setPhuong(rs.getString("PHUONG"));
                hk.setThanhPho(rs.getString("THANHPHO"));
                
                list.add(hk);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean tachHo(int id, ArrayList<NhanKhau> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean thayDoiChuHo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean chuyenHoKhau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public int soThanhVien(int id) {
        int res=0;
        String sql="SELECT COUNT(*) FROM dbo.NhanKhau WHERE ID='"+id+"'";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                res=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    @Override
    public ArrayList<NhanKhau> getNhanKhauListByCriteria(String ageString, String sexString){
        ArrayList<NhanKhau> list = new ArrayList<>();
        String sql;
        
        String dateCalculationQuery = "SELECT TEN, BIETDANH, NGAYSINH, NOISINH, NGUYENQUAN, DANTOC, NGHENGHIEP, NOILAMVIEC, SOCMND, NGAYCAP, NOICAP, NGAYDANGKITHUONGTRU, DIACHITRUOCKHICHUYENDEN, Age FROM (SELECT *, DATEDIFF(YY, NGAYSINH, GETDATE()) - CASE WHEN DATEADD(YY, DATEDIFF(YY, NGAYSINH, GETDATE()), NGAYSINH) > GETDATE() THEN 1 ELSE 0 END AS [Age] FROM dbo.NhanKhau ) AS PL WHERE [Age] ";
//         "SELECT TEN, BIETDANH, NGAYSINH, NOISINH, NGUYENQUAN, DANTOC, NGHENGHIEP, NOILAMVIEC,"
//        +"SOCMND, NGAYCAP, NOICAP, NGAYDANGKITHUONGTRU, DIACHITRUOCKHICHUYENDEN" 
//        +"FROM ("
//        +"    SELECT *, DATEDIFF(YY, NGAYSINH, GETDATE()) -" 
//        +"        CASE" 
//        +"            WHEN DATEADD(YY, DATEDIFF(YY, NGAYSINH, GETDATE()), NGAYSINH)"
//        +"                > GETDATE() THEN 1"
//        +"            ELSE 0"
//        +"        END AS [Age]"
//        +"    FROM dbo.NhanKhau"
//        +"     ) AS PL"
//        +"WHERE [Age] ";
                
        if (ageString.equals("null") && sexString.equals("null")){
            //không có tiêu chí nào
            sql = "SELECT * FROM dbo.NhanKhau;";
        } else if(!ageString.equals("null") && sexString.equals("null")){
            //không có tiêu chí về giới tính
            sql = dateCalculationQuery + ageString + ";";
        } else if(ageString.equals("null") && !sexString.equals("null")){
            //không có tiêu chí về độ tuổi
            sql = "SELECT * FROM dbo.NhanKhau WHERE GIOITINH = N'" + sexString + "';";
        } else{
            //có cả 2 tiêu chí: giới tính và độ tuổi
            sql = dateCalculationQuery + ageString + " AND GIOITINH = N'" + sexString + "';";
        }

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanKhau nk = new NhanKhau();
                nk.setTen(rs.getString("TEN"));
                nk.setBietDanh(rs.getString("BIETDANH"));
                nk.setNgaySinh(rs.getDate("NGAYSINH"));
                nk.setNoiSinh(rs.getString("NOISINH"));
                nk.setQueQuan(rs.getString("NGUYENQUAN"));
                nk.setDanToc(rs.getString("DANTOC"));
                nk.setNgheNghiep(rs.getString("NGHENGHIEP"));
                nk.setNoiLamViec(rs.getString("NOILAMVIEC"));
                nk.setSoCMND(rs.getString("SOCMND"));
                nk.setNgayCap(rs.getDate("NGAYCAP"));
                nk.setNoiCap(rs.getString("NOICAP"));
                nk.setNgayDangKiThuongTru(rs.getDate("NGAYDANGKITHUONGTRU"));
                nk.setDiaChiTruocKhiChuyenDen(rs.getString("DIACHITRUOCKHICHUYENDEN"));
                
                
                list.add(nk);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//ctrl+shift+c: test connection
//    public static void main(String[] args){
//        new DAO();
//    }
    
}