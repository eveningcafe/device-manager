/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Connect;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngohoa
 */
public class C_ItemThietBi {
    public int IDThietBi;
    public String maTaiSan;
    public String viTri;
    public boolean thuocPhongThucHanh;
    public String ghiChu;
    public String soHieuMay;
    public boolean DaThanhLy;
    public C_muonTra muonTra;
    public C_ItemThietBi(int idloai, int index){
        try {
            Connect co =new Connect();
            String q="use quanlythietbi select * from ItemThietBi where IDLoai = '";
            String truyvan=q.concat(Integer.toString(idloai)).concat("'");
            co.doQuerry(truyvan);
            int i=0;
            while(co.result.next()){
                if(i==index-1){
                this.IDThietBi=co.result.getInt(1);
                maTaiSan=co.result.getString(2);
                viTri=co.result.getString(4);
                thuocPhongThucHanh=co.result.getBoolean(5);
                ghiChu=co.result.getString(6);
                soHieuMay=co.result.getString(7);
                DaThanhLy=co.result.getBoolean(8); i++;}
                else i++;
            };
            muonTra = new C_muonTra(maTaiSan);
            
        } catch (SQLException ex) {
            Logger.getLogger(C_ItemThietBi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_ItemThietBi.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public C_ItemThietBi(String maTaiSan, String soHieuMay){
                this.muonTra= new C_muonTra();
                this.maTaiSan=maTaiSan;
                this.soHieuMay=soHieuMay;
                DaThanhLy=false;
    }
    public boolean kiemTraDaMuon(){
        if(muonTra!=null){
            if(muonTra.tenNguoiMuon==null) return false;
            else return true;
        }else return false;
    }
}
