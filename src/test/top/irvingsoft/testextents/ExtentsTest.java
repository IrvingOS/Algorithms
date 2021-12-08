package top.irvingsoft.testextents;

import org.junit.jupiter.api.Test;

public class ExtentsTest {

    @Test
    public void testMethodExtends() {
        Parent child1 = new Child("1");
        Parent child2 = new Child("2");
        System.out.println(child1.compareTo(child2));
    }
}
