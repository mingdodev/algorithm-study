import java.io.*;
import java.util.*;

public class Main {

    public static class Wire {
        int a;
        int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Wire> wires = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires.add(new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        wires.sort((x, y) -> x.a - y.a);
        int[] b = wires.stream().mapToInt(wire -> wire.b).toArray();

        // 삽질 결과 최장 증가 수열임, A 위치는 이제 필요없음. B 위치로 최장 증가 수열 구하기
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (b[j] < b[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // i로 끝나는 수열 중 최대 길이를 찾기 위해, 이전 인덱스들의 dp값 중 최대인 걸 탐색하는 것
                }
            }
        }

        System.out.println(n - Arrays.stream(dp).max().getAsInt());
    }
}