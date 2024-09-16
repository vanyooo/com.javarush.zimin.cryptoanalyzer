
import java.util.Scanner;

public class Cipher {

    public static int key;

    public static void encryption() {
        Scanner con = new Scanner(System.in);
        System.out.println("Вы выбрали режим шифрования.\nВведите ключ шифрования:");
        while (true) {
            if (con.hasNextInt()) {
                key = con.nextInt(); // Чтение ключа
                if (key > 0) {
                    System.out.println("Ваш ключ шифрования: " + key);
                    FileWork.modeEncryption(); // Вызов метода работы с файлами
                    break; // Выход из цикла после успешного ввода
                } else {
                    System.out.println("Ключ не может быть меньше 0. Попробуйте снова.");
                }
            } else {
                System.out.println("Ключ должен быть числом. Попробуйте снова.");
                con.next(); // Пропускаем некорректный ввод
            }
        }
    }

    public static void decryption() {
        Scanner con = new Scanner(System.in);
        System.out.println("Вы выбрали режим дешифрования.\nВведите ключ дешифрования:");
        while (true) {
            if (con.hasNextInt()) {
                key = con.nextInt(); // Чтение ключа
                if (key > 0) {
                    System.out.println("Ваш ключ дешифрования: " + key);
                    FileWork.modeEncryption(); // Вызов метода работы с файлами
                    break; // Выход из цикла после успешного ввода
                } else {
                    System.out.println("Ключ не может быть меньше 0. Попробуйте снова.");
                }
            } else {
                System.out.println("Ключ должен быть числом. Попробуйте снова.");
                con.next(); // Пропускаем некорректный ввод
            }
        }
    }
}

