class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 2499; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = width * 2 + (height - 2) * 2;
                int center = width * height - boundary;
                if (boundary == brown && center == yellow) {
                    return new int[] { width, height };
                }
            }
        }
        return null;
    }
}