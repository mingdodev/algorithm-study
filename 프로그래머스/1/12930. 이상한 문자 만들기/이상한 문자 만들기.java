class Solution {
    public String solution(String s) {
        String answer = "";
        // 1. char 배열로 변환
        // 2. 인덱스를 0으로 초기화
        // 3. 하나씩 순회
            // 알파벳이고 인덱스가 짝수면 toUpperCase
            // 알파벳이고 인덱스가 홀수면
            // 알파벳이 아니면 인덱스 0으로 초기화
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(" ");
                index = 0;
                continue;
            }
            
            if (index % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            
            index++;
        }
        return sb.toString();
    }
}