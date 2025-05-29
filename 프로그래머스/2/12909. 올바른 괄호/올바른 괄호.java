import java.util.*; 
import java.io.*; 

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArr = s.toCharArray();
        
        // 짝이 알맞은 경우: 모든 배열 순회 후 스택이 비어 있음
        // (가 더 많은 경우: 모든 배열 순회 후 스택이 비어 있지 않음
        // )가 더 많은 경우: 배열 순회 중 스택이 비어 있는 상태에서 pop 시도
        for(char c : charArr) {
            if (c == '(') stack.push(1);
            if (stack.isEmpty() && c == ')') return false;
            if (!stack.isEmpty() && c == ')') stack.pop();
        }
        
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}