import java.nio.charset.StandardCharsets;

public class MyEncryption {

    public static byte[] alphabetEncryption(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] charArray = str.toCharArray();// получаем массив чар из массива байт
        Alphabet.search();// заполнение мапы (ключ-символ, значение-порядковый номер)
        int keyStep = Cipher.key;// ключ пользователя
        for (int i = 0; i < charArray.length; i++) {
            //цикл зашифровки со сдвигом keyStep
            char upChar = Character.toUpperCase(charArray[i]);
            char lowerChar = Character.toLowerCase(charArray[i]);
            if (Alphabet.alphabetMap.containsKey(upChar)) {
                int position = Alphabet.alphabetMap.get(upChar);
                int p = (position + keyStep) % Alphabet.ALPHABET.length;
                char newChar = Alphabet.ALPHABET[p];
                charArray[i] = newChar;
            } else if (Alphabet.alphabetMap.containsKey(lowerChar)) {
                int position = Alphabet.alphabetMap.get(lowerChar);
                int p = (position + keyStep) % Alphabet.ALPHABET.length;
                char newChar = Alphabet.ALPHABET[p];
                charArray[i] = newChar;
            }
        }
        return new String(charArray).getBytes(StandardCharsets.UTF_8);// получаем массив байт после кодировки
    }

    public static byte[] alphabetDecryption(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] charArray = str.toCharArray();
        Alphabet.search();
        int keyStep = Cipher.key;
        for (int i = 0; i < charArray.length; i++) {
            if (Alphabet.alphabetMap.containsKey(charArray[i])) { //цикл дешифровки со сдвигом keyStep
                int position = Alphabet.alphabetMap.get(charArray[i]);
                int newPosition = (position - keyStep + Alphabet.ALPHABET.length) % Alphabet.ALPHABET.length;
                char newChar = Alphabet.ALPHABET[newPosition];
                charArray[i] = newChar;
            }
        }
        return new String(charArray).getBytes(StandardCharsets.UTF_8);
    }
}

