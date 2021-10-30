package top.irvingsoft.exam.nestedBuild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NestedBuild {

    private static final Map<String, Integer> DICTIONARY = new HashMap() {{
        put("A", 1);
        put("B.A", 2);
        put("B.B", 3);
        // put("B.B.A", 4); 不成立
        put("CC.D.E", 4);
        put("CC.D.F", 5);
        put("CC.D.G", 7);
        put("CC.G.G", 9);
        put("CC.F.F", 9);
        put("B.D.E", 3);
    }};

    public static void main(String[] args) {

        ArrayList<Tree> nestedList = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        ArrayList<Tree> treeList = new ArrayList<>();

        for (String dict : DICTIONARY.keySet()) {
            String[] splits = dict.split("\\.");
            for (int i = 0; i < splits.length; i++) {
                if (!treeIsContains(treeList, splits[i], i == splits.length - 1 ? DICTIONARY.get(dict) : null, i != 0 ? splits[i - 1] : null, i, splits.length)) {
                    Tree tree = new Tree(splits[i], i == splits.length - 1 ? DICTIONARY.get(dict) : null, i != 0 ? splits[i - 1] : null, i != 0, i != splits.length - 1);
                    if (i < splits.length - 1) {
                        tree.initChildren();
                    }
                    treeList.add(tree);
                }
            }
        }

//        System.out.println(treeList);
        treeList.forEach(
                tree -> {
                    String parentKey = tree.getParentKey();
                    if (parentKey == null && !tree.isHasParent()) {
                        nestedList.add(tree);
                        return;
                    }
                    for (Tree parent : treeList) {
                        if (parent.isContains(tree.getKey())) {
                            continue;
                        }
                        if (parent.getKey().equals(parentKey) && parent.isHasChildren()) {
                            for (Tree child : parent.getChildren()) {
                                child.setLastChild(false);
                            }
                            tree.setLastChild(true);
                            parent.getChildren().add(tree);
                            return;
                        }
                    }
                }
        );
//        System.out.println(nestedList);

        buffer.append("{\n");
        for (Tree tree : nestedList) {
            int count = 1;
            nestedBufferBuild(tree, buffer, count);
        }
        buffer.append("}\n");

        System.out.println(buffer);
    }

    private static boolean treeIsContains(ArrayList<Tree> treeList, String key, Integer value, String parentKey, int index, int length) {
        return treeList.contains(new Tree(key, value, parentKey, index != 0, index != length - 1));
    }

    /**
     * String.repeat(int); 方法从 Jdk 11 开始引入
     *
     * @author TimeChaser
     * @since 2021/3/6 2:08
     */

    public static void nestedBufferBuild(Tree tree, StringBuffer buffer, int count) {
        for (int i = 0; i < Math.max(0, count * 2); i++) {
            buffer.append(" ");
        }
        buffer.append("'").append(tree.getKey()).append("' :");
        if (tree.isHasChildren()) {
            count++;
            buffer.append(" {\n");
            for (Tree child : tree.getChildren()) {
                nestedBufferBuild(child, buffer, count);
            }
            for (int i = 0; i < Math.max(0, (count - 1) * 2); i++) {
                buffer.append(" ");
            }
            buffer.append("}\n");
        } else {
            buffer.append(" ").append(tree.getValue());
            if (tree.isLastChild()) {
                buffer.append("\n");
            } else {
                buffer.append(", \n");
            }
        }
    }
}


/*
  可能出现的特殊情况：
  1、两个子结点的 parentKey 不同，但是其他属性都相同。此时要区分开两个结点
  <p>
  不能解决的情况：
  1、结点的值相同，父结点 key 相同，而父结点的父结点不同的情况，无法区分
  <p>
  流程分析：
  1、解析 Map 中每一个 key，根据定义的比较方法判断结点是否已存在与结点数组，不存在则创建
  2、遍历结点数组，不存在父结点则存储到嵌套数组中，存在则遍历结点数组，找到其父结点，将其存入其父结点的子结点数组中
  3、递归遍历每一个根结点，构建输出的字符串
 */
