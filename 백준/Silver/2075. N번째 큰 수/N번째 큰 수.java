import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int t;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                t = Integer.parseInt(st.nextToken());
                if (minHeap.size() < n) minHeap.offer(t);
                else {
                    if (t >= minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(t);
                    }
                }
            }
        }
        System.out.println(minHeap.peek());
    }
}
