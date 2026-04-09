import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }
        Set<String> listenSee = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (listen.contains(name))
                listenSee.add(name);
        }

        System.out.println(listenSee.size());
        StringBuilder sb = new StringBuilder();
        listenSee.stream().sorted(String::compareTo)
                .forEach(s -> sb.append(s).append("\n"));
        System.out.println(sb);
    }
}