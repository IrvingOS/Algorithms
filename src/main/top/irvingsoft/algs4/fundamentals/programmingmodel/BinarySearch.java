package top.irvingsoft.algs4.fundamentals.programmingmodel;

/**
 * 二分查找
 *
 * @author TimeChaser
 * @since 2021/12/7 20:43
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int count(int[] arr, int target) {
        int lo = indexOf(arr, target, true);
        int hi = indexOf(arr, target, false) - 1;
        if (lo <= hi && hi < arr.length && arr[lo] == target && arr[hi] == target) {
            return hi - lo + 1;
        }
        return 0;
    }

    public static int indexOf(int[] arr, int target, boolean lower) {
        int index = arr.length;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < arr[mid] || (lower && target <= arr[mid])) {
                hi = mid - 1;
                index = mid;
            } else {
                lo = mid + 1;
            }
        }
        return index;
    }

    public static int indexOf(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < arr[mid]) {
                hi = mid - 1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank(int[] arr, int target) {
        return indexOf(arr, target, true);
    }

}
