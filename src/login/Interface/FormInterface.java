/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.Interface;

import java.rmi.*;

/**
 *
 * @author Isaac A. Marin
 */
public interface FormInterface extends Remote {
    
    public boolean getLogin(String user, String pass) throws RemoteException;
    public boolean register(String user, String pass) throws RemoteException;
}
