package com.powernode.demo;

public class TestApp {

    public static void main(String[] args) {
        Student s1 = new Student(1,20);
        Student s2 = new Student(1,20);
        String max = getMax(s1, s2);
        System.out.println(max);
    }

    public static String getMax(Student s1,Student s2){
        if (s1.getStu_age().compareTo(s2.getStu_age())>0){
            return s1.toString();
        }else if (s1.getStu_age().compareTo(s2.getStu_age())<0){
            return s2.toString();
        }else{
            return "same";
        }
    }
}
