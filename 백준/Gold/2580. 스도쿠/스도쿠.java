import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] raw = new boolean[9][10];
    static boolean[][] column = new boolean[9][10];
    static boolean[][] miniBoard = new boolean[9][10];
    static int blank = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
                if (temp == 0)
                    blank++;
                else {
                    raw[i][temp] = true;
                    column[j][temp] = true;
                    miniBoard[(i / 3) * 3 + j / 3][temp] = true;
                }
            }
        }

        // 0인 부분에 가능한 경우의 수를 채워나가며 판단한다.
        // 가능한지 판단은 다음 두 가지 기준
        // 1. board[i][x]에 없는 수 (0인가?)
        // 2. board[y][i]에 없는 수 (0인가?)
        // 3. 부분 정사각형에 없는 수 (false인가?)
        // 9*3번의 비교 연산, 최대 27*81이므로 ㄱㅊ

        dfs(0, 0);

    }
    private static void dfs(int x, int y) {
        if (blank == 0) { // 정답을 찾았으면 탐색 종료
            printBoard();
            return;
        }

        if (board[y][x] != 0) { // 빈칸이 아니면 다음 칸으로 이동
            move(x, y);
            return;
        }

        // 빈칸이라면 알맞은 숫자 채우기
        for (int t = 1; t <= 9; t++) {
            if (raw[y][t] == true || column[x][t] == true || miniBoard[(y / 3) * 3 + x / 3][t] == true) continue;
            board[y][x] = t;
            raw[y][t] = true;
            column[x][t] = true;
            miniBoard[(y / 3) * 3 + x / 3][t] = true;
            blank--;
            move(x, y);
            if (blank == 0) break;
            board[y][x] = 0;
            raw[y][t] = false;
            column[x][t] = false;
            miniBoard[(y / 3) * 3 + x / 3][t] = false;
            blank++;
        }
    }

    private static void move(int x, int y) {
        if (x == 8)
            dfs(0, y + 1);
        else
            dfs(x + 1, y);
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