//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static Deque<Integer> stack = new ArrayDeque<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            String command = st.nextToken();
//            switch (command) {
//                case "push":
//                    stack.addLast(Integer.parseInt(st.nextToken()));
//                    break;
//                case "pop":
//                    if (!stack.isEmpty()) {
//                        System.out.println(stack.pollLast());
//                    }
//                    System.out.println(-1);
//                    break;
//                case "size":
//                    System.out.println(stack.size());
//                    break;
//                case "empty":
//                    if (stack.isEmpty()) System.out.println(1);
//                    else System.out.println(0);
//                    break;
//                case "top":
//                    System.out.println(stack.peekLast());
//                    break;
//            }
//        }
//    }
// }

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!stack.isEmpty()) sb.append(stack.pollLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    if (stack.isEmpty())
                        sb.append('1').append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                case "top":
                    if (!stack.isEmpty()) sb.append(stack.peekLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}