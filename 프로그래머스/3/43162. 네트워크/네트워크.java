import java.util.*;

class Solution {
    private boolean[] visited;
    private List<List<Integer>> graph = new ArrayList<> ();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
               if (i != j && computers[i][j] == 1)
                   graph.get(i).add(j);
            } 
        }
            
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    private void dfs(int i) {
        visited[i] = true;
        for (int j : graph.get(i)) {
            if (!visited[j]) dfs(j);
        }
    }
}