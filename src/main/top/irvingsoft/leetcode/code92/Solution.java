package top.irvingsoft.leetcode.code92;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/19 10:57
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = dfs(left, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = leftNode;
                    curNode.right = rightNode;
                    result.add(curNode);
                }
            }
        }
        return result;
    }
}
