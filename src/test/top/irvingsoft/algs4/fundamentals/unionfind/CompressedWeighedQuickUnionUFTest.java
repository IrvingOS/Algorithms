package top.irvingsoft.algs4.fundamentals.unionfind;

public class CompressedWeighedQuickUnionUFTest {

    public static int a = 1;

    public static void main(String[] args) {
        CompressedWeighedQuickUnionUF uf = new CompressedWeighedQuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(8, 9);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);
        uf.union(6, 7);
        uf.find(7);
        uf.find(2);
        uf.find(4);
        uf.find(8);
        System.out.println(testAssignmentAndReturn());
        System.out.println(a);
    }

    public static int testAssignmentAndReturn() {
        return a = 2;
    }
}