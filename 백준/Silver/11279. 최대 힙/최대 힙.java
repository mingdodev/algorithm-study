import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1,o2);
                }
        });

        int N = Integer.parseInt(br.readLine());
        int i, x;
        for (i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x==0) {
                if (maxHeap.isEmpty()) sb.append("0\n");
                else {
                    sb.append(maxHeap.peek()).append("\n");
                    maxHeap.poll();
                }
            }
            else {
                maxHeap.offer(x);
            }
        }

        System.out.println(sb);
    }
}