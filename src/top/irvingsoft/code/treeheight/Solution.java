package top.irvingsoft.code.treeheight;

/**
 * 与二叉树高度相关的解法
 *
 * @author TimeChaser
 * @since 2021/8/7 16:53
 */
public class Solution {

    /**
     * 通过递归计算二叉树的最小高度
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author TimeChaser
     * @since 2021/8/7 17:33
     */
    public static int minHeightRecursion(Node head) {

        if (head == null) {
            return 0;
        }
        return computeMinHeightRecursion(head);
    }

    /**
     * 左树和右树都为空，直接返回根结点高度 1
     * <br>
     * 左树不为空或者右树不为空，继续递归计算左右树的高度，返回左右数中更小的高度 + 根结点高度 1
     *
     * @author TimeChaser
     * @since 2021/8/7 17:34
     */
    private static int computeMinHeightRecursion(Node head) {

        if (head.left == null && head.right == null) {
            return 1;
        }
        int leftHeight = Integer.MAX_VALUE;
        if (head.left != null) {
            leftHeight = computeMinHeightRecursion(head.left);
        }
        int rightHeight = Integer.MAX_VALUE;
        if (head.right != null) {
            rightHeight = computeMinHeightRecursion(head.right);
        }
        return 1 + Math.min(leftHeight, rightHeight);
    }

    /**
     * 思路：
     * 实时计算可能为叶子结点的高度，在确定为叶子结点后收集最小高度，然后进行相应的回溯。
     *
     * @author TimeChaser
     * @since 2021/8/7 21:32
     */
    public static int minHeightMorris(Node head) {

        if (head == null) {
            return 0;
        }

        Node mostRight, current = head;
        int curLevel = 0, minHeight = Integer.MAX_VALUE;
        while (current != null) {

            mostRight = current.left;
            if (mostRight != null) {

                int rightEdgeCount = 1;
                while (mostRight.right != null && mostRight.right != current) {
                    rightEdgeCount++;
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = current;
                    current = current.left;
                    curLevel++;
                    continue;
                } else {
                    if (mostRight.left == null) {
                        // 叶子结点
                        minHeight = Math.min(minHeight, curLevel);
                    }
                    curLevel -= rightEdgeCount;
                    mostRight.right = null;
                }
            } else {
                curLevel++;
            }
            current = current.right;
        }

        current = head;
        int rightEdgeHeight = 1;
        while (current.right != null) {
            current = current.right;
            rightEdgeHeight++;
        }
        if (current.left == null) {
            minHeight = Math.min(minHeight, rightEdgeHeight);
        }
        return minHeight;
    }

    public static void main(String[] args) {

        Node head = new Node(3);
        head.left = new Node(5);
//        head.right = new Node(7);
        head.left.right = new Node(2);
        head.left.right.left = new Node(2);
//        head.right.left = new Node(6);
//        head.right.right = new Node(8);
        System.out.println(minHeightMorris(head));
    }
}
