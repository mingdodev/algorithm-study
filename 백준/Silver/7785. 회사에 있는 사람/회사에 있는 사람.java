import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp;
        HashSet<String> log = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            temp = str.split(" ");
            if (temp[1].equals("enter")) {
                log.add(temp[0]);
            }
            if (temp[1].equals("leave")) {
                log.remove(temp[0]);
            }
        }

        log.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}