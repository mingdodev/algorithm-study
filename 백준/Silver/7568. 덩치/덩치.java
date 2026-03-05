import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean isBiggerThan(int[] info1, int[] info2) {
        return info1[0] > info2[0] && info1[1] > info2[1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] infos = new int[n][2];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            infos[i][0] = Integer.parseInt(st.nextToken());
            infos[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (isBiggerThan(infos[i], infos[j]))
                        rank[j]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rank) {
            sb.append(r).append(' ');
        }
        System.out.println(sb);
    }
}