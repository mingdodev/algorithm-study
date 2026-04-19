import java.io.*;
import java.util.*;

public class Main {
    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        List<Tomato> start = new ArrayList<>();
        // bfs를 하는데, 시작점이 여러 개.
        // 1일차 - 익은 토마토 입력 받은 거 -> 토마토의 개수가 m * n 개인가?
        // 2일차 - bfs 1단계
        // 스택이 비었을 때 -> 토마토 개수가 m * n 개보다 작으면 -1

        // 좌표 표현 필요, 시작점만 따로 저장하기
        int all = m * n;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int box = Integer.parseInt(st.nextToken());
                graph[i][j] = box;
                if (box == 1) start.add(new Tomato(j, i));
                if (box == -1) all--;
            }
        }

        int count = start.size();
        if (count == all) {
            System.out.println(0);
            return;
        }
        Deque<Tomato> queue = new ArrayDeque<>();
        for (Tomato t : start) {
            queue.addLast(t);
        }
        while (!queue.isEmpty()) {
            Tomato temp = queue.pollFirst();

            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (graph[ny][nx] == 0) {
                    queue.addLast(new Tomato(nx, ny));
                    graph[ny][nx] = graph[temp.y][temp.x] + 1;
                    count++;
                    if (count == all) {
                        System.out.println(graph[ny][nx] - 1);
                        return;
                    }
                }
            }
        }
        if (count < all) {
            System.out.println(-1);
        }
    }
}