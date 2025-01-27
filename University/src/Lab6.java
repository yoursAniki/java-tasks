import annotation.*;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Lab6 task = new Lab6();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания: ");
        System.out.println("1 - Рефлексия, 2 - Аннотация, 3 - Обработка аннотаций, 4 - Тестирование");
        int variant = scanner.nextInt();
        int innerVariant;


        switch (variant) {

////////////////////// 1.1 //////////////////////

            case 1 -> {
                class A extends Entity {
                    String s="hello";
                    int x = 42;
                }

                class B extends A {
                    String text="B";
                }

                B b = new B();
                System.out.println(b);


            }

////////////////////// 2 //////////////////////

            case 2 -> {
                System.out.println("Введите номер подзадания: ");
                System.out.println("1 - @Invoke, 2 - @Default, 3 - @ToString, 4 - @Validate, 5 - @Two, 6 - @Cache");
                innerVariant = scanner.nextInt();

                switch (innerVariant) {


//        Task2.1
                    case 1 -> {
                        class AnnotationExample {
                            @Invoke
                            public void annotatedByInvokeMethod() {
                                System.out.println("Этот метод аннотирован @Invoke.");
                            }
                        }

                        System.out.println("Поле field аннотировано @Invoke");
                    }
//        Task2.2
                    case 2 -> {
                        @Default(value = String.class)
                        class AnnotationExample {
                            @Default(value = Integer.class)
                            private Object field;
                        }

                        System.out.println("Поле field аннотировано @Default");

                    }
//        Task2.3
                    case 3 -> {
                        @ToString
                        class AnnotationExample {
                            @ToString(ToString.Value.NO)
                            int x = 20;
                        }
                        System.out.println("Поле x аннотировано @ToString");

                    }
//        Task2.4
                    case 4 -> {
                        class NotNullValidator {
                            public static boolean validate(Object obj) {
                                return obj != null;
                            }
                        }

                        class RangeValidator {
                            public static boolean validate(int value) {
                                return value >= 0 && value <= 120;
                            }
                        }

                        @Validate({NotNullValidator.class, RangeValidator.class})
                        class AnnotationExample {
                            // Тело класса
                        }
                    }
//        Task2.5
                    case 5 -> {
                        @Two(first = "first", second = 42)
                        class AnnotationExample {
                            // Тело класса
                        }
                    }
//        Task2.6
                    case 6 -> {
                        @Cache(value = {"exampleValue1", "exampleValue2"})
                        class AnnotationExample {
                            // Тело класса
                        }
                    }
                    default -> System.out.println("Такого задания нет");

                }


            }

////////////////////// 3.1 //////////////////////

            case 3 -> {
                @ToString(ToString.Value.NO)
                class A extends Entity {
                    private int x = 10;

                    @ToString(ToString.Value.YES)
                    private int y = 20;

                    private int z = 30;
                }

                A test1 = new A();
                System.out.println(test1);

                class B extends Entity {
                    private String name = "John";
                    private int age = 25;

                    @ToString(ToString.Value.NO)
                    private String password = "secret";
                }

                B test2 = new B();
                System.out.println(test2);
            }

////////////////////// 4.1 //////////////////////

            case 4 -> {
                EntityToStringTest.ClassWithToStringNo obj1 = new EntityToStringTest.ClassWithToStringNo();
                EntityToStringTest.ClassWithoutAnnotation obj2 = new EntityToStringTest.ClassWithoutAnnotation();
                EntityToStringTest.ClassWithExcludedFields obj3 = new EntityToStringTest.ClassWithExcludedFields();
                EntityToStringTest.ClassWithMixedAnnotations obj4 = new EntityToStringTest.ClassWithMixedAnnotations();

                // Выводим результаты toString() для каждого объекта
                System.out.println("obj1: " + obj1);
                System.out.println("obj2: " + obj2);
                System.out.println("obj3: " + obj3);
                System.out.println("obj4: " + obj4);
            }

            default -> System.out.println("Такого задания не существует.");
        }
    }
}