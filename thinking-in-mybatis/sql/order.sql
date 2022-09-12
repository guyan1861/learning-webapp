-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
create table `order`
(
    id           int auto_increment comment '订单主键'
        primary key,
    order_name   varchar(255) null comment '订单名',
    order_number int          null comment '订单号',
    user_id      int          null comment '用户ID',
    note         varchar(255) not null comment '订单说明'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;



