package top.irvingsoft.testextends;

/**
 * 无法在类的声明语句中添加 static
 * <p>
 * 抽象类可以继承类，所有的类在继承时必须最少覆盖一个父类的构造函数
 *
 * @author TimeChaser
 * @since 2022/4/2 3:44 PM
 */
public abstract class AbstractParent extends Parent {

    public AbstractParent(String id, Integer count) {
        super(id);
    }
}
