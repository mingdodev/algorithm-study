import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) - Math.abs(b) != 0)
                return Math.abs(a) - Math.abs(b);
            else
                return a - b;
        });

        int x;
        Integer t;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            switch (x) {
                case 0:
                    t = absHeap.poll();
                    if (t != null)
                        sb.append(t).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                default:
                    absHeap.offer(x);
            }
        }

        System.out.println(sb);
    }
}
