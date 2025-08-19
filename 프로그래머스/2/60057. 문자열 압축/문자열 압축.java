class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
        // 2로 잘랐을 때 ~ length로 잘랐을 때 중 총 길이가 가장 짧은 경우
        // 1000의 길이면 완전 탐색해도 100만 -> 일단 해봐
        
        for (int i = 1; i < s.length(); i++) {
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            String token = s.substring(0, i);
            int cnt = 1;
             for (int j = i; j <= len - i; j += i) {
                 if (token.equals(s.substring(j, j + i)))
                     cnt++;
                 else {
                     if (cnt == 1)
                         sb.append(token);
                     else
                         sb.append(cnt + token);
                     
                     token = s.substring(j, j + i);
                     cnt = 1;
                 }
             }
            
            if (cnt == 1)
                sb.append(token);
            else
                sb.append(cnt + token);
            if (len % i != 0)
                sb.append(s.substring(len - len % i, s.length()));
                      
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}