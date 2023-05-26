CREATE TABLE `vcd_type` (
                            `type_id` INT(11) NOT NULL AUTO_INCREMENT,
                            `type_name` VARCHAR(50) NOT NULL,
                            PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SHOW INDEX FROM `vcd_type`;

-- 创建VCD信息表
CREATE TABLE `vcd_info` (
                            `vcd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'VCD编号',
                            `vcd_name` varchar(50) NOT NULL COMMENT 'VCD名称',
                            `type_id` int(11) NOT NULL COMMENT 'VCD类型编号',
                            `price` decimal(10,2) NOT NULL COMMENT 'VCD价格',
                            `operator_id` int(11) DEFAULT NULL COMMENT '操作人员编号',
                            PRIMARY KEY (`vcd_id`),
                            KEY `type_id` (`type_id`),
                            KEY `operator_id` (`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='VCD信息表';

-- 创建入库管理表
CREATE TABLE `vcd_in` (
                          `in_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库编号',
                          `in_time` datetime NOT NULL COMMENT '入库时间',
                          `in_num` int(11) NOT NULL COMMENT '入库数量',
                          `vcd_id` int(11) NOT NULL COMMENT 'VCD编号',
                          `operator_id` bigint(20) DEFAULT NULL COMMENT '操作人员编号',
                          PRIMARY KEY (`in_id`),
                          KEY `vcd_id` (`vcd_id`),
                          KEY `operator_id` (`operator_id`),
                          CONSTRAINT `vcd_in_ibfk_1` FOREIGN KEY (`vcd_id`) REFERENCES `vcd_info` (`vcd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                          CONSTRAINT `vcd_in_ibfk_2` FOREIGN KEY (`operator_id`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='入库管理表';

-- 创建零售管理表
CREATE TABLE `vcd_sale` (
                            `sale_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售编号',
                            `sale_time` datetime NOT NULL COMMENT '销售时间',
                            `sale_num` int(11) NOT NULL COMMENT '销售数量',
                            `vcd_id` int(11) NOT NULL COMMENT 'VCD编号',
                            `operator_id` bigint(20) DEFAULT NULL COMMENT '操作人员编号',
                            PRIMARY KEY (`sale_id`),
                            KEY `vcd_id` (`vcd_id`),
                            KEY `operator_id` (`operator_id`),
                            CONSTRAINT `vcd_sale_ibfk_1` FOREIGN KEY (`vcd_id`) REFERENCES `vcd_info` (`vcd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                            CONSTRAINT `vcd_sale_ibfk_2` FOREIGN KEY (`operator_id`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='零售管理表';

-- 创建借还管理表
CREATE TABLE `vcd_borrow_return` (
                                     `br_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借还编号',
                                     `br_time` datetime NOT NULL COMMENT '借还时间',
                                     `br_num` int(11) NOT NULL COMMENT '借还数量',
                                     `vcd_id` int(11) NOT NULL COMMENT 'VCD编号',
                                     `borrower_id` bigint(20) DEFAULT NULL COMMENT '借出人员编号',
                                     `returner_id` bigint(20) DEFAULT NULL COMMENT '归还人员编号',
                                     `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '借还状态，0表示借出，1表示归还',
                                     PRIMARY KEY (`br_id`),
                                     KEY `vcd_id` (`vcd_id`),
                                     KEY `borrower_id` (`borrower_id`),
                                     KEY `returner_id` (`returner_id`),
                                     CONSTRAINT `vcd_borrow_return_ibfk_1` FOREIGN KEY (`vcd_id`) REFERENCES `vcd_info` (`vcd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                     CONSTRAINT `vcd_borrow_return_ibfk_2` FOREIGN KEY (`borrower_id`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE,
                                     CONSTRAINT `vcd_borrow_return_ibfk_3` FOREIGN KEY (`returner_id`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='借还管理表';
