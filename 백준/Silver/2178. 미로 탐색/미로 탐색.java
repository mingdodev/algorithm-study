import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n * m];
        queue.addLast(0);

        while(!queue.isEmpty()) {
            int temp = queue.pollFirst();
            if (temp == n * m - 1) { // 목적지에 도달 -> 이동거리 중 최소인가?
                System.out.println(graph[temp / m][temp % m]);
                return;
            }
            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            int x = temp % m;
            int y = temp / m;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                int next = ny * m + nx;

                if (visited[next]) continue;
                if (graph[ny][nx] == 0) continue;

                visited[next] = true;
                graph[ny][nx] = graph[y][x] + 1;
                queue.addLast(next);
            }
        }
    }
}