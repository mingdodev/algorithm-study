class Solution {
    public int solution(String s) {
        // 첫 번째 생각한 풀이: 단 한 번의 탐색 O(N)
        // 현재 풀이: O(N) * M (M >= 10)
        // s = s.replace("zero", "0");
        // s = s.replace("one", "1");
        // s = s.replace("two", "2");
        // s = s.replace("three", "3");
        // s = s.replace("four", "4");
        // s = s.replace("five", "5");
        // s = s.replace("six", "6");
        // s = s.replace("seven", "7");
        // s = s.replace("eight", "8");
        // s = s.replace("nine", "9");
        
        // 리팩토링
        String[] numbers = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        
        for (int i = 0; i < numbers.length; i++) {
            s = s.replace(numbers[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}