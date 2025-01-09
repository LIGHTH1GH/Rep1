package com.powernode.demo;

public class Student implements Comparable<Student> {

    private Integer stu_id;
    private Integer stu_age;

    @Override
    public int compareTo(Student o) {
        return this.stu_age - o.stu_age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_age=" + stu_age +
                '}';
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getStu_age() {
        return stu_age;
    }

    public void setStu_age(Integer stu_age) {
        this.stu_age = stu_age;
    }

    public Student(Integer stu_id, Integer stu_age) {
        this.stu_id = stu_id;
        this.stu_age = stu_age;
    }

    public Student() {
    }
}
