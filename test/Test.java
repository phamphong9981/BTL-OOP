
import controller.DAO;
import java.util.ArrayList;
import model.HoKhau;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Phong
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<HoKhau> list=(new DAO().getHoKhauList("K"));
        for(HoKhau hk : list){
            System.out.println(hk.getTen());
        }
    }
}
