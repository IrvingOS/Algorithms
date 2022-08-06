package top.irvingsoft.foroffer.code46;

/**
 * 把数字翻译成字符串
 *
 * @author TimeChaser
 * @since 2021/12/5 18:45
 */
public class Solution {

    private int count = 0;

    public int translateNumMath(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int temp = x * 10 + y;
            int c = (temp >= 10 && temp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    public int translateNumMine(int num) {
        dfs(Integer.toString(num), 0);
        return count;
    }

    private void dfs(String string, int index) {
        if (index == string.length()) {
            count++;
            return;
        }
        int sum = 0;
        for (int i = index; i < string.length(); i++) {
            sum = sum * 10 + string.charAt(i) - '0';
            if (sum > 25) {
                break;
            }
            dfs(string, i + 1);
            if (string.charAt(i) == '0') {
                break;
            }
        }
    }

}
