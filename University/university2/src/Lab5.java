import cating.Cat;
import cating.MeowCaller;
import cating.MeowCounter;
import cating.Meowable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Lab5 {
    public static void main(String[] args) {
        Lab5 task = new Lab5();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания: ");
        System.out.println("1 - Шаблоны, 2 - Структурные шаблоны, 3 - Список, 4 - Мап," +
                " 5 - Сет, 6 - Очередь, 7 - Стрим");
        int variant = scanner.nextInt();
        int innerVariant;


        switch (variant) {

////////////////////// 1.1 //////////////////////

            case 1 -> {
                Fraction f1 = new Fraction(1, 2);
                System.out.println("f1: " + f1 + ", value: " + f1.getValue());

                Fraction f2 = new Fraction(-1, 2);
                System.out.println("f2: " + f2 + ", value: " + f2.getValue());

                Fraction f3 = new Fraction(1, -2);
                System.out.println("f3: " + f3 + ", value: " + f3.getValue());

                Fraction f4 = new Fraction(-1, -2);
                System.out.println("f4: " + f4 + ", value: " + f4.getValue());

                System.out.println("f1 equals f4: " + f1.equals(f4));

                f1.setNumerator(3);
                System.out.println("f1 after setNumerator: " + f1 + ", value: " + f1.getValue());

                f1.setDenominator(4);
                System.out.println("f1 after setDenominator: " + f1 + ", value: " + f1.getValue());

                Fraction f5 = new Fraction(3,4);
                System.out.println("f1 equals f5: " + f1.equals(f5));
            }

////////////////////// 2.1 //////////////////////

            case 2 -> {
                Cat cat = new Cat("Барсик");
                System.out.println(cat);

                MeowCounter counter = new MeowCounter(cat);
                Meowable[] meowables = {counter};

                MeowCaller.makeThemMeow(meowables);
                MeowCaller.makeThemMeow(meowables);

                System.out.println("Количество мяуканий кота " + cat.getName() + ": " + counter.getMeowCount());

                counter.resetCount();
                MeowCaller.makeThemMeow(meowables);
                System.out.println("Количество мяуканий кота " + cat.getName() + ": " + counter.getMeowCount());

            }

////////////////////// 3.7 //////////////////////

            case 3 -> {
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list1.add(2);
                list1.add(3);
                list1.add(2);
                list1.add(4);
                list1.add(2);

                System.out.println("Исходный список 1: " + list1);
                ListRemover.removeAllElements(list1, 2);
                System.out.println("Список 1 после удаления 2: " + list1);


                List<Integer> list2 = new ArrayList<>();
                list2.add(1);
                list2.add(3);
                list2.add(4);

                System.out.println("Исходный список 2: " + list2);
                ListRemover.removeAllElements(list2, 2);
                System.out.println("Список 2 после удаления 2: " + list2);

                List<Integer> list3 = new ArrayList<>();
                System.out.println("Исходный список 3: " + list3);
                ListRemover.removeAllElements(list3, 2);
                System.out.println("Список 3 после удаления 2: " + list3);
            }

////////////////////// 4.7 //////////////////////

            case 4 -> {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите количество записей: ");
                int n = Integer.parseInt(scanner1.nextLine());

                Map<Integer, Integer> minPrices = new HashMap<>();
                Map<Integer, Integer> minPriceCounts = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    System.out.println("Введите запись: ");
                    String line = scanner1.nextLine();
                    String[] parts = line.split(" ");
                    int brand = Integer.parseInt(parts[2]);
                    int price = Integer.parseInt(parts[3]);

                    if (!minPrices.containsKey(brand) || price < minPrices.get(brand)) {
                        minPrices.put(brand, price);
                        minPriceCounts.put(brand, 1);
                    } else if (price == minPrices.get(brand)) {
                        minPriceCounts.put(brand, minPriceCounts.get(brand) + 1);
                    }
                }

                System.out.print(minPriceCounts.getOrDefault(92, 0) + " ");
                System.out.print(minPriceCounts.getOrDefault(95, 0) + " ");
                System.out.print(minPriceCounts.getOrDefault(98, 0));
                System.out.println();

                scanner1.close();
            }

////////////////////// 5.7 //////////////////////

            case 5 -> {
                System.out.println("Текущая рабочая директория: " + System.getProperty("user.dir"));
                String filePath = "input.txt";
                Set<Character> uniqueLetters = new HashSet<>();

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.toLowerCase();
                        for (char c : line.toCharArray()) {
                            if (Character.isLetter(c) && Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC)
                                uniqueLetters.add(c);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                    return;
                }

                System.out.println("Количество различных букв: " + uniqueLetters.size());
            }

////////////////////// 6.2 //////////////////////

            case 6 -> {
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list1.add(2);
                list1.add(3);
                Queue<Integer> queue1 = ListToQueue.buildQueueFromList(list1);
                System.out.println("Очередь из списка " + list1 + ": " + queue1);

                List<String> list2 = new ArrayList<>();
                list2.add("a");
                list2.add("b");
                list2.add("c");
                Queue<String> queue2 = ListToQueue.buildQueueFromList(list2);
                System.out.println("Очередь из списка " + list2 + ": " + queue2);

                List<Integer> list3 = new ArrayList<>();
                Queue<Integer> queue3 = ListToQueue.buildQueueFromList(list3);
                System.out.println("Очередь из списка " + list3 + ": " + queue3);

                List<Integer> list4 = null;
                Queue<Integer> queue4 = ListToQueue.buildQueueFromList(list4);
                System.out.println("Очередь из списка " + list4 + ": " + queue4);
            }

////////////////////// 7 //////////////////////


            case 7 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1, 2");
                innerVariant = scanner.nextInt();

                switch (innerVariant) {


//        Task7.1
                    case 1 -> {
                        List<Point> points = new ArrayList<>(Arrays.asList(
                                new Point(1, 2),
                                new Point(3, -4),
                                new Point(1, 2),
                                new Point(5, 6),
                                new Point(3,-4),
                                new Point(-2, -3),
                                new Point(-2, 3)

                        ));

                        Polyline polyline = points.stream()
                                .distinct()
                                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                                .map(Point::withPositiveY)
                                .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new));

                        System.out.println(polyline);
                    }
//        Task7.2
                    case 2 -> {


                    }
                    default -> System.out.println("Такого задания не существует.");
                }


            }
            default -> System.out.println("Такого задания не существует.");
        }
    }
}