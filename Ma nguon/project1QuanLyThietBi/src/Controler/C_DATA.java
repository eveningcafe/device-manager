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
import javax.swing.JOptionPane;

/**
 *
 * @author ngohoa
 */
public class C_DATA {
    public ArrayList<C_LoaiTB> danhSachToanBo;
    private ArrayList<String> querys;
    public C_DATA(){
        querys= new ArrayList<>();
        try {
            danhSachToanBo= new ArrayList<>();
            Connect co =new Connect();
            String q="use quanlythietbi select count(*) from LoaiTB";
            String truyvan=q;
            co.doQuerry(truyvan);
            co.result.next();
            int soluongloai=co.result.getInt(1);
            for(int i=1;i<=soluongloai;i++){
                C_LoaiTB l= new C_LoaiTB(i);
                danhSachToanBo.add(l);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối với cơ sở dữ liệu",
                  "Lỗi", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(C_DATA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_DATA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showDATA(){
        if(danhSachToanBo == null) System.out.println("loi ket noi ");
        else if(danhSachToanBo.size()==0) System.out.println("khong co thiet bi nao");
        else{
        for(C_LoaiTB l: danhSachToanBo){
            System.out.println(l.chiTieuKyThuat);
            if(l.idloai==0) System.out.println("id loai null");else System.out.println("id loai "+ l.idloai);
            if(l.gia1TB==0) System.out.println("gia null");else System.out.println(l.gia1TB);
            if(l.ngayNhap==null) System.out.println("gia null");else System.out.println(l.ngayNhap);
            if(l.nguonTien==null) System.out.println("nguontien null");else System.out.println(l.nguonTien);
            if(l.nuocSX==null) System.out.println("nuocsx null");else System.out.println(l.nuocSX);
            if(l.ngayNhap==null) System.out.println("ngaynhap null");else System.out.println(l.ngayNhap);
            if(l.tinhTrang==0) System.out.println("tinh trang null");else System.out.println(l.tinhTrang);
            if(l.ghiChu==null  )System.out.println("ghi chu null");else System.out.println(l.ghiChu);
            if(l.cacItems==null||l.cacItems.size()==0) System.out.println(" ko co items");else {
                System.out.println(" item la ");
                for(C_ItemThietBi i: l.cacItems){
                    System.out.println("ma tai san:"+i.maTaiSan);
                    System.out.println("so hieu may:"+i.soHieuMay);
                    System.out.println("id thiet bi "+i.IDThietBi);
                    System.out.println("vi tri "+i.viTri);
                    System.out.println("thuoc phong thuc hanh "+i.thuocPhongThucHanh);
                    System.out.println("ghi chu "+i.ghiChu);
                    System.out.println("da thanh ly"+i.DaThanhLy);
                    System.out.println("nguoi muon "+i.muonTra.tenNguoiMuon);
                    System.out.println("ngay muon"+i.muonTra.ngayMuon);
                    System.out.println("ngay tra"+i.muonTra.ngayTra);
                }
            }
        }
        }
    }
    public void addquerry(String query){
        querys.add(query);
    }
     public ArrayList<String> getQuerrys(){
         return querys;
     }

    public void reserstQuerrys() {
        querys = new ArrayList<>();
    }
    public C_ItemThietBi timItemtheoMaTaiSan(String mataisan){
        if(mataisan==null)return null;
        for(C_LoaiTB l: danhSachToanBo ){
                for(C_ItemThietBi i: l.cacItems){
                    if(i.maTaiSan.equals(mataisan)) return i;
                }
            }
        return null;
    }
    public C_ItemThietBi timItemtheoSoHieuMay(String sohieumay){
        for(C_LoaiTB l: danhSachToanBo ){
                for(C_ItemThietBi i: l.cacItems){
                    if(i.soHieuMay.equals(sohieumay)) return i;
                }
            }
        return null;
    }
    public C_LoaiTB timLoaiTBtheoID(int id){
        for(C_LoaiTB l: danhSachToanBo ){
            if(l.idloai==id) return l;
        }
         return null;
    }
    public C_LoaiTB timLoaiTBtheoItem(C_ItemThietBi item){
        for(C_LoaiTB l: danhSachToanBo ){
            for(C_ItemThietBi i: l.cacItems){
                if(i == item) return l;
            }
        }
         return null;
    }
    public C_LoaiTB timLoaiTBtheoChiTieuKT( String chiTieuKT){
        for(C_LoaiTB l: danhSachToanBo ){
            if(l.chiTieuKyThuat.equals(chiTieuKT)) return l;
        }
         return null;
    }
    
}
