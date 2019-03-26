/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Implement;

import Connection.Conexion;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import login.Interface.FormInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Isaac A. Marin
 */
public class LoginImplement extends UnicastRemoteObject implements FormInterface{
    
    private Conexion cc = new Conexion();
    private Connection cn= cc.conexion();
    private String passDb;
    private String userDB;
    
    public LoginImplement() throws RemoteException{
        
    }

    public boolean getLogin(String user, String pass) throws RemoteException {
        boolean found = false;
        String sql = "SELECT * FROM users WHERE username = '"+ user +"'";
        
        try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql); 
                while(rs.next()){
                    userDB = rs.getString(2);
                    passDb=rs.getString(3);
                }
                if(user.equals(userDB.toLowerCase()) && pass.equals(passDb)){
                    found = true;
                }else{
                    found = false;
                }
            } catch (SQLException e) {
                Logger.getLogger(LoginImplement.class.getName()).log(Level.SEVERE, null, e);
            }
        return found;
    }
    
    public boolean register(String user, String pass) throws RemoteException {
        boolean found = false;
        String sql = "INSERT INTO users(username, password) VALUES (?,?)";
        
        try {
               PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, pass);
                int n = pst.executeUpdate();
                if(n>0){
                    found = true;
                }else{
                    found = false;
                }
            } catch (SQLException e) {
                Logger.getLogger(LoginImplement.class.getName()).log(Level.SEVERE, null, e);
                System.out.println(e);
            }
        return found;
    }
    
}
