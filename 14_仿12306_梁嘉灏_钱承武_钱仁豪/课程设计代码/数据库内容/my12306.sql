/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : my12306
Target Host     : localhost:3306
Target Database : my12306
Date: 2018-12-26 18:49:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dingdan
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `username` char(100) CHARACTER SET utf8 NOT NULL,
  `name` char(10) CHARACTER SET utf8 NOT NULL,
  `time` char(10) CHARACTER SET utf8 NOT NULL,
  `start` char(10) CHARACTER SET utf8 NOT NULL,
  `arrive` char(10) CHARACTER SET utf8 NOT NULL,
  `start_time` char(100) CHARACTER SET utf8 NOT NULL,
  `arrive_time` char(100) CHARACTER SET utf8 NOT NULL,
  `price` char(100) CHARACTER SET utf8 NOT NULL,
  `type` char(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('shaluo', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('shaluo', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('shaluo', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('ren', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('ren', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qian', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qian', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('hunzi', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qian', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qian', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('shaluo', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('shaluo', 'G44', '2018-12-13', '杭州', '上海', '11:00', '13:00', '￥80', '无座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G102', '2018-12-03', '杭州', '上海', '8:10', '12:00', '￥58', '一等座');
INSERT INTO `dingdan` VALUES ('qianrenhao', 'G102', '2018-12-03', '杭州', '上海', '8:10', '12:00', '￥58', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G105', '2018-12-03', '杭州', '上海', '12:10', '15:50', '￥51', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G105', '2018-12-03', '杭州', '上海', '12:10', '15:50', '￥51', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G105', '2018-12-03', '杭州', '上海', '12:10', '15:50', '￥51', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G105', '2018-12-03', '杭州', '上海', '12:10', '15:50', '￥51', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G105', '2018-12-03', '杭州', '上海', '12:10', '15:50', '￥51', '无座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '无座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G100', '2018-12-03', '杭州', '上海', '9:10', '12:10', '￥50', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G10', '2018-12-03', '杭州', '上海', '8:10', '12:10', '￥55', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '一等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '二等座');
INSERT INTO `dingdan` VALUES ('whiteclover', 'G1', '2018-12-03', '杭州', '上海', '9:15', '12:15', '￥51', '一等座');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `zhanghao` char(100) CHARACTER SET utf8 NOT NULL,
  `mima` char(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`zhanghao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('qianrenhao', 'qianrenhao');
INSERT INTO `login` VALUES ('shaluo', 'shaluo');
INSERT INTO `login` VALUES ('whiteclover', 'whiteclover');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `checi` char(10) CHARACTER SET utf8 NOT NULL,
  `date` char(10) CHARACTER SET utf8 NOT NULL,
  `start` char(100) CHARACTER SET utf8 NOT NULL,
  `start_time` char(100) CHARACTER SET utf8 NOT NULL,
  `arrive` char(100) CHARACTER SET utf8 NOT NULL,
  `arrive_time` char(100) CHARACTER SET utf8 NOT NULL,
  `type` char(100) CHARACTER SET utf8 NOT NULL,
  `yideng` char(100) CHARACTER SET utf8 NOT NULL,
  `erdeng` char(100) CHARACTER SET utf8 NOT NULL,
  `wuzuo` char(100) CHARACTER SET utf8 NOT NULL,
  `price` char(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`checi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('G1', '2018-12-03', '杭州', '9:15', '上海', '12:15', '商务', '一等：18张', '二等：8张', '无座：25张', '￥51');
INSERT INTO `train` VALUES ('G10', '2018-12-04', '杭州', '8:10', '上海', '12:10', '硬座', '一等：20张', '二等：0张', '无座：0张', '￥55');
INSERT INTO `train` VALUES ('G100', '2018-12-03', '杭州', '9:10', '上海', '12:10', '商务', '一等：19张', '二等：10张', '无座：21张', '￥50');
INSERT INTO `train` VALUES ('G101', '2018-12-05', '杭州', '10:10', '上海', '12:10', '硬座', '一等：2张', '二等：20张', '无座：5张', '￥57');
INSERT INTO `train` VALUES ('G102', '2018-12-03', '杭州', '8:10', '上海', '12:00', '软座', '一等：0张', '二等：3张', '无座：1张', '￥58');
INSERT INTO `train` VALUES ('G103', '2018-12-12', '杭州', '8:10', '上海', '10:00', '软座', '一等：2张', '二等：2张', '无座：5张', '￥52');
INSERT INTO `train` VALUES ('G104', '2018-12-11', '北京', '10:00', '杭州', '12:00', '软座', '一等：3张', '二等：19张', '无座：17张', '￥45');
INSERT INTO `train` VALUES ('G105', '2018-12-03', '杭州', '12:10', '上海', '15:50', '硬座', '一等：0张', '二等：0张', '无座：0张', '￥51');
INSERT INTO `train` VALUES ('G11', '2018-12-04', '杭州', '10:00', '上海', '13:00', '硬座', '一等：21张', '二等：11张', '无座：10张', '￥60');
INSERT INTO `train` VALUES ('G111', '2018-12-18', '北京', '12:00', '杭州', '11:00', '软座', '一等：1张', '二等：0张', '无座：10张', '￥51');
INSERT INTO `train` VALUES ('G112', '2018-12-18', '北京', '11:00', '杭州', '12:00', '软座', '一等：10张', '二等：12张', '无座：10张', '￥51');
INSERT INTO `train` VALUES ('G113', '2018-12-20', '北京', '11:00', '杭州', '13:00', '软座', '一等：11张', '二等：10张', '无座：10张', '￥41');
INSERT INTO `train` VALUES ('G114', '2018-12-20', '北京', '11:00', '杭州', '14:00', '硬座', '一等：10张', '二等：5张', '无座：10张', '￥51');
INSERT INTO `train` VALUES ('G12', '2018-12-02', '杭州', '10:00', '上海', '14:10', '软座', '一等：1张', '二等：11张', '无座：10张', '￥51');
INSERT INTO `train` VALUES ('G13', '2018-12-02', '杭州', '8:10', '上海', '10:10', '软座', '一等：11张', '二等：10张', '无座：11张', '￥55');
INSERT INTO `train` VALUES ('G14', '2018-12-02', '杭州', '10:00', '上海', '12:00', '软座', '一等：11张', '二等：20张', '无座：11张', '￥56');
INSERT INTO `train` VALUES ('G15', '2018-12-02', '杭州', '11:00', '上海', '13:10', '硬座', '一等：20张', '二等：10张', '无座：15张', '￥60');
INSERT INTO `train` VALUES ('G16', '2018-12-04', '杭州', '12:00', '上海', '14:10', '软座', '一等：10张', '二等：10张', '无座：10张', '￥78');
INSERT INTO `train` VALUES ('G17', '2018-12-03', '杭州', '6:00', '上海', '8:00', '硬座', '一等：12张', '二等：10张', '无座：10张', '￥80');
INSERT INTO `train` VALUES ('G18', '2018-12-19', '杭州', '8:00', '上海', '10:00', '硬座', '一等：12张', '二等：21张', '无座：10张', '￥71');
INSERT INTO `train` VALUES ('G19', '2018-12-19', '北京', '9:00', '上海', '10:10', '硬座', '一等：11张', '二等：12张', '无座：10张', '￥81');
INSERT INTO `train` VALUES ('G2', '2018-12-03', '杭州', '11:10', '上海', '12:50', '商务', '一等：20张', '二等：0张', '无座：11张', '￥81');
INSERT INTO `train` VALUES ('G20', '2018-11-08', '杭州', '10:00', '上海', '12:00', '商务', '一等：2张', '二等：2张', '无座：3张', '￥80');
INSERT INTO `train` VALUES ('G200', '2018-12-03', '北京', '6:00', '杭州', '8:00', '软座', '一等：12张', '二等：10张', '无座：10张', '￥41');
INSERT INTO `train` VALUES ('G201', '2018-12-03', '北京', '7:00', '杭州', '9:00', '硬座', '一等：8张', '二等：10张', '无座：11张', '￥60');
INSERT INTO `train` VALUES ('G21', '2018-12-04', '杭州', '13:00', '上海', '15:10', '硬座', '一等：6张', '二等：4张', '无座：13张', '￥40');
INSERT INTO `train` VALUES ('G22', '2018-11-09', '杭州', '11:00', '上海', '12:30', '商务', '一等：2张', '二等：3张', '无座：4张', '￥90');
INSERT INTO `train` VALUES ('G23', '2018-12-06', '上海', '10:30', '北京', '13:50', '硬座', '一等：2张', '二等：8张', '无座：0张', '￥52');
INSERT INTO `train` VALUES ('G24', '2018-12-07', '上海', '11:10', '北京', '12:00', '软座', '一等：2张', '二等：7张', '无座：7张', '￥78');
INSERT INTO `train` VALUES ('G25', '2018-12-06', '杭州', '11:00', '上海', '12:00', '硬座', '一等：2张', '二等：21张', '无座：11张', '￥100');
INSERT INTO `train` VALUES ('G3', '2018-12-02', '杭州', '8:10', '上海', '12:30', '商务', '一等：12张', '二等：20张', '无座：11张', '￥62');
INSERT INTO `train` VALUES ('G32', '2018-12-05', '上海', '10:20', '北京', '11:30', '商务', '一等：5张', '二等：10张', '无座：15张', '￥70');
INSERT INTO `train` VALUES ('G34', '2018-12-20', '上海', '10:00', '杭州', '12:00', '商务', '一等：7张', '二等：12张', '无座：12张', '￥80');
INSERT INTO `train` VALUES ('G35', '2018-12-19', '上海', '8:00', '杭州', '10:00', '商务', '一等：9张', '二等：19张', '无座：13张', '￥90');
INSERT INTO `train` VALUES ('G36', '2018-12-18', '北京', '8:00', '上海', '10:00', '硬座', '一等：5张', '二等：3张', '无座：23张', '￥80');
INSERT INTO `train` VALUES ('G37', '2018-12-17', '北京', '10:00', '杭州', '12:00', '软座', '一等：4张', '二等：12张', '无座：12张', '￥80');
INSERT INTO `train` VALUES ('G40', '2018-12-19', '北京', '8:00', '杭州', '10:00', '软座', '一等：12张', '二等：12张', '无座：10张', '￥61');
INSERT INTO `train` VALUES ('G41', '2018-12-16', '北京', '14:00', '上海', '16:00', '软座', '一等：2张', '二等：23张', '无座：17张', '￥80');
INSERT INTO `train` VALUES ('G42', '2018-12-15', '北京', '11:00', '杭州', '13:00', '软座', '一等：8张', '二等：14张', '无座：16张', '￥80');
INSERT INTO `train` VALUES ('G43', '2018-12-14', '杭州', '11:00', '北京', '13:00', '软座', '一等：8张', '二等：15张', '无座：13张', '￥80');
INSERT INTO `train` VALUES ('G44', '2018-12-13', '杭州', '11:00', '上海', '13:00', '硬座', '一等：6张', '二等：15张', '无座：13张', '￥80');
INSERT INTO `train` VALUES ('G48', '2018-12-12', '上海', '10:00', '杭州', '12:00', '软座', '一等：5张', '二等：17张', '无座：13张', '￥80');
INSERT INTO `train` VALUES ('G5', '2018-12-03', '杭州', '9:10', '上海', '11:10', '软座', '一等：15张', '二等：3张', '无座：4张', '￥80');
INSERT INTO `train` VALUES ('G50', '2018-12-11', '上海', '8:00', '北京', '10:00', '商务', '一等：2张', '二等：18张', '无座：15张', '￥80');
INSERT INTO `train` VALUES ('G51', '2018-12-10', '上海', '10:00', '杭州', '12:00', '软座', '一等：3张', '二等：12张', '无座：12张', '￥75');
INSERT INTO `train` VALUES ('G52', '2018-12-09', '北京', '10:00', '杭州', '12:00', '硬座', '一等：4张', '二等：14张', '无座：18张', '￥85');
INSERT INTO `train` VALUES ('G53', '2018-12-08', '杭州', '8：00', '上海', '10:00', '硬座', '一等：7张', '二等：17张', '无座：19张', '￥92');
INSERT INTO `train` VALUES ('G54', '2018-12-07', '上海', '8：00', '北京', '10:00', '软座', '一等：6张', '二等：12张', '无座：17张', '￥78');
INSERT INTO `train` VALUES ('G55', '2018-12-06', '北京', '10:00', '杭州', '12:00', '软座', '一等：6张', '二等：14张', '无座：10张', '￥87');
INSERT INTO `train` VALUES ('G58', '2018-12-04', '北京', '8：30', '上海', '13:50', '商务', '一等：8张', '二等：7张', '无座：2张', '￥100');
INSERT INTO `train` VALUES ('G6', '2018-12-04', '杭州', '9:00', '上海', '12:00', '硬座', '一等：11张', '二等：22张', '无座：11张', '￥55');
INSERT INTO `train` VALUES ('G7', '2018-12-04', '杭州', '7:30', '上海', '11:10', '软座', '一等：11张', '二等：15张', '无座：22张', '￥45');
