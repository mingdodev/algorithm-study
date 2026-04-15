import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> dfsResult = new ArrayList<>();
    private static List<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] dfsVisited = new boolean[n + 1];
        boolean[] bfsVisited = new boolean[n + 1];
        dfs(graph, dfsVisited, v);
        bfs(graph, bfsVisited, v);

        StringBuilder sb = new StringBuilder();
        for (int i : dfsResult) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        for (int i : bfsResult) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        dfsResult.add(start);

        for (int i : graph.get(start)) {
            if (visited[i]) continue;
            dfs(graph, visited, i);
        }
    }

    private static void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        bfsResult.add(start);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);

        while(!queue.isEmpty()) {
            int temp = queue.pollFirst();
            for (int i : graph.get(temp)) {
                if (visited[i]) continue;
                visited[i] = true;
                bfsResult.add(i);
                queue.addLast(i);
            }
        }
    }
}