package top.irvingsoft.code.morris;

/**
 * Morris 遍历二叉树
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author TimeChaser
 * @date 2021/8/6 21:59
 */

public class Solution {

    /**
     * 递归遍历二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author TimeChaser
     * @date 2021/8/7 0:08
     */
    public static void recursionProcess(Node head) {

        if (head == null) {
            return;
        }

        // 先序
        recursionProcess(head.left);
        // 中序
        recursionProcess(head.right);
        // 后序
        System.out.println(head.value + " ");
    }

    public static void morris(Node head) {

        if (head == null) {
            return;
        }
        Node current = head;
        Node mostRight = null;
        while (current != null) {

            // 判断是否存在左树
            mostRight = current.left;
            if (mostRight != null) {

                // 在有左树的情况下
                // 找到 current 左树上真实的最右节点
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                // 此时 mostRight 一定是 current 左树上的最右节点
                if (mostRight.right == null) {

                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(6);
        head.left = new Node(1);
        head.right = new Node(8);
        head.left.left = new Node(9);
        head.left.right = new Node(3);
        head.left.left.left = new Node(7);
        head.left.left.right = new Node(2);
        head.left.right.left = new Node(5);
        head.left.right.right = new Node(0);
        head.right.left = new Node(90);
        head.right.right = new Node(30);
        head.right.left.left = new Node(70);
        head.right.left.right = new Node(20);
        head.right.right.left = new Node(50);
        head.right.right.right = new Node(10);
        recursionProcess(head);
    }
}
