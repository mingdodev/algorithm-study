import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 0;
            int buildingCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[buildingCount];
            for (int i = 0; i < buildingCount; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 2; i < buildingCount - 2; i++) {
                int[] idx = { -2, -1, 1, 2 };
                int minDiff = 256;
                for (int j = 0; j < 4; j++) {
                    int diff = buildings[i] - buildings[i + idx[j]];
                    if (diff < minDiff) minDiff = diff;
                }
                if (minDiff > 0) result += minDiff;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}