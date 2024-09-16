import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    public static final char[] ALPHABET = {'а', 'А', 'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'е', 'Е', 'ж', 'Ж', 'з','З',
            'и','И', 'к', 'К', 'л','Л', 'м','М', 'н','Н', 'о','О', 'п','П', 'р','Р', 'с','С', 'т', 'Т', 'у','У', 'ф','Ф', 'х','Х', 'ц','Ц',
            'ч','Ч', 'ш','Ш', 'щ','Щ', 'ъ','Ъ', 'ы','Ы', 'ь','Ь', 'э','Э', 'Ю','ю','я','Я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    static Map<Character, Integer> alphabetMap = new HashMap<>();

    public static void search() {
        for (int i = 0; i < ALPHABET.length; i++) {
            alphabetMap.put(ALPHABET[i], i);
        }
    }
}
