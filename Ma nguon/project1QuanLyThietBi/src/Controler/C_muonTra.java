/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Connect;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngohoa
 */
public class C_muonTra {
    public String tenNguoiMuon;
    public String ngayMuon;
    public String ngayTra;
    public String chuThich;
    public C_muonTra(String mataisan){
        try {
            Connect co =new Connect();
            String q="use quanlythietbi select * from MuonTra where MaTaiSan = '";// 'Máy tính HP%'"
            String truyvan=q.concat(mataisan).concat("'");
            co.doQuerry(truyvan);
            if(co.result.next()){
            tenNguoiMuon=co.result.getString(2);
            ngayMuon=co.result.getString(3);
            ngayTra=co.result.getString(4);
            chuThich=co.result.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_muonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_muonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public C_muonTra(){
        tenNguoiMuon=null;
        ngayMuon= null;
        ngayTra= null;
    }
}
