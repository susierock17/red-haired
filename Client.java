package by.bsuir.Fedyuk;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client  {
    public Client(){}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Cipher stub = (Cipher) registry.lookup("Crypt");
            String choice=null;

            Scanner str = new Scanner(System.in);
            while (true) {
                int flag = 0;
                System.out.println("1.Encrypt word.");
                System.out.println("2.Decrypt word.");
                System.out.println("3.Exit.");
                while (flag == 0) {
                    System.out.println("Enter your choice:");
                    choice = str.nextLine();
                    flag=1;
                    if (!checkInt(choice))
                        flag = 0;
                }

                switch (choice.toCharArray()[0]) {
                    case '1': {
                        String word = new String();
                        System.out.println("Enter word:");
                        word = str.nextLine();
                        word.trim();
                        word.matches("[A-Za-z]");
                        String response = stub.encrypt(word);
                        System.out.println("Your encrypted word: " + response);

                    }
                    break;
                    case '2': {
                        String number = new String();
                        while (true) {
                            System.out.println("Enter word:");
                            number = str.nextLine();
                            if (/*checkInt(number) &&*/ (number.length()%2==0) && /*number.matches("([1-5])+")*/ number.matches("^[1-5]+$"))
                                break;
                            else
                                continue;
                        }
                        String response = stub.decrypt(number);
                        System.out.println("Your decrypted word: " + response);

                    }
                    break;
                    case '3': {
                        Runtime.getRuntime().exit(0);
                    }
                    break;
                }

            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public static boolean checkInt(String number){
        try {
            Integer.parseInt(number);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}

