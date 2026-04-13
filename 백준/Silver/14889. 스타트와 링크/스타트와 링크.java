import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int min = 2000; // 두 팀 능력치의 차이
    static boolean[] selectedStart; // true인 경우 start팀. 순회 대상
    static int[][] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selectedStart = new boolean[n];

        ability = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
    private static void dfs(int depth, int count) {
        if (count == n / 2) {
            int startAbility = 0;
            int linkAbility = 0;
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (selectedStart[i]) start.add(i);
                else link.add(i);
            }
            
            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    startAbility += (ability[start.get(i)][start.get(j)] + ability[start.get(j)][start.get(i)]);
                    linkAbility += (ability[link.get(i)][link.get(j)] + ability[link.get(j)][link.get(i)]);
                }
            }

            min = Math.min(Math.abs(startAbility - linkAbility), min);
            return;
        }

        for (int i = depth; i < n; i++) {
            selectedStart[i] = true; // 선택
            dfs(i + 1, count + 1); // 그 다음 사람을 탐색
            selectedStart[i] = false;
        }
    }
}