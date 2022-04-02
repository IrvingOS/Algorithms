package top.irvingsoft.testextends;

import java.util.Collection;

/**
 * 接口只能继承接口
 * <p>
 * 接口方法默认被 public abstract 修饰
 * <p>
 * 接口中的接口属性被 public static final 修饰
 * <p>
 * 除了 default 和 static 方法，接口中的方法不能有方法体
 * <p>
 * 接口中不能有 static 代码块
 *
 * @author TimeChaser
 * @since 2022/4/2 3:45 PM
 */
public interface InterfaceParent<T> extends Collection<T> {

    void count();

    static void count1() {

    }

}
