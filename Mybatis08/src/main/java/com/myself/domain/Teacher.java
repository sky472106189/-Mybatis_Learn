package com.myself.domain;

import java.util.List;

public class Teacher {
    private int id;
    private String name;

    //上一个Mybatis07的例子,学生中的老师,是一个private Teacher teacher,
    //这次因为老师只有一个就能对应多个学生.
    //而且查找的方法返回的是 List<Student> 类型,正是因为学生是多个.
    //一个老师对应多个学生,所以学生是集合.
    private List<Student> students;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher() {

    }

    public Teacher(int id, String name, List<Student> students) {

        this.id = id;
        this.name = name;
        this.students = students;
    }
}
