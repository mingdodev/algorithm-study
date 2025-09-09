import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(stringNumbers, (a, b) -> { return (b + a).compareTo(a + b); });
        StringBuilder sb = new StringBuilder("");
        for (String s : stringNumbers) {
            sb.append(s);
        }
        String result = sb.toString();
        if (result.charAt(0) == '0') return "0";
        return result;
    }
}