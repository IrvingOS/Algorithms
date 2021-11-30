package top.irvingsoft.exam.others.nestedBuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tree {

    private final String  key;
    private final Integer value;

    private final String parentKey;

    private final boolean hasParent;
    private final boolean hasChildren;

    private boolean isLastChild;

    private List<Tree> children;

    public Tree(String key, Integer value, String parentKey, boolean hasParent, boolean hasChildren) {
        this.key = key;
        this.value = value;
        this.parentKey = parentKey;
        this.hasParent = hasParent;
        this.hasChildren = hasChildren;
    }

    public String getParentKey() {
        return parentKey;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public boolean isLastChild() {
        return isLastChild;
    }

    public void setLastChild(boolean isLastChild) {
        this.isLastChild = isLastChild;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public boolean isContains(String key) {
        if (isHasChildren()) {
            for (Tree child : children) {
                if (child.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void initChildren() {
        this.children = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tree tree = (Tree) o;

        return hasParent == tree.hasParent &&
                hasChildren == tree.hasChildren &&
                Objects.equals(key, tree.key) &&
                Objects.equals(parentKey, tree.parentKey) &&
                Objects.equals(value, tree.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, hasParent, hasChildren);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", parentKey='" + parentKey + '\'' +
                ", hasParent=" + hasParent +
                ", hasChildren=" + hasChildren +
                ", children=" + children +
                "}\n";
    }
}
