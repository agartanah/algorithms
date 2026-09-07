import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUnrepeatChar {
    public static Character firstUniqueCharacter(String str) {
        char[] charArr = str.toCharArray();

        HashMap<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < charArr.length; i++) {
            if (!chars.containsKey(charArr[i])) {
                chars.put(charArr[i], i);
            } else {
                chars.put(charArr[i], -1);
            }
        }

        int minIndex = charArr.length;

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            int index = entry.getValue();

            if (index < 0) {
                continue;
            }

            if (index < minIndex) {
                minIndex = index;
            }
        }

        if (minIndex == charArr.length) {
            throw new RuntimeException("нет уникального символа!");
        }

        return charArr[minIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        try {
            Character ch = firstUniqueCharacter(str);

            System.out.println(ch);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
