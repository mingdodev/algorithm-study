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
		   StringTokenizer st = new StringTokenizer(br.readLine());
            int plus = Integer.parseInt(st.nextToken());
            int minus = Integer.parseInt(st.nextToken());
            
            int a = (plus + minus) / 2;
            int b = (plus - minus) / 2;
            System.out.println(a + " " + b);
		}
	}
}