import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }

        int max = count;
        for (int i = k; i < n; i++) {
            count = count + nums[i] - nums[i - k];
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}