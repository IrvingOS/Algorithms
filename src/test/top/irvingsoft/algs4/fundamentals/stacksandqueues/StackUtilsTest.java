package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

class StackUtilsTest {

    @Test
    void calculateAddAndSub() {
        assert StackUtils.calculateAddAndSub(" 1 + ( ( 2 + 3 ) - ( 4 + 5 ) ) ") == -3;
    }

    @Test
    void calculateCompleteExpression() {
        assert StackUtils.calculateCompleteExpression("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )") == 101.0;
        assert StackUtils.calculateCompleteExpression("( 1 + ( ( 2 + 3 ) - ( 4 + 5 ) ) )") == -3;
    }

    @Test
    void isValidParentheses() {
        assert StackUtils.isValidParentheses("");
        assert StackUtils.isValidParentheses("()");
        assert StackUtils.isValidParentheses("()[]{}");
        assert !StackUtils.isValidParentheses("(]");
        assert !StackUtils.isValidParentheses("([)]");
        assert StackUtils.isValidParentheses("{[]}");
    }

    @Test
    void validateStackSequences() {
        assert StackUtils.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{4, 3, 2, 1, 0, 9, 8, 7, 6, 5});
        assert !StackUtils.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{4, 6, 8, 7, 5, 3, 2, 9, 0, 1});
        assert StackUtils.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{2, 5, 6, 7, 4, 8, 9, 3, 1, 0});
        assert StackUtils.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{4, 3, 2, 1, 0, 5, 6, 7, 8, 9});
        assert StackUtils.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new Integer[]{1, 2, 3, 4, 5, 6, 9, 8, 7, 0});
    }
}