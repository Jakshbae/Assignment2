package com.Assignment;

import java.util.*;

public class MyHeap<T extends Comparable<T>> {
    private int size;
    private int maxsize;
    private ArrayList<T> heap;


    public MyHeap(int maxsize)
    {
        heap = new ArrayList<>(maxsize);
        this.maxsize = maxsize;
        this.size = 0;
    }


    public void add(T item){
        if (size == 0){
            heap.add(item);
        }
        if (size >= maxsize){
            System.out.println("Max Size less than size");
            return;
        }
        size++;
        heap.add(item);
        int current = size;
        while(heap.get(current).compareTo(heap.get(parent(current))) > 0 && current > 0){
            Collections.swap(heap, current, parent(current));
            current = parent(current);
        }
    }

    public void removeRoot(){
        heap.set(1, heap.get(size));
        heap.remove(size);
        size--;
        heapify(1);
    }

    public void heapify(int pos){
        if (!isLeaf(pos)){
            if (right(pos) <= size && heap.get(left(pos)).compareTo(heap.get(pos)) > 0){
                Collections.swap(heap, pos, left(pos));
                heapify(left(pos));
            }
            if (right(pos) <= size && heap.get(right(pos)).compareTo(heap.get(pos)) > 0){
                Collections.swap(heap, pos, right(pos));
                heapify(right(pos));
            }
        }
    }

    private int right(int i){
        return i * 2 + 1;
    }

    private int left(int i){
        return i * 2;
    }

    private int parent(int i){
        return i / 2;
    }

    private boolean isLeaf(int i) {
        return i > (size / 2) && i <= size;
    }
    
}