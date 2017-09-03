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
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author ngohoa
 */
public class GenderRenderer extends JTextArea implements TableCellRenderer {
     public GenderRenderer(){
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, 
                          boolean isSelected, boolean hasFocus, int row, int column) {
        if(isSelected){
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        }else{
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setFont(table.getFont());
        if (hasFocus) {
          setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
          if (table.isCellEditable(row, column)) {
            setForeground(UIManager.getColor("Table.focusCellForeground"));
            setBackground(UIManager.getColor("Table.focusCellBackground"));
          }
        } else {
          setBorder(new EmptyBorder(1, 2, 1, 2));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
