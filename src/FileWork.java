
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWork {

    public static void ModeEncryption() {
        try (Scanner con = new Scanner(System.in)) {
            System.out.println("Введите путь к исходному файлу:");//F:/1/text.txt
            Path path1 = Path.of(con.nextLine());                                           // указываем путь к файлу откуда берем текст
            if (Files.exists(path1)) {                                                      // проверяем есть ли данный путь/ если есть продолжаем работу
                System.out.println("Введите путь куда будет скопирован файл:");
                Path path2 = Path.of(con.nextLine());                                       //указываем путь к файлу куда сохраняем текст
                if (Files.exists(path2)) {                                                  // если файл уже существует, уточнить перезапись файла
                    System.out.println("Файл уже существует. Перезаписать? (да/нет)");
                    String response = con.nextLine();
                    if (!response.equalsIgnoreCase("да")) {
                        System.out.println("Операция отменена.");
                        return;
                    }
                }
                byte[] bytes = Files.readAllBytes(path1);                                   //читаем текст и сохраняем в массив байтов
                Files.write(path2, MyEncryption.alphabetEncryption(bytes));                 //используем метод кодирования и записываем в новый файл
                System.out.println("Файл успешно зашифрован и сохранен.");
            } else {                                                                        // если путь отсутствует, просим ввести путь еще раз
                System.out.println("Вы ввели некорректный путь. Пожалуйста, попробуйте снова.");
                ModeEncryption();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке файла: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void ModeDecryption() {
        try (Scanner con = new Scanner(System.in)) {
            System.out.println("Введите путь к исходному файлу:");//F:/1/text.txt
            Path path1 = Path.of(con.nextLine());                                           // указываем путь к файлу откуда берем текст
            if (Files.exists(path1)) {                                                      // проверяем есть ли данный путь/ если есть продолжаем работу
                System.out.println("Введите путь куда будет скопирован файл:");
                Path path2 = Path.of(con.nextLine());                                       //указываем путь к файлу куда сохраняем текст
                if (Files.exists(path2)) {                                                  // если файл уже существует, уточнить перезапись файла
                    System.out.println("Файл уже существует. Перезаписать? (да/нет)");
                    String response = con.nextLine();
                    if (!response.equalsIgnoreCase("да")) {
                        System.out.println("Операция отменена.");
                        return;
                    }
                }
                byte[] bytes = Files.readAllBytes(path1);                                   //читаем текст и сохраняем в массив байтов
                Files.write(path2, MyEncryption.alphabetEncryption(bytes));                 //используем метод кодирования и записываем в новый файл
                System.out.println("Файл успешно зашифрован и сохранен.");
            } else {                                                                        // если путь отсутствует, просим ввести путь еще раз
                System.out.println("Вы ввели некорректный путь. Пожалуйста, попробуйте снова.");
                ModeEncryption();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке файла: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
