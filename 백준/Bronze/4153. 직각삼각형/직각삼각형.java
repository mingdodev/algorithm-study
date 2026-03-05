import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstEdge = Integer.parseInt(st.nextToken());
            if (firstEdge == 0) break;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.add(firstEdge);
            int secondEdge = Integer.parseInt(st.nextToken());
            pq.add(secondEdge);
            int thirdEdge = Integer.parseInt(st.nextToken());
            pq.add(thirdEdge);

            if (Math.pow(pq.remove(), 2) == Math.pow(pq.remove(), 2) + Math.pow(pq.remove(), 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}