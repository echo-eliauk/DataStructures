package com.itcast.cn;
/*
* 浅拷贝
* 拷贝新建了一个对象，引用部分没有拷贝，只是引用地址，所以更改会一起改变
*
* */
public class copy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Major major=new Major("软件工程");
        Student a=new Student("朱文",22,major);
        Student b=(Student) a.clone();
        System.out.println(a==b);
        System.out.println(a);
        System.out.println("----------");
        System.out.println(b);
        major.setName("计算机科学与技术");
        a.setName("张三");
        System.out.println(a);
        System.out.println("----------");
        System.out.println(b);
    }
}
class Student implements Cloneable{
    private String name;
    private int age;
    private Major major;

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Major{
    private String name;

    public Major(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                '}';
    }
}
