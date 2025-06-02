import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // ArrayList는 회의 개수가 유동적일 때 쓰기.
        int[][] meetings = new int[N][2];

        for (int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 두 번째 값 (끝나는 시각) 기준 오름차순 정렬
        // 근데!! 끝나는 시각이 같으면, 시작하는 시각이 더 빠른 게 앞에 와야 오류가 없다.
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // 다음으로 시작할 수 있는 회의 중 가장 빨리 끝나는 회의를 선택하는 것이 유리하다.
        int ans = 0;
        int t = 0;

        for (int i = 0; i < N; i++) {
            if (t <= meetings[i][0]) {
                t = meetings[i][1];
                ans++;
            }
        }

        System.out.println(ans);
    }
}