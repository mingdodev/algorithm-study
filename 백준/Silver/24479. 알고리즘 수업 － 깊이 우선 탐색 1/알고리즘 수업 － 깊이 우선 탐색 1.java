import java.io.*;
import java.util.*;

public class Main {
    private static int index = 1; // 전역으로 관리. 변화하는 상태를 기록해야 함

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
        for (int i = 1; i <= n; i++) { // 오름차순 방문을 위해
            Collections.sort(graph.get(i));
        }

        int[] visited = new int[n + 1];
        dfs(visited, graph, r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int[] visited, List<List<Integer>> graph, int start) {
        visited[start] = index++;
        for (int i : graph.get(start)) {
            if (visited[i] == 0)
                dfs(visited, graph, i);
        }
    }
}