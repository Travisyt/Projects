package com.yu.common.dstructure.queue;

public interface Queue<T> {

    void push(T item) throws Exception;

    T pop() throws Exception;

    boolean isEmpty();

    boolean isFull();

    void reset();

}
