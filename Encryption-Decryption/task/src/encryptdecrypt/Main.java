package encryptdecrypt;

import javax.swing.text.Style;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = "we found a treasure!";
        char[] a2 = a.toCharArray();
        ArrayList<Character> chars = new ArrayList<Character>();


        for (int i = 0; i < a2.length; i++){
            if(a2[i] == ' ' || a2[i] == '!'){
                chars.add(a2[i]);
                continue;
            }
            int ch = a2[i];
            int s = 122 - ch + 97;
            a2[i] = (char) s;
            chars.add(a2[i]);
            
        }
        for (char a3:
             chars) {
                System.out.print(a3);
            }


        
    }
}
