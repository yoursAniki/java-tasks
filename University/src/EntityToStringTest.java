import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import annotation.ToString;

public class EntityToStringTest {

    // 1. Тестовый объект, где класс помечен @ToString(NO), но одно поле помечено @ToString(YES)
    @ToString(ToString.Value.NO)
    static class ClassWithToStringNo extends Entity {
        private int a = 1;

        @ToString(ToString.Value.YES)
        private int b = 2;

        private int c = 3; // Не включается, так как класс помечен @ToString(NO)
    }

    // 2. Тестовый объект, где класс не помечен аннотацией, а поле помечено @ToString(NO)
    static class ClassWithoutAnnotation extends Entity {
        private int x = 10;

        @ToString(ToString.Value.NO)
        private int y = 20;

        private String z = "Hello";
    }

    // 3. Тестовый объект, где класс помечен @ToString(NO), и нет @ToString(YES) на полях
    @ToString(ToString.Value.NO)
    static class ClassWithExcludedFields extends Entity {
        private String name = "John";
        private int age = 30;
    }

    // 4. Тестовый объект, где класс помечен @ToString(YES), но поле помечено @ToString(NO)
    static class ClassWithMixedAnnotations extends Entity {
        private String name = "Alice";

        @ToString(ToString.Value.NO)
        private String password = "secret";

        private int score = 100;
    }

    /**
     * Тест для класса, аннотированного @ToString(NO), где одно поле явно включено с @ToString(YES).
     */
    @Test
    public void testClassWithToStringNo() {
        ClassWithToStringNo obj = new ClassWithToStringNo();
        String expected = "ClassWithToStringNo {b=2}";
        String actual = obj.toString();
        assertEquals(expected, actual, "Должно отображаться только поле b, помеченное @ToString(YES).");
    }

    /**
     * Тест для класса без аннотации, где одно поле помечено @ToString(NO).
     */
    @Test
    public void testClassWithoutAnnotation() {
        ClassWithoutAnnotation obj = new ClassWithoutAnnotation();
        String expected = "ClassWithoutAnnotation {x=10, z=Hello}";
        String actual = obj.toString();
        assertEquals(expected, actual, "Должны отображаться только поля, не помеченные @ToString(NO).");
    }

    /**
     * Тест для класса, аннотированного @ToString(NO), где нет полей с @ToString(YES).
     */
    @Test
    public void testClassWithExcludedFields() {
        ClassWithExcludedFields obj = new ClassWithExcludedFields();
        String expected = "ClassWithExcludedFields {}";
        String actual = obj.toString();
        assertEquals(expected, actual, "Ни одно поле не должно отображаться, так как класс помечен @ToString(NO), а поля не помечены @ToString(YES).");
    }

    /**
     * Тест для класса, где одно поле помечено @ToString(NO), а остальные должны отображаться.
     */
    @Test
    public void testClassWithMixedAnnotations() {
        ClassWithMixedAnnotations obj = new ClassWithMixedAnnotations();
        String expected = "ClassWithMixedAnnotations {name=Alice, score=100}";
        String actual = obj.toString();
        assertEquals(expected, actual, "Должны отображаться только поля, не помеченные @ToString(NO).");
    }
}
