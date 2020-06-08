### 插入数据 manager_device
DROP TABLE IF EXISTS `manager_device`;
CREATE TABLE IF NOT EXISTS `manager_device` (
                                  `device_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `device_description` varchar(255) DEFAULT NULL,
                                  `device_name` varchar(255) DEFAULT NULL,
                                  `device_status` int(11) NOT NULL,
                                  `group_id` int(11) NOT NULL,
                                  `is_online` int(11) NOT NULL,
                                  `model_id` int(11) NOT NULL,
                                  `online_time` datetime DEFAULT NULL,
                                  `protocol` varchar(64) DEFAULT NULL,
                                  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPad1',1,'mzl iPad',1,1,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPad2',1,'mzl iPad',1,1,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPad3',1,'mzl iPad',1,1,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPad4',1,'mzl iPad',1,1,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPhone1',1,'mzl iPhone',2,2,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPhone2',1,'mzl iPhone',2,2,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPhone3',1,'mzl iPhone',2,2,'HTTP');
INSERT INTO `manager_device`  (`is_online`,`device_name`, `device_status`, `device_description`, `group_id`, `model_id`, `protocol`)
VALUES (0,'iPhone4',1,'mzl iPhone',2,2,'HTTP');

### 插入数据 manager_model
DROP TABLE IF EXISTS `manager_model`;
CREATE TABLE IF NOT EXISTS `manager_model` (
                                 `model_id` int(11) NOT NULL AUTO_INCREMENT,
                                 `attr_identifier` varchar(64) DEFAULT NULL,
                                 `attr_name` varchar(64) DEFAULT NULL,
                                 `call_method` int(11) NOT NULL,
                                 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `data_len` int(11) NOT NULL,
                                 `data_max` int(11) NOT NULL,
                                 `data_min` int(11) NOT NULL,
                                 `data_type` varchar(64) DEFAULT NULL,
                                 `data_unit` varchar(64) DEFAULT NULL,
                                 `model_description` varchar(255) DEFAULT NULL,
                                 `model_name` varchar(64) DEFAULT NULL,
                                 `service_description` varchar(255) DEFAULT NULL,
                                 `service_identifier` varchar(64) DEFAULT NULL,
                                 `service_name` varchar(64) DEFAULT NULL,
                                 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `manager_model` (`model_name`, `model_description`, `attr_name`, `attr_identifier`, `data_type`,`data_len`, `data_unit`, `data_min`, `data_max`, `service_name`, `service_identifier`, `call_method`, `service_description`)
VALUES ('iPad Model','descripe iPads','iPad attr','iPad Attr','int',10,'mbps','0','1000','iPad service','iPad Service',1,'Data sync' );
INSERT INTO `manager_model` (`model_name`, `model_description`, `attr_name`, `attr_identifier`, `data_type`, `data_len`,`data_unit`, `data_min`, `data_max`, `service_name`, `service_identifier`, `call_method`, `service_description`)
VALUES ('iPhone Model','descripe iPhones','iPhone attr','iPhone Attr','int',20,'mbps','0','2000','iPhone service','iPhone Service',2,'Data sync lazy' );

### 插入数据 manager_shadow
DROP TABLE IF EXISTS `manager_shadow`;
CREATE TABLE IF NOT EXISTS `manager_shadow` (
                                  `shadow_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `device_id` int(11) NOT NULL,
                                  `meta_data` varchar(64) DEFAULT NULL,
                                  `rep_time` datetime DEFAULT NULL,
                                  `report` varchar(255) DEFAULT NULL,
                                  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  `version` int(11) NOT NULL,
                                  PRIMARY KEY (`shadow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (1,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (2,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (3,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (4,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (5,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (6,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (7,'device online and operate normal','transfor total 2000KB',1);
INSERT INTO `manager_shadow` (`device_id`,`meta_data`,`report`,`version`) VALUES (8,'device online and operate normal','transfor total 2000KB',1);

### 插入数据 manager_group
DROP TABLE IF EXISTS `manager_group`;
CREATE TABLE IF NOT EXISTS `manager_group` (
                                 `group_id` int(11) NOT NULL AUTO_INCREMENT,
                                 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `group_description` varchar(255) DEFAULT NULL,
                                 `group_name` varchar(64) DEFAULT NULL,
                                 `parent_id` int(11) NOT NULL,
                                 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `manager_group` (`parent_id`,`group_description`,`group_name`) VALUES (0,'mamager all iPhone','iPhone Group');
INSERT INTO `manager_group` (`parent_id`,`group_description`,`group_name`) VALUES (1,'mamager all iPhone','iPhone Group');