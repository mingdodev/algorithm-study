import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            Deque<Integer> queue = new ArrayDeque<>();
            int[] visited = new int[v + 1];
            boolean result = true;

            for (int start = 1; start <= v; start++) {
                if (visited[start] != 0) continue;
                queue.addLast(start);
                int flag = 1; // 1 or 2
                visited[start] = flag;

                while(!queue.isEmpty()) {
                    int temp = queue.pollFirst();
                    flag = visited[temp];
                    if (flag == 1) flag = 2;
                    else flag = 1;

                    for (int i : graph.get(temp)) {
                        if (visited[i] != 0){
                            if (visited[i] == visited[temp]) {
                                result = false;
                                break;
                            }
                            continue;
                        } // 현재 노드가 들어간 그룹과 달라야 함
                        visited[i] = flag;
                        queue.addLast(i);
                    }
                }
            }
            if (result)
                System.out.println("YES");
            else {
                System.out.println("NO");
            }
        }


    }
}