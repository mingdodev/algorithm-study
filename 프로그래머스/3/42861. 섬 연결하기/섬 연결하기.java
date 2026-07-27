import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        int minCost = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, Comparator.comparingInt(edge -> edge[2]));
        
        int selected = 0;
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            if (union(from, to)) {
                minCost += cost;
                selected++;
                
                if (selected == n - 1) break;
            };
        }
        
        return minCost;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int from, int to) {
        int parentFrom = find(from);
        int parentTo = find(to);
        
        if (parentFrom == parentTo) return false;
        
        parent[parentTo] = parentFrom;
        
        return true;
    }
}