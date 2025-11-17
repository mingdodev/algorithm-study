import java.io.*;
import java.util.*;

public class Main {
    private static void vps(String ps) {
        // 스택에 순서대로 넣는데, (는 그냥 넣고, )는 이전 항목이 (이면 둘 다 pop된다.
        // 즉 현재 항목과 이전 항목이 파악이 필요하다.
        char[] psArray = ps.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        char last = ' ';

        for(char c : psArray) {
            if (c == ')' && last == '(') {
                stack.pollLast();
                last = stack.isEmpty()? ' ' : stack.peekLast();
            } else {
                stack.offerLast(c);
                last = c;
            }
        }

        if (stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            vps(br.readLine());
        }
    }
}