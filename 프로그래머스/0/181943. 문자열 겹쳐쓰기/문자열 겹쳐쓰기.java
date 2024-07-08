class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        char[] my = my_string.toCharArray();
        char[] ow = overwrite_string.toCharArray();
        int l = my.length;
        int m = ow.length;
        
        for (int i = 0; i < s; i++) {
            answer += my[i];
        }
        
        for (char c: ow) {
            answer += c;
        }
        
        for (int i = m + s; i < l; i++) {
            answer += my[i];
        }
        
        return answer;
    }
}