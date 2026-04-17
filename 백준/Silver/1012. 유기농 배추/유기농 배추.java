import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] results = new int[t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new boolean[n][m];
            visited = new boolean[n * m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = true;
            }

            for (int index = 0; index < m * n; index++) {
                if (visited[index]) continue;
                visited[index] = true;
                if (!graph[index / m][index % m]) continue;
                dfs(index, m, n);
                results[i]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int root, int m, int n) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1};
        int x = root % m;
        int y = root / m;

        for (int i = 0; i < 4; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= m || y + dy[i] < 0 || y + dy[i] >= n) continue;
            int index = (y + dy[i]) * m + x + dx[i];
            if (visited[index]) continue;
            visited[index] = true;
            if (!graph[y + dy[i]][x + dx[i]]) continue;
            dfs(index, m, n);
        }
    }
}