import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> results = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                results.add(numbers[i] + numbers[j]);
            }
        }
        
        return results.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}