package top.irvingsoft.test.basedatatype;

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
        int i4 = '\u8010';
        short s1 = (short) i4;

        /**
         *
         *
         * '\u8010'：
         *          char 类型，16 位
         *          8 * (16^3) + 1 * (16^1) = 32784;
         *
         * @author TimeChaser
         * @author TimeChaser
         * @since 2021/4/27 14:48
         */

        System.out.println('\u8010');
        System.out.println(i4);
        System.out.println(s1);

        Integer integer = 11;
    }

}
