import java.util.*;
import java.lang.*;
import java.io.*;

class Student implements Comparable<Student> {
    String name;
    int korean;
    int math;
    int english;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }

    @Override
    public int compareTo(Student s) {
        if (s.korean == this.korean) {
            if (s.english == this.english) {
                if (s.math == this.math) {
                    return this.name.compareTo(s.name);
                }
                return s.math - this.math;
            }
            return this.english - s.english;
        }
        return s.korean - this.korean;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Student> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            Student s = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            pq.add(s);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().name);
        }
    }
}