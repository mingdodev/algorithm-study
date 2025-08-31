import java.util.Arrays;

class Solution {
    private int zero = 0;
    private int one = 0;
    
    public int[] solution(int[][] arr) {
        // [영역 압축]
        // - 종료 조건: 해당 영역의 원소 개수가 1개 -> 그 원소를 리턴
        // - 다음 상태: 영역의 원소들이 모두 같은 0/1이라면 하나로 압축
        //            하나라도 다르다면, 원소수/4 의 크기로 쪼갠다. -> 영역 압축 다시 진행
        
        quadCompression(arr);

        return new int[] {zero, one};
    }
    private void quadCompression(int[][] arr) {
        int l = arr.length;
        if (l == 1) { // 정사각형 배열이므로, 배열 전체의 길이와 각 배열의 길이 같음
            if (arr[0][0] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        // 1. 압축
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
            if (arr[0][0] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        // 2. 쪼개기
        // (0~l/2, 0~l/2) (l/2~l, 0~l/2)
        // (0~l/2, l/2~l) (l/2~l, l/2~l)
        int n = l / 2;
        int[] dx = { 0, n , 0, n };
        int[] dy = { 0, 0, n, n };
        
        for (int i = 0; i < 4; i++) {
            int[][] quad = new int[n][n];
            int p = 0;
            for (int j = dy[i]; j < dy[i] + n; j++) {
                quad[p] = Arrays.copyOfRange(arr[j], dx[i], dx[i] + n);
                p++;
            }
            quadCompression(quad);
        }
    }
}