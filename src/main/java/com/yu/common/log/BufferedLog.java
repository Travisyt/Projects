package com.yu.common.log;

import com.yu.common.dstructure.queue.CircularQueue;

public abstract class BufferedLog implements Logging {

    private String logPath = DEFAULT_PATH;

    private String fileName = DEFAULT_FILE_NAME;

    private Byte logLevel = ALL;
    public static Byte ALL = 0;
    public static Byte OFF = 1;
    public static Byte INFO = 2;
    public static Byte ERROR = 3;

    private static String PREFIX;

    private CircularQueue<String> logBuffer;
    private Integer bufferSize = 10;

    protected BufferedLog(){
        this.logBuffer = new CircularQueue<String>(this.bufferSize);
    }

    @Override
    public void setPath(String path) {
        this.logPath = path;
    }

    @Override
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void setLogLevel(Byte level) {
        this.logLevel = level;
    }

    /**
     * 如果文件尚未创建，就创建文件。
     * 设置缓冲队列和延迟时间，在一定时间内监听是否有log信息，如果有就进队列；如果超时或者队列满就将队列flush进文件。减少了文件IO。
     * 进入缓冲队列之前判断日志级别，与类中设置的级别相符则进队。
     * @param info log infos
     */
    @Override
    public void log(String info) {

    }

    protected abstract void levelLog(String info, Byte level);
}
