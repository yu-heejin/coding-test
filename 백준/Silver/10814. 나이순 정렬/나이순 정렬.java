import java.util.*;
import java.io.*;

class Member implements Comparable<Member>{
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member m) {
        return this.age - m.age;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            Member member = new Member(Integer.parseInt(input[0]), input[1]);
            members.add(member);
        }

        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }
}