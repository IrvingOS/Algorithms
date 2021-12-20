package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Tree Command to Sniff files in the directory.
 *
 * @author TimeChaser
 * @since 2021/12/20 15:40
 */
public class Tree {

    private static String         rootPath   = null;
    private static boolean        directOnly = false;
    private static boolean        hidden     = false;
    private static int            level      = -1;
    private static FilenameFilter filter     = null;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-p": {
                    i++;
                    rootPath = args[i];
                }
                break;
                case "-d": {
                    directOnly = true;
                }
                break;
                case "-h": {
                    hidden = true;
                }
                break;
                case "-l": {
                    i++;
                    level = Integer.parseInt(args[i]);
                }
                break;
                default:
                    break;
            }
        }
        if (rootPath == null || rootPath.length() == 0) {
            rootPath = System.getProperty("user.dir");
        }
        filter = (dir, name) -> {
            boolean accept = true;
            File file = new File(dir, name);
            if (directOnly) {
                accept = file.isDirectory();
            }
            if (!hidden) {
                accept &= !file.isHidden();
            }
            return accept;
        };
        File file = new File(rootPath);
        printTree(file);
    }

    private static void printTree(File file) {
        System.out.println(file.getAbsoluteFile());
        printTree(file, "", 0);
    }

    private static void printTree(File file, String prefix, int depth) {
        if (level != -1 && depth >= level) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles(filter);
            String curPrefix = null;
            String nextPrefix = null;
            for (int i = 0; i < files.length; i++) {
                if (i + 1 < files.length) {
                    curPrefix = prefix + " ├─";
                    nextPrefix = prefix + " │ ";
                } else {
                    curPrefix = prefix + " └─";
                    nextPrefix = prefix + "    ";
                }
                System.out.println(curPrefix + files[i].getName());
                printTree(files[i], nextPrefix, depth + 1);
            }
        }
    }
}
