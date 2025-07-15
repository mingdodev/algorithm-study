import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputString = br.readLine().toCharArray();
        char[] bombString = br.readLine().toCharArray();
        int bombLength = bombString.length;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : inputString) {
            stack.addLast(c);

            // 뒤에서부터 비교해야 한다.
            // 선형적으로 터지기 때문에, 설령 앞에서 새로 폭발 문자열이 생기더라도 그것부터 터지면 안 됨!
            if (stack.size() >= bombLength) {
                boolean match = true;
                Iterator<Character> it = stack.descendingIterator();
                for (int i = bombLength - 1; i >= 0; i--) {
                    if (!it.hasNext() || it.next() != bombString[i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int i = 0; i < bombLength; i++) stack.removeLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}