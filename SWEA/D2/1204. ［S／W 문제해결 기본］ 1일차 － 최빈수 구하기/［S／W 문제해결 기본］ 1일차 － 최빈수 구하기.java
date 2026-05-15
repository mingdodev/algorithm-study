import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[101];

            for (int i = 0; i < 1000; i++) {
                scores[Integer.parseInt(st.nextToken())] += 1;
            }

            int result = 0;
            for (int i = 1; i <= 100; i++) {
                if (scores[result] < scores[i]) result = i;
                else if (scores[result] == scores[i]) result = Math.max(result, i);
            }

            System.out.println("#" + num + " " + result);
        }
    }
}