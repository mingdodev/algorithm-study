import java.util.PriorityQueue;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int i, x;
        for (i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x==0) {
                if (minHeap.isEmpty()) sb.append("0\n");
                else {
                    sb.append(minHeap.peek() + "\n");
                    minHeap.poll();
                }
            }
            else {
                minHeap.offer(x);
            }
        }

        System.out.println(sb);
    }
}