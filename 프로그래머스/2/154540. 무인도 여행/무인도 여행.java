import java.util.*;

class Solution {
    public int rows;
    public int columns;
    
    public int[] solution(String[] maps) {
        this.rows = maps.length;
        this.columns = maps[0].length();
        // 좌표: (rows * i + j)
        boolean[] visited = new boolean[rows * columns];
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[columns * i + j] && maps[i].charAt(j) != 'X') {
                    answerList.add(dfs(i, j, maps, visited));
                }    
            }
        }
        
        if (answerList.isEmpty()) {
            int[] result = { -1 };
            return result;
        } else {
            Collections.sort(answerList);
            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    
    public int dfs(int i, int j, String[] maps, boolean[] visited) {
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int index = columns * i + j;
        visited[index] = true;
        int result = Character.getNumericValue(maps[i].charAt(j));
            
        for (int x = 0; x < 4; x++) {
            if (i + di[x] < 0 || rows <= i + di[x] ||
                j + dj[x] < 0 || columns <= j + dj[x]) continue;
            int searchIndex = columns * (i + di[x]) + j + dj[x];
            if (!visited[searchIndex] && maps[i + di[x]].charAt(j + dj[x]) != 'X') {
                visited[searchIndex] = true;
                result += dfs(i + di[x], j + dj[x], maps, visited);
            }
        }
        
        return result;
    }
}