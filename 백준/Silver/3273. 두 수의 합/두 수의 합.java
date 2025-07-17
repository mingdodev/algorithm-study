import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        boolean[] exists = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            numbers[i] = temp;
            exists[temp] = true;
        }

        int x = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i : numbers) {
            if (x - i >= 1 && x - i <= 1000000 && exists[x - i]) {
                result++;
            }
        }
        System.out.println(result/2);
    }
}