package com.yu.common.dstructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个循环队列，传入队列长度。
 * @param <T>
 */
public class CircularQueue<T> implements Queue<T> {

    public CircularQueue(int size){
        this.size = size;
        this.queue = new ArrayList<>();

    }

    private int size;

    private int front = 0;

    private int count = 0;

    private List<T> queue;

    @Override
    public void push(T item) throws Exception {
        if(!this.isFull()) {
            this.queue.add(item);
            this.count++;
        } else {
            throw new RuntimeException("队列满");
        }
    }

    @Override
    public T pop() throws Exception {
        if(this.isEmpty()) {
            throw new RuntimeException("队列空");
        } else {
            count --;
            return this.queue.get(front++);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count <= 0;
    }

    @Override
    public boolean isFull() {
        return this.count >= this.size;
    }

    @Override
    public void reset(){
        this.count = 0;
        this.front = 0;
        this.queue.clear();
    }

}
