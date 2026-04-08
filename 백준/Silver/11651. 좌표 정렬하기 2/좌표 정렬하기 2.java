import java.io.*;
import java.util.*;

public class Main {

    static class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Dot> dots = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dots.sort(Comparator.comparingInt(Dot::getY).thenComparingInt(Dot::getX));

        StringBuilder sb = new StringBuilder();
        for (Dot dot : dots) {
            sb.append(dot.getX()).append(" ").append(dot.getY()).append("\n");
        }
        System.out.println(sb);
    }
}