package top.irvingsoft.exam.meituan.code1;

import java.util.Scanner;

/**
 * 小美的用户名
 *
 * @author TimeChaser
 * @since 2022/1/21 12:30
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            System.out.println(name);
            int length = name.length();
            if (length < 2 || !Character.isLetter(name.charAt(0))) {
                System.out.println("Wrong");
                continue;
            }
            boolean hasNum = false, valid = true;
            for (int j = 1; j < length; j++) {
                if (!Character.isLetterOrDigit(name.charAt(i))) {
                    valid = false;
                    break;
                }
                if (!hasNum && Character.isDigit(name.charAt(i))) {
                    hasNum = true;
                }
            }
            if (hasNum && valid) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }

}
