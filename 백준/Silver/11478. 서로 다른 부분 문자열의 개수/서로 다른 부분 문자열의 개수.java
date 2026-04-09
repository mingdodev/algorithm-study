import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int size = string.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String tempString = String.valueOf(string.charAt(i));
            set.add(tempString);
            for (int j = i + 1; j < size; j++) {
                tempString += String.valueOf(string.charAt(j));
                set.add(tempString);
            }
        }
        
        System.out.println(set.size());
    }
}