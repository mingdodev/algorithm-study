import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> box = new HashMap<>();
        for (int t: tangerine) {
            Integer temp = box.get(t);
            if (temp == null) box.put(t, 1);
            else box.put(t, temp + 1);
        }
        Map<Integer, Integer> sortedBox = box.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new));
        
        int answer = 0;
        Iterator<Integer> it = sortedBox.keySet().iterator();
        while(it.hasNext() && k > 0) {
            int key = it.next();
            int value = sortedBox.get(key);
            answer++;
            if (k >= value) k -= value;
            else k = 0;
        }
    
        return answer;
    }
}