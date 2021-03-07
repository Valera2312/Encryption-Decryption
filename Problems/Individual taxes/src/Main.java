import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        String three = scanner.nextLine();
        String[] two_ = two.split(" ");
        String[] three_ = three.split(" ");
        int company = 0;
        double max = 0;
        for (int i = 0; i < Integer.parseInt(one); i++) {
            double v = Integer.parseInt(two_[i]) * ((Integer.parseInt(three_[i]) * 0.01));
            if(v > max) {
                max = v;
                company = i + 1;
            }
        }
        System.out.println(company);
    }
}