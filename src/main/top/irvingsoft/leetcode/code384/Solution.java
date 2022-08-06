package top.irvingsoft.leetcode.code384;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class RandomShuffle {

    private final int[] nums;
    private final Random random;

    public RandomShuffle(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        List<Integer> list = Arrays.stream(this.nums).boxed().collect(Collectors.toList());
        int i = 0;
        int[] shuffled = new int[this.nums.length];
        while (i < this.nums.length) {
            int index = random.nextInt(list.size());
            shuffled[i++] = list.remove(index);
        }
        return shuffled;
    }

    public int[] shuffleAnother() {
        int[] shuffled = Arrays.copyOf(this.nums, this.nums.length);
        for (int i = 0; i < shuffled.length; i++) {
            int j = i + random.nextInt(shuffled.length - i);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }

}

/**
 * 打乱数组
 *
 * @author TimeChaser
 * @since 2021/11/22 11:39
 */
public class Solution {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(100));
        List<Integer> list = new ArrayList<>();
    }

}