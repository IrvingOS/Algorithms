package top.irvingsoft.test.jvm;

/**
 * @description: 运行时内存测试
 *
 * 虚拟机参数：-Xms1024m -Xmx1024m -XX:+PrintGCDetails
 * 运行时，老年代和新生代堆空间的总和等于最大空间，元空间逻辑上存在，物理上不存在。
 *
 * @author: TimeChaser
 * @date: 2021/5/5 9:46
 */

public class RuntimeMemoryTest {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("max = " + maxMemory + " Byte\t" + maxMemory / 1024.0 / 1024 + " MB");
        System.out.println("total = " + totalMemory + " Byte\t" + totalMemory / 1024.0 / 1024 + " MB");
        System.out.println("free = " + freeMemory + " Byte\t" + freeMemory / 1024.0 / 1024 + " MB");
    }
}
