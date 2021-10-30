package top.irvingsoft.leetcode.code638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大礼包
 * <p>
 * 思路：
 * <p>
 * 1. 过滤
 * <p>
 * 2. 缓存
 * <p>
 * 3. 深度优先
 *
 * @author TimeChaser
 * @since 2021/10/24 19:27
 */
public class Solution {

    private static final Map<List<Integer>, Integer> CACHE = new HashMap<>();

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        ArrayList<List<Integer>> realSpecial = new ArrayList<>();
        for (List<Integer> sp : special) {
            boolean overflow = false;
            int originalCost = 0;
            for (int i = 0; i < n; i++) {
                if (sp.get(i) > needs.get(i)) {
                    overflow = true;
                    break;
                }
                originalCost += sp.get(i) * price.get(i);
            }
            if (overflow) {
                continue;
            }
            if (originalCost > sp.get(n)) {
                realSpecial.add(sp);
            }
        }
        return dfs(price, realSpecial, needs, n);
    }

    public static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int n) {
        if (!CACHE.containsKey(needs)) {
            int minCost = 0;
            for (int i = 0; i < n; i++) {
                minCost += needs.get(i) + price.get(i);
            }
            for (List<Integer> sp : special) {
                ArrayList<Integer> restNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (sp.get(i) > needs.get(i)) {
                        break;
                    }
                    restNeeds.add(needs.get(i) - sp.get(i));
                }
                if (restNeeds.size() == n) {
                    minCost = Math.min(minCost, dfs(price, special, restNeeds, n) + sp.get(n));
                }
            }
            CACHE.put(needs, minCost);
            return minCost;
        }
        return CACHE.get(needs);
    }
}
