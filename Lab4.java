import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 task = new Lab4();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания: ");
        System.out.println("1 - Обобщенные типы, 2 - Параметризации, 3 - Обобщенные методы");
        int variant = scanner.nextInt();
        int innerVariant;


        switch (variant) {

////////////////////// 1 //////////////////////

            case 1 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - обобщенная коробка, 2 - без null");
                innerVariant = scanner.nextInt();
                switch (innerVariant) {


//        Task1.1
                    case 1 -> {
                        Box<Integer> intBox = new Box<>();
                        intBox.put(3);
                        System.out.println("Коробка заполнена? " + intBox.isFull());
                        displayBoxValue(intBox);
                    }
//        Task1.2
                    case 2 -> {
                        Storage<Integer> integerStorage = new Storage<>(null);
                        displayIntStorageValue(integerStorage, 0);

                        Storage<Integer> integerStorage2 = new Storage<>(99);
                        displayIntStorageValue(integerStorage2, -1);

                        Storage<String> stringStorage = new Storage<>(null);
                        displayStringStorageValue(stringStorage, "default");

                        Storage<String> stringStorage2 = new Storage<>("hello");
                        displayStringStorageValue(stringStorage2, "hello world");
                    }
                    default -> System.out.println("Такого задания нет");

                }


            }

////////////////////// 2.3 //////////////////////

            case 2 -> {
                Box<ThreeDimensionalPoint> pointBox = new Box<>();
                addRandomPoint(pointBox);

                ThreeDimensionalPoint point = pointBox.take();
                System.out.println("Содержимое коробки: " + point);
            }

////////////////////// 3 //////////////////////

            case 3 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - Функция, 2 - Фильтр");
                innerVariant = scanner.nextInt();
                switch (innerVariant) {


//3.1
                    case 1 -> {
                        List<String> stringList = List.of("qwerty", "asdfg", "zx");
                        List<Integer> lengths = transformList(stringList, String::length);
                        System.out.println("Длины строк: " + lengths);

                        List<Integer> numbers = List.of(1, -3, 7);
                        List<Integer> absoluteValues = transformList(numbers, Math::abs);
                        System.out.println("Положительные значения: " + absoluteValues);

                        List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{5, 10, 15});
                        List<Integer> maxValues = transformList(arrays, arr -> {
                            int max = arr[0];
                            for (int num : arr) {
                                if (num > max) max = num;
                            }
                            return max;
                        });
                        System.out.println("Максимальные значения массивов: " + maxValues);
                    }
//3.2
                    case 2 -> {
                        List<String> stringList = List.of("qwerty", "asdfg", "zx");
                        List<String> filteredStrings = filterList(stringList, s -> s.length() >= 3);
                        System.out.println("Отфильтрованные строки: " + filteredStrings);

                        List<Integer> numbers = List.of(1, -3, 7);
                        List<Integer> filteredNumbers = filterList(numbers, n -> n <= 0);
                        System.out.println("Отфильтрованные числа: " + filteredNumbers);

                        List<int[]> arrays = List.of(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{-5, -10, -15});
                        List<int[]> filteredArrays = filterList(arrays, arr -> {
                            for (int num : arr) {
                                if (num > 0) {
                                    return false;
                                }
                            }
                            return true;
                        });

                        System.out.print("Отфильтрованные массивы: ");
                        for (int[] arr : filteredArrays) {
                            System.out.print("[ ");
                            for (int num : arr) {
                                System.out.print(num + " ");
                            }
                            System.out.print("] ");
                        }

                    }
                    default -> System.out.println("Такого задания нет");
                }

            }

            default -> System.out.println("Такого задания не существует.");
        }
    }
    
    private static void displayBoxValue(Box<Integer> box) {
        Integer value = box.take();
        System.out.println("Значение из коробки: " + value);
    }
    private static void displayIntStorageValue(Storage<Integer> storage, int alt) {
        Integer value = storage.getValue(alt);
        System.out.println("Значение из хранилища: "+ value);
    }
    private static void displayStringStorageValue(Storage<String> storage, String alt) {
        String value = storage.getValue(alt);
        System.out.println("Значение из хранилища: "+ value);
    }
    public static void addRandomPoint(Box<? super ThreeDimensionalPoint> box) {
        ThreeDimensionalPoint point = new ThreeDimensionalPoint(1, 2, 3);
        box.put(point);
    }

    // Для 3 задания

    public static <T, P> List<P> transformList(List<T> inputList, Function<T, P> transformer) {
        List<P> result = new ArrayList<>();
        for (T item : inputList) {
            result.add(transformer.apply(item));
        }
        return result;
    }

    public static <T> List<T> filterList(List<T> inputList, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : inputList) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}