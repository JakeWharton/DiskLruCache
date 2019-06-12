package java.util;

public class ExtendedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    public ExtendedLinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ExtendedLinkedHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ExtendedLinkedHashMap() {
    }

    public ExtendedLinkedHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public ExtendedLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    public V get(Object key, boolean accessOrder) {
        Node<K, V> e;
        if ((e = getNode(hash(key), key)) == null)
            return null;
        if (accessOrder)
            afterNodeAccess(e);
        return e.value;
    }
}