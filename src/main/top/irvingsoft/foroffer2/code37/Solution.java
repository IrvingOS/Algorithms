package top.irvingsoft.foroffer2.code37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化二叉树
 *
 * @author TimeChaser
 * @since 2021/12/3 10:37
 */
public class Solution {

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node != null ? Integer.toString(node.val) : "null");
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if ("null".equals(list.get(i))) {
                if (i * 2 + 1 < list.size() && !"null".equals(list.get(i * 2 + 1))) {
                    list.add(i * 2 + 1, "null");
                }
                if (i * 2 + 2 < list.size() && !"null".equals(list.get(i * 2 + 2))) {
                    list.add(i * 2 + 2, "null");
                }
            }
        }
//        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(']');
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        if (values.length == 0 || "null".equals(values[0])) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(values[0]));
        build(head, values, 0);
        return head;
    }

    private void build(TreeNode node, String[] values, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (!"null".equals(values[leftIndex])) {
            node.left = new TreeNode(Integer.parseInt(values[leftIndex]));
            build(node.left, values, leftIndex);
        }
        if (!"null".equals(values[rightIndex])) {
            node.right = new TreeNode(Integer.parseInt(values[rightIndex]));
            build(node.right, values, rightIndex);
        }
    }
}
