package top.irvingsoft.code.bfprt;

/**
 * BFPRT 算法
 * <br>
 * 找出无序数组中第 k 小的数（从 1 开始）
 * <br>
 * 其他问法：找出前 k 小数组成的数组（先找出第 k 小的数，然后遍历原数组找出小于第 k 小的数的所有数）
 * <p/>
 * BFPRT 算法，注重的是 pivot 的选举，
 * 通过合理的选举 pivot 以排除更多无效数据的比较过程，
 * 从而避免快速排序中最坏情况的发生
 *
 * @author TimeChaser
 * @date 2021/8/4 9:31
 */
public class Solution {

    /**
     * 类快排算法
     * <br>
     * 在划分界限后，只选择一边进行下一步比较
     * <br>
     * 时间复杂度期望值 O(n)
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 10:51
     */
    public static int likeQuickSort(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        return processQuickSort(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * 类快排处理
     * <br>
     * 随机选举一个划分值
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 10:52
     */
    private static int processQuickSort(int[] arr, int left, int right, int index) {

        // left == right == index
        if (left == right) {
            return arr[left];
        }
        // right - left + 1 是为了保证 pivot >= left && pivot <= right
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] partition = partition(arr, left, right, pivot);

        if (index >= partition[0] && index <= partition[1]) {
            return arr[index];
        } else if (index < partition[0]) {
            return processQuickSort(arr, left, partition[0] - 1, index);
        } else {
            return processQuickSort(arr, partition[1] + 1, right, index);
        }
    }

    /**
     * 根据划分值，小于划分值的向左移，大于划分值的向右移
     * <br>
     * 移完后，中间区域是划分值
     * <p/>
     * 区间扩大一格是为了让 pivot 与数组中的每一个数字都进行一次比较（包括自身）
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 16:44
     */
    private static int[] partition(int[] arr, int left, int right, int pivot) {

        int less = left - 1;
        int more = right + 1;
        int current = left;
        while (current < more) {
            if (arr[current] < pivot) {
                swap(arr, ++less, current++);
            } else if (arr[current] > pivot) {
                swap(arr, current, --more);
            } else {
                current++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static int useBfprt(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * Bfprt 算法
     * <br>
     * 重点关注了如何选举一个划分值，以排除更多无用数据
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 16:41
     */
    private static int bfprt(int[] arr, int left, int right, int index) {

        if (left == right) {
            return arr[left];
        }
        int pivot = medianOfMedians(arr, left, right);
        int[] partition = partition(arr, left, right, pivot);

        if (index >= partition[0] && index <= partition[1]) {
            return arr[index];
        } else if (index < partition[0]) {
            return bfprt(arr, left, partition[0] - 1, index);
        } else {
            return bfprt(arr, partition[1] + 1, right, index);
        }
    }

    /**
     * 在中位数数组中选出中位数
     * <br>
     * 1. 划分成长度为 5 的子数组
     * <br>
     * 2. 对每个子数组排序后获取每个子数组的中位数并组成数组
     * <br>
     * 3. 将中位数组成的数组利用 bfprt 算法，找出其中位数，不用管其中的过程，所得即为精心挑选的划分值
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 16:46
     */
    private static int medianOfMedians(int[] arr, int left, int right) {

        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] mArr = new int[size / 5 + offset];

        for (int team = 0; team < mArr.length; team++) {
            int teamFirst = left + team * 5;
            mArr[team] = getMedian(arr, teamFirst, Math.min(right, teamFirst + 4));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int left, int right) {
        insertSort(arr, left, right);
        return arr[(left + right) / 2];
    }

    /**
     * 插入排序
     *
     * @author TimeChaser
     * @author TimeChaser
     * @date 2021/8/4 16:51
     */
    private static void insertSort(int[] arr, int left, int right) {

        for (int i = left + 1; i < arr.length && i <= right; i++) {

            int temp = arr[i];
            int j = i;
            while (j > left && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {3, 5, 2, 4, 6, 1};
        System.out.println(likeQuickSort(ints, 4));
        System.out.println(useBfprt(ints, 4));
//        insertSort(ints, 0, 5);
//        System.out.println(Arrays.toString(ints));
    }
}
