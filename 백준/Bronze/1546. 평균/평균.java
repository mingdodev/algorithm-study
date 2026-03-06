import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[n];
        double max = 0;

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max)
                max = scores[i];
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scores[i] / max * 100;
        }

        double avg = sum / n;

        System.out.println(avg);
    }
}