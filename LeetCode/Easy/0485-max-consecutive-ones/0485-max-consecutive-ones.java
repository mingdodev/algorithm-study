class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int result = 0;
        
        for (int n : nums) {
            if (n == 0) {
                temp = 0;
            } else {
                temp += 1;
                if (temp > result) {
                    result = temp;
                }
            }
        }
        
        return result;
    }
}