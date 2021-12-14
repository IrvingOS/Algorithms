package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 堆栈
 * <p>
 * 同样使用链表实现的堆栈
 * <p>
 * 此处注意使用静态内部类 {@link Node<Item>} 与 {@link LinkedStack} 的内部类对比
 *
 * @author TimeChaser
 * @since 2021/12/13 20:02
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int        n;

    public Stack() {
        n = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        n--;
        Item value = first.item;
        first = first.next;
        return value;
    }

    public void push(Item item) {
        n++;
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        for (Item item : this) {
            s.append(item);
            s.append(',').append(' ');
        }
        if (s.length() > 3) {
            s.deleteCharAt(s.length() - 1);
            s.deleteCharAt(s.length() - 1);
        }
        s.append(']');
        return s.toString();
    }

    private static class Node<Item> {
        private Item       item;
        private Node<Item> next;
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> cur;

        public LinkedIterator() {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack underflow");
            }
            Item value = cur.item;
            cur = cur.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
