package top.irvingsoft.leetcode.code65;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效数字
 *
 * @author TimeChaser
 * @since 2021/11/4 8:55
 */
public class Solution {

    public static boolean isNumberViolence(String s) {
        boolean hasE = false;
        boolean hasNum = false;
        boolean isFloat = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // +- 只能出现在第一位或者 e 之后
            if ((ch == '-' || ch == '+') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                continue;
            } else if ((ch == 'e' || ch == 'E') && !hasE && hasNum) {
                // 只存在一个 e，前面必须有数字，后面也必须有数字
                hasE = true;
                // 此时指示后面有无数字
                hasNum = false;
            } else if (ch == '.' && !isFloat && !hasE) {
                // 只存在一个小数点，而且在 e 之前
                isFloat = true;
            } else if (Character.isDigit(ch)) {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }

    public static boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumberViolence("2"));
        System.out.println(isNumberViolence("0089"));
        System.out.println(isNumberViolence("-0.1"));
        System.out.println(isNumberViolence("+3.14"));
        System.out.println(isNumberViolence("4."));
        System.out.println(isNumberViolence("-.9"));
        System.out.println(isNumberViolence("2.e10"));
        System.out.println(isNumberViolence("-90E3"));
        System.out.println(isNumberViolence("3e+7"));
        System.out.println(isNumberViolence("+6e-1"));
        System.out.println(isNumberViolence("53.5e93"));
        System.out.println(isNumberViolence("-123.456e789"));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1a"));
        System.out.println(isNumber("1e"));
        System.out.println(isNumber("e3"));
        System.out.println(isNumber("99e2.5"));
        System.out.println(isNumber("--6"));
        System.out.println(isNumber("-+3"));
        System.out.println(isNumber("95a54e53"));
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_ILLEGAL
    }
}
