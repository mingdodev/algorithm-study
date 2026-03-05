import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstElement = Integer.parseInt(st.nextToken());
        int max = firstElement;
        int min = firstElement;

        for (int i = 1; i < n; i++) {
            int tempElement = Integer.parseInt(st.nextToken());
            if (max < tempElement) {
                max = tempElement;
                continue;
            }
            if (min > tempElement) {
                min = tempElement;
            }
        }

        System.out.println(min + " " + max);
    }
}