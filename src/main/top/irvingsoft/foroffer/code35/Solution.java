package top.irvingsoft.foroffer.code35;

import top.irvingsoft.structure.Node;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 *
 * @author TimeChaser
 * @since 2021/12/3 9:01
 */
public class Solution {

    public Node copyRandomListMine(Node head) {
        Node dummy = new Node(-1);
        Node curPrev = dummy;
        Node originHead = head;
        Map<Node, Integer> originIndexMap = new LinkedHashMap<>();
        Map<Node, Integer> originIndexNewMap = new LinkedHashMap<>();
        Map<Integer, Node> indexCurMap = new LinkedHashMap<>();
        int index = 0;
        while (originHead != null) {
            originIndexMap.put(originHead, index++);
            originHead = originHead.next;
        }
        originHead = head;
        while (originHead != null) {
            originIndexNewMap.put(originHead, originIndexMap.get(originHead.random));
            originHead = originHead.next;
        }
        originHead = head;
        while (originHead != null) {
            curPrev.next = new Node(originHead.val);
            curPrev = curPrev.next;
            originHead = originHead.next;
        }
        Node curHead = dummy.next;
        index = 0;
        while (curHead != null) {
            indexCurMap.put(index++, curHead);
            curHead = curHead.next;
        }
        curHead = dummy.next;
        originHead = head;
        while (curHead != null && originHead != null) {
            curHead.random = indexCurMap.get(originIndexNewMap.get(originHead));
            curHead = curHead.next;
            originHead = originHead.next;
        }
        return dummy.next;
    }

}
