import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1000만 * 2개의 배열을 만들어서 개수를 저장하는 방법 -> 메모리 제한에 걸릴까? 비효율적인 것 같기도 하다. 시간복잡도는 낮음
        // 하지만 하나하나 판단하려면 50만 * 50만 = 250000000000 말도 안 되는 연산 횟수
        // 일단 1번으로 해봐

        int n = Integer.parseInt(br.readLine());
        int[] minusCards = new int[10000001];
        int[] plusCards = new int[10000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) plusCards[temp]++;
            else minusCards[-temp]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i ++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp >= 0) sb.append(plusCards[temp]).append(" ");
            else sb.append(minusCards[-temp]).append(" ");
        }

        System.out.println(sb);
    }
}