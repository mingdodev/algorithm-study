import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(n);
        visited[n] = 0;

        while(!queue.isEmpty()) {
            int temp = queue.pollFirst();
            if (temp == k) {
                System.out.println(visited[k]);
                return;
            }

            int[] move = new int[]{ temp + 1, temp - 1, temp * 2 };
            for (int i : move) {
                if (i < 0 || i > 100000) continue;
                if (visited[i] != -1) continue;
                queue.addLast(i);
                visited[i] = visited[temp] + 1;
            }
        }
    }
}