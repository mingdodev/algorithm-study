class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        
        for (int n : nums) {
            int l = String.valueOf(n).length();
            
            if (l % 2 == 0) {
                result += 1;
            }
        }
        
        return result;
    }
}