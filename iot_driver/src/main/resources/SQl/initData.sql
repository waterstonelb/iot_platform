/*
 Navicat Premium Data Transfer

 Source Server         : alyunESC
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 101.200.189.184:3306
 Source Schema         : iot

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 15/06/2020 21:52:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
                        `device_id` int(11) NOT NULL,
                        `topic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                        `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                        `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                        `qos` int(2) NULL DEFAULT NULL,
                        `level` int(2) NOT NULL,
                        PRIMARY KEY (`topic_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (8, '8/attributes/request', '请求设备属性', 'publish', 0, 0);
INSERT INTO `topic` VALUES (8, '8/attributes/response', '设备属性响应', 'subscribe', 0, 0);
INSERT INTO `topic` VALUES (8, '8/instruction/request', '向设备下发指令', 'publish', 0, 0);
INSERT INTO `topic` VALUES (8, '8/instruction/response', '设备指令响应结果', 'subscribe', 0, 0);
INSERT INTO `topic` VALUES (8, '8/offline', '设备离线', 'subscribe', 0, 0);
INSERT INTO `topic` VALUES (8, '8/online', '设备上线', 'subscribe', 0, 0);
INSERT INTO `topic` VALUES (8, '8/telemetry', '设备遥测数据上传', 'subscribe', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
