import java.nio.IntBuffer;

public class CheckJava {
    public static void main(String[] args) {
        System.out.println((0 + 15d) / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && true || false && true);

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == c && c == b) {
            System.out.println("равны");
        } else {
            System.out.println("неравны");
        }

        String s = "";
        String ss = s + " ";
        Boolean bool = false;
    }
}
