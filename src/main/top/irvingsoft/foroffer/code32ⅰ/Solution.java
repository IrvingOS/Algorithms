package top.irvingsoft.foroffer.code32ⅰ;

import top.irvingsoft.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *
 * @author TimeChaser
 * @since 2021/12/2 11:20
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            result[index++] = integer;
        }
        return result;
    }

}
