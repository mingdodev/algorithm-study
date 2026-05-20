import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }

            int sub = 1;
            while (true) {
                int temp = queue.removeFirst() - sub;
                if (temp <= 0) {
                    temp = 0;
                    queue.addLast(temp);
                    break;
                }
                queue.addLast(temp);
                sub++;
                if (sub > 5) sub -= 5;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(num).append(" ");
            for (int i : queue) {
                sb.append(i).append(" ");
            }

            System.out.println(sb);
        }
    }
}