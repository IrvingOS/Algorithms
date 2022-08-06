package top.irvingsoft.algs4.fundamentals.stacksandqueues;

import org.junit.jupiter.api.Test;

class StacksTest {

    @Test
    void calculate() {
        assert Stacks.calculate("1 + 2.0 + 3.0 * 4.0 * 5 ") == 63;
        assert Stacks.calculate("1 -2 + 1") == 0;
    }

    @Test
    void calculateAddAndSub() {
        assert Stacks.calculateAddAndSub(" 1 + ( ( 2 + 3 ) - ( 4 + 5 ) ) ") == -3;
    }

    @Test
    void calculateCompleteExpression() {
        assert Stacks.calculateCompleteExpression("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )") == 101.0;
        assert Stacks.calculateCompleteExpression("( 1 + ( ( 2 + 3 ) - ( 4 + 5 ) ) )") == -3;
    }

    @Test
    void completeParentheses() {
        System.out.println(Stacks.completeParentheses("11 + 23 ) * 33 - 44 ) * 65 - 6 ) ) )"));
        System.out.println(Stacks.completeParentheses("11+23)*33-44)*65-6)))"));
    }

    @Test
    void isValidParentheses() {
        assert Stacks.isValidParentheses("");
        assert Stacks.isValidParentheses("()");
        assert Stacks.isValidParentheses("()[]{}");
        assert !Stacks.isValidParentheses("(]");
        assert !Stacks.isValidParentheses("([)]");
        assert Stacks.isValidParentheses("{[]}");
    }

    @Test
    void validateStackSequences() {
        assert Stacks.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                                             new Integer[]{4, 3, 2, 1, 0, 9, 8, 7, 6, 5});
        assert !Stacks.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                                              new Integer[]{4, 6, 8, 7, 5, 3, 2, 9, 0, 1});
        assert Stacks.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                                             new Integer[]{2, 5, 6, 7, 4, 8, 9, 3, 1, 0});
        assert Stacks.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                                             new Integer[]{4, 3, 2, 1, 0, 5, 6, 7, 8, 9});
        assert Stacks.validateStackSequences(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                                             new Integer[]{1, 2, 3, 4, 5, 6, 9, 8, 7, 0});
    }

}