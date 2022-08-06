package top.irvingsoft.leetcode.code133;

import top.irvingsoft.structure.Node;

import java.util.*;

/**
 * 克隆图
 *
 * @author TimeChaser
 * @since 2022/1/13 15:56
 */
public class Solution {

    private final Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbor));
        }
        return clone;
    }

}
