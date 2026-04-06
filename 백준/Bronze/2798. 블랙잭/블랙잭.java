import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            // if (cards[i] + 2 > m) 로 아예 말이 안 되는 숫자를 사전 차단하면 효율이 올라갈까?
        }

        // 100 * 99 * 98 < 1000000 이므로 시간 복잡도 충분
        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = cards[i] + cards[j] + cards[k];
                    if (temp <= m && temp > answer) answer = temp;
                }
            }
        }

        System.out.println(answer);
    }
}