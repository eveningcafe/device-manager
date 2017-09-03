/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import Controler.*;
import java.awt.BorderLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author ngohoa
 */
public class V_CanBoMuonThietBi extends javax.swing.JFrame{
    C_CanBoMuonThietBi infoTable;
    public V_CanBoMuonThietBi(C_DATA data,String tencanbo){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(800,200);
        infoTable =new C_CanBoMuonThietBi(data, tencanbo);
        JTable tableCanbo = new JTable(infoTable);
        JScrollPane StableCanbo=new JScrollPane(tableCanbo);
        add(StableCanbo,BorderLayout.CENTER);
        setVisible(true);
    }
}
