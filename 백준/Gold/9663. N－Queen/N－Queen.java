import java.io.*;
import java.util.*;

public class Main {
    private static int result = 0;
    private static int n;

    private static boolean[] col;
    private static boolean[] rightDiag;
    private static boolean[] leftDiag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        rightDiag = new boolean[n * 2 - 1];
        leftDiag = new boolean[n * 2 - 1];

        dfs(0);
        System.out.println(result);
    }
    private static void dfs(int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || rightDiag[row + i] || leftDiag[row - i + n - 1]) { // 음수를 양수 범위로
                continue;
            }
            col[i] = true;
            rightDiag[row + i] = true;
            leftDiag[row - i + n - 1] = true;
            dfs(row + 1);
            col[i] = false;
            rightDiag[row + i] = false;
            leftDiag[row - i + n - 1] = false;
        }
    }
}