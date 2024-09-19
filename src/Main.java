import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        while (true) {
            System.out.println(Menu.START);
            String userNumber = con.nextLine();
            if (userNumber.equals("1")) {
                Cipher.encryption();

            } else if (userNumber.equals("2")) {
                Cipher.decryption();

            } else if (userNumber.equals("3")) {
                BruteForce.enumerationMethod();

            } else if (userNumber.equals("4")) {
                MapAnalysis.analysisMethod();
            } else if (userNumber.equals("5")) {
                System.out.println(Menu.BYE);
                break;
            } else {
                System.out.println(Menu.START_MISS);
            }
        }
    }
}

