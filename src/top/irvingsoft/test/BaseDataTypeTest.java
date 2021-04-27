package top.irvingsoft.test;

public class BaseDataTypeTest {

    public static void main(String[] args) {

//        int i1 = 2147483648;
        int i2 = 2147483647;
        long l1 = 2147483648L;
        long l2 = i2;
        int i3 = (int) l1;
//        float f1 = 0.0;
        float f2 = 0.0f;
        double d1 = 0.0;
        double d2 = 0.0d;

        char c = 12123;
        c = (char) i2;
        System.out.println(c);
    }
}
