import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int size = string.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                set.add(string.substring(i, j + 1));
            }
        }

        System.out.println(set.size());
    }
}