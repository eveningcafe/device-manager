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
import Controler.C_BangTenLoaiTB;
import Model.Connect;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controler.*;
public class V_ChonLoaiThietBi extends javax.swing.JFrame{
    C_BangTenLoaiTB c_LoaiThietBi;
    JLabel label;
    String tenLoaidcchon;

    public V_ChonLoaiThietBi(C_DATA data,JLabel label,JLabel label4,JLabel label7,JLabel label9,JLabel label11, JTextField jTextField3,JTextField jTextField4){
        tenLoaidcchon=new String("chưa có loại nào được chon");
        this.label=label;
        c_LoaiThietBi = new C_BangTenLoaiTB(data);
        setSize(800,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JTable tenloai = new JTable(c_LoaiThietBi);
        add(tenloai,BorderLayout.CENTER);
        tenloai.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            tenLoaidcchon = tenloai.getValueAt(tenloai.getSelectedRow(), 0).toString();
            
        }
            });
        JButton chonBut = new JButton();
        chonBut.setText("Chọn");
        
        chonBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(C_LoaiTB l: data.danhSachToanBo){
                    if(tenLoaidcchon.equals(l.chiTieuKyThuat)==false) continue;
                    label4.setText(l.nuocSX);
                    label7.setText(l.ngayNhap);
                    label9.setText(l.nguonTien);
                    label11.setText(Float.toString(l.gia1TB));
                    jTextField3.setEnabled(true);
                    jTextField4.setEnabled(true);
                    clickChon(evt);
                }
            }
        });
        add(chonBut,BorderLayout.SOUTH);
        setVisible(true);
    }
    private void clickChon(ActionEvent evt) {
                label.setText(tenLoaidcchon);
                this.dispose();
            }
    
}
