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

        int[] selected = new int[m];
        int depth = 0;

        dfs(selected, depth);
        System.out.println(sb);
    }
    private static void dfs(int[] selected, int depth) {
        if (depth == m) {
            for (int num : selected)
                sb.append(num).append(" ");
            return;
        }
        for (int i = 1; i <= n; i++) {
            selected[depth] = i;
            dfs(selected, depth + 1);
        }
    }
}