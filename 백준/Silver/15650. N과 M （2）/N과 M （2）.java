import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] array, int depth, int start) {
        if (depth == m) {
            for (int i : array) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int size = array.length;

        for (int i = start; i <= n; i++) {
            array[depth] = i;
            dfs(array, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] array = new int[m];

        dfs(array, 0, 1);

        System.out.print(sb);
    }
}