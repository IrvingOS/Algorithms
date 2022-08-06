package top.irvingsoft.test.interfaceextends;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author TimeChaser
 * @since 2021/9/22 16:52
 */
public interface Iterator<E> {

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext()) {
            action.accept(next());
        }
    }

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
