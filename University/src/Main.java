import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main task = new Main();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания: ");
        System.out.println("1 - Методы, 2 - Условия, 3 - Циклы, 4 - Массивы");
        int variant = scanner.nextInt();
        int innerVariant;


        switch (variant) {

////////////////////// 1 //////////////////////

            case 1 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - дробная часть, 2 - буква в число, 3 - двузначное, 4 - диапазон, 5 - равенство");
                innerVariant = scanner.nextInt();
                switch (innerVariant) {


//        Task1.1
                    case 1 -> {
                        System.out.println("Enter your double number to convert: ");
                        double x = scanner.nextDouble();
                        double answer = task.fraction(x);
                        System.out.println(answer);
                    }

//        Task1.3
                    case 2 -> {
                        System.out.println("Enter your char from 0 to 9");
                        String input = scanner.next();
                        if (input.length() != 1 || input.charAt(0) < '0' || input.charAt(0) > '9') {
                            System.out.println("Надо было ввести число от 0 до 9");
                            break;
                        }
                        char x1 = input.charAt(0);
                        int answer1 = task.charToNum(x1);
                        System.out.println(answer1);
                    }

//        Task1.5
                    case 3 -> {
                        System.out.println("Enter your number to check it is 2 digits");
                        int x2 = scanner.nextInt();
                        boolean answer2 = task.is2Digits(x2);
                        System.out.println("Statement 'this number has 2 digits' is: " + answer2);
                    }

//        Task1.7
                    case 4 -> {
                        System.out.println("Введите две границы a и b, а так же целое число num, чтобы проверить, входит ли оно в диапазон: ");
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        int num = scanner.nextInt();
                        System.out.println("Утверждение, что num входит в границы (a, b): " + task.isInRange(a, b, num));
                    }
//        Task1.9
                    case 5 -> {
                        System.out.println("Введите три числа, чтобы сравнить их между собой: ");
                        int a1 = scanner.nextInt();
                        int b1 = scanner.nextInt();
                        int c1 = scanner.nextInt();
                        System.out.println("Утверждение, что все три числа равны: " + task.isEqual(a1, b1, c1));
                    }
                    default -> System.out.println("Такого подзадания не существует.");
                }
            }

////////////////////// 2 //////////////////////

            case 2 -> {

                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - модуль числа, 2 - тридцать пять, 3 - тройной максимум, 4 - двойная сумма, 5 - день недели");
                innerVariant = scanner.nextInt();
                switch (innerVariant) {

//        Task2.1
                    case 1 -> {
                        System.out.println("Введите число, чтобы получить его модуль: ");
                        int num1 = scanner.nextInt();
                        System.out.println("Модуль числа " + num1 + " - " + task.abs(num1));
                    }

//        Task2.3
                    case 2 -> {
                        System.out.println("Введите число, чтобы проверить делится оно НА 3 ИЛИ НА 5: ");
                        int num2 = scanner.nextInt();
                        System.out.println("Утверждение число " + num2 + " делится НА 3 ИЛИ НА 5: " + task.is35(num2));
                    }

//        Task2.5
                    case 3 -> {
                        System.out.println("Введите три числа, чтобы найти максимальное из них: ");
                        int number1 = scanner.nextInt();
                        int number2 = scanner.nextInt();
                        int number3 = scanner.nextInt();
                        System.out.println("Максимальное из трех чисел - это " + task.max3(number1, number2, number3));
                    }

//        Task2.7
                    case 4 -> {
                        System.out.println("Введите два числа для получения суммы: ");
                        int task21 = scanner.nextInt();
                        int task22 = scanner.nextInt();
                        System.out.println("Получившаяся сумма: " + task.sum2(task21, task22));
                    }

//        Task2.9
                    case 5 -> {
                        System.out.println("Введите номер дня недели: ");
                        int day = scanner.nextInt();
                        System.out.println("Выбранный день: " + task.day(day));
                    }

                    default -> System.out.println("Такого подзадания не существует.");
                }
            }

////////////////////// 3 //////////////////////

            case 3 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - числа подряд, 2 - четные числа, 3 - длина числа, 4 - квадрат, 5 - правый треугольник");
                innerVariant = scanner.nextInt();

                switch (innerVariant) {
                    case 1 -> {
                        System.out.println("Введите число до которого хотите составить последовательность (включительно): ");
                        int task31 = scanner.nextInt();
                        System.out.println("Последовательность: " + task.listNums(task31));
                    }
                    case 2 -> {
                        System.out.println("Введите число до которого хотите составить последовательность четных (включительно): ");
                        int task32 = scanner.nextInt();
                        System.out.println("Последовательность четных чисел: " + task.chet(task32));
                    }
                    case 3 -> {
                        System.out.println("Введите целое число для посчета количества знаков: ");
                        int task33 = scanner.nextInt();
                        System.out.println("Количество цифр в числе: " + task.numLen(task33));
                    }
                    case 4 -> {
                        System.out.println("Введите целое число как размер квадрата: ");
                        int task34 = scanner.nextInt();
                        System.out.println("Полученный квадрат: ");
                        task.square(task34);
                    }
                    case 5 -> {
                        System.out.println("Введите целое число как размер треугольника: ");
                        int task35 = scanner.nextInt();
                        System.out.println("Полученный треугольник: ");
                        task.rightTriangle(task35);
                    }
                    default -> System.out.println("Такого подзадания не существует.");
                }
            }

////////////////////// 4 //////////////////////

            case 4 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - поиск первого значения, 2 - поиск максимального," +
                        "3 - добавление массива в массив, 4 - возвартный реверс, 5 - все вхождения");
                innerVariant = scanner.nextInt();

                switch (innerVariant) {
                    case 1 -> {
                        System.out.println("Введите длину массива: ");
                        int arrayLength = scanner.nextInt();
                        if(arrayLength <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }
                        int[] arr = new int[arrayLength];
                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr[i] = scanner.nextInt();
                        }
                        System.out.println("Введите искомое число: ");
                        int findNum = scanner.nextInt();
                        System.out.println("Индекс этого элемента: " + task.findFirst(arr, findNum));
                    }
                    case 2 -> {
                        System.out.println("Введите длину массива: ");
                        int arrayLength = scanner.nextInt();
                        if(arrayLength <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }
                        int[] arr = new int[arrayLength];
                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr[i] = scanner.nextInt();
                        }
                        System.out.println("Наибольший по модулю элемент: " + task.maxAbs(arr));
                    }
                    case 3 -> {
                        System.out.println("Введите длину массива: ");
                        int arrayLength = scanner.nextInt();
                        if(arrayLength <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }

                        int[] arr = new int[arrayLength];

                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr[i] = scanner.nextInt();
                        }

                        System.out.println("Введите длину вставного массива: ");
                        int array2Length = scanner.nextInt();
                        if(array2Length <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }

                        int[] arr2 = new int[array2Length];

                        for (int i = 0; i < array2Length; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr2[i] = scanner.nextInt();
                        }

                        System.out.println("Введите индекс позиции для вставки: ");
                        int pos = scanner.nextInt();

                        if (pos < 0 || pos > arr.length) {
                            System.out.println("Некорректная позиция");
                            break;
                        }
                        int[] newArr = task.add(arr, arr2, pos);

                        System.out.println("Новый массив: ");
                        for (int el: newArr) {
                            System.out.print(el + " ");
                        }
                    }
                    case 4 -> {
                        System.out.println("Введите длину массива: ");
                        int arrayLength = scanner.nextInt();
                        if(arrayLength <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }

                        int[] arr = new int[arrayLength];

                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr[i] = scanner.nextInt();
                        }

                        System.out.println("Перевернутый массив: ");

                        for(int el: task.reverseBack(arr)) {
                            System.out.print(el + " ");
                        }
                    }
                    case 5 -> {
                        System.out.println("Введите длину массива: ");
                        int arrayLength = scanner.nextInt();
                        if(arrayLength <= 0) {
                            System.out.println("Длина массива должна быть больше 0");
                            break;
                        }

                        int[] arr = new int[arrayLength];

                        for (int i = 0; i < arrayLength; i++) {
                            System.out.print("Введите элемент массива: ");
                            arr[i] = scanner.nextInt();
                        }

                        System.out.println("Введите число x: ");
                        int x = scanner.nextInt();

                        System.out.println("Массив индексов вхождений числа x: ");
                        for(int el: task.findAll(arr, x)) {
                            System.out.print(el + " ");
                        }
                    }
                    default -> System.out.println("Такого подзадания не существует.");
                }
            }

            default -> System.out.println("Такого задания не существует.");
        }
    }

//    METHODS FOR TASK 1

    public double fraction (double x) {
        return x - (int)x;
    }

    public int charToNum (char x) {
        return x - '0';
    }

    public boolean is2Digits (int x) {
        return (x >= 10 && x < 100) || (x<=-10 && x>-100);
    }

    public boolean isInRange (int a, int b, int num) {
        if(a>b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return num >= a && num <= b;
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && c == a;
    }

//    METHODS FOR TASK 2

    public int abs (int x) {
        if(x>=0) return x;
        return x * -1;
    }

    public boolean is35 (int x) {
        return (x%3 == 0 || x%5 == 0) && !(x%3 == 0 && x%5 == 0);
    }

    public int max3 (int x, int y, int z) {
        int max = x;
        if(x<y) {
            max = y;
        }
        if(max > z) return max;

        return z;
    }

    public int sum2 (int x, int y) {
        int sum = x + y;
        if(sum<=19 && sum >=10) {
            return 20;
        }
        return sum;
    }

    public String day (int x) {
        return switch (x) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "это не день недели";
        };
    }

//    METHODS FOR TASK 3

    public String listNums (int x) {
        if(x<0) return "You need to enter positive number...";

        String result = "";

        for (int i = 0; i<=x; i++) {
            result += " " + Integer.toString(i);
        }

        return result;
    }

    public String chet (int x) {
        if(x<0) return "You need to enter positive number...";

        String result = "";

        for (int i = 0; i<=x; i+=2) {
            result += " " + Integer.toString(i);
        }

        return result;
    }

    public int numLen (long x) {
        int count = 0;

        while(x != 0) {
            x = x/10;
            count++;
        }

        return count;
    }

    public void square (int x) {
        if(x<=0) {
            System.out.println("Введите размер квадрата больше 0");
            return;
        }

        for (int i = 0; i<x;i++) {
            for (int j = 0; j<x;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void rightTriangle (int x) {
        if(x<=0) {
            System.out.println("Введите размер треугольника больше 0");
            return;
        }

        for (int i = 0; i<x;i++) {
            int count = x-1-i;
            for (int j1 = 0; j1 < count; j1++) {
                System.out.print(" ");
            }
            for (int j2 = 0; j2 < x-count; j2++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//    METHODS FOR TASK 4

    public int findFirst (int[] arr, int x) {

        for(int index=0;index<arr.length;index++) {
            if(arr[index] == x) return index;
        }

        return -1;
    }

    public int maxAbs (int[] arr) {
        int max = arr[0];

        for (int i = 1;i<arr.length;i++) {
            if(abs(max) < abs(arr[i])) max = arr[i];
        }

        return max;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }

        return result;
    }

    public int[] reverseBack (int[] arr) {
        int[] reverseArr = new int[arr.length];

        for (int i = 0;i < arr.length; i++) {
            reverseArr[arr.length - 1-i] = arr[i];
        }

        return reverseArr;
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int value : arr) {
            if (value == x) {
                count++;
            }
        }

        int[] indices = new int[count];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices[index] = i;
                index++;
            }
        }

        return indices;
    }

}
