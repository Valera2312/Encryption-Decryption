package encryptdecrypt;

import javax.swing.text.Style;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, String> hashMap = new HashMap<String, String>();
        for(int i = 0; args.length - 1  > i; i++){
            hashMap.put(args[i], args[i + 1]);
        }

        if(!hashMap.containsKey("-key")){
            hashMap.put("-key","0");
        }

        if(!hashMap.containsKey("-mode")){
            hashMap.put("-mode", "enc");
        }

        if(!hashMap.containsKey("-data")){
            hashMap.put("-data", "");
        }

        if(!hashMap.containsKey("-in")){
            hashMap.put("-in", "");
        }

        if(!hashMap.containsKey("-out")){
            hashMap.put("-out", "");
        }

        if(hashMap.get("-mode").equals("enc")){

            encryption(hashMap.get("-data"),
                    Integer.parseInt(hashMap.get("-key")),
                    hashMap.get("-in"),hashMap.get("-out"));
        }else {
            decryption(hashMap.get("-data"),
                    Integer.parseInt(hashMap.get("-key")),
                    hashMap.get("-in"),hashMap.get("-out"));
        }

    }
    public static void decryption(String data, int key, String in, String out ) throws IOException {

        String message = "";

        if (data.equals("") && in.equals("")) {
            message = "";
        }
        else if(!data.equals("") && in.equals("")){
            message = data;
        }
        else if(!data.equals("")){
            message = data;
        }

        else {
            File file = new File(in);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                message = scanner.nextLine();
            }
            scanner.close();
            //System.out.println(message);
            //file.deleteOnExit();
        }


        char[] message2 = message.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < message2.length; i++) {

            int ch = message2[i];
            int s = ch - key;
            message2[i] = (char) s;
            chars.add(message2[i]);
        }

        StringBuilder result = new StringBuilder();
        for (char ch :
                chars) {
            result.append(ch);
        }

        if (out.equals("")) {

            System.out.print(result);

        } else {
            FileWriter writer = new FileWriter(out); // appends text to the file

            writer.write(String.valueOf(result));
            writer.close();
        }
    }
    public static void encryption(String data, int key, String in, String out ) throws IOException {

        String message = "";

        if (data.equals("") && in.equals("")) {
            message = "";

        }
        else if(!data.equals("") && in.equals("")){
            message = data;
        }
        else if(!data.equals("")){
            message = data;

        } else {
            File file = new File(in);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                message = scanner.nextLine();
            }
            //System.out.println(message);
            //file.deleteOnExit();
            scanner.close();
        }


        char[] message2 = message.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < message2.length; i++){

            int ch = message2[i];
            int s = key + ch;
            message2[i] = (char) s;
            chars.add(message2[i]);
        }

        StringBuilder result = new StringBuilder();
        for (char ch :
                chars) {
            result.append(ch);
        }

        if (out.equals("")) {

            System.out.print(result);

        } else {
            FileWriter writer = new FileWriter(out); // appends text to the file

            writer.write(String.valueOf(result));
            writer.close();
        }
    }
}


