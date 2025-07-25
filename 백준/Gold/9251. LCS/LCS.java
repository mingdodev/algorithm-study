import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();
        int lenF = f.length();
        int lenS = s.length();

        int[][] dp = new int[lenF + 1][lenS + 1];
        for (int i = 1; i <= lenF; i++) {
            for (int j = 1; j <= lenS; j++) {
                if (f.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lenF][lenS]);
    }
}