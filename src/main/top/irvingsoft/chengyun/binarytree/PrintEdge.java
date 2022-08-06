package top.irvingsoft.chengyun.binarytree;

/**
 * Page 113
 *
 * @author TimeChaser
 * @since 2021/9/24 14:37
 */
public class PrintEdge {

    public static int getHeight(Node head, int l) {
        if (head == null) {
            return l;
        }
        return Math.max(getHeight(head.left, l + 1), getHeight(head.right, l + 1));
    }

    public static void printEdge1(Node head) {

        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        for (Node[] nodes : edgeMap) {
            System.out.println(nodes[0].value + " ");
        }
        printLeafNotInMap(head, 0, edgeMap);
        for (int i = edgeMap.length - 1; i >= 0; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1].value + " ");
            }
        }
    }

    public static void printEdge2(Node head) {

        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        } else {
            printEdge2(head.left != null ? head.left : head.right);
        }
    }

    public static void printLeafNotInMap(Node head, int l, Node[][] edgeMap) {

        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null && head != edgeMap[l][0] && head != edgeMap[l][1]) {
            System.out.println(head.value + " ");
        }
        printLeafNotInMap(head.left, l + 1, edgeMap);
        printLeafNotInMap(head.right, l + 1, edgeMap);
    }

    public static void printLeftEdge(Node head, boolean print) {

        if (head == null) {
            return;
        }
        if (print || (head.left == null && head.right == null)) {
            System.out.println(head.value + " ");
        }
        printLeftEdge(head.left, print);
        printLeftEdge(head.right, print && head.left == null);
    }

    public static void printRightEdge(Node head, boolean print) {

        if (head == null) {
            return;
        }
        printRightEdge(head.left, print && head.right == null);
        printRightEdge(head.right, print);
        if (print || (head.left == null && head.right == null)) {
            System.out.println(head.value + " ");
        }
    }

    public static void setEdgeMap(Node head, int l, Node[][] edgeMap) {

        if (head == null) {
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
        edgeMap[l][1] = head;
        setEdgeMap(head.left, l + 1, edgeMap);
        setEdgeMap(head.right, l + 1, edgeMap);
    }

}
