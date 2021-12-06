package top.irvingsoft.test.interfaceextends;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * @author TimeChaser
 * @since 2021/9/22 16:55
 */
public interface Iterable<T> {

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
//        for (T t : this) {
//            action.accept(t);
//        }
    }

    Iterator<T> iterator();

    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
