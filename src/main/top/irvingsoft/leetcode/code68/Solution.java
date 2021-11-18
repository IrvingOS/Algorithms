package top.irvingsoft.leetcode.code68;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 *
 * @author TimeChaser
 * @since 2021/11/5 16:20
 */
public class Solution {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int wordCount = 0;
            int charCount = 0;
            int j = i;
            for (; j < n; j++) {
                if (charCount + words[j].length() + wordCount > maxWidth) {
                    break;
                }
                charCount += words[j].length();
                wordCount++;
            }
            StringBuilder sb = new StringBuilder();
            if (j < n) {
                if (wordCount == 1) {
                    sb.append(words[i]);
                    for (int k = 0; k < maxWidth - words[i].length(); k++) {
                        sb.append(" ");
                    }
                } else {
                    int spaceCharCount = maxWidth - charCount;
                    int spaceCount = wordCount - 1;
                    if (spaceCharCount % (spaceCount) != 0) {
                        int[] space = new int[spaceCount];
                        processSpace(spaceCharCount, space);
                        int spaceIndex = 0;
                        for (int k = i; k < j; k++) {
                            sb.append(words[k]);
                            if (k != j - 1) {
                                int spaceNum = space[spaceIndex++];
                                for (int l = 0; l < spaceNum; l++) {
                                    sb.append(" ");
                                }
                            }
                        }
                    } else {
                        int singleSpaceCharCount = spaceCharCount / (spaceCount);
                        for (int k = i; k < j; k++) {
                            sb.append(words[k]);
                            if (k != j - 1) {
                                for (int l = 0; l < singleSpaceCharCount; l++) {
                                    sb.append(" ");
                                }
                            }
                        }
                    }
                }
            } else {
                for (int k = i; k < n; k++) {
                    sb.append(words[k]);
                    if (k != n - 1) {
                        sb.append(" ");
                    }
                }
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }

    private static void processSpace(int spaceCharCount, int[] space) {
        int index = 0;
        while (spaceCharCount-- > 0) {
            space[index++]++;
            if (index == space.length) {
                index = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }
}
