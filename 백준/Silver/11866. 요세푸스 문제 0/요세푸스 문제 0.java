import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> people = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            people.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ");
        int index = k - 1;
        while(!people.isEmpty()) {
            sj.add(String.valueOf(people.remove(index)));
            n -= 1;
            index += (k - 1);
            if (index > n - 1 && n > 0)
                index %= n;
        }
        sb.append("<").append(sj).append(">");
        System.out.println(sb);
    }
}