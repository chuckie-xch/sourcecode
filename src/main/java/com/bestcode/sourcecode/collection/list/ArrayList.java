package com.bestcode.sourcecode.collection.list;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private transient Object[] elementData;

    private int size;

    public ArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegalArgument: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    public ArrayList() {
        super();
        elementData = EMPTY_ELEMENT_DATA;
    }

    public ArrayList(Collection<E> c) {
        elementData = c.toArray();
        size = elementData.length;
        // Collection.toArray() 不一定返回Object[]
        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if(elementData == EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 考虑溢出情况
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

//    @Override
//    public boolean add(E e) {
//
//        return true;
//    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterable<E> iterator() {
        return null;
    }
}
