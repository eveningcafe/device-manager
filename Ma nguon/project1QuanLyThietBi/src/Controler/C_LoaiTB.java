/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import Controler.*;
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
public class C_LoaiTB {
    public int idloai;
    public String chiTieuKyThuat;
    public String nuocSX;
    public String ngayNhap;
    public float gia1TB;
    public float tinhTrang;
    public String nguonTien;
    public String ghiChu;
    public ArrayList<C_ItemThietBi> cacItems;
    public C_LoaiTB(int idloai){
        try {
            cacItems= new ArrayList<>();
            Connect co =new Connect();
            String q="use quanlythietbi select * from LoaiTB where IDLoai ='";
            String truyvan=q.concat(Integer.toString(idloai)).concat("'");
            co.doQuerry(truyvan);
            co.result.next();
            this.idloai=co.result.getInt(1);
            chiTieuKyThuat=co.result.getString(2);
            nuocSX=co.result.getString(3);
            ngayNhap=co.result.getString(4);
            gia1TB=co.result.getFloat(5);
            tinhTrang=co.result.getFloat(6);
            nguonTien=co.result.getString(7);
            ghiChu=co.result.getString(8);
            q="use quanlythietbi select count(*) from ItemThietBi where ItemThietBi.IDLoai ='";
            truyvan=q.concat(Integer.toString(idloai)).concat("'");
            co.doQuerry(truyvan);
            co.result.next();
            int soluongitem= co.result.getInt(1);
            for(int i=1;i<=soluongitem;i++){
                C_ItemThietBi item = new C_ItemThietBi(idloai, i);
                cacItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(C_LoaiTB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_LoaiTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public C_LoaiTB(int currentNumOfLoai,String ChiTieuKT,String NuocSX,String ngayNhap,float Gia1TB,String NguonTien ){
        //ChiTieuKT,NuocSX,NgayNhap,Gia1TB,NguonTien
        this.cacItems = new ArrayList<>();
        this.ngayNhap=ngayNhap;
        this.idloai=currentNumOfLoai+1;
        this.chiTieuKyThuat=ChiTieuKT;
        this.nuocSX=NuocSX;
        this.gia1TB=Gia1TB;
        this.nguonTien=NguonTien;
    }
    
}
