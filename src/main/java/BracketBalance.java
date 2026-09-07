import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BracketBalance {
    public static boolean bracketBalance(String brackets) {
        char[] charArr = brackets.toCharArray();

        Deque<Character> stackBrack = new ArrayDeque<>();

        for (char bracket : charArr) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stackBrack.push(bracket);
            } else if (bracket == ')') {
                if (stackBrack.pop() != '(') {
                    return false;
                }
            } else if (bracket == '}') {
                if (stackBrack.pop() != '{') {
                    return false;
                }
            } else if (bracket == ']') {
                if (stackBrack.pop() != '[') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(bracketBalance(str));
    }
}
