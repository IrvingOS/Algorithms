package top.irvingsoft.code.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 *
 * @author TimeChaser
 * @date 2021/8/8 9:30
 */
public class UnionSet<T> {

    private HashMap<T, Node<T>> nodes;
    private HashMap<Node<T>, Node<T>> parents;
    private HashMap<Node<T>, Integer> sizeMap;

    public UnionSet(List<T> values) {

        for (T value : values) {
            Node<T> node = new Node<>(value);
            nodes.put(value, node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node<T> findFather(Node<T> value) {

        Stack<Node<T>> path = new Stack<>();
        while (value != parents.get(value)) {
            path.push(value);
            value = parents.get(value);
        }
        while (!path.isEmpty()) {
            parents.put(path.pop(), value);
        }
        return value;
    }

    public boolean isSameSet(T a, T b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return false;
        }
        return findFather(nodes.get(a)) == findFather(nodes.get(b));
    }

    public void union(T a, T b) {

        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return;
        }
        Node<T> aHead = findFather(nodes.get(a));
        Node<T> bHead = findFather(nodes.get(b));
        if (aHead != bHead) {
            Integer aSetSize = sizeMap.get(aHead);
            Integer bSetSize = sizeMap.get(bHead);
            Node<T> big = aSetSize > bSetSize ? aHead : bHead;
            Node<T> small = big == aHead ? bHead : aHead;
            parents.put(small, big);
            sizeMap.put(big, aSetSize + bSetSize);
            sizeMap.remove(small);
        }
    }

    public int getSize() {
        return sizeMap.size();
    }
}

class Node<T> {
    T value;

    public Node(T value) {
        this.value = value;
    }
}