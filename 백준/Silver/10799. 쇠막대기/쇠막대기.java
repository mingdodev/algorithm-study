import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        // )이 들어올 때: 이전 값이 ( 이라면 pop 하고 레이저 쏘기 / 이전 값이 )라면 pop만
        boolean isBeforeLeft = false;
        int result = 0;

        for (Character c : input) {
            if (c == '(') {
                stack.offerLast(c);
                isBeforeLeft = true;
            }
            if (c == ')') {
                stack.remove();
                if (isBeforeLeft) {
                    result += stack.size();
                } else {
                    result += 1;
                }
                isBeforeLeft = false;
            }
        }
        System.out.println(result);
    }
}
