package com.guyan.jvm.tools;

/**
 * @Author: GuYan
 * @Time: 2022/7/19 20:06
 * @Description: TODO
 **/
public class Student {

    private String name;

    private byte b;

    private short s;
    private int age;

    private long l;
    private float score;

    private double balance;

    private boolean sex;

    private char c;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", score=" + score + ", sex=" + sex + '}';
    }

    public void test() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(11);
        student.setName("王传涛");
        student.setSex(false);
        student.setScore(88.5F);

        System.out.println(student);
    }

}
