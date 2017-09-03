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
import Controler.*;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ngohoa
 */
public class C_BangTenLoaiTB extends AbstractTableModel{
    
    ArrayList<String> giatri;
    
    public C_BangTenLoaiTB(C_DATA data){
        
        giatri= new ArrayList<String>();
        for(C_LoaiTB l: data.danhSachToanBo){
            giatri.add(l.chiTieuKyThuat);
        }
        
    }
    @Override
    public int getRowCount() {
        return giatri.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return giatri.get(i);
    }
    
}
