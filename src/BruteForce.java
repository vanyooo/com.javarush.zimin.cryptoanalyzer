import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BruteForce {

    public static Scanner con = new Scanner(System.in);
    public static void inputFile() {
        System.out.println("Вы выбрали режим грубой силы, а это значит у Вас нет ключа");
        //
        while (true) {
            System.out.println("Введите путь к зашифрованному файлу:");//F:/1/text.txt
            Path path1 = Path.of(con.nextLine());                                           // указываем путь к файлу откуда берем текст
            if (Files.exists(path1)) {                                                      // проверяем есть ли данный путь/ если есть продолжаем работу
                System.out.println("Введите путь, куда будет скопирован файл:");
                Path path2 = Path.of(con.nextLine());                                       //указываем путь к файлу куда сохраняем текст
                if (Files.exists(path2)) {                                                  // если файл уже существует, уточнить перезапись файла
                    System.out.println("Файл уже существует. Перезаписать? (да/нет)");
                    String response = con.nextLine();
                    if (!response.equalsIgnoreCase("да")) {
                        System.out.println("Операция отменена.");
                        return;
                    }
                }
                byte[] bytes;
                try {
                    bytes = Files.readAllBytes(path1);//читаем все байты из изначального файла
                    Files.write(path2,decoding(bytes));// методом decoding записываем расшифрованный текст
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Файл успешно расшифрован и сохранен.");
                break;
            } else {
                System.out.println("Вы ввели некорректный путь. Пожалуйста, попробуйте снова.");
                inputFile();
            }
        }
    }

    public static byte[] decoding(byte[] bytes){
        String str = new String(bytes, StandardCharsets.UTF_8);
        Alphabet.search();// заполнение мапы (ключ-символ, значение-порядковый номер)
        String report;
        int key = 1;// начинаем с ключа значением 1
        char[] charArray;
        while (true) {
            charArray = str.toCharArray();
            for (int i = 0; i < 10; i++) {// даём пользователю первое предложение расшифрованного текста
                if (Alphabet.alphabetMap.containsKey(charArray[i])) { //цикл дешифровки со сдвигом keyStep
                    int position = Alphabet.alphabetMap.get(charArray[i]);
                    int newPosition = (position - key + Alphabet.ALPHABET.length) % Alphabet.ALPHABET.length;
                    char newChar = Alphabet.ALPHABET[newPosition];
                    charArray[i] = newChar;
                }
            }
            key++;// увеличиваем ключ на 1
            report = new String(charArray);
            String first15Chars = report.substring(0, Math.min(15, report.length()));
            System.out.println(first15Chars);
            System.out.println("Расшифровка подходит? Если да, нажмите ДА для полной расшифровки");
            String answer = con.nextLine();
            if (answer.equalsIgnoreCase("да")) {// если расшифровка подходит, расшифровываем весь текст
                charArray = str.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (Alphabet.alphabetMap.containsKey(charArray[i])) { //цикл дешифровки со сдвигом keyStep
                        int position = Alphabet.alphabetMap.get(charArray[i]);
                        int newPosition = (position - (key-1) + Alphabet.ALPHABET.length) % Alphabet.ALPHABET.length;
                        char newChar = Alphabet.ALPHABET[newPosition];
                        charArray[i] = newChar;
                    }
                }
                break;
            }
        }
        System.out.println("Ключ шифрования: " + (key-1));
        return new String(charArray).getBytes(StandardCharsets.UTF_8);
    }
}

