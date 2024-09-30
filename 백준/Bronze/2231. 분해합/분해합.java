import java.io.*;

public class Main {
    public static int sum(int n) {
        // 문자로 변환하면 시간이 훨씬 오래 걸림
        // 되도록 숫자로 처리할 것
        // 각 자리수의 합을 가장 효율적으로 구하는 방법! 난 완전 복잡하게 함
        
        int t = n;
        int s = 0;

        while(t != 0) {
            s += t % 10;
            t /= 10;
        }

        return s;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = 0;
        
        // 브루트포스

        for (int i = 0; i < N; i++) {
            if (N == i + sum(i)) {
                M = i;
                break;
            }
        }

        System.out.println(M);
    }
}