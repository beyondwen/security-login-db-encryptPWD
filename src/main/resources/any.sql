/*
Navicat MySQL Data Transfer

Source Server         : mysql8.0
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : any

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-10-10 17:31:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_USER');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '昵称',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'anoy', 'pwd', 'anoy', 'ROLE_USER');
INSERT INTO `user` VALUES ('2', 'admin', 'pwd', 'admin', 'ROLE_USER,ROLE_ADMIN');
INSERT INTO `user` VALUES ('3', 'anoy1', '$2a$10$hw7w6hh6kI5RAGX8VGbZ/Oj79wnVWZ4C7Gu7Jvofw.dBenpr7Ej2K', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('4', 'anoy2', '$2a$10$bEyXYzzEBmmtmOUtHbb.ROWQ.DXl2945jBp2N3YqK665gLcIOZ4yy', '1234', 'ROLE_USER');
INSERT INTO `user` VALUES ('5', 'wenhao111111', '$2a$10$sG9hjHWRo4Alaad18rCZB.rpgx2rjCNNVK2.9Xc.g.0uEO1vFxCTe', '31231313123131231', '');
INSERT INTO `user` VALUES ('6', 'wenhao', '$2a$10$sG9hjHWRo4Alaad18rCZB.rpgx2rjCNNVK2.9Xc.g.0uEO1vFxCTe', '3224', 'ROLE_USER');
INSERT INTO `user` VALUES ('7', 'wenhao111111432423', '$2a$10$FIbGFfL3C10ZrYLOBDha8.eD0Pgj/.mvvbCZ6obOSzjG3IGjJFL0S', '4234234423', 'ROLE_USER');
INSERT INTO `user` VALUES ('8', '534534535', '$2a$10$gZ6/vZsKZjADT5mb/x4DU.fcZ8eKfRKq666Uo0RQsrqfYXN/2i/wq', '11恶趣味全额', 'ROLE_USER');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '5', '1');
