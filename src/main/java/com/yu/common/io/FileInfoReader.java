package com.yu.common.io;

import com.yu.common.dstructure.queue.CircularQueue;

import java.io.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final class FileInfoReader implements Iterable, Closeable {

    public FileInfoReader(String fileName) {
        this.isDir = Utils.isDir(fileName);
        this.buffer = new CircularQueue<>(this.bufferSize);
        this.fileQueue = new CircularQueue<>(10000);
        if(!this.isDir) {
            try {
                this.fileQueue.push(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            File file = new File(fileName);
            if(file.exists()) {
                // 将所有子文件进队列
                for (File f : file.listFiles()) {
                    try {
                        this.fileQueue.push(f.getAbsolutePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!this.fileQueue.isEmpty()) {
            try {
                this.fileReader = new FileReader(this.fileQueue.pop());
                this.bufferedReader = new BufferedReader(this.fileReader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.fileEnd = true;
        }
    }
    /**
     * 当前一行
     * 迭代器next()方法的返回值
     */
    private String currentLine = "";
    /**
     * 是否已经读完
     */
    private boolean fileEnd;

    private boolean isDir;
    /**
     * 文件队列
     */
    private CircularQueue<String> fileQueue;
    /**
     * 行缓冲队列
     * 默认缓冲区有10行数据
     */
    private int bufferSize = 20;

    private CircularQueue<String> buffer;
    /**
     * 行缓冲区
     */
    private BufferedReader bufferedReader = null;

    private FileReader fileReader = null;

    public void setBufferSize(int size) {
        this.bufferSize = size;
    }

    private void pushLines(){
        try {
            while (this.bufferedReader.ready()) {
                if (!this.buffer.isFull()) {
                    buffer.push(this.bufferedReader.readLine());
                    if (!this.bufferedReader.ready()) {
                        if (this.fileQueue.isEmpty()) {
                            this.fileEnd = true;
                            this.currentLine = "";
                        }
                        else
                            this.bufferedReader = new BufferedReader(new FileReader(fileQueue.pop()));
                    }
                }
                else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("pushLines err");
            this.fileEnd = true;
            this.currentLine = "";
        }
    }

    /**
     * 更新当前行
     * 如果缓冲区为空，更新缓冲区后递归
     */
    private void getLine(){
        if(!this.buffer.isEmpty()){
            try {
                this.currentLine = this.buffer.pop();
            } catch (Exception e) {
                e.printStackTrace();
                this.currentLine = "";
            }
        } else {
            this.pushLines();
            getLine();
        }
    }

    public void close() {
        if(this.bufferedReader != null){
            try {
                this.bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭BufferedReader发生错误");
            }
        }
        if(this.fileReader != null) {
            try {
                this.fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭FileReader发生错误");
            }
        }
    }

    /**
     *
     * @return 返回当前的迭代器
     */
    @Override
    public Iterator iterator() {
        return new InfoIterator(this);
    }

    /**
     * 暂时不用
     * @param action 传入函数
     */
    @Override
    public void forEach(Consumer action) { }

    /**
     * 暂时不用
     * @return null
     */
    @Override
    public Spliterator spliterator() { return null; }

    /**
     * 重写迭代器
     * 文件迭代器的next()返回文件的一行数据
     */
    private class InfoIterator implements Iterator<String> {

        InfoIterator(FileInfoReader infoReader){
            this.infoReader = infoReader;
        }

        private FileInfoReader infoReader;

        @Override
        public boolean hasNext() {
            return !this.infoReader.fileEnd;
        }

        @Override
        public String next() {
            if(this.infoReader.fileEnd)
                return null;
            else {
                this.infoReader.getLine();
                return this.infoReader.currentLine;
            }
        }

        /**
         * 不用
         */
        @Override
        public void remove() { }

        /**
         * 不用lambda
         * @param action
         */
        @Override
        public void forEachRemaining(Consumer<? super String> action) {
        }
    }

    /**
     * 测试
     */
/*    public static void main(String[] args) {

        FileInfoReader infoReader = new FileInfoReader("C:\\Users\\YT\\Desktop\\structure\\temp\\transinfos");

        Iterator iterator = infoReader.iterator();

//        int count = 0;
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            count ++;
//        }
//
//        System.out.println(count);
        int i = 5;
        while (i-->0) {
            System.out.println(iterator.next());
        }

        infoReader.close();

    }
    */

}
