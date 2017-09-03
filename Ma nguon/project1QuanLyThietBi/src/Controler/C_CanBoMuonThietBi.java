/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ngohoa
 */
public class C_CanBoMuonThietBi extends AbstractTableModel{
    public final String[] columnNames = {
         "STT","Mã tài sản","Chi tiết KT","Tình trạng(%) ","Ngày mượn","Vị trí"
        };
    C_DATA data;
    public ArrayList cot0, cot1,cot2,cot3,cot4,cot5;
    public C_CanBoMuonThietBi(C_DATA data, String tenNguoiMuon){
        this.data=data;
            cot0 = new ArrayList();
            cot1 = new ArrayList();
            cot2 = new ArrayList();
            cot3 = new ArrayList();
            cot4 = new ArrayList();
            cot5 = new ArrayList();
        int stt=1;
        for(C_LoaiTB l : data.danhSachToanBo){
            for(C_ItemThietBi i : l.cacItems){
                if(i.muonTra.tenNguoiMuon!=null&&(i.muonTra.tenNguoiMuon.equals("")==false)&&(i.muonTra.tenNguoiMuon.equals(tenNguoiMuon)==true)){
                    cot0.add(stt);stt++;
                    cot1.add(i.maTaiSan);
                    cot2.add(data.timLoaiTBtheoItem(i).chiTieuKyThuat);
                    cot3.add(data.timLoaiTBtheoItem(i).tinhTrang);
                    cot4.add(i.muonTra.ngayMuon);
                    cot5.add(i.viTri);
                }  
            }
        }
    }
    @Override
        public String getColumnName(int column){
            return columnNames[column];
        }
    @Override
    public int getRowCount() {
        return cot1.size();
    }

        @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Object kq= null;
        if(j==0) kq=cot0.get(i);if(j==1) kq=cot1.get(i);if(j==2) kq=cot2.get(i);if(j==3) kq=cot3.get(i);if(j==4) kq=cot4.get(i);if(j==5) kq=cot5.get(i); 
        return kq;
    }
    
}
