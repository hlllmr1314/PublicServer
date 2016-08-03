package com.haley.appserver.controller.net.request;

public interface RequestCallBack<T> {

    void back(boolean success, T obj);

}