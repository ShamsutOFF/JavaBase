package Lesson04;
//1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
public class Employee {
    String name;
    String position;
    String phone;
    int salary;
    int age;
    int number;
//2 Конструктор класса должен заполнять эти поля при создании объекта;
    Employee(String name, String position, String phone, int salary, int age, int number){
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.number = number;
    }
//3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getPhone() {
        return phone;
    }
    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
    public int getNumber() {
        return number;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public void setAge(int age){
        this.age = age;
    }
}