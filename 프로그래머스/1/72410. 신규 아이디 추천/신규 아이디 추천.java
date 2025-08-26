class Solution {
    
    public String solution(String new_id) {
        // 1. 입력 아이디가 규칙에 맞는지 검사
        if (new_id.matches("[a-z0-9\\.\\_\\-]{3,15}")
            && new_id.matches("^[^\\.]")
            && new_id.matches("[^\\.]&")
            && !new_id.matches(".\\.{2,}.")
           ) return new_id;
        
        // 2. 소문자 치환 및 잘못된 문자 제거
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>/]", "");
 
        // 3. ..을 .로 치환, .가 처음과 끝이면 제거
        new_id = new_id.replaceAll("\\.{2,}", "\\.");
        if (!new_id.isBlank()) {
            new_id = new_id.charAt(0) == '.'
                    ? new_id.substring(1, new_id.length())
                    : new_id;
        }
        if (!new_id.isBlank()) {
            new_id = new_id.charAt(new_id.length() - 1) == '.'
                    ? new_id.substring(0, new_id.length() - 1)
                    : new_id;
        }
                                
        // 4-1. 빈 문자열인 경우 "aaa" 반환
        int length = new_id.length();
        if (length == 0)
            return "aaa";
        
        // 4-2. 빈 문자열이 아닌 경우, 16자 이상이면 15개로 자르기 + 마지막 . 제거
        //                        2자 이하이면 마지막 문자로 길이 3으로 늘리기
        if (length >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.charAt(new_id.length() - 1) == '.'
                    ? new_id.substring(0, new_id.length() - 1)
                    : new_id;
        }
        
        if (length <= 2) {
            StringBuilder sb = new StringBuilder();
            char lastChar = new_id.charAt(length - 1);
            sb.append(new_id.substring(0, length - 1));
            while (sb.length() < 3) {
                sb.append(lastChar);
            }
            
            return sb.toString();
        }

        return new_id;
    }
}