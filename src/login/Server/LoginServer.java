/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import login.Implement.LoginImplement;
/**
 *
 * @author Isaac A. Marin
 */
public class LoginServer {
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            LoginImplement lp = new LoginImplement();
            reg.bind("login", lp);
            reg.bind("register", lp);
            System.out.println("Server is Ready");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
