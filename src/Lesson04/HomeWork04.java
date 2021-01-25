package Lesson04;

public class HomeWork04 {

//    //7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
    public static int a = 0;
    public static int Number (){
        return ++a;
    }
    //5.1 Создать массив из 5 сотрудников.
    
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Mr.Black", "Директор", "8(800)000 00 01", 100000, 50, Number()),
                new Employee("Mr.White", "Ст.Менеджер", "8(800)000 00 02", 60000, 41,Number()),
                new Employee("Mr.Green", "Менеджер", "8(800)000 00 03", 55000, 30,Number()),
                new Employee("Mr.Yellow", "Юрист", "8(800)000 00 04", 40000, 35,Number()),
                new Employee("Ms.Purple", "Секретарь", "8(800)000 00 05", 25000, 25,Number()),
        };
        //4 Вывести при помощи методов из пункта 3 ФИО и должность.
        for (int i = 0; i < employees.length; i++) {
            System.out.print(employees[i].getName() + " - ");
            System.out.println(employees[i].getPosition());
        }
//5.2 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.print(employees[i].getName() + " - ");
                System.out.print(employees[i].getPosition() + " - ");
                System.out.print(employees[i].getPhone() + " - ");
                System.out.print(employees[i].getSalary() + " - ");
                System.out.print(employees[i].getAge());
                System.out.println(employees[i].getNumber());
            }
        }
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].age > 35){
                    employees[i].setSalary(employees[i].getSalary()+10000);
                    System.out.println("Зарплата " + employees[i].name + " стала " + employees[i].getSalary());
            }
        }
    }
}
//6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;

