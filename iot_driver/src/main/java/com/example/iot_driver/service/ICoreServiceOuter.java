package com.example.iot_driver.service;

public interface ICoreServiceOuter {

    /**增加主题订阅*/
    boolean addSub(String[] topics, int qos);

    /**增加信息发布*/
    boolean addPub(String topic, int qos, String message);

    /**取消主题订阅*/
    boolean removeSub(String[] topics);
}
