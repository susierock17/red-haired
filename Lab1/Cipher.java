package by.bsuir.Fedyuk;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cipher extends Remote {

    public String encrypt(String word) throws RemoteException;
    public String decrypt(String number) throws RemoteException;

}
