package top.irvingsoft.leetcode.code1518;

/**
 * 换酒问题
 *
 * @author TimeChaser
 * @since 2021/12/17 10:42
 */
public class Solution {

    public int numWaterBottlesIteration(int numBottles, int numExchange) {
        int bottle = numBottles;
        int result = numBottles;
        while (bottle >= numBottles) {
            bottle -= numBottles;
            bottle++;
            result++;
        }
        return result;
    }

    public int numWaterBottlesMath(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }

    public int numWaterBottlesRecursion(int numBottles, int numExchange) {
        return numBottles + f(numBottles, numExchange);
    }

    private int f(int emptyBottles, int numExchange) {
        if (emptyBottles < numExchange) {
            return 0;
        }
        return emptyBottles / numExchange + f(emptyBottles / numExchange + emptyBottles % numExchange, numExchange);
    }

}
