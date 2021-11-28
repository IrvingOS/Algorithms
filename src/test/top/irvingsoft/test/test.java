package top.irvingsoft.test;

/**
 * @author TimeChaser
 * @since 2021/11/28 11:16
 */
public class test {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int a = 1;
        int b = 2;
        return a > b ? a : (a = b);
    }
}
