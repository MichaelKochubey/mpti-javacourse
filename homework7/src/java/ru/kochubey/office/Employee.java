package ru.kochubey.office;

// 4.2.1
public class Employee {
    String name;
    Dept dept;

    public Employee(String name) {
        this.name = name;
    }
    public Employee(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        if (isHeadOfDept()) return name + " is a Head of dept " + dept.title;
        return name + " works in dept " + dept.title + " where Head is " + dept.head.name;
    }
    public boolean isHeadOfDept() {
        return this.name.equals(this.dept.head.name);
    }
}
