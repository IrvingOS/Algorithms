package top.irvingsoft.code.containers.map;

import java.util.*;

/**
 * 比直接操作 ArrayList 的 Map 稍快一些
 * <p>
 * 直接将 key、value 作为一个 Entry 存储
 *
 * @author TimeChaser
 * @date 2021/5/6 11:40
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private final LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> bucketIterator = bucket.listIterator();
        while (bucketIterator.hasNext()) {
            MapEntry<K, V> iPair = bucketIterator.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                bucketIterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            set.addAll(bucket);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> stringStringSimpleHashMap = new SimpleHashMap<>();
        stringStringSimpleHashMap.put("CHINA", "Beijing");
        stringStringSimpleHashMap.put("CONGO", "Brazzaville");
        stringStringSimpleHashMap.put("ANGOLA", "Luanda");
        System.out.println(stringStringSimpleHashMap);
        System.out.println(stringStringSimpleHashMap.get("CHINA"));
        System.out.println(stringStringSimpleHashMap.entrySet());
    }
}
