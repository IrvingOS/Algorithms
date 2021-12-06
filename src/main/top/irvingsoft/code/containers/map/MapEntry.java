package top.irvingsoft.code.containers.map;

import java.util.Map;

/**
 * @author TimeChaser
 * @since 2021/5/6 10:20
 */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private       V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) {
            return false;
        }
        MapEntry me = (MapEntry) o;
        return (key == null ?
                me.getKey() == null : key.equals(me.getKey()))
                &&
                (value == null ?
                        me.getValue() == null : value.equals(me.getValue()));
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
