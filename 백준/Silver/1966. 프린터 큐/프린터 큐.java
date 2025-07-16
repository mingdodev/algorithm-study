import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int index;
        int priority;

        public Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.index + ": " + this.priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // n개의 문서들 중
            int m = Integer.parseInt(st.nextToken()); // m번째 문서

            Deque<Document> printer = new ArrayDeque<>();
            PriorityQueue<Integer> priorityStack = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                printer.addLast(new Document(priority, j));
                priorityStack.offer(priority);
            }

            int result = 1;
            while (!printer.isEmpty()) {
                Document d = printer.peekFirst();
                if (d.priority == priorityStack.peek()) {
                    printer.removeFirst(); // 출력
                    priorityStack.poll();
                    if (d.index == m) {
                        sb.append(result).append('\n');
                        break;
                    }
                    result++;
                } else {
                    d = printer.removeFirst();
                    printer.offerLast(d);
                }
            }
        }

        System.out.println(sb);
    }
}