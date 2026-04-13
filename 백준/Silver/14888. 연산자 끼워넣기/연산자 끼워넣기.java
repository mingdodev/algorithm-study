import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] selectedOperators; // // 0:+ 1:- 2:x 3:/
    static int[] operators = new int[4]; // 0:+ 1:- 2:x 3:/ 의 개수. 탐색 대상
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selectedOperators = new int[n - 1];

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Arrays.fill(operators, -1); // 미선택은 -1로 표기
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs(int depth) {
        if (depth == n - 1) {
            int sum = calculateSum();
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == 0) continue;
            selectedOperators[depth] = i;
            operators[i]--;
            dfs(depth + 1);
            selectedOperators[depth] = -1;
            operators[i]++;
        }
    }
    private static int calculateSum() {
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            switch (selectedOperators[i]) {
                case 0:
                    temp += nums[i + 1];
                    break;
                case 1:
                    temp -= nums[i + 1];
                    break;
                case 2:
                    temp *= nums[i + 1];
                    break;
                case 3:
                    temp /= nums[i + 1];
            }
        }
        return temp;
    }
}