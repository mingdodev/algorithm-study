import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        // 아무리 매번 10을 나눠준대도 팩토리얼만큼 큰 수를 담을 변수를 만들기가 힘들다.
        // 따라서 실제 값으로 문제를 해결하려고 하지 마
        // 들어오는 값을 10으로 나누면 2 * 5를 놓치게 된다
        // 2는 짝수일 때마다 들어오므로, 10을 만드는 것은 5가 들어올 때마다.

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                int temp = i;
                while (temp % 5 == 0) {
                    temp /= 5;
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}