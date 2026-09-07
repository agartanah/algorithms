import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Anagrams {
    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstCharArr = first.toCharArray();
        char[] secondCharArr = second.toCharArray();

        HashMap<Character, Integer> firstQuantityChars = new HashMap<>();
        HashMap<Character, Integer> secondQuantityChars = new HashMap<>();

        for (char ch : firstCharArr) {
            firstQuantityChars.put(ch, firstQuantityChars.getOrDefault(ch, 0) + 1);
        }

        for (char ch : secondCharArr) {
            secondQuantityChars.put(ch, secondQuantityChars.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : firstQuantityChars.entrySet()) {
            if (!Objects.equals(entry.getValue(), secondQuantityChars.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        System.out.println(areAnagrams(str1, str2));
    }
}
