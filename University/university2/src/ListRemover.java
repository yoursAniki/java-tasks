import java.util.ArrayList;
import java.util.List;

public class ListRemover {

    public static void removeAllElements(List<Integer> list, Integer elementToRemove) {
        // Удаляет элементы безопасным образом, избегая ConcurrentModificationException,
        // то есть, избегает ошибку во время перебора
        list.removeIf(element -> element.equals(elementToRemove));
    }
}