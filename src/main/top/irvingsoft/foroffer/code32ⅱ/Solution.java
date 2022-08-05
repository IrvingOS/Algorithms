package top.irvingsoft.foroffer.code32ⅱ;

import top.irvingsoft.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 ⅱ
 *
 * @author TimeChaser
 * @since 2021/12/2 11:24
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Queue<TreeNode>> queue = new ArrayDeque<>();
        Queue<TreeNode> level = new ArrayDeque<>();
        level.offer(root);
        queue.offer(level);
        while (!queue.isEmpty()) {
            level = queue.poll();
            List<Integer> resultLevel = new ArrayList<>();
            Queue<TreeNode> nextLevel = new ArrayDeque<>();
            while (!level.isEmpty()) {
                TreeNode node = level.poll();
                resultLevel.add(node.val);
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
            if (!nextLevel.isEmpty()) {
                queue.offer(nextLevel);
            }
            result.add(resultLevel);
        }
        return result;
    }
}
