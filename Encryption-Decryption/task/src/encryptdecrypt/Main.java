package encryptdecrypt;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {

        Choice sender = new Choice();
        Map<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; args.length - 1 > i; i++) {

            hashMap.put(args[i], args[i + 1]);
        }

        if (!hashMap.containsKey("-key")) {
            hashMap.put("-key", "0");
        }
        if (!hashMap.containsKey("-mode")) {
            hashMap.put("-mode", "enc");
        }
        if (!hashMap.containsKey("-data")) {
            hashMap.put("-data", "");
        }
        if (!hashMap.containsKey("-in")) {
            hashMap.put("-in", "");
        }
        if (!hashMap.containsKey("-out")) {
            hashMap.put("-out", "");
        }
        if (!hashMap.containsKey("-alg")) {
            hashMap.put("-alg", "shift");
        }

        if (hashMap.get("-alg").equals("unicode")){

            sender.SetAlgorithm(new unicode());

            if (hashMap.get("-mode").equals("enc")) {

                sender.encryption(hashMap.get("-data"),
                        Integer.parseInt(hashMap.get("-key")),
                        hashMap.get("-in"), hashMap.get("-out"));
            } else {
                sender.decryption(hashMap.get("-data"),
                        Integer.parseInt(hashMap.get("-key")),
                        hashMap.get("-in"), hashMap.get("-out"));
            }
        }
        else if(hashMap.get("-alg").equals("shift")){

            sender.SetAlgorithm(new shift());

            if (hashMap.get("-mode").equals("enc")) {

                sender.encryption(hashMap.get("-data"),
                        Integer.parseInt(hashMap.get("-key")),
                        hashMap.get("-in"), hashMap.get("-out"));
            } else {
                sender.decryption(hashMap.get("-data"),
                        Integer.parseInt(hashMap.get("-key")),
                        hashMap.get("-in"), hashMap.get("-out"));
            }
        }


    }
}

class Choice {

    private Algorithm alg;

    public void SetAlgorithm (Algorithm alg) {
        this.alg = alg;
    }

    public void encryption(String data, int key, String in, String out) throws IOException {
        this.alg.encryption(data, key, in, out);
    }
    public void decryption(String data, int key, String in, String out) throws IOException {
        this.alg.decryption(data, key, in, out);
    }
}

    interface Algorithm {

        void encryption (String data, int key, String in, String out) throws IOException;

        void decryption (String data, int key, String in, String out) throws IOException;
    }

    class shift implements Algorithm {

        @Override
        public void encryption (String data, int key, String in, String out) throws IOException {

            String message = "";
            if (data.equals("") && in.equals("")) {
                message = "";
            } else if (!data.equals("") && in.equals("")) {
                message = data;
            } else if (!data.equals("")) {
                message = data;
            } else {
                File file = new File(in);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    message = scanner.nextLine();
                }
                scanner.close();

//------------------------------------------
                char[] message2 = message.toCharArray();
                ArrayList<Character> chars = new ArrayList<Character>();

                for (int i = 0; i < message2.length; i++){

                    if(message2[i] == ' ' || message2[i] == '!'){
                        chars.add(message2[i]);
                        continue;
                    }
                    int ch = message2[i];
                    int count = 122 - key;

                    if(ch > count){
                        int s = key - (122 - ch)- 1 + 97;
                        message2[i] = (char) s;
                        chars.add(message2[i]);
                    }else {
                        int s =  ch + key;
                        message2[i] = (char) s;
                        chars.add(message2[i]);
                    }
                }

//------------------------------------------
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

        @Override
        public void decryption (String data, int key, String in, String out) throws IOException {

            String message = "";
            if (data.equals("") && in.equals("")) {
                message = "";
            } else if (!data.equals("") && in.equals("")) {
                message = data;
            } else if (!data.equals("")) {
                message = data;
            } else {
                File file = new File(in);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    message = scanner.nextLine();
                }
                scanner.close();
            }
            //--------------------------------------------------------------------------
            char[] message2 = message.toCharArray();
            ArrayList<Character> chars = new ArrayList<Character>();

            for (int i = 0; i < message2.length; i++){

                if(message2[i] == ' ' || message2[i] == '!'){
                    chars.add(message2[i]);
                    continue;
                }
                int ch = message2[i];
                int count = 97 + key;

                if(ch < count){
                    int s = Math.abs(key - (122 + ch)- 1 + 97);
                    message2[i] = (char) s;
                    chars.add(message2[i]);
                }else {
                    int s =  ch - key;
                    message2[i] = (char) s;
                    chars.add(message2[i]);
                }
            }
            //--------------------------------------------------------------------------
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

    class unicode implements Algorithm {

        @Override
        public void encryption (String data, int key, String in, String out) throws IOException {
            String message = "";
            if (data.equals("") && in.equals("")) {
                message = "";
            } else if (!data.equals("") && in.equals("")) {
                message = data;
            } else if (!data.equals("")) {
                message = data;
            } else {
                File file = new File(in);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    message = scanner.nextLine();
                }
                scanner.close();
            }
            char[] message2 = message.toCharArray();
            ArrayList<Character> chars = new ArrayList<Character>();

            for (int i = 0; i < message2.length; i++) {

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
        @Override
        public void decryption (String data, int key, String in, String out) throws IOException {
            String message = "";
            if (data.equals("") && in.equals("")) {
                message = "";
            } else if (!data.equals("") && in.equals("")) {
                message = data;
            } else if (!data.equals("")) {
                message = data;
            } else {
                File file = new File(in);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    message = scanner.nextLine();
                }
                scanner.close();

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

    }



