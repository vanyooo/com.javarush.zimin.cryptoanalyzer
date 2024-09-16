import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        System.out.println("Выберете режим работы:\n1 - шифрование текста.\n2 - расшифровка текста.\n3 - расшифровка без ключа\n4 - выход из программы.");
        while (true) {
            String userNumber = con.nextLine();
            if (userNumber.equals("1")) {
                Cipher.encryption();
                break;
            } else if (userNumber.equals("2")) {
                Cipher.decryption();
                break;
            } else if (userNumber.equals("3")) {
                BruteForce.inputFile();
                break;
            } else if (userNumber.equals("4")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Вы нажали не туда, выберете еще раз");
            }
        }
    }
}

