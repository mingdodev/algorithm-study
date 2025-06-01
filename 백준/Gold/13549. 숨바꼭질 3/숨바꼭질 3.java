import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100_001;
    static int[] time = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 가장 빠른 시간이므로 BFS. 탐색하면서 K 발견하면 그게 최단 시간 (과연?)
        // 시간은 따로 기록해야 함. 1초 후일 수도, 0초 후일 수도 있기 때문에
        // N에서 1초 후가 되는 경우와 0초 후가 되는 경우의 위치를 계산

        Arrays.fill(time, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        time[N] = 0;
        queue.add(N);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                System.out.println(time[cur]);
                return;
            }

            // 순간이동 (0초)
            int next = cur * 2;
            if (next < MAX && time[next] == -1) {
                time[next] = time[cur];
                queue.addFirst(next);
            }

            // 걷기 -1
            next = cur - 1;
            if (next >= 0 && time[next] == -1) {
                time[next] = time[cur] + 1;
                queue.addLast(next);
            }

            // 걷기 +1
            next = cur + 1;
            if (next < MAX && time[next] == -1) {
                time[next] = time[cur] + 1;
                queue.addLast(next);
            }
        }
    }
}