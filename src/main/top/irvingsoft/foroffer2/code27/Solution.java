package top.irvingsoft.foroffer2.code27;

/**
 * 二叉树的镜像
 *
 * @author TimeChaser
 * @since 2021/12/1 9:20
 */
public class Solution {

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        dfs(node.left);
        dfs(node.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }
}
