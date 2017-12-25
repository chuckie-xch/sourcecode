package com.bestcode.sourcecode.collection.list;

public interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean containsAll(Collection<T> c);

    Object[] toArray();

    boolean add(T o);

    boolean remove(Object o);

    void clear();

}
