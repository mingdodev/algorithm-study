import java.util.*;

class Solution {
    private int minCost = 0;
    private int[] parent;
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private void union(int from, int to, int cost) {
        int rootFrom = find(from);
        int rootTo = find(to);
        
        if (rootFrom == rootTo) return;
        
        parent[rootTo] = rootFrom;
        minCost += cost;
    }
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int currentCost = cost[2];
            
            union(from, to, currentCost);
        }
        
        return minCost;
    }
}