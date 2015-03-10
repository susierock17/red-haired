package by.bsuir.Fedyuk;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server implements Cipher {

    private char  Polybius[][]={
            {'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}
    };

    public Server(){}

    public String encrypt(String word){

        word = word.toUpperCase();
        String encMessage=new String();

        for(int index = 0;index < word.length();index++){
                for(int i = 0;i<5;i++){
                    for(int j = 0;j < 5;j++) {
                        if (Polybius[i][j] == word.toCharArray()[index]){
                            encMessage += Integer.toString(i + 1) + Integer.toString(j + 1) + " ";

                        }
                    }
                }
            }
        System.out.println("Enc: " + encMessage);
        return encMessage;
    }

    public String decrypt(String number){

        String decMessage=new String();

        for(int i = 0;i < number.length();i += 2){
            decMessage+=Polybius[Integer.parseInt(Character.toString(number.toCharArray()[i]))-1][Integer.parseInt(Character.toString(number.toCharArray()[i+1]))-1];
        }
        return decMessage;
    }

    public static void main(String [] args){
        try {
            Server obj = new Server();
            Cipher stub = (Cipher) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Crypt", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
