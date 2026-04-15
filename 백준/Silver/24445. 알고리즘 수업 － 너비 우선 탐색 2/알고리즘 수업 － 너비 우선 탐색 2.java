import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.reverseOrder());
        }

        int[] visited = new int[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        int index = 1;
        queue.addLast(r);
        visited[r] = index++;

        while(!queue.isEmpty()) {
            int temp = queue.pollFirst();
            for (int i : graph.get(temp)) {
                if (visited[i] == 0) {
                    queue.addLast(i);
                    visited[i] = index++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}