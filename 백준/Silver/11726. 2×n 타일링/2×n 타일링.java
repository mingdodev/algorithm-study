import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tiling = new int[n + 1];
        tiling[0] = 1;
        tiling[1] = 1;

        for (int i = 2; i <= n; i++) {
            tiling[i] = (tiling[i - 1] + tiling[i - 2]) % 10007;
        }

        System.out.println(tiling[n]);
    }
}