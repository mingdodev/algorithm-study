import java.util.Comparator;

class Solution {
    public String solution(String s) {
        
        return s.chars()
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(StringBuilder::new,
                     StringBuilder::appendCodePoint,
                     StringBuilder::append)
            .toString();
    }
}