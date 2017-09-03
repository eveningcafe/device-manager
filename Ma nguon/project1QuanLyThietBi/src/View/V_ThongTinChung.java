/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Controler.C_BangMuonTra;
import Controler.C_BangThietBi;
import Controler.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author ngohoa
 */
public class V_ThongTinChung extends javax.swing.JFrame{
    public C_BangMuonTra c_BangMuonTra;
    public C_BangThietBi c_BangThietBi;
    public JScrollPane v_SBangThietBi;
    public JTable v_BangThietBi;
    public JTable v_BangMuonTra;
    public JScrollPane v_SBangMuonTra;
    public JTabbedPane cacTab;
    int refresh;
    public V_ThongTinChung(C_DATA data){
        setSize(800,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        cacTab =new JTabbedPane();
        c_BangThietBi= new C_BangThietBi(data);
        v_BangThietBi= new JTable(c_BangThietBi);
        v_BangThietBi.getColumnModel().getColumn(8).setCellRenderer(new GenderRenderer());
        v_BangThietBi.getColumnModel().getColumn(9).setCellRenderer(new GenderRenderer());
        v_SBangThietBi= new JScrollPane(v_BangThietBi);
        
        c_BangMuonTra =new C_BangMuonTra(data);
        v_BangMuonTra= new JTable(c_BangMuonTra);
        v_SBangMuonTra=new JScrollPane(v_BangMuonTra);
        JPanel panetab1 = new JPanel();
        JTextField textfield1 = new JTextField();
        panetab1.setLayout(new BorderLayout());
        panetab1.add(v_SBangThietBi,BorderLayout.CENTER);
        panetab1.add(textfield1, BorderLayout.SOUTH);
        v_BangThietBi.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
             textfield1.setText(v_BangThietBi.getValueAt(v_BangThietBi.getSelectedRow(),v_BangThietBi.getSelectedColumn()).toString());
            
        }
            });
        cacTab.addTab("Thiết Bị", null, panetab1, "click to show detail");
        cacTab.addTab("Mượn Trả", null, v_SBangMuonTra, "click to show detail");
        add(cacTab,BorderLayout.CENTER);
        v_BangThietBi.getValueAt(0, 0);
        int m=c_BangThietBi.cot0.size();
        for(int i=0;i<m;i++){
            int hight=0;
            hight=(int)c_BangThietBi.gNumberCellOfcot8.get(i);
            if(hight>1) v_BangThietBi.setRowHeight(i,v_BangThietBi.getRowHeight() * hight);
        }
        setVisible(true);
    }
    
}
