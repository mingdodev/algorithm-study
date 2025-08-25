class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int cCnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                pCnt++;
            }
            if (c == 'y' || c == 'Y') {
                cCnt++;
            }
        }
        
        if (pCnt == 0 && cCnt == 0)
            return true;
        
        if (pCnt != cCnt)
            return false;

        return true;
    }
}