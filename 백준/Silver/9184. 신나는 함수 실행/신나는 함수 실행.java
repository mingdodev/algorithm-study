import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // -50 ≤ a, b, c ≤ 50 -> + 50 -> 0 <= a, b, c <= 100
        int[][][] dp = new int[101][101][101];
        StringBuilder sb = new StringBuilder();
        while (!(a == -1 && b == -1 && c == -1)) {
            int n = w(a, b, c, dp);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(n).append('\n');

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    public static int w(int a, int b, int c, int[][][] dp) {
        if (dp[a + 50][b + 50][c + 50] != 0) return dp[a + 50][b + 50][c + 50];
        else {
            if (a <= 0 || b <= 0 || c <= 0) {
                dp[a + 50][b + 50][c + 50] = 1;
                return 1;
            }
            if (a > 20 || b > 20 || c > 20) {
                return dp[a + 50][b + 50][c + 50] = w(20, 20, 20, dp);
            }
            if (a < b && b < c) {
                return dp[a + 50][b + 50][c + 50] = w(a, b, c-1, dp) + w(a, b-1, c-1, dp) - w(a, b-1, c, dp);
            }
            return dp[a + 50][b + 50][c + 50] = w(a-1, b, c, dp) + w(a-1, b-1, c, dp) + w(a-1, b, c-1, dp) - w(a-1, b-1, c-1, dp);
        }
    }
}