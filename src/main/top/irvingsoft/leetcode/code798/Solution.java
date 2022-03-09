package top.irvingsoft.leetcode.code798;

/**
 * 得分最高的最小轮调
 * <p>
 * 注释不一定准确
 *
 * @author TimeChaser
 * @since 2022/3/9 12:30 PM
 */
public class Solution {

    /**
     * 前缀和之差分数组
     * 1. 规律发现, 索引为i时, nums[i] 在k为 [(i + 1) mod length, (length - nums[i] + i + 1) mod length] 时当前值可以获得得分, length为数组长度
     * 2. 常规思路, 遍历nums中每一个元素, 为满足条件的k计数加1(最后根据前后k的差值获取结果), 但时间复杂度为O(n^2)不满足要求
     * 3. 常规思路是直接计算前缀和, 由于k的区间较大(每个nums[i]都会得到一个符合的k区间), 这里使用差分数组
     * 注: 不懂差分数组的可以先学习一下 https://blog.csdn.net/qq_31601743/article/details/105352885
     */
    public int bestRotation(int[] nums) {
        int length = nums.length;
        //差分数组, 默认分数都是0
        int[] diffScoreArr = new int[length];
        //预处理差分数组
        for (int i = 0; i < length; i++) {
            //nums[i] 可以得分的k区间为[i + 1, length - nums[i] + i + 1]
            int left = (i + 1) % length;
            //差分数组为区间[a, b]加1可以转换为 a位置加1, b+1位置减1(超过右边界则取模). 这里right代表b+1位置
            int right = (length - nums[i] + i + 1) % length;
            //为a位置加1, b+1位置减1
            diffScoreArr[left]++;
            diffScoreArr[right]--;
            //若[a, b]跨右边界, 则需要为[0, a-1]加回1
            if (left >= right) {
                diffScoreArr[0]++;
            }
        }
        //计算差分数组中出现最大值的位置
        int bestIdx = 0;
        //初始差分数组为0, 若有得分, 则maxScore必定>0
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < length; i++) {
            score += diffScoreArr[i];
            if (score > maxScore) {
                score = maxScore;
                bestIdx = i;
            }
        }
        return bestIdx;
    }
}
