import java.io.*;
import java.util.*;

public class Main {
    public static int[] storedSum;
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        storedSum = new int[n + 1];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            storedSum[i + 1] = sum;
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(storedSum[j] - storedSum[i - 1]).append('\n');
        }
        System.out.println(sb);
    }
}