package top.irvingsoft.leetcode.code30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 *
 * @author TimeChaser
 * @since 2021/11/2 7:51
 */
public class Solution {

    /**
     * 滑动窗口
     * <p>
     * 以单个单词的长度区间为起点，依次遍历到末尾
     * <p>
     * 类双指针的方式指示子串的起始索引
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int singleLength = words[0].length();
        int length = words.length;
        HashMap<String, Integer> map = new HashMap<>(length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < singleLength; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>(length);
            while (right + singleLength <= s.length()) {
                String w = s.substring(right, right + singleLength);
                right += singleLength;
                if (!map.containsKey(w)) {
                    // 滑动窗口重置
                    count = 0;
                    left = right;
                    tempMap.clear();
                } else {
                    count++;
                    // 入滑动窗口
                    tempMap.put(w, tempMap.getOrDefault(w, 0) + 1);
                    // 滑动窗口不符合匹配要求则去尾
                    while (tempMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        // 以一个 word 为单位删除
                        String tempW = s.substring(left, left + singleLength);
                        tempMap.put(tempW, tempMap.getOrDefault(tempW, 0) - 1);
                        count--;
                        left += singleLength;
                    }
                    // 所有 word 均符合要求，保存起始索引
                    if (count == length) {
                        result.add(left);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring(
                "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel",
                new String[]{"dhvf",
                             "sind",
                             "ffsl",
                             "yekr",
                             "zwzq",
                             "kpeo",
                             "cila",
                             "tfty",
                             "modg",
                             "ztjg",
                             "ybty",
                             "heqg",
                             "cpwo",
                             "gdcj",
                             "lnle",
                             "sefg",
                             "vimw",
                             "bxcb"}));
    }

}
