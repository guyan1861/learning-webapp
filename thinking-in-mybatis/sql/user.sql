/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : order

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 23/04/2022 20:48:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '风清扬', '浙江杭州');
INSERT INTO `user` VALUES (2, '洪七公', '随机地址');
INSERT INTO `user` VALUES (3, '黄药师', '桃花岛');
INSERT INTO `user` VALUES (4, '段皇爷', '大理');
INSERT INTO `user` VALUES (5, '欧阳修', '甘肃天水');
INSERT INTO `user` VALUES (6, '郭靖', '临安牛家村');

SET FOREIGN_KEY_CHECKS = 1;
