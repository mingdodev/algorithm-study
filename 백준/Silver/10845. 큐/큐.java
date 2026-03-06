import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.pollFirst()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front":
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.peekFirst()).append("\n");
                    break;
                case "back":
                    if (q.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(q.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}