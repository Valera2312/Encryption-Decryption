import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String MS = scanner.nextLine();
        int count = 1;
        BigInteger number = new BigInteger("1");
        BigInteger M = new BigInteger(MS);
        while (number.compareTo(M) <= 0) {
            number = number.multiply(BigInteger.valueOf(count));
            if(number.compareTo(M) >= 0 ){
                break;
            }else {
                count++;
            }

        }
        System.out.println(count);
    }

}