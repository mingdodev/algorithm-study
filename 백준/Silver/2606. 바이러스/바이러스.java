import java.util.*;
import java.io.*;

public class Main {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        // 1번부터 n번까지 사용
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트에 그래프 정보 저장하기
        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph.get(n).add(m);
            graph.get(m).add(n);
        }

        visited = new boolean[c + 1];

        dfs(1);

        // 1번을 통해 감염되는 컴퓨터의 수 출력
        System.out.println(set.size() - 1);
    }

    public static void dfs(int n) {
        visited[n] = true;
        set.add(n);
        for(int i = 0; i < graph.get(n).size(); i++) {
            int m = graph.get(n).get(i);
            if (!visited[m]) dfs(m);
        }
    }
}