import java.io.*;
import java.util.*;

public class Main {
    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Dot> dots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        dots.sort(new Comparator<Dot>() {
            @Override
            public int compare(Dot a, Dot b) {
                if (a.x == b.x) return a.y - b.y;
                return a.x - b.x;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Dot dot : dots) {
            sb.append(dot.x).append(" ").append(dot.y).append("\n");
        }
        System.out.println(sb);
    }
}