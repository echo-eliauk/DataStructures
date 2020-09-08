package com.itcast.cn;

/**
 * 深拷贝
 * 对象和引用类型都进行拷贝，形成新的对象，和原来对象无任何联系
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Major1 major=new Major1("软件工程");
        Student1 a=new Student1("朱文",22,major);
        Student1 b=(Student1) a.clone();
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

class Student1 implements Cloneable{
    private String name;
    private int age;
    private Major1 major;

    public void setName(String name) {
        this.name = name;
    }

    public Student1(String name, int age, Major1 major) {
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
        Student1 student1=(Student1)super.clone();
        student1.major=(Major1)major.clone();
        return student1;
    }
}
class Major1 implements Cloneable{
    private String name;

    public Major1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Major1{" +
                "name='" + name + '\'' +
                '}';
    }
}
