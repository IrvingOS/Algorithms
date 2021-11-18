package top.irvingsoft.chengyun.stackandqueue;

/**
 * Page 28
 * <p>
 * 猫狗队列实体
 *
 * @author TimeChaser
 * @since 2021/8/8 15:32
 */
public class Pet {

    private final String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                '}';
    }
}

class Dog extends Pet {
    Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    Cat() {
        super("cat");
    }
}
