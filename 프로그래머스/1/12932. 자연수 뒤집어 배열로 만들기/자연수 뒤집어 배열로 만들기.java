class Solution {
    public int[] solution(long n) {
        // 1. 자연수를 문자로 다룰 수 있도록 변환
        // 2. 순서 뒤집기
        // 3. 다시 정수 배열로 변환
        char[] numbers = String.valueOf(n).toCharArray();
        int length = numbers.length;
        System.out.println(length);
        int[] answer = new int[length];
        
        for (int i = length - 1; i >= 0; i--) {
            answer[length - 1 - i] = numbers[i] - '0';
        }
        
        return answer;
    }
}