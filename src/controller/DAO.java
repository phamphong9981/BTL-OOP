/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoKhau;
import model.HoKhauChuyen;
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
            //connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=sa;password=emsehanhphuc");
            //connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=sa;password=emsehanhphuc");
   
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=username;password=emsehanhphuc");
            //login với database trên máy Điệp
//            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=username;password=emsehanhphuc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<NhanKhau> getNhanKhauList(int id) {
        ArrayList<NhanKhau> list=new ArrayList<>();

        //code
        String sql = "SELECT * FROM dbo.NhanKhau WHERE ID ='"+id+"';";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanKhau nk = new NhanKhau();
                nk.setId(rs.getInt("ID"));
                nk.setStt(rs.getInt("STT"));
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
                nk.setQuanHe(rs.getString("QUANHE"));
                nk.setGioiTinh(rs.getString("GIOITINH"));
                
                list.add(nk);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }    

    @Override
    public boolean khaiSinh(int id, NguoiCon nguoiCon) {
        int stt=0;
        String sql1="INSERT INTO dbo.NhanKhau (ID,TEN,NGAYSINH,NOISINH,NGUYENQUAN,DANTOC,QUANHE,GIOITINH) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql1);
            ps.setInt(1, id);
            ps.setString(2, nguoiCon.getTen());
            ps.setDate(3, nguoiCon.getNgaySinh());
            ps.setString(4, nguoiCon.getNoiSinh());
            ps.setString(5, nguoiCon.getQueQuan());
            ps.setString(6, nguoiCon.getDanToc() );
            ps.setString(7, nguoiCon.getQuanHeVoiNguoiDuocKhaiSinh());
            ps.setString(8, nguoiCon.getGioiTinh());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        String sql3="SELECT TOP 1 * FROM dbo.NhanKhau WHERE ID='"+id+"' ORDER BY STT DESC";
        try {
            PreparedStatement ps2=connection.prepareStatement(sql3);
            ResultSet rs=ps2.executeQuery();
            rs.next();
            stt=rs.getInt("STT");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2="INSERT INTO dbo.SinhCon (ID,HOTENCHA,DANTOCCHA,QUOCTICHCHA,HOTENME,DANTOCME,QUOCTICHME,NGAYSINHCHU,QUOCTICH,STT,QUANHEVOINGUOIDUOCKHAISINH,HOTENNGUOIKHAISINH,NGAYSINH) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql2);
            ps.setInt(1, nguoiCon.getId());
            ps.setString(2, nguoiCon.getHoTenCha());
            ps.setString(3, nguoiCon.getDanTocCha());
            ps.setString(4, nguoiCon.getQuocTichCha());
            ps.setString(5, nguoiCon.getHoTenMe());
            ps.setString(6, nguoiCon.getDanTocMe());
            ps.setString(7, nguoiCon.getQuocTichMe());
            ps.setString(8, nguoiCon.getNgaySinhChu());
            ps.setString(9, nguoiCon.getQuocTich());
            ps.setInt(10, stt);
            ps.setString(11, nguoiCon.getQuanHeVoiNguoiDuocKhaiSinh());
            ps.setString(12, nguoiCon.getHoTenNguoiKhaiSinh());
            ps.setDate(13, nguoiCon.getNgaySinh());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean khaiTu(NguoiChet nguoiChet) {
        String sql1="INSERT INTO dbo.KhaiTu (TEN,GIOITINH,NGAYSINH,DANTOC,NOITHUONGTRU,SOCMND,NGAYCHET,NOICHET,LYDO,NOIDANGKI,NGAYDANGKI) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String sql2="DELETE FROM dbo.NhanKhau WHERE ID='"+nguoiChet.getId()+"' AND STT='"+nguoiChet.getStt()+"'";
        try {
            PreparedStatement ps=connection.prepareStatement(sql1);
            ps.setString(1, nguoiChet.getTen());
            ps.setString(2, nguoiChet.getGioiTinh());
            ps.setDate(3, nguoiChet.getNgaySinh());
            ps.setString(4, nguoiChet.getDanToc());
            ps.setString(5, getDiaChiThuongTru(nguoiChet.getId()));
            ps.setString(6, nguoiChet.getSoCMND());
            ps.setDate(7, nguoiChet.getNgayChet());
            ps.setString(8, nguoiChet.getNoiChet());
            ps.setString(9, nguoiChet.getLyDo());
            ps.setString(10, nguoiChet.getNoiDangKi());
            ps.setDate(11, nguoiChet.getNgayDangKi());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement ps=connection.prepareStatement(sql2);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean tamVang(NguoiTamVang nguoiTamVang) {
        String sql="INSERT INTO dbo.TamVang (ID,STT,NOIDEN,TUNGAY,DENNGAY,LYDO) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, nguoiTamVang.getId());
            ps.setInt(2, nguoiTamVang.getStt());
            ps.setString(3, nguoiTamVang.getNoiChuyenDen());
            ps.setDate(4, nguoiTamVang.getTuNgay());
            ps.setDate(5, nguoiTamVang.getDenNgay());
            ps.setString(6, nguoiTamVang.getLyDo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean tamTru(NguoiTamTru nguoiTamTru) {
        String sql="INSERT INTO dbo.TamTru (ID,STT,TUNGAY,DENNGAY,LYDO,TAMTRUTAI) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, nguoiTamTru.getId());
            ps.setInt(2, nguoiTamTru.getStt());
            ps.setDate(3, nguoiTamTru.getTuNgay());
            ps.setDate(4, nguoiTamTru.getDenNgay());
            ps.setString(5, nguoiTamTru.getLyDo());
            ps.setString(6, nguoiTamTru.getTamTruTai());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean chuyenDi(NguoiChuyenDi nguoiChuyenDi) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String sql = "INSERT INTO NhanKhauChuyen VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
       try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, nguoiChuyenDi.getId());
            ps.setString(2, nguoiChuyenDi.getTen());
            ps.setString(3, nguoiChuyenDi.getGioiTinh());
            ps.setString(4, nguoiChuyenDi.getBietDanh());
            ps.setDate(5, nguoiChuyenDi.getNgaySinh());
            ps.setString(6, nguoiChuyenDi.getNoiSinh());
            ps.setString(7, nguoiChuyenDi.getQueQuan());
            ps.setString(8, nguoiChuyenDi.getDanToc());
            ps.setString(9, nguoiChuyenDi.getSoCMND());
            ps.setDate(10, nguoiChuyenDi.getTuNgay());
            ps.setString(11, nguoiChuyenDi.getNoiChuyenDen());
            ps.setString(12, nguoiChuyenDi.getLyDo());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<HoKhau> getHoKhauList(String key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<HoKhau> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.HoKhau WHERE TEN LIKE N'%" + key + "%'";
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
    public void tachHo(ArrayList<NhanKhau> list,HoKhau hoKhau) {
        String sql="INSERT INTO dbo.HoKhau (TEN,SONHA,DUONG,PHUONG,THANHPHO) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, hoKhau.getTen());
            ps.setString(2, hoKhau.getSoNha());
            ps.setString(3, hoKhau.getDuong());
            ps.setString(4, hoKhau.getPhuong());
            ps.setString(5, hoKhau.getThanhPho());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public boolean thayDoiChuHo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void chuyenHoKhau(HoKhauChuyen hoKhauChuyen) {
        String sql1="SELECT * FROM HoKhau WHERE ID='"+hoKhauChuyen.getId()+"'";
        try {
            PreparedStatement ps=connection.prepareStatement(sql1);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                hoKhauChuyen.setTen(rs.getString("TEN"));
                hoKhauChuyen.setDuong(rs.getString("DUONG"));
                hoKhauChuyen.setPhuong(rs.getString("PHUONG"));
                hoKhauChuyen.setThanhPho(rs.getString("THANHPHO"));
                hoKhauChuyen.setSoNha(rs.getString("SONHA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2="DELETE FROM HoKhau WHERE ID='"+hoKhauChuyen.getId()+"'";
        try {
            PreparedStatement ps=connection.prepareStatement(sql2);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql3="INSERT INTO HoKhauChuyen(TEN,SONHA,DUONG,PHUONG,THANHPHO,NOICHUYENDEN,NGAYDANGKICHUYEN) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql3);
            ps.setString(1, hoKhauChuyen.getTen());
            ps.setString(2, hoKhauChuyen.getSoNha());
            ps.setString(3, hoKhauChuyen.getDuong());
            ps.setString(4, hoKhauChuyen.getPhuong());
            ps.setString(5, hoKhauChuyen.getThanhPho());
            ps.setString(6, hoKhauChuyen.getNoiChuyenDen());
            ps.setDate(7, hoKhauChuyen.getNgayChuyenDi());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                
        if (ageString==null && sexString==null){
            //không có tiêu chí nào
            sql = "SELECT * FROM dbo.NhanKhau;";
        } else if(!(ageString==null) && sexString==null){
            //không có tiêu chí về giới tính
            sql = dateCalculationQuery + ageString + ";";
        } else if(ageString==null && sexString!=null){
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
    @Override
    public ArrayList<NhanKhau> getTamVang(){
        ArrayList<NhanKhau> list = new ArrayList<>();
        String sql = "SELECT TEN, BIETDANH, NGAYSINH, NOISINH, NGUYENQUAN, DANTOC, NGHENGHIEP, NOILAMVIEC, SOCMND, NGAYCAP, NOICAP, NGAYDANGKITHUONGTRU, DIACHITRUOCKHICHUYENDEN FROM NhanKhau, TamVang WHERE NhanKhau.ID = TamVang.ID AND NhanKhau.STT = TamVang.STT;";
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
    @Override
    public ArrayList<NhanKhau> getTamTru(){
        ArrayList<NhanKhau> list = new ArrayList<>();
        String sql = "SELECT TEN, BIETDANH, NGAYSINH, NOISINH, NGUYENQUAN, DANTOC, NGHENGHIEP, NOILAMVIEC, SOCMND, NGAYCAP, NOICAP, NGAYDANGKITHUONGTRU, DIACHITRUOCKHICHUYENDEN FROM NhanKhau, TamTru WHERE NhanKhau.ID = TamTru.ID AND NhanKhau.STT = TamTru.STT;";
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
    @Override
    public String getDiaChiThuongTru(int id){
        String sql = "SELECT SONHA, DUONG, PHUONG, THANHPHO FROM HOKHAU WHERE ID ='" + id + "'";
        String diaChiThuongTru = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            diaChiThuongTru = rs.getString("SONHA") + " " + rs.getString("DUONG") + " " + rs.getString("PHUONG") + " " + rs.getString("THANHPHO");            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diaChiThuongTru;
    }
//ctrl+shift+c: test connection
//    public static void main(String[] args){
//        new DAO();
//    }
    
}