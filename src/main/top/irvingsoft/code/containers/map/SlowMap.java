package top.irvingsoft.code.containers.map;

import java.util.*;

/**
 * @author TimeChaser
 * @since 2021/5/6 9:37
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {

    private final List<K> keys   = new ArrayList<>();
    private final List<V> values = new ArrayList<>();

    public static void main(String[] args) {
        SlowMap<String, String> stringStringSlowMap = new SlowMap<>();
        stringStringSlowMap.put("CAMEROON", "Yaounde");
        stringStringSlowMap.put("CONGO", "Brazzaville");
        stringStringSlowMap.put("ANGOLA", "Luanda");
        System.out.println(stringStringSlowMap);
        System.out.println(stringStringSlowMap.get("CONGO"));
        System.out.println(stringStringSlowMap.entrySet());
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        Iterator<K> kIterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (kIterator.hasNext()) {
            set.add(new MapEntry<>(kIterator.next(), vIterator.next()));
        }
        return set;
    }
}
