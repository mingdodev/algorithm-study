import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();
                return a.compareTo(b);
            }
        };

        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            stringSet.add(br.readLine());
        }

        List<String> stringList = new ArrayList<>(stringSet);
        stringList.sort(comparator);

        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}