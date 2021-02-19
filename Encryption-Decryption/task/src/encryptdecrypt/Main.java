package encryptdecrypt;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


       // Scanner scanner = new Scanner(System.in);
       // String method = scanner.nextLine();
        //String message = scanner.nextLine();
        //int key = scanner.nextInt();

        Map<String, String> hashMap = new HashMap<String, String>();
        for(int i = 0; args.length - 1  > i; i++){

            hashMap.put(args[i], args[i + 1]);

        }


        if(hashMap.get("-mode").equals("enc")){
            encryption(hashMap.get("-data"),Integer.parseInt(hashMap.get("-key")));
        }else {
            decryption(hashMap.get("-data"),Integer.parseInt(hashMap.get("-key")));
        }

    }

    public static void decryption(String message, int key){

        char[] message2 = message.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < message2.length; i++){

           // if(message2[i] == ' ' ){
                //chars.add(message2[i]);
                //continue;
            //}
            int ch = message2[i];
            //int count = 122 - key;

            //if(ch > count){
                int s = ch - key;
                message2[i] = (char) s;
                chars.add(message2[i]);
                /*
            }else {
                int s =  ch + key;
                message2[i] = (char) s;
                chars.add(message2[i]);
            }
                 */
        }
        for (char ch:
                chars) {
            System.out.print(ch);
        }
    }



    public static void  encryption(String message, int key){

        char[] message2 = message.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < message2.length; i++){

            //if(message2[i] == ' '){
                //chars.add(message2[i]);
                //continue;
            //}
            int ch = message2[i];
            //int count = 122 - key;

            //if(ch > count){
                int s = key + ch;
                message2[i] = (char) s;
                chars.add(message2[i]);

                /*
            }else {
                int s =  ch + key;
                message2[i] = (char) s;
                chars.add(message2[i]);
            }

                 */
        }
        for (char ch:
                chars) {
            System.out.print(ch);
        }
    }

}
