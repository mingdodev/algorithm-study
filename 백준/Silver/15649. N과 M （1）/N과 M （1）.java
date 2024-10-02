import java.io.*;
import java.util.*;

public class Main {
    public static void dfs(int N, int M, int temp, boolean[] visited, StringBuilder sb) {
        if (temp == M) {
            System.out.println(sb);
            return;
        }

        // 백트래킹
        // 선택하여 만드는 수열 -> 조합이 아니라 "순열"
        for (int i = 0; i < N; i++) {
            // 선택한 숫자는 넘어감 (중복하여 선택할 수 없음)
            if (!visited[i]) { // 해당 수를 선택하지 않음
                visited[i] = true;
                sb.append(String.valueOf(i+1)).append(" ");
                dfs(N, M, temp + 1, visited, sb);
                // 백트래킹 상태 복구
                visited[i] = false;
                sb.setLength(sb.length() - 2);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        StringBuilder sb = new StringBuilder();

        dfs(N, M, 0, visited, sb);
    }
}