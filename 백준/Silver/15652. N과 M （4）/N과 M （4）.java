import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 비내림차순 1 2 2 3 4

        int[] selected = new int[m];
        int depth = 0;
        int start = 1;

        dfs(selected, depth, start);
        System.out.println(sb);
    }
    private static void dfs(int[] selected, int depth, int start) {
        if (depth == m) {
            for (int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            // 여기서, 다음에 고를 수는 이전 수보다 같거나 커야 비내림차순이 된다.
            dfs(selected, depth + 1, i);
        }
    }
}