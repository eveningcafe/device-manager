/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Connect;
import javax.swing.table.AbstractTableModel;
import Controler.*;

/**
 *
 * @author ngohoa
 */
public class C_BangMuonTra extends AbstractTableModel{
            public final String[] columnNames = {"Mã thiết bị","Số hiệu TB","Tên người mượn","Ngày mượn","Ngày trả","Chú Thích"};
            ArrayList cot0, cot1,cot2,cot3,cot4,cot5;
            public C_BangMuonTra(C_DATA data){            
            cot0= new ArrayList();
            cot1= new ArrayList();
            cot2= new ArrayList();
            cot3= new ArrayList();
            cot4= new ArrayList();
            cot5= new ArrayList();
            for(C_LoaiTB d: data.danhSachToanBo){
                for(C_ItemThietBi i: d.cacItems){
                    if(i.muonTra.tenNguoiMuon==null) continue;
                    cot0.add(i.maTaiSan);
                    cot1.add(i.soHieuMay);
                    cot2.add(i.muonTra.tenNguoiMuon);
                    cot3.add(i.muonTra.ngayMuon);
                    cot4.add(i.muonTra.ngayTra);
                    cot5.add(i.muonTra.chuThich);
                }
            }
            }
            @Override
            public String getColumnName(int column){
                return columnNames[column];
            }
            @Override
            public int getRowCount() {
                
                return cot0.size();
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
