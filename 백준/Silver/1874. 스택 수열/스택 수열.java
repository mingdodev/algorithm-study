/**
 * BOJ
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 지금 들어가는 수 < 목표 수 -> true: 계속 push false: pop
        // 그럼 포인터가 두 개여야 하네
        int temp = 1;
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        do {
            if (temp <= sequence[index]) {
                stack.addFirst(temp);
                sb.append("+").append("\n");
                temp++;
            } else {
                int out = stack.removeFirst();
                if (out != sequence[index]) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-").append("\n");
                index++;
            }
        } while (temp <= n || !stack.isEmpty());

        System.out.println(sb);
    }
}