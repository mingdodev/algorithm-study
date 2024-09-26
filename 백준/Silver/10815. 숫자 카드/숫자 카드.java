import java.util.*;
import java.io.*;

public class Main {
    public static boolean isExist(int n, int[] arr, int e) {
        boolean found = false;
        int s = 0, p;

        while (!found && s<=e) {
            p = (s+e) / 2;
            if (arr[p] == n) found = true;
            if (arr[p] > n) e = p-1;
            if (arr[p] < n) s = p+1;
        }

        return found;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] origin = new int[N];

        for(int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(origin);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringJoiner sj = new StringJoiner(" ");

        for(int i = 0; i < M; i++) {
            if (isExist(Integer.parseInt(st.nextToken()), origin, N-1))
                sj.add("1");
            else
                sj.add("0");
        }

        System.out.println(sj);
    }
}