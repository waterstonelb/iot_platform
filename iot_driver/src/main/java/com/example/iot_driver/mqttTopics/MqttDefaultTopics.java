package com.example.iot_driver.mqttTopics;

import lombok.Getter;

@Getter
public class MqttDefaultTopics {

    // 设备上线
    public static final String DEVICE_ONLINE = "iot/online";

    // 设备下线
    public static final String DEVICE_OFFLINE = "iot/offline";

    // 请求设备属性
    public static final String DEVICE_ATTRIBUTES_REQUEST = "iot/attributes/request";

    // 设备属性响应
    public static final String DEVICE_ATTRIBUTES_RESPONSE = "iot/attributes/request";

    // 向设备下发指令
    public static final String DEVICE_INSTRUCTION_REQUEST = "iot/instruction/request";

    // 设备指令响应
    public static final String DEVICE_INSTRUCTION_RESPONSE = "iot/instruction/response";

    // 遥测数据上传
    public static final String DEVICE_TELEMETRY = "iot/telemetry";

}
