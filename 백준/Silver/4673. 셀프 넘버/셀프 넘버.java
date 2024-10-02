import java.io.*;

public class Main {
    public static final int MAX = 10000;
    public static int d(int n) {
        int s = n;
        int t = n;

        while (t != 0) {
            s += t % 10;
            t /= 10;
        }

        return s;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] notSelfNums = new boolean[MAX+1];

        int temp;
        for (int i = 1; i <= MAX; i++) {
            temp = d(i);
            if (temp <= MAX) {
                notSelfNums[temp] = true;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            if (!notSelfNums[i]) {
                sb.append(String.valueOf(i)).append("\n");
            }
        }

        System.out.println(sb);
    }
}