import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 task = new Lab2();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания: ");
        System.out.println("1 - Задание 1, 2 - Сотрудники и отделы, 3 - Создаем Время, 4 - Сколько сейчас времени?");
        int variant = scanner.nextInt();
        int innerVariant;


        switch (variant) {

////////////////////// 1 //////////////////////

            case 1 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - имена, 2 - время");
                innerVariant = scanner.nextInt();
                switch (innerVariant) {


//        Task1.3
                    case 1 -> {
                        Name name1 = new Name("Клеопатра");
                        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
                        Name name3 = new Name("Маяковский", "Владимир");

                        System.out.println(name1.toString());
                        System.out.println(name2.toString());
                        System.out.println(name3.toString());
                    }
//        Task1.4
                    case 2 -> {
                        Time time1 = new Time(10);
                        Time time2 = new Time(10000);
                        Time time3 = new Time(100000);

                        System.out.println(time1.toString());
                        System.out.println(time2.toString());
                        System.out.println(time3.toString());

                    }

                }


            }

////////////////////// 2, 3 //////////////////////

            case 2 -> {
                Department department = new Department("IT");

                Employee employee1 = new Employee("Петров", department);
                Employee employee2 = new Employee("Козлов", department);
                Employee employee3 = new Employee("Сидоров", department);

                department.setChief(employee1);

                System.out.println(employee1);
                System.out.println(employee2);
                System.out.println(employee3);

                department.printEmployees();
            }

////////////////////// 4 //////////////////////

            case 3 -> {
                Time time1 = new Time(10000);
                Time time2 = new Time(2, 3, 5);

                System.out.println("Для 10000 секунд характерно время " + time1);
                System.out.println("Для 2 часов 3 минут и 5 секунд характерно время " + time2);
            }

////////////////////// 5 //////////////////////

            case 4 -> {
                Time time1 = new Time(34056);
                System.out.println("С таким количеством секунд сейчас " + time1.getCurrentHour() + " часов");

                Time time2 = new Time(4532);
                System.out.println("С начала текущего часа прошло " + time2.getMinutesPastHour() + " минут");

                Time time3 = new Time(123);
                System.out.println("С начала текущей минуты прошло " + time3.getSecondsPastMinute() + " секунд");
            }

            default -> System.out.println("Такого задания не существует.");
        }
    }
}

//    METHODS FOR TASK 1

