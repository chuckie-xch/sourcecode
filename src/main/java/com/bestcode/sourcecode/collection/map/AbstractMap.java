package com.bestcode.sourcecode.collection.map;

import java.util.Iterator;
import java.util.Set;

/**
 * AbastractMap
 *
 * @author xch
 * @version 1.00
 * @date 2017-12-26
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    protected AbstractMap() {

    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // my implements
//    public V get(Object key) {
//        Set<Entry<K, V>> set = entrySet();
//        Iterator<Entry<K, V>> iterator =  set.iterator();
//        while(iterator.hasNext()) {
//            Entry<K, V> entry = iterator.next();
//            if (entry.getKey().equals(key)) {
//                return entry.getValue();
//            }
//        }
//        return null;
//    }


    @Override
    public V get(Object key) {
        Iterator<Entry<K, V>> iterator = entrySet().iterator();
        // 先判断一些边界情况
        if (key == null) {
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.getKey() == null) {
                    return entry.getValue();
                }
            }
        } else {
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        Iterator<Entry<K, V>> iterator = entrySet().iterator();
        Entry<K, V> correctEntry = null;
        if (key == null) {
            while (correctEntry == null && iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if(entry.getKey() == null) {
                    correctEntry = entry;
                }
            }
        } else {
            while (correctEntry == null && iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (key.equals(entry.getKey())) {
                    correctEntry = entry;
                }
            }
        }
        V oldValue = null ;
        if(correctEntry != null) {
            oldValue = correctEntry.getValue();
            // todo 如何理解Iterator.remove方法
            iterator.remove();
        }
        return oldValue;
    }

    @Override
    public abstract Set<Entry<K, V>> entrySet();
}
