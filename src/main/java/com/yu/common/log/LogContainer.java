package com.yu.common.log;

import com.yu.common.Container;
import com.yu.common.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Log容器，用来管理Log实例。
 * 不可继承。
 */
public final class LogContainer implements Container<LogContainer, BufferedLog> {

    private static LogContainer instance = null;

    private LogContainer(){
        this.logs = new ArrayList<BufferedLog>();
    }

    private List<? extends BufferedLog> logs;

    /**
     * 创建容器
     * @return 返回一个容器实例
     */
    @Override
    public LogContainer getContainerInstance() {
        if (LogContainer.instance == null)
            LogContainer.instance = new LogContainer();
        return LogContainer.instance;
    }

    @Override
    public void close() {

    }

    /**
     *
     * @param clazz 传入Class类型。
     * 从对象池里找到对应类型的对象，返回该对象。
     */
    @Override
    public <T extends BufferedLog> T get(Class<T> clazz) throws Exception {

        T req = null;
        Object temp = null;

        for (BufferedLog log : this.logs) {
            temp = log;
            // 判断字节码是否相同以判断类型是否相同
            if (temp.getClass().equals(clazz)) {
                req = (T) temp;
            }
        }
        // 对象池没有该对象，则创建新对象。
        if(req == null){
            req = ClassUtils.newInstance(clazz);
        }
        if(req == null){
            throw new Exception("BufferedLog Container Instance Error");
        }
        return req;
    }


}
