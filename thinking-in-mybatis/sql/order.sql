# 新建数据库
CREATE DATABASE `order` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
                          `id` int NOT NULL COMMENT '订单主键',
                          `order_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单名',
                          `order_number` int NULL DEFAULT NULL COMMENT '订单号',
                          `user_id` int NULL DEFAULT NULL COMMENT '用户ID',
                          `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单说明',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;