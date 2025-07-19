import java.io.*;
import java.util.*;

public class Main {
    public static class Tomato {
        int x;
        int y;
        int days;

        public Tomato(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];

        Deque<Tomato> ripen = new ArrayDeque<>();

        // 처음부터 다 넣지말고, 익은 것만 넣기
        // BFS는 어떻게 구현하지? 큐?
        // 익은 거 다 넣어두고 사방으로 익지 않은 토마토 체크하기 -> 근데 이러면 일자 계산은 어떻게 하지

        int k;
        int empty = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                k = Integer.parseInt(st.nextToken());
                box[i][j] = k;
                if (k == 1) {
                    ripen.offerLast(new Tomato(i, j, 0));
                }
                if (k == -1) {
                    empty++;
                }
            }
        }

        // 사방 탐색을 위한 방향 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;
        int ripenTomatoes = 0;

        while (!ripen.isEmpty()) {
            Tomato t = ripen.pollFirst();
            result = Math.max(result, t.days); // 리프 노드를 검사할 때 최대 값 저장 가능
            ripenTomatoes++;

            for (int d = 0; d < 4; d++) {
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];

                // 좌표 범위를 벗어나거나, 익지 않은 토마토가 아닐 경우는 스킵
                if (nx < 0 || ny < 0 || ny >= m || nx >= n) continue;
                if (box[nx][ny] != 0) continue;

                box[nx][ny] = 1;
                ripen.offerLast(new Tomato(nx, ny, t.days + 1));
            }
        }

        if (n * m - empty > ripenTomatoes) {
            System.out.println(-1);
        } else {
            // 처음부터 모두 익었을 경우에 0 출력 가능
            System.out.println(result);
        }
    }
}