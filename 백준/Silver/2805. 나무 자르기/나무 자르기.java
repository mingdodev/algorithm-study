import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine()); // 아하ㅏ!! 여기서 새로운 줄 입력 받기

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int start = 0; // 여기는 0이어야 한다!! 0이라는 건 모두 gain한다는 뜻. 문데에서는 gain이 목적이므로 0이어야 해!!
        int end = trees[N - 1];
        int ans = 0;

        while (start <= end) {
            int cut = (start + end) / 2;
            long cnt = 0;

            for (int tree : trees) {
                if (tree > cut) cnt += tree - cut;
            }
            if (cnt < M) end = cut - 1;
            if (cnt >= M) {
                ans = cut; // 왜냐, 값이 더 크다는 건 높이를 높일 필요가 있다는 것. 다음 try 때 조건에 맞지 않으면 이 값이 답이 되게 됨. 아하..
                start = cut + 1;
            } 
        }
        
        System.out.println(ans);
     }
}