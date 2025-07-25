import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[m + 1][n + 1];
            sb.append(comb(m, n, dp)).append('\n');
        }
        System.out.println(sb);
    }

    public static int comb(int m, int n, int[][] dp) {
        // m개 중에 n개를 택하는 경우의 수
        // m-1개 중에 n-1개를 택하는 경우의 수 + m-1개 중에 n개를 택하는 경우의 수
        // 궁금한 게 무한 루프가 발생하지 않아? -> 문제 조건에 n <= m 조건이 있기 때문에 괜찮은 것
        if (n == m || n == 0) {
            dp[m][n] = 1;
            return dp[m][n];
        }
        else {
            if (dp[m][n] != 0) return dp[m][n];
            dp[m][n] = comb(m - 1, n - 1, dp) + comb(m - 1, n, dp);
            return dp[m][n];
        }
    }
}