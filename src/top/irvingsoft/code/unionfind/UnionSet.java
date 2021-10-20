package top.irvingsoft.code.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/8/8 9:30
 */
public class UnionSet<T> {

    // 存储泛型实体的结点
    private final HashMap<T, Node<T>> nodeMap = new HashMap<>();
    // 存储结点的父结点
    private final HashMap<Node<T>, Node<T>> parentMap = new HashMap<>();
    // 存储父结点集的大小（包含多少个子结点，包括自身）
    private final HashMap<Node<T>, Integer> sizeMap = new HashMap<>();

    public UnionSet(List<T> values) {

        for (T value : values) {
            Node<T> node = new Node<>(value);
            nodeMap.put(value, node);
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node<T> findFather(Node<T> value) {

        Stack<Node<T>> path = new Stack<>();
        while (value != parentMap.get(value)) {
            // 结点的父结点另有其人
            path.push(value);
            value = parentMap.get(value);
        }
        while (!path.isEmpty()) {
            // 确保搜索路径上的所有结点能直接指向根父结点，节省后续路径上结点查找其父结点的时间
            parentMap.put(path.pop(), value);
        }
        return value;
    }

    public boolean isSameSet(T a, T b) {
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)) {
            return false;
        }
        return findFather(nodeMap.get(a)) == findFather(nodeMap.get(b));
    }

    public void union(T a, T b) {

        // 只能合并 nodes 中已存在的元素结点
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)) {
            return;
        }
        Node<T> aHead = findFather(nodeMap.get(a));
        Node<T> bHead = findFather(nodeMap.get(b));
        if (aHead != bHead) {
            Integer aSetSize = sizeMap.get(aHead);
            Integer bSetSize = sizeMap.get(bHead);
            Node<T> big = aSetSize > bSetSize ? aHead : bHead;
            Node<T> small = big == aHead ? bHead : aHead;
            parentMap.put(small, big);
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