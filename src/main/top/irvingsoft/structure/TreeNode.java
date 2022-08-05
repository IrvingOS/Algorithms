package top.irvingsoft.structure;

/**
 * 树结点
 *
 * @author TimeChaser
 * @since 2021/11/13 9:40
 */
public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
