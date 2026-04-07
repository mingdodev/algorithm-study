import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 88 체스판은 두 가지뿐 : 왼쪽 검은색 왼쪽 흰색
        // 브루투포수로밖에 생각이 안 나는데
        // 1. 8*8 체스판 두 개를 만든다.
        // 2. 주어진 판떼기에 겹쳐서 비교한다 -> 43 * 43 * 2 번의 비교 = 4천번도 안 되네??
        // 3. 최솟값 따란

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] targetBoard = new char[n][m];
        for (int i = 0; i < n; i++) {
            targetBoard[i] = br.readLine().toCharArray();
        }

        int min = 64;
        for (int i = 0; i + 7 < n; i++) {
            for (int j = 0; j + 7 < m; j++) {
                int blackBoardCount = 0;
                int whiteBoardCount = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (targetBoard[i + x][j + y] != blackBoard[x][y]) blackBoardCount++;
                        if (targetBoard[i + x][j + y] != whiteBoard[x][y]) whiteBoardCount++;
                    }
                }
                int tempMin = Math.min(blackBoardCount, whiteBoardCount);
                min = Math.min(min, tempMin);
            }
        }
        System.out.println(min);
    }

    static char[][] blackBoard = {
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
    };

    static char[][] whiteBoard = {
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
    };
}