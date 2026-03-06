import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrimeNumber(int n) {
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(Integer.parseInt(st.nextToken()))) count++;
        }

        System.out.println(count);
    }
}