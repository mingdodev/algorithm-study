import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(graph, visited, 1);
        System.out.println(count - 1); // "1번 컴퓨터를 통해" 걸리게 되는 컴퓨터의 수이므로 1번 컴퓨터는 제외
    }
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        count++;

        for (int i : graph.get(start)) {
            if (visited[i]) continue;
            dfs(graph, visited, i);
        }
    }
}