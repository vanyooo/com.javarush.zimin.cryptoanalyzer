
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MapAnalysis {

    public static int a = 0;
    public static int b = 0;
    public static int v = 0;
    public static int g = 0;
    public static int d = 0;
    public static int e = 0;
    public static int zz = 0;
    public static int z = 0;
    public static int i = 0;
    public static int ik = 0;
    public static int k = 0;
    public static int l = 0;
    public static int m = 0;
    public static int n = 0;
    public static int o = 0;
    public static int p = 0;
    public static int r = 0;
    public static int s = 0;
    public static int t = 0;
    public static int y = 0;
    public static int f = 0;
    public static int x = 0;
    public static int c = 0;
    public static int ch = 0;
    public static int sh = 0;
    public static int shc = 0;
    public static int hardSign = 0;
    public static int bi = 0;
    public static int softSign = 0;
    public static int ea = 0;
    public static int u = 0;
    public static int ai = 0;
    public static int dot = 0;
    public static int comma = 0;
    public static int quotationMark1 = 0;
    public static int quotationMark2 = 0;
    public static int colon = 0;
    public static int questionMark = 0;
    public static int exclamationMark = 0;
    public static int space = 0;

    public static void analysisMethod(){
        System.out.println(Menu.Analysis);
        Cipher.chooseFileWrite = 4;
        FileWork.fileRead();
        FileWork.fileWrite();
    }

    public static byte[] createMap(byte[] bytes) {
        String str = new String(bytes, StandardCharsets.UTF_8);
        char[] charArray = str.toCharArray();
        Alphabet.search();

        for (char c : charArray) {
            switch (c) {
                case 'а' -> a++;
                case 'б' -> b++;
                case 'в' -> v++;
                case 'г' -> g++;
                case 'д' -> d++;
                case 'е' -> e++;
                case 'ж' -> zz++;
                case 'з' -> z++;
                case 'и' -> i++;
                case 'й' -> ik++;
                case 'к' -> k++;
                case 'л' -> l++;
                case 'м' -> m++;
                case 'н' -> n++;
                case 'о' -> o++;
                case 'п' -> p++;
                case 'р' -> r++;
                case 'с' -> s++;
                case 'т' -> t++;
                case 'у' -> y++;
                case 'ф' -> f++;
                case 'х' -> x++;
                case 'ц' -> c++;
                case 'ч' -> ch++;
                case 'ш' -> sh++;
                case 'щ' -> shc++;
                case 'ъ' -> hardSign++;
                case 'ы' -> bi++;
                case 'ь' -> softSign++;
                case 'э' -> ea++;
                case 'ю' -> u++;
                case 'я' -> ai++;
                case '.' -> dot++;
                case ',' -> comma++;
                case '«' -> quotationMark1++;
                case '»' -> quotationMark2++;
                case ':' -> colon++;
                case '?' -> questionMark++;
                case '!' -> exclamationMark++;
                case ' ' -> space++;
            }
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("v", v);
        map.put("g", g);
        map.put("d", d);
        map.put("e", e);
        map.put("zz", zz);
        map.put("z", z);
        map.put("i", i);
        map.put("ik", ik);
        map.put("k", k);
        map.put("l", l);
        map.put("m", m);
        map.put("n", n);
        map.put("o", o);
        map.put("p", p);
        map.put("r", r);
        map.put("s", s);
        map.put("t", t);
        map.put("y", y);
        map.put("f", f);
        map.put("x", x);
        map.put("c", c);
        map.put("ch", ch);
        map.put("sh", sh);
        map.put("shc", shc);
        map.put("hardSign", hardSign);
        map.put("bi", bi);
        map.put("softSign", softSign);
        map.put("ea", ea);
        map.put("u", u);
        map.put("ai", ai);
        map.put("dot", dot);
        map.put("comma", comma);
        map.put("quotationMark1", quotationMark1);
        map.put("quotationMark2", quotationMark2);
        map.put("colon", colon);
        map.put("questionMark", questionMark);
        map.put("exclamationMark", exclamationMark);
        map.put("space", space);

        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        List<String> keys = new ArrayList<>(map.keySet());
        int index = keys.indexOf(maxKey);
        int keyStep = index + 1;

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