/**
 * BOJ
 */

import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static boolean[] visited;
    private static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[n * n];
        int sum = 0;
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (graph[i / n][i % n] == 0) continue;
            counts.add(dfs(i));
            sum++;
        }

        System.out.println(sum);
        StringBuilder sb = new StringBuilder();
        Collections.sort(counts);
        for (int count : counts) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);

        // 집이 있는지는 모든 위치에 대해 탐색을 수행해야 함
        // visited[], index 필요
        // 집이 있는 위치 발견 -> dfs
        // 리프 노드에서 return 1 -> 순환한 가지들의 반환 값 전부 더해서 루트가 갖고 있어야 함. 저장은 List에 해야겠다
    }
    private static int dfs(int root) {
        // 갈 수 있는 곳
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int x = root % n;
        int y = root / n;

        int temp = 1; // 자기 자신
        for (int i = 0; i < 4; i++) {
            if (y + dy[i] < 0 || y + dy[i] >= n || x + dx[i] < 0 || x + dx[i] >= n) continue;
            int index = (y + dy[i]) * n + (x + dx[i]);
            if (visited[index]) continue;
            visited[index] = true;
            if (graph[y + dy[i]][x + dx[i]] == 0) continue;
            temp += dfs(index);
        }
        return temp;
    }
}