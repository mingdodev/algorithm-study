import java.util.*;

class Solution {
    public String solution(String s) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] nums = Arrays.stream(s.split(" ")).mapToInt(n -> { return Integer.parseInt(n); }).toArray();
        
        for (int n : nums) {
            minHeap.offer(n);
            maxHeap.offer(n);
        }    
        
        return minHeap.peek() + " " + maxHeap.peek();
    }
}