package com.bestcode.sourcecode.collection.map;

import java.util.Set;

public interface Map<K, V> {

    int size();

    boolean isEmpty();

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    Set<Map.Entry<K, V>> entrySet();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);

        boolean euqals(Object o);

        @Override
        int hashCode();
    }
}
