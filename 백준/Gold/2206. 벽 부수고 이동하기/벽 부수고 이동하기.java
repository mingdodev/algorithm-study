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

        Deque<int[]> queue = new ArrayDeque<>();
        int[][][] visited = new int[n][m][2]; // y, x, crashed
        queue.addLast(new int[]{0, 0, 0}); // y, x, crashed
        visited[0][0][0] = 1; // 벽을 부수고 이동한 거리와 벽을 부수지 않고 이동한 거리는 서로 다른 상태로 관리되어야 한다.

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            int x = temp[1];
            int y = temp[0];
            int crashed = temp[2]; // 1은 부숨, 0은 안 부숨
            if (x == m - 1 && y == n - 1) {
                System.out.println(visited[y][x][crashed]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (graph[ny][nx] == 0 && visited[ny][nx][crashed] == 0) {
                    queue.addLast(new int[]{ny, nx, crashed});
                    visited[ny][nx][crashed] = visited[y][x][crashed] + 1;
                }
                if (graph[ny][nx] == 1 & crashed == 0 && visited[ny][nx][1] == 0) { // 이미 벽을 부순 상태로 해당 위치에 더 빠르게 도착한 적이 있나?
                    queue.addLast(new int[]{ny, nx, 1});
                    visited[ny][nx][1] = visited[y][x][crashed] + 1;
                }
            }
        }
        System.out.println(-1);
    }
}