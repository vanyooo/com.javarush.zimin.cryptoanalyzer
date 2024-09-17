
import java.util.Scanner;

public class Cipher {

    public static int key;
    public static int chooseFileWrite;
    public static void encryption() {
        Scanner con = new Scanner(System.in);
        System.out.println(Menu.CIPHER1);
        while (true) {
            if (con.hasNextInt()) {
                key = con.nextInt(); // Чтение ключа
                if (key > 0) {
                    System.out.println(Menu.INFO_KEY + key);
                    chooseFileWrite = 1;
                    FileWork.fileRead();
                    FileWork.fileWrite(); // Вызов метода работы с файлами
                    break; // Выход из цикла после успешного ввода
                } else {
                    System.out.println(Menu.KEY_0);
                }
            } else {
                System.out.println(Menu.KEY_NUMBER);
                con.next(); // Пропускаем некорректный ввод
            }
        }
    }

    public static void decryption() {
        Scanner con = new Scanner(System.in);
        System.out.println(Menu.CIPHER2);
        while (true) {
            if (con.hasNextInt()) {
                key = con.nextInt();
                if (key > 0) {
                    System.out.println(Menu.INFO_KEY + key);
                    chooseFileWrite = 2;
                    FileWork.fileRead();
                    FileWork.fileWrite();
                    break;
                } else {
                    System.out.println(Menu.KEY_0);
                }
            } else {
                System.out.println(Menu.KEY_NUMBER);
                con.next();
            }
        }
    }
}

