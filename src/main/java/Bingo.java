import java.util.HashMap;
import java.util.Scanner;

public class Bingo {
    public static int bingo(int[] arr, int t, int n) {
        double firstSumRaw = n * (n + 1) / 2d;
        double firstSumCol = n / 2d * (2 + (n - 1) * n);
        double firstSumD1 = n / 2d * (2 + (n - 1) * (n + 1));
        double firstSumD2 = n / 2d * (2 * n + (n - 1) * (n - 1));

        HashMap<Integer, Integer> field = new HashMap<>();

        for (int i = 0; i < t; i++) {
            int x = arr[i] / n;
            int y = arr[i] - arr[i] / n * n - 1;

            if (arr[i] % n == 0) {
                --x;
            }

            if (arr[i] % n == 0) {
                y = arr[i] / n - 1;
            }

            int rawId = x;
            int colId = y + n;
            int dId1 = n * 2;
            int dId2 = n * 2 + 1;

            field.put(rawId, field.getOrDefault(rawId, 0) + arr[i]);
            field.put(colId, field.getOrDefault(colId, 0) + arr[i]);

            if (x == y) {
                field.put(dId1, field.getOrDefault(dId1, 0) + arr[i]);
            }

            if (Math.abs(x - n) - 1 == y) {
                field.put(dId2, field.getOrDefault(dId2, 0) + arr[i]);
            }

            if (field.get(rawId) != null && field.get(rawId) >= firstSumRaw + n * n * x || field.get(colId) != null &&
                    field.get(colId) >= firstSumCol + n * x) {
                return i + 1;
            }

            if (field.get(dId2) != null && field.get(dId2) >= firstSumD2) {
                return i + 1;
            }

            if (field.get(dId1) != null && field.get(dId1) >= firstSumD1) {
                return i + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nt = scanner.nextLine();

        int n = Integer.parseInt(String.valueOf(nt.charAt(0)));
        int t = Integer.parseInt(String.valueOf(nt.charAt(2)));

        int[] numt = new int[t];
        char[] strNums = scanner.nextLine()
                .replace(" ", "")
                .toCharArray();

        for (int i = 0; i < t; i++) {
            numt[i] = Integer.parseInt(String.valueOf(strNums[i]));
        }

        System.out.println(bingo(numt, t, n));
    }
}
