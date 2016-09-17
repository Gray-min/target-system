/*
Navicat MySQL Data Transfer

Source Server         : GRAY
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-05-30 14:28:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `x_action_node`
-- ----------------------------
DROP TABLE IF EXISTS `x_action_node`;
CREATE TABLE `x_action_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_action_node
-- ----------------------------
INSERT INTO `x_action_node` VALUES ('1', '个人信息', 'info', '0', '1');
INSERT INTO `x_action_node` VALUES ('2', '密码修改', 'change_pass', '0', '1');
INSERT INTO `x_action_node` VALUES ('3', '重置密码', 'admin/select_alluser?currentpage=1', '1', '3');
INSERT INTO `x_action_node` VALUES ('4', '我的项目', 'prolist?currentpage=1', '1', '2');
INSERT INTO `x_action_node` VALUES ('5', '我参加的', 'join?currentpage=1', '0', '2');
INSERT INTO `x_action_node` VALUES ('6', '发起项目', 'add', '1', '2');
INSERT INTO `x_action_node` VALUES ('7', '还原项目', 'delete_prolist?currentpage=1', '1', '2');

-- ----------------------------
-- Table structure for `x_point`
-- ----------------------------
DROP TABLE IF EXISTS `x_point`;
CREATE TABLE `x_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `point` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_point
-- ----------------------------
INSERT INTO `x_point` VALUES ('1', '123456', '2', '2', '1');
INSERT INTO `x_point` VALUES ('4', '123456', '测试1', '4@5', '1');
INSERT INTO `x_point` VALUES ('5', '123456ds', '测试1', '4@6', '0');
INSERT INTO `x_point` VALUES ('6', '123456ds', '2', '2', '0');
INSERT INTO `x_point` VALUES ('8', '123456ds', '测试2', '1', '0');
INSERT INTO `x_point` VALUES ('9', '123456ds', '556', '2', '0');
INSERT INTO `x_point` VALUES ('10', '123456ds', '测试3', '', '0');
INSERT INTO `x_point` VALUES ('11', '123456', '测试3', '2@3', '1');
INSERT INTO `x_point` VALUES ('12', '123456', '测试5', null, '0');
INSERT INTO `x_point` VALUES ('13', '123456ds', '测试5', null, '0');

-- ----------------------------
-- Table structure for `x_role`
-- ----------------------------
DROP TABLE IF EXISTS `x_role`;
CREATE TABLE `x_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `pid` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '上级角色',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态(1:可用,0:不可用)',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of x_role
-- ----------------------------
INSERT INTO `x_role` VALUES ('1', '超级管理员', '0', '拥有系统最高权限', '1', '0');
INSERT INTO `x_role` VALUES ('4', '一般管理员', '0', '日常管理', '1', '0');

-- ----------------------------
-- Table structure for `x_target`
-- ----------------------------
DROP TABLE IF EXISTS `x_target`;
CREATE TABLE `x_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_target
-- ----------------------------
INSERT INTO `x_target` VALUES ('25', '123456', '2', '2', '2', '0');
INSERT INTO `x_target` VALUES ('27', '123456', '测试1', '指标1@指标2', '5@6', '0');
INSERT INTO `x_target` VALUES ('28', '123456', '556', '2', '2', '0');
INSERT INTO `x_target` VALUES ('29', '123456', '测试2', '1', '1', '0');
INSERT INTO `x_target` VALUES ('30', '123456', '测试3', '1@1', '2@3', '1');
INSERT INTO `x_target` VALUES ('31', '123456ds', '测试5', '指标1@指标2', '5@6', '1');

-- ----------------------------
-- Table structure for `x_user`
-- ----------------------------
DROP TABLE IF EXISTS `x_user`;
CREATE TABLE `x_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT '0',
  `mail` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `question1` varchar(255) DEFAULT NULL,
  `question2` varchar(255) DEFAULT NULL,
  `question3` varchar(255) DEFAULT NULL,
  `answer1` varchar(255) DEFAULT NULL,
  `answer2` varchar(255) DEFAULT NULL,
  `answer3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of x_user
-- ----------------------------
INSERT INTO `x_user` VALUES ('9', '123456', 'e10adc3949ba59abbe56e057f20f883e', '1', '775071305@qq.com', '男', '1111', '15', '96-8-8', '13600888', 'http://localhost:8080/data/image/20160523/lEqDjIWfhV_!!1920x1200.jpg', '', '2', '3', '1', '2', '3');
INSERT INTO `x_user` VALUES ('15', '123456ds', 'e10adc3949ba59abbe56e057f20f883e', '0', 'ds8499@qq.com', '女', '丸子', '20', null, '116', null, null, null, null, null, null, null);
INSERT INTO `x_user` VALUES ('16', 'siisk11', 'e10adc3949ba59abbe56e057f20f883e', '0', '775071305@qq.com', null, null, null, null, null, null, null, null, null, null, null, null);
