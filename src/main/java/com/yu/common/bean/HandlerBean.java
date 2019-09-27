package com.yu.common.bean;

import com.yu.common.exceptions.MemberNotFoundException;

import java.util.List;

public class HandlerBean<K, V> implements Bean<K, V> {
    @Override
    public void setValue(K name, V value) throws MemberNotFoundException {

    }

    @Override
    public void getValue(K name) throws MemberNotFoundException {

    }

    @Override
    public List<K> getKeyList() {
        return null;
    }

    @Override
    public boolean isInit() {
        return false;
    }
}
