package top.irvingsoft.test.interfaceextends;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author TimeChaser
 * @date 2021/9/23 22:42
 */
public class Test<T> implements Collection<T> {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(iterator.next());
            i++;
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
