/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import model.NhanKhau;

/**
 *
 * @author Pham Phong
 */
public class DAO {
    private Connection connection;
    public DAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=BTL-OOP;username=sa;password=emsehanhphuc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public boolean themNhanKhau(NhanKhau nk){
//        String sql = "INSERT INTO Nhân-Khẩu(
//    }

    
}
