package Lessons.Lesson3.Task4.Object;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;

    public Book book;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name);
    }
}
