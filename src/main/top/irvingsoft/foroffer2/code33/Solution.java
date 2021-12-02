package top.irvingsoft.foroffer2.code33;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author TimeChaser
 * @since 2021/12/2 11:27
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        int min = postorder[0];
        int max = postorder[0];
        for (int i : postorder) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return verify(postorder, 0, postorder.length - 1, min, max);
    }

    private boolean verify(int[] postorder, int left, int right, int min, int max) {
        if (left >= right) {
            return true;
        }
        if (postorder[right] < min || postorder[right] > max) {
            return false;
        }
        int leftEnd = -1;
        int rightMax = Integer.MIN_VALUE;
        boolean leftEndFound = false;
        for (int i = left - 1; i < right; i++) {
            if (!leftEndFound && postorder[i + 1] >= postorder[right]) {
                leftEnd = i;
                leftEndFound = true;
            }
            rightMax = Math.max(rightMax, postorder[i + 1]);
        }
        return verify(postorder, left, leftEnd, min, postorder[right])
                && verify(postorder, leftEnd + 1, right - 1, postorder[right], rightMax);
    }
}
