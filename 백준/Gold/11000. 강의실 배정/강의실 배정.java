import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lectures, (a, b) -> {
            if (a.start == b.start)
                return a.end - b.end;
            return a.start - b.start;
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(lectures[0].end); // 필요한 강의실. 끝나는 시각만 저장하고, 넣을 데가 없으면 추가함. 이어서 강의 가능하면 끝나는 시각 업데이트

        for (int i = 1; i < n; i++) {
            if (lectures[i].start >= endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.add(lectures[i].end);
        }

        System.out.println(endTimes.size());
    }
}