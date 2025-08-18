import java.util.*;

class Solution {
    private static class Point {
        public final long x, y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Point)
                return x == ((Point) o).x && y == ((Point) o).y;
            return false;
        }
    }
    
    public String[] solution(int[][] line) {
        // 1. 별의 교점 목록 찾기
        // - line끼리 비교하면서 교점이 생기는지 확인 후, 생기면 계산
        // - 계산 시 정수가 아니면 바로 패스
        // 2. 정수인 교점만 남기기
        // 3. 출력 만들기
        // - x값의 최대 최소, y값의 최대 최소 찾기
        Set<Point> points = new HashSet<>();
        
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = integerIntersection(line[i][0], line[i][1], line[j][0],
                             line[j][1], line[i][2], line[j][2]);
                if (intersection != null)
                    points.add(intersection);
            }
        }
        
        Point minPoint = getMinimumPoint(points);
        Point maxPoint = getMaximumPoint(points);
        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : points) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
    
    private Point integerIntersection(long a, long b, long c, long d, long e, long f) {
        if (a * d == b * c) return null;
        
        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);
        
        if (x % 1 != 0 || y % 1 != 0)
            return null;
        
        return new Point((long) x, (long) y);
    }
    
    private Point getMinimumPoint(Set<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for (Point p : points) {
            if (x > p.x) x = p.x;
            if (y > p.y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(Set<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for (Point p : points) {
            if (x < p.x) x = p.x;
            if (y < p.y) y = p.y;
        }
        
        return new Point(x, y);
    }
}