import java.io.*;
import java.util.*;

public class Main {
    public static int result = 0;
    public static void subSet(int N, int S, int[] arr, boolean[] visited, int idx, int temp) {
        if (idx == N) {
            return;
        }

        visited[idx] = false;
        subSet(N, S, arr, visited, idx + 1, temp);

        visited[idx] = true;
        temp += arr[idx];
        if (temp == S) result++;
        subSet(N, S, arr, visited, idx + 1, temp);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());

        int[] nums = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }

        // 부분수열은 부분집합이라고 합니다
        // dfs
        // 매 노드마다 체크해야 함
        boolean[] visited = new boolean[N];
        subSet(N, S, nums, visited, 0, 0);

        System.out.println(result);
    }
}