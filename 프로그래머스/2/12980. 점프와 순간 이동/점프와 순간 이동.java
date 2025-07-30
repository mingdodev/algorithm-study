import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        // 최대한 순간이동을 많이해야 함
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}