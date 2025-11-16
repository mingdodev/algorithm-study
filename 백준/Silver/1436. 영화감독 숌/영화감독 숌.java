import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int count = 0;
        int temp = 1;
        while(count != target) {
            if (isEndNumber(temp)) {
                count++;
            }
            temp++;
        }
        System.out.println(temp - 1);
    }
    private static boolean isEndNumber(int n) {
        return String.valueOf(n).contains("666");
    }
}