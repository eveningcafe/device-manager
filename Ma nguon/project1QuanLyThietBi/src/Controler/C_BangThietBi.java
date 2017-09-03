/*
chi in gia tri 1 lan dau. va phu thuoc vao bien "lammoi"
thieu dong ket noi khi dung xong
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
public class C_BangThietBi extends AbstractTableModel{
        public final String[] columnNames = {
         "Mã loại máy","Chi Tiết", "Nước SX", "Ngày nhập","Giá 1 TB","Tình trạng","Nguồn tiền","Ghi chú","Mã tài sản","Vị trí"
        };
        public ArrayList cot0, cot1,cot2,cot3,cot4,cot5,cot6,cot7,cot8,cot9;
        public ArrayList gNumberCellOfcot8;
        public ArrayList gNumberCellOfcot9;
        C_DATA data;
        //ket noi csdl va lay ra phan tu dau tien
        public C_BangThietBi(C_DATA data){     
            
            this.data=data;
            cot0 = new ArrayList();
            cot1 = new ArrayList();
            cot2 = new ArrayList();
            cot3 = new ArrayList();
            cot4 = new ArrayList();
            cot5 = new ArrayList();
            cot6 = new ArrayList();
            cot7 = new ArrayList();
            cot8 = new ArrayList();
            cot9 = new ArrayList();
            gNumberCellOfcot8= new ArrayList();
            gNumberCellOfcot9= new ArrayList();
            for(C_LoaiTB l : data.danhSachToanBo){
                cot0.add(l.idloai);
                cot1.add(l.chiTieuKyThuat);
                cot2.add(l.nuocSX);
                cot3.add(l.ngayNhap);
                cot4.add(l.gia1TB);
                cot5.add(l.tinhTrang);
                cot6.add(l.nguonTien);
                cot7.add(l.ghiChu);
                
                String stringOf8 = new String("");
                int NumberCellOfcot8=0;
                if(l.cacItems.size()>=1){
                    System.out.println(l.cacItems.get(0).maTaiSan);
                for(int i=0; i<l.cacItems.size()-1;i++){
                    stringOf8=stringOf8.concat(l.cacItems.get(i).maTaiSan);
                    stringOf8=stringOf8.concat("\n");
                    NumberCellOfcot8++;
                }
                stringOf8=stringOf8.concat(l.cacItems.get(l.cacItems.size()-1).maTaiSan);
                NumberCellOfcot8++;
                }
                cot8.add(stringOf8);
                gNumberCellOfcot8.add(NumberCellOfcot8);
                
                String stringOf9 = new String("");
                int NumberCellOfcot9=0;
                if(l.cacItems.size()>=1){
                    System.out.println(l.cacItems.get(0).viTri);
                for(int i=0; i<l.cacItems.size()-1;i++){
                    if(l.cacItems.get(i).viTri!=null) {
                        stringOf9=stringOf9.concat(l.cacItems.get(i).viTri);
                    }
                    else stringOf9=stringOf9.concat("");
                    stringOf9=stringOf9.concat("\n");
                    NumberCellOfcot9++;
                }
                
                if(l.cacItems.get(l.cacItems.size()-1).viTri!=null){
                    stringOf9=stringOf9.concat(l.cacItems.get(l.cacItems.size()-1).viTri);
                }else stringOf9=stringOf9.concat("");
                NumberCellOfcot9++;
                }
                cot9.add(stringOf9);
                gNumberCellOfcot9.add(NumberCellOfcot9);
                
            }
           
        }
        
        @Override
        public String getColumnName(int column){
            return columnNames[column];
        }
        @Override
        public int getRowCount() {
            return data.danhSachToanBo.size();
        }

        @Override
        public int getColumnCount() {          
            return columnNames.length;
        }
        
        
        @Override
        public Object getValueAt(int i, int j) {
            Object kq= null;
            if(j==0) kq=cot0.get(i);if(j==1) kq=cot1.get(i);if(j==2) kq=cot2.get(i);if(j==3) kq=cot3.get(i);if(j==4) kq=cot4.get(i);if(j==5) kq=cot5.get(i);if(j==6) kq=cot6.get(i);if(j==7) kq=cot7.get(i);
            if(j==8) kq=cot8.get(i);if(j==9) kq=cot9.get(i);
            return kq;
        }
        
    }