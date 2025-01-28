import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListToQueue {

    public static <T> Queue<T> buildQueueFromList(List<T> list) {
        if (list == null) {
            return new LinkedList<>();
        }

        Queue<T> queue = new LinkedList<>();
        for (T element : list) {
            queue.offer(element);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            queue.offer(list.get(i));
        }

        return queue;
    }
}