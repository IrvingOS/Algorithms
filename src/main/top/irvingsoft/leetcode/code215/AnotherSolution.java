package top.irvingsoft.leetcode.code215;

/**
 * 基于堆排序的选择算法
 *
 * @author TimeChaser
 * @since 2021/11/15 15:15
 */
public class AnotherSolution {

    public static void main(String[] args) {
        System.out.println(new AnotherSolution().findKthLargest(new int[]{4, 2, 1, 6, 3, 9, 7, 5, 8}, 4));
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
