import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 1000000;
    static boolean[] notPrime = new boolean[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int i, j;

        // 에라토스테네스의 체
        notPrime[0] = notPrime[1] = true;
        for (i = 2; i * i <= MAX; i++) {
            if(notPrime[i]) continue;
            for (j = i * i; j <= MAX; j += i) {
                // i는 소수임, i보다 작은 애들과의 곱은 이미 검토됨. 즉 i * i부터 검토
                notPrime[j] = true;
            }
        }
        for (i = m; i <= n; i++) {
            if (!notPrime[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}