package com.example.iot_driver.vo;

public class DeviceConnectInfo {

    private String deviceId;

    private Integer qos;

    private String uploadMessageType;

    private String sentMessageType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public String getUploadMessageType() {
        return uploadMessageType;
    }

    public void setUploadMessageType(String uploadMessageType) {
        this.uploadMessageType = uploadMessageType;
    }

    public String getSentMessageType() {
        return sentMessageType;
    }

    public void setSentMessageType(String sentMessageType) {
        this.sentMessageType = sentMessageType;
    }
}
