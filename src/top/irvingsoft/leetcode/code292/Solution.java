package top.irvingsoft.leetcode.code292;

/**
 * @author TimeChaser
 * @since 2021/10/20 9:15
 */
public class Solution {

    /**
     * 你是先手，由于每个人的拿法都是最优解，所以当你先手时剩下石子为 4 的倍数则你必输
     *
     * @param n Nums
     * @return boolean
     */
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(2));
        System.out.println(canWinNim(4));
    }
}
