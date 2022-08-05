package top.irvingsoft.leetcode.code173;

import top.irvingsoft.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树迭代器
 *
 * @author TimeChaser
 * @since 2021/11/28 16:30
 */
public class Solution {
}

class BSTIterator {

    private final Deque<TreeNode> stack;
    private       TreeNode        cur;

    public BSTIterator(TreeNode root) {
        this.cur = root;
        this.stack = new LinkedList<>();
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int next = cur.val;
        cur = cur.right;
        return next;
    }
}