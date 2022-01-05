package top.irvingsoft.algs4.fundamentals.analysisofalgorithms;

/**
 * @author TimeChaser
 * @since 2022/1/5 10:39
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(count(new int[]{-9, -9, -8, -8, -7, -6, -5, -5, -3, -3, -1, 0, 0, 1, 3, 3, 3, 4, 7, 7}));
    }

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((long) a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
