package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 8, 2, 1, 2, 3, 4, 5);
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.get());
    }
}
