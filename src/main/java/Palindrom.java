import java.util.Scanner;

public class Palindrom {
    public static boolean isPalindrom(String str) {
        boolean flagPalindrom = true;
        int i = 0, j;

        while (i < str.length() / 2) {
            j = str.length() - 1 - i;
            System.out.println(i + " " + j);

            if (str.charAt(i) != str.charAt(j)) {
                flagPalindrom = false;
                break;
            }

            i++;
        }

        return flagPalindrom;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(isPalindrom(str));
    }
}
