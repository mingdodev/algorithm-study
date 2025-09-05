import java.util.List;
import java.util.ArrayList;

class Solution {
    
    private int first(int[] answers) {
        int result = 0;
        int[] pattern = { 1, 2, 3, 4, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % 5]) result++;
        }
        return result;
    }
    
    private int second(int[] answers) {
        int result = 0;
        int[] pattern = { 2, 1, 2, 3, 2, 4, 2, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % 8]) result++;
        }
        return result;
    }
    
    private int third(int[] answers) {
        int result = 0;
        int[] pattern = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % 10]) result++;
        }
        return result;
    }
    
    public int[] solution(int[] answers) {
        int[] results = { first(answers), second(answers), third(answers) };
        
        int max = results[0];
        for (int i = 1; i < 3; i++) {
            if (max < results[i]) max = results[i];
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == results[i]) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}