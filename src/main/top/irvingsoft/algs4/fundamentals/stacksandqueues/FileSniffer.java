package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.io.File;

/**
 * 文件嗅探器
 *
 * @author TimeChaser
 * @since 2021/12/20 14:53
 */
public class FileSniffer {

    public static void main(String[] args) {
        File file = null;
        if (args.length == 0) {
            file = new File(System.getProperty("user.dir"));
        } else {
            file = new File(args[0]);
        }
        FileSniffer sniffer = new FileSniffer();
        sniffer.snifferRecursion(file);
        sniffer.snifferQueue(file);
    }

    public void snifferQueue(File file) {
        sniff(file);
    }

    public void snifferRecursion(File file) {
        sniff(file, 0);
    }

    private String fileString(File file, int depth) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            s.append("    ");
        }
        s.append("- ");
        s.append(file.getName());
        return s.toString();
    }

    private void sniff(File file) {
        Queue<File> files = new Queue<>();
        Queue<Integer> depths = new Queue<>();
        files.enqueue(file);
        depths.enqueue(0);
        while (!files.isEmpty()) {
            File cur = files.dequeue();
            Integer depth = depths.dequeue();
            System.out.println(fileString(cur, depth));
            if (cur.isDirectory()) {
                for (File child : cur.listFiles()) {
                    files.enqueue(child);
                    depths.enqueue(depth + 1);
                }
            }
        }
    }

    private void sniff(File file, int depth) {
        System.out.println(fileString(file, depth));
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                sniff(child, depth + 1);
            }
        }
    }

}
