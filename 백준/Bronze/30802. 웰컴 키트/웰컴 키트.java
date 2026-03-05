import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] shirtsPerSize = new int[6];
        for (int i = 0; i < 6; i++) {
            shirtsPerSize[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int totalShirtBundles = 0;
        for (int shirts : shirtsPerSize) {
            totalShirtBundles += shirts / t;
            if (shirts % t != 0) totalShirtBundles++;
        }

        int penBundles = n / p;
        int singlePens = n % p;

        System.out.println(totalShirtBundles);
        System.out.println(penBundles + " " + singlePens);
    }
}