package com.yu.common.bean;

import com.yu.common.exceptions.MemberNotFoundException;

import java.util.List;

public interface Bean<K, V> {

    void setValue(K name, V value) throws MemberNotFoundException;

    void getValue(K name) throws MemberNotFoundException;

    List<K> getKeyList();

    boolean isInit();

}
