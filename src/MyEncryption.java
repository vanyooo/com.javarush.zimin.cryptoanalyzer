import java.nio.charset.StandardCharsets;

public class MyEncryption {

    public boolean isValidKey(int key, char[] alphabet) {
        return key >= 0 && key < alphabet.length;                                                   // Ключ допустим, если он находится в пределах размера алфавита
    }


    public static byte[] alphabetEncryption(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] charArray = str.toCharArray();// получаем массив чар из массива байт
        Alphabet.search();// заполнение мапы (ключ-символ, значение-порядковый номер)
        int keyStep = Cipher.key;// ключ пользователя
        for (int i = 0; i < charArray.length; i++) {
            if (Alphabet.alphabetMap.containsKey(charArray[i])) {                                 //цикл зашифровки со сдвигом keyStep
                int position = Alphabet.alphabetMap.get(charArray[i]);
                int p = (position + keyStep) % Alphabet.ALPHABET.length;
                char newChar = Alphabet.ALPHABET[p];
                charArray[i] = newChar;
            }
        }
        return new String(charArray).getBytes(StandardCharsets.UTF_8);// получаем массив байт после кодировки
    }

    public static byte[] alphabetDecryption(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] charArray = str.toCharArray();// получаем массив чар из массива байт
        Alphabet.search();// заполнение мапы (ключ-символ, значение-порядковый номер)
        int keyStep = Cipher.key;// ключ пользователя
        for (int i = 0; i < charArray.length; i++) {
            if (Alphabet.alphabetMap.containsKey(charArray[i])) {                                 //цикл зашифровки со сдвигом keyStep
                int position = Alphabet.alphabetMap.get(charArray[i]);
                int p = (position + keyStep) % Alphabet.ALPHABET.length;
                char newChar = Alphabet.ALPHABET[p];
                charArray[i] = newChar;
            }
        }
        return new String(charArray).getBytes(StandardCharsets.UTF_8);// получаем массив байт после кодировки
    }
}
