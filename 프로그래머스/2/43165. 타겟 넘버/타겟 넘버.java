class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(-numbers[0], numbers, target, 0, 0)
            + dfs(numbers[0], numbers, target, 0, 0);
    }
    private int dfs(int sum, int[] numbers, int target, int i, int answer) {
        if (i == numbers.length - 1) {
            if (sum == target) return 1;
            return 0;
        }
        
        return dfs(sum - numbers[i + 1], numbers, target, i + 1, answer)
            + dfs(sum + numbers[i + 1], numbers, target, i + 1, answer);
    }
}