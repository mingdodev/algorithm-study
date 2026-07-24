import java.util.*;

class Solution {
    private static class Location {
        final int x;
        final int y;
        final int distance;
        
        Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Deque<Location> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offerLast(new Location(0, 0, 1));
        
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        while (!queue.isEmpty()) {
            Location location = queue.pollFirst();
            
            if (location.x == m - 1 && location.y == n - 1)
                return location.distance;
            
            for (int i = 0; i < 4; i++) {
                int nextX = location.x + dx[i];
                int nextY = location.y + dy[i];
                
                if (nextX < 0 || nextX >= m
                   || nextY < 0 || nextY >= n)
                    continue;
                
                if (maps[nextY][nextX] == 0 || visited[nextY][nextX])
                    continue;
                
                visited[nextY][nextX] = true;
                queue.offerLast(new Location(nextX, nextY, location.distance + 1));
            }
        }       
        
        return -1;
    }
}