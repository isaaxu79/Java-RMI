/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac A. Marin
 */
public class Conexion {
    Connection conectar = null;
    public Connection conexion(){        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/hola","root","");                        
            JOptionPane.showMessageDialog(null,"conectado");
        }catch(Exception e){
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null,"no conectado");
        }
        return conectar;
    }
    public static void main(String[] args){
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
    }
}
