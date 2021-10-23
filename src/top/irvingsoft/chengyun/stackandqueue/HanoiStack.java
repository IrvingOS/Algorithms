package top.irvingsoft.chengyun.stackandqueue;

import java.util.Stack;

enum Action {
    No, LToM, MToL, MToR, RToM
}

/**
 * Page 32
 * <p>
 * 1. 递归求解：
 * <p>
 * 从下至上依次把每层移到目标塔，在移动每层之前，要先把当前层之上的所有层通过中间塔移到目标塔，
 * <p>
 * 再把当前层移到中间塔，然后通过中间塔复原目标答上的所有层到原塔，最后把当前层移到目标塔。依此递归移动当前层之上的每一层。
 * <p>
 * 2. 栈求解：
 * <p>
 * 每个栈首先压入最大整数，然后把代表层数的数组压入原栈（左栈）
 * <p>
 * 三个栈之间只存在四个动作 L -> M、M -> L、M -> R、R -> M
 * <p>
 * 其中相邻动作不可逆（最少移动次数）、小压大（数值小的层在数值大的层之上）
 * <p>
 * 在遵循上述两个原则的条件下循环上述四个动作（每次循环只会执行符合条件的两个动作），直到目标栈的大小为层数 + 1（包含最大整数）
 *
 * @author TimeChaser
 * @date 2021/8/8 15:53
 */
public class HanoiStack {

    public static void hanoiProblem1(int num, String left, String mid, String right) {

        if (num < 1) {
            return;
        }
        int steps = processRecursion(num, left, mid, right, left, right);
        System.out.println("It will move " + steps + " steps");
    }

    public static int processRecursion(int num, String left, String mid, String right,
                                       String from, String to) {

        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {

            String another = (from.equals(left)) || (to.equals(left)) ? right : left;
            int part1 = processRecursion(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = processRecursion(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            // 移动当前层之上的所有塔到目标塔
            int part1 = processRecursion(num - 1, left, mid, right, from, to);
            int part2 = 1;
            // 移动当前层到中间塔
            System.out.println("Move " + num + " from " + from + " to " + mid);
            // 复原目标塔上的所有层到原塔
            int part3 = processRecursion(num - 1, left, mid, right, to, from);
            int part4 = 1;
            // 移动中间塔上的当前层到目标塔
            System.out.println("Move " + num + " from " + mid + " to " + to);
            // 继续移动原塔上的后续层到目标塔
            int part5 = processRecursion(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void hanoiProblem2(int num, String left, String mid, String right) {

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> midStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        leftStack.push(Integer.MAX_VALUE);
        midStack.push(Integer.MAX_VALUE);
        rightStack.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            leftStack.push(i);
        }
        Action[] record = {Action.No};
        int steps = 0;
        while (rightStack.size() != num + 1) {
            // 此处的移动顺序没有影响，通过 fStackTotStack 函数的内条件判断，符合条件的都是有效移动
            steps += fStackTotStack(record, Action.MToL, Action.LToM, leftStack, midStack, left, mid);
            steps += fStackTotStack(record, Action.LToM, Action.MToL, midStack, leftStack, mid, left);
            steps += fStackTotStack(record, Action.RToM, Action.MToR, midStack, rightStack, mid, right);
            steps += fStackTotStack(record, Action.MToR, Action.RToM, rightStack, midStack, right, mid);
        }
        System.out.println("It will move " + steps + " steps");
    }

    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct,
                                     Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        // 相邻不可逆 && 小压大
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

        hanoiProblem2(3, "left", "mid", "right");
    }
}