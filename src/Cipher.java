
import java.util.Scanner;

public class Cipher {

    public static int key;
    public static void encryption(){
        Scanner con = new Scanner(System.in);
        System.out.println("Вы выбрали режим шифрования.\nВведите ключ шифрования.");
        if (con.hasNextInt()) {
            key = con.nextInt();
            System.out.println("Ваш ключ шифрования: " + key);
            FileWork.ModeEncryption();
        } else {
            System.out.println("Вы ввели некоректный ключ");
            con.next();
            encryption();
        }
    }

    public static void decryption(){
        Scanner con = new Scanner(System.in);
        System.out.println("Вы выбрали режим дешифрования.\nВведите ключ дешифрования.");
        if (con.hasNextInt()) {
            key = con.nextInt();
            System.out.println("Ваш ключ дешифрования: " + key);
            FileWork.ModeEncryption();
        } else {
            System.out.println("Вы ввели некоректный ключ");
            con.next();
            decryption();
        }



    }
}
