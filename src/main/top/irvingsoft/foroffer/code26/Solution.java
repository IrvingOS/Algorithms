package top.irvingsoft.foroffer.code26;

import top.irvingsoft.structure.TreeNode;

/**
 * 树的子结构
 *
 * @author TimeChaser
 * @since 2021/12/1 12:42
 */
public class Solution {

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        return a != null && b != null && (dfs(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b));
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }

}
