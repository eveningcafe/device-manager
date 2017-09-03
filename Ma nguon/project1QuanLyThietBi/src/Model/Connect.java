/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.C_DATA;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ngohoa
 */
public class Connect{
        public Statement statement;
        public ResultSet result;
        public String querry;
        public Connect() throws IOException{
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Properties p = new Properties();
        p.load(new FileInputStream("config.properties"));
        //System.out.println(p.getProperty("user"));
        //System.out.println(p.getProperty("DATABASE_LINK"));
        String dbURL= p.getProperty("DATABASE_LINK").concat(":").concat(p.getProperty("port")).concat(";databaseName=").concat(p.getProperty("databaseName"))
                                    .concat(";user=").concat(p.getProperty("user")).concat(";password=").concat(p.getProperty("password"));
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
          DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
          this.statement = conn.createStatement();
          //rs.next();
          //conn.close();
        }

            } catch (SQLException ex) {
              System.err.println("Cannot connect database, " + ex);
            }catch (ClassNotFoundException ex) {
                     Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Không load được file cấu hình config.properties ","Lỗi", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        //phuong thuc cua conect
        public void doQuerry(String querry) throws SQLException{
            try{
            this.result = statement.executeQuery(querry);
            }catch(com.microsoft.sqlserver.jdbc.SQLServerException e){
                System.out.println(" khong thay tra ve cai gi");
            }
        }
        public void saveApplication(C_DATA data){
            for(String s: data.getQuerrys()){
                try {
                    doQuerry(s);
                } catch (SQLException ex) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            data.reserstQuerrys();
            JOptionPane.showMessageDialog(null, "Lưu xong!",
                  "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
        }
