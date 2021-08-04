package top.irvingsoft.test.jvm;

import java.util.UUID;

/**
 * @author TimeChaser
 * GC 测试
 * <p>
 * 虚拟机参数：-Xms8m -Xmx8m -XX:+PrintGCDetails
 * @date 2021/5/5 9:48
 */
public class GCTest {

    public static void main(String[] args) {

        String str = "IrvingSoft";

        while (true) {
            str += UUID.randomUUID().toString();
        }
    }
}
