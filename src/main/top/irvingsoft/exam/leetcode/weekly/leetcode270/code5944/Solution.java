package top.irvingsoft.exam.leetcode.weekly.leetcode270.code5944;

/**
 * 从二叉树一个结点到另一个结点每一步的方向
 *
 * @author TimeChaser
 * @since 2021/12/5 15:21
 */
public class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        StringBuilder leftRoute = getRoute(root, startValue, new StringBuilder());
        StringBuilder rightRoute = getRoute(root, destValue, new StringBuilder());
        for (int i = 0; i < leftRoute.length() && i < rightRoute.length(); ) {
            if (leftRoute.charAt(i) == rightRoute.charAt(i)) {
                leftRoute.deleteCharAt(i);
                rightRoute.deleteCharAt(i);
            } else {
                break;
            }
        }
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < leftRoute.length(); i++) {
            route.append("U");
        }
        for (int i = 0; i < rightRoute.length(); i++) {
            route.append(rightRoute.charAt(i));
        }
        return route.toString();
    }

    private StringBuilder getRoute(TreeNode node, int targetValue, StringBuilder route) {
        if (node.val == targetValue) {
            return route;
        }
        if (node.left != null) {
            route.append("L");
            StringBuilder leftRoute = getRoute(node.left, targetValue, route);
            if (leftRoute.length() != 0) {
                return leftRoute;
            }
            route.deleteCharAt(route.length() - 1);
        }
        if (node.right != null) {
            route.append("R");
            StringBuilder rightRoute = getRoute(node.right, targetValue, route);
            if (rightRoute.length() != 0) {
                return rightRoute;
            }
            route.deleteCharAt(route.length() - 1);
        }
        return new StringBuilder();
    }
}
