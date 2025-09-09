import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> stringList = new ArrayList<>();
        stringList = Arrays.stream(strings).collect(Collectors.toList());
        
        stringList.sort((a, b) -> {
            if (a.charAt(n) == b.charAt(n)) return a.compareTo(b);
            return a.charAt(n) - b.charAt(n);
        });
            
        return stringList.toArray(String[]::new);
    }
}