import java.io.*;
import java.util.*;

public class Main {
    static class Member {
        private int id;
        private int age;
        private String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member a, Member b) {
                if (a.getAge() == b.getAge()) return a.getId() - b.getId();
                return a.getAge() - b.getAge();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.getAge()).append(" ")
                    .append(member.getName()).append("\n");
        }
        System.out.println(sb);
    }
}