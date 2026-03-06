import java.io.*;

public class Main {

    public static boolean isPalindrome(char[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - 1 - i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String target = br.readLine();
            if ("0".equals(target)) break;

            if (isPalindrome(target.toCharArray())) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}