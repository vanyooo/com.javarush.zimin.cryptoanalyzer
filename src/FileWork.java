
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWork {

    public static byte[] bytes;
    public static void fileRead() {
        try {
            Scanner con = new Scanner(System.in);
            while (true) { // Цикл для повторного ввода при некорректном пути
                System.out.println(Menu.PATH); // F:/1/text.txt
                Path path1 = Path.of(con.nextLine()); // Указываем путь к файлу откуда берем текст
                if (Files.exists(path1)) { // Проверяем, есть ли данный путь/ если есть, продолжаем работу
                    bytes = Files.readAllBytes(path1);// Читаем текст и сохраняем в массив байтов
                    break; // Выход из цикла после успешного выполнения
                } else {
                    System.out.println(Menu.BUD_PATH);
                }
            }
        } catch (IOException e) {
            System.out.println(Menu.ERROR + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public static void fileWrite() {
        try {
            Scanner con = new Scanner(System.in);
            System.out.println(Menu.NEW_PATH);
            Path path2 = Path.of(con.nextLine());
            if (Files.exists(path2)) {
                System.out.println(Menu.File_IS);
                String response = con.nextLine();
                if (!response.equalsIgnoreCase("да")) {
                    System.out.println(Menu.BREAK);
                    return;
                }
            }
            if (Cipher.chooseFileWrite == 1) {
                Files.write(path2, MyEncryption.alphabetEncryption(FileWork.bytes));
            } else if (Cipher.chooseFileWrite == 2){
                Files.write(path2, MyEncryption.alphabetDecryption(FileWork.bytes));
            } else if (Cipher.chooseFileWrite == 3){
                Files.write(path2, BruteForce.decoding(FileWork.bytes));
            } else if (Cipher.chooseFileWrite == 4){
                Files.write(path2, MapAnalysis.createMap(FileWork.bytes));
            }
            System.out.println(Menu.ALL_GOOD);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}