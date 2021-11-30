package top.irvingsoft.leetcode.code230;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TimeChaser
 * @since 2021/11/18 10:10
 */
public class SecondSolution {

    public int kthSmallest(TreeNode root, int k) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        return binarySearchTree.kthSmallest(k);
    }
}

@SuppressWarnings("all")
class BinarySearchTree {
    private final TreeNode               root;
    private final Map<TreeNode, Integer> nodeNum;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
        this.nodeNum = new HashMap<>();
        countNodeNum(this.root);
    }

    public int kthSmallest(int k) {
        TreeNode node = this.root;
        while (node != null) {
            int left = getNodeNum(node.left);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            } else if (left == k - 1) {
                break;
            } else {
                node = node.left;
            }
        }
        return node.val;
    }

    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
        return nodeNum.get(node);
    }

    private int getNodeNum(TreeNode node) {
        return nodeNum.getOrDefault(node, 0);
    }
}