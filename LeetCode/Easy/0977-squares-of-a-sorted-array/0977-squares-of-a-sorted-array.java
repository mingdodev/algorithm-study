class Solution {
    public int[] sortedSquares(int[] nums) {
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        // O(nlogn)
        Arrays.sort(nums);
        
        return nums;
        
        // O(n)이 어떻게 가능?
    }
}