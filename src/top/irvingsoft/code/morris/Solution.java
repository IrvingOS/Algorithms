package top.irvingsoft.code.morris;

/**
 * Morris 遍历二叉树
 * <br>
 * 时间复杂度：O(n)
 * <br>
 * 空间复杂度：O(1)
 * <p>
 * 二叉树的遍历：
 * <br>
 * 先序、中序、后序的主要区分就是根结点输出的部位，遍历的结点先后顺序都是相同的。整个遍历遵循先左再右的原则，左边遍历结束后，才会前往右边。
 * <p>
 * 先序：访问到一个结点后，即刻输出该结点的值，并继续遍历其左右子树。(根左右)
 * <br>
 * 中序：访问到一个结点后，将其暂存，遍历完左子树后，再输出该结点的值，然后遍历右子树。(左根右)
 * <br>
 * 后序：访问到一个结点后，将其暂存，遍历完左子树后，再输出该结点的值，然后遍历右子树。(左根右)
 *
 * @author TimeChaser
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
     * @author TimeChaser
     * @date 2021/8/7 0:08
     */
    public static void recursionPre(Node head) {

        if (head == null) {
            return;
        }

        System.out.print(head.value + " ");
        recursionPre(head.left);
        recursionPre(head.right);
    }

    public static void recursionIn(Node head) {

        if (head == null) {
            return;
        }

        recursionIn(head.left);
        System.out.print(head.value + " ");
        recursionIn(head.right);
    }

    public static void recursionPost(Node head) {

        if (head == null) {
            return;
        }

        recursionPost(head.left);
        recursionPost(head.right);
        System.out.print(head.value + " ");
    }

    public static void morrisPre(Node head) {

        if (head == null) {
            return;
        }
        Node mostRight, current = head;
        while (current != null) {

            // 判断是否存在左树
            mostRight = current.left;
            if (mostRight != null) {

                // 在有左树的情况下
                // 找到 current 左树上真实的最右结点
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                // 此时 mostRight 一定是 current 左树上的最右结点
                if (mostRight.right == null) {
                    // 第一次回到自己
                    // 存在左树，在 current 左移前打印
                    System.out.print(current.value + " ");
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    // 第二次回到自己
                    mostRight.right = null;
                }
            } else {
                // current 不存在左树，第一次也是最后一次来到这个结点
                // 不存在左树，在右移前打印
                System.out.print(current.value + " ");
            }
            current = current.right;
        }
    }

    public static void morrisIn(Node head) {

        if (head == null) {
            return;
        }
        Node mostRight, current = head;
        while (current != null) {

            // 判断是否存在左树
            mostRight = current.left;
            if (mostRight != null) {

                // 在有左树的情况下
                // 找到 current 左树上真实的最右结点
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                // 此时 mostRight 一定是 current 左树上的最右结点
                if (mostRight.right == null) {
                    // 第一次回到自己
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    // 第二次回到自己
                    mostRight.right = null;
                }
            }
            // 不存在左树，此时是第一次也是最后一次经过自己
            // 存在左树，此时是最后一次经过自己
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public static void morrisPost(Node head) {

        if (head == null) {
            return;
        }
        Node mostRight, current = head;
        while (current != null) {

            // 判断是否存在左树
            mostRight = current.left;
            if (mostRight != null) {

                // 在有左树的情况下
                // 找到 current 左树上真实的最右结点
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                // 此时 mostRight 一定是 current 左树上的最右结点
                if (mostRight.right == null) {
                    // 第一次回到自己
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    // 第二次回到自己
                    mostRight.right = null;
                    // 打印左树的右边界
                    printEdge(current.left);
                }
            }
            current = current.right;
        }
        // 打印整棵树的右边界
        printEdge(head);
    }

    /**
     * 打印右边界
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/7 12:48
     */
    private static void printEdge(Node head) {
        Node tail = reverseEdgeNormal(head);
        Node current = tail;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.right;
        }
        assert tail != null;
        reverseEdgeRecursion(tail);
    }

    /**
     * 递归翻转右边界
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/7 16:03
     */
    private static Node reverseEdgeRecursion(Node head) {

        if (head.right == null) {
            return head;
        }

        Node last = reverseEdgeRecursion(head.right);
        head.right.right = head;
        head.right = null;
        return last;
    }

    /**
     * 普通翻转右边界
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/7 16:03
     */
    private static Node reverseEdgeNormal(Node head) {

        Node last = null, current = head;
        while (current != null) {
            Node temp = current.right;
            current.right = last;
            last = current;
            current = temp;
        }
        return last;
    }

    /**
     * 判断是否是 二叉搜索树，二叉排序树（Binary Search Tree）
     * <p>
     * 二叉搜索树规则：
     * <br>
     * 1. 若它的左子树不为空，则其左子树上的所有值小于其根结点的值
     * <br>
     * 2. 若它的右子树不为空，则其右子树上的所有值大于其根结点的值
     * <p>
     * BST 的规则判断流程正好与中序遍历的流程相同
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/7 16:02
     */
    public static boolean isBinarySearchTree(Node head) {

        if (head == null) {
            return true;
        }
        Node mostRight, current = head;
        Integer pre = null;
        while (current != null) {
            mostRight = current.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != current) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = current;
                    current = current.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (pre != null && pre >= current.value) {
                return false;
            }
            pre = current.value;
            current = current.right;
        }
        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(3);
        head.left = new Node(5);
        head.right = new Node(7);
        head.left.right = new Node(2);
        head.right.left = new Node(6);
        head.right.right = new Node(8);
        recursionPre(head);
        System.out.println();
        morrisPre(head);
        System.out.println();
        recursionIn(head);
        System.out.println();
        morrisIn(head);
        System.out.println();
        recursionPost(head);
        System.out.println();
        morrisPost(head);
    }
}
