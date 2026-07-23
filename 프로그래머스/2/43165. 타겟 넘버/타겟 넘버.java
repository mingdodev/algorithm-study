class Solution {
    private int[] numbers;
    private int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        return dfs(0, 0);
    }
    private int dfs(int i, int sum) {
        if (i == numbers.length) {
            if (sum == target) return 1;
            return 0;
        }
        return dfs(i + 1, sum - numbers[i]) + dfs(i + 1, sum + numbers[i]);
    }
}