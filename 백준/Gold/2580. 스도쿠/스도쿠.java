import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] raw = new boolean[9][10];
    static boolean[][] column = new boolean[9][10];
    static boolean[][] miniBoard = new boolean[9][10];
    static List<int[]> blanks = new ArrayList<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
                if (temp == 0)
                    blanks.add(new int[] {i, j});
                else {
                    raw[i][temp] = true;
                    column[j][temp] = true;
                    miniBoard[(i / 3) * 3 + j / 3][temp] = true;
                }
            }
        }

        dfs(0);

    }
    private static boolean dfs(int idx) {
        if (idx == blanks.size()) { // 정답을 찾았으면 탐색 종료
            printBoard();
            return true;
        }
        int x = blanks.get(idx)[1];
        int y = blanks.get(idx)[0];

        // 빈칸이라면 알맞은 숫자 채우기
        for (int t = 1; t <= 9; t++) {
            if (raw[y][t] == true || column[x][t] == true || miniBoard[(y / 3) * 3 + x / 3][t] == true) continue;
            board[y][x] = t;
            raw[y][t] = true;
            column[x][t] = true;
            miniBoard[(y / 3) * 3 + x / 3][t] = true;
            if (dfs(idx + 1)) return true;
            else {
                board[y][x] = 0;
                raw[y][t] = false;
                column[x][t] = false;
                miniBoard[(y / 3) * 3 + x / 3][t] = false;
            }
        }
        return false;
    }
    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}