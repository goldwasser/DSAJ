package com.zybooks.dsaj.design;

public class Student implements Person {
    String id;
    String name;
    int age;
    public Student(String i, String n, int a) {         // simple constructor
        id = i;
        name = n;
        age = a;
    }
    protected int studyHours() { return age/2;}         // just a guess
    public String getID() { return id;}                 // ID of the student
    public String getName() { return name; }            // from Person interface
    public int getAge() { return age; }                 // from Person interface
    public boolean equals(Person other) {               // from Person interface
        if (!(other instanceof Student)) return false;  // cannot possibly be equal
        Student s = (Student) other;                    // explicit cast now safe
        return id.equals(s.id);                         // compare IDs
    }
    public String toString() {                          // for printing
        return "Student(ID:" + id + ", Name:" + name + ", Age:" + age + ")";
    }
}
