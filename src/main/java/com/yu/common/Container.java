package com.yu.common;

/**
 *
 * @param <T> 具体的容器对象类型。
 * @param <C> 内容物父类型。
 */
public interface Container<T, C> {

    /**
     * 创建容器对象
     * @return 返回具体的容器对象。
     */
     T getContainerInstance();

    /**
     * @param <A> 期望返回的类型，与传入类型相同。
     * @param clazz 传入Class类型。
     * @return 返回对象实例。
     * 从对象池里找到对应的对象，返回该对象。
     * 如果没有对象，容器负责创建对象。
     */
    <A extends C> A get(Class<A> clazz) throws Exception;

    /**
     * 关闭容器，释放资源。
     */
    void close();

}
