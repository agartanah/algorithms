import java.util.Scanner;

public class SecondMax {
    public static int secondMax(int[] arr) {
        int firstMax = arr[0];
        int secondMax = arr[0];
        boolean hasSecond = false;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
                hasSecond = true;
            } else if (num > secondMax) {
                secondMax = num;
                hasSecond = true;
            } else if (secondMax == firstMax) {
                secondMax = num;

                if (num != firstMax) {
                    hasSecond = true;
                }
            }
        }

        if (!hasSecond) {
            throw new RuntimeException("Второго максимума нет!");
        }

        return secondMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenArr = scanner.nextInt();

        int[] arr = new int[lenArr];

        for (int i = 0; i < lenArr; i++) {
            arr[i] = scanner.nextInt();
        }

        try {
            int res = secondMax(arr);
            System.out.println(res);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
