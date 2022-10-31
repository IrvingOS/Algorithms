package top.irvingsoft.leetcode.code481;

/*
 * 神奇字符串
 */
public class Solution {

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("1");
        int i = 0;
        int j = 0;
        int cur = 1;
        int count = 1;
        int result = 1;
        while (++i < n) {
            if (count == sb.charAt(j) - '0') {
                count = 0;
                j++;
                cur = cur == 2 ? 1 : 2;
            }
            sb.append(cur);
            count++;
            result += cur == 1 ? 1 :0;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(6));
    }
}
