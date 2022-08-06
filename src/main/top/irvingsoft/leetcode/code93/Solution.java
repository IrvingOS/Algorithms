package top.irvingsoft.leetcode.code93;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 复原 IP 地址
 *
 * @author TimeChaser
 * @since 2021/11/4 11:33
 */
public class Solution {

    private static final int SEG_COUNT = 4;
    private static final List<String> ans = new ArrayList<>();
    private static final int[] segments = new int[SEG_COUNT];

    public static void backtrack(String s, int index, int remain, List<String> combination, Set<String> result) {
        if (remain == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < combination.size(); i++) {
                sb.append(combination.get(i));
                if (i != combination.size() - 1) {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = null;
            if (remain == 1) {
                sub = s.substring(index);
            } else {
                sub = s.substring(index, i);
            }
            if (!isValid(sub)) {
                return;
            }
            combination.add(sub);
            backtrack(s, i, remain - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("101023"));
        System.out.println(restoreIpAddresses("0279245587303"));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        backtrack(s, 0, 4, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public static List<String> restoreIpAddressesAnother(String s) {
        if (s.length() > 12) {
            return ans;
        }
        dfs(s, 0, 0);
        return ans;
    }

    private static boolean isValid(String s) {
        return s.length() == 1 || (s.charAt(0) != '0' && Long.parseLong(s) <= 255);
    }

}
