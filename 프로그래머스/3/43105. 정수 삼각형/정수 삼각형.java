import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // dp[row][col] = 여기서 시작했을 때 가장 최댓값
        int h = triangle.length;
        int[][] dp = new int[h][h];

        for (int col = 0; col < h; col++) {
            dp[h - 1][col] = triangle[h - 1][col];
        }
        
        int weight = h;
        for (int row = h - 2; row >= 0; row--) {
            weight--;
            for (int col = 0; col < weight; col++) {
                dp[row][col] = triangle[row][col]
                    + Math.max(dp[row + 1][col], dp[row + 1][col + 1]);
            }
        }
        
        return dp[0][0];
    }
}