package top.irvingsoft.test;

import java.util.ArrayList;

/**
 * @description: JProfiler 生成并分析 Dump
 *
 * 虚拟机参数：-Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author: TimeChaser
 * @date: 2021/5/5 10:32
 */
public class JProfilerTest {

   byte[]  array = new byte[1*1024];

    public static void main(String[] args) {

        ArrayList<JProfilerTest> jProfilerTestArrayList = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                jProfilerTestArrayList.add(new JProfilerTest());
                count ++;
            }
        } catch (Error e) {
            System.out.println("count" + count);
            e.printStackTrace();
        }
    }
}
