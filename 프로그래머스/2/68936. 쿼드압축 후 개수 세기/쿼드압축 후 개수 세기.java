import java.util.Arrays;

class Solution {
    private int zero = 0;
    private int one = 0;
    
    public int[] solution(int[][] arr) {
        
        quadCompression(arr);

        return new int[] {zero, one};
    }
    
    private void quadCompression(int[][] arr) {
        
        int l = arr.length;
        
        // 1. 압축 (종료)
        boolean isEqualTo = true;
        int value = arr[0][0];
        
        for (int[] a : arr) {
            for (int target : a) {
                if (target != value) {
                    isEqualTo = false;
                    break;
                }
            }
        }
        
        if (isEqualTo) {
            if (value == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        // 2. 쪼개기
        int unit = l / 2;
        int[] dx = { 0, unit , 0, unit };
        int[] dy = { 0, 0, unit, unit };
        
        for (int i = 0; i < 4; i++) {
            int[][] quad = new int[unit][unit];
            int p = 0;
            for (int j = dy[i]; j < dy[i] + unit; j++) {
                quad[p] = Arrays.copyOfRange(arr[j], dx[i], dx[i] + unit);
                p++;
            }
            quadCompression(quad);
        }
    }
}