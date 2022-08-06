package top.irvingsoft.leetcode.code106;

/**
 * 树结点
 *
 * @author TimeChaser
 * @since 2021/11/13 9:40
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
