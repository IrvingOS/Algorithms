package top.irvingsoft.code.containers.hashcode;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Groundhog 没有重写 hashCode() 和 equals()
 *
 * @author TimeChaser
 * @date 2021/5/6 10:38
 */
public class SpringDetector {

    public static <T extends Groundhog> void detectorSpring(Class<T> type) throws Exception {
        Constructor<T> constructor = type.getConstructor(int.class);
        HashMap<Groundhog, Prediction> groundhogPredictionHashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            groundhogPredictionHashMap.put(constructor.newInstance(i), new Prediction());
        }
        System.out.println("map = " + groundhogPredictionHashMap);
        Groundhog groundhog = constructor.newInstance(3);
        System.out.println("Looking up prediction for " + groundhog);
        if (groundhogPredictionHashMap.containsKey(groundhog)) {
            System.out.println(groundhogPredictionHashMap.get(groundhog));
        } else {
            System.out.println("Key not Found: " + groundhog);
        }
    }

    public static void main(String[] args) throws Exception {
        detectorSpring(Groundhog.class);
        detectorSpring(Groundhog2.class);
    }
}
