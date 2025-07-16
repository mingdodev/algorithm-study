import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 입력 받으면서 배포 가능한 일자 저장
        int size = progresses.length;
        Deque<Integer> workingDays = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            workingDays.offerLast((int)(Math.ceil(((double)(100 - progresses[i]) / speeds[i]))));
        }

        while (!workingDays.isEmpty()) {
            int deploy = workingDays.removeFirst();
            int cnt = 1;
            while (!workingDays.isEmpty() && workingDays.peekFirst() <= deploy) {
                workingDays.removeFirst();
                cnt++;
            }
            result.add(cnt);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}