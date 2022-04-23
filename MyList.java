package com.company;
public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index) throws Exception;
    int indexOf(Object o);
    int lastIndexOf(Object o);
    Object sort();

    void add(T item);
    T removeRoot();
    bool remove(T item);
    private void heapify();
}
