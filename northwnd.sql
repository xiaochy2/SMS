/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : northwnd

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 04/09/2017 11:06:55 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `mark`
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` int(10) DEFAULT NULL,
  `stuName` varchar(10) DEFAULT NULL,
  `English` int(10) DEFAULT NULL,
  `Math` int(10) DEFAULT NULL,
  `Physics` int(10) DEFAULT NULL,
  `state` varchar(20) DEFAULT 'unmark',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stuId_UNIQUE` (`stuId`),
  UNIQUE KEY `stuName_UNIQUE` (`stuName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `mark`
-- ----------------------------
BEGIN;
INSERT INTO `mark` VALUES ('1', '1', 'stu1', '80', '80', '100','marked'), ('2', '2', 'stu2', '19', '29', '88','marked');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `roleId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('2', 'stu1', 'student', '0', '1'), ('6', 'tea1', 'teacher', '1', '1'), ('18', 'admin', 'admin', '2', '1'), ('22', 'stu2', 'student', '0', '33');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `count`;
CREATE TABLE `count` (
  `type` int(11) NOT NULL AUTO_INCREMENT,
  `times` int(11) not null,
  PRIMARY KEY (`type`)
  
);
insert into `count` values(0,1);