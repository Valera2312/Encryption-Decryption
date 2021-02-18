package encryptdecrypt;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int n = scanner.nextInt();
        //String a = "welcome to hyperskill";
        //int n = 5;
        char[] a2 = a.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < a2.length; i++){

            if(a2[i] == ' ' || a2[i] == '!'){
                chars.add(a2[i]);
                continue;
            }
            int ch = a2[i];
            int count = 122 - n;

            if(ch > count){
                int s = n - (122 - ch)- 1 + 97;
                a2[i] = (char) s;
                chars.add(a2[i]);
            }else {
                int s =  ch + n;
                a2[i] = (char) s;
                chars.add(a2[i]);
            }
        }
        for (char a3:
             chars) {
                System.out.print(a3);
            }


        
    }
}
