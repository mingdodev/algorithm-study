import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] solution(int n) {
        // 1. 상태: (n, from, to)
        // 2. 종료 조건: (1, from, to)
        // 3. 다음 기둥: (n - 1, from, 6 - from - to)
        //           + (1, from, to)
        //           + (n - 1, 6 - from - to, to)
        List<int[]> answer = new ArrayList<>();
        hanoi(n, 1, 3, answer);
        
        return answer.toArray(int[][]::new);
    }
    
    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }
        
        int empty = 6 - from - to;
        
        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}