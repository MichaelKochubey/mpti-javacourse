package ru.kochubey.office;

public class Dept {
    String title;
    Employee head;

    public Dept(String title) {
        this.title = title;
    }
    public Dept(String title, Employee head) {
        this.title = title;
        this.head = head;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Employee getHead() {
        return head;
    }
    public void setHead(Employee employee) {
        if (employee.dept.equals(this)) this.head = employee;
        else throw new IllegalArgumentException("ru.kochubey.office.Employee must work in this dept to be the head of it");
    }
}
