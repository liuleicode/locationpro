/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : locationpro

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 15/07/2017 17:30:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for localdtl
-- ----------------------------
DROP TABLE IF EXISTS `localdtl`;
CREATE TABLE `localdtl`  (
  `locationid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文名称',
  `parentid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父级id',
  `locallevel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编制等级（0-国家 10-省 20-直辖市 30-市 40-县级市 50-县 60-区 200-地点）',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态（0-正常 1-失效）',
  `countryid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家id',
  `countryname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家名称',
  `provinceid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省id',
  `provincename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省名称',
  `cityid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市id',
  `cityname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '市名称',
  `countyid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '县id',
  `countyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '县名称',
  `regionid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区id',
  `regionname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区名称',
  `localtionfixurl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '定位链接',
  PRIMARY KEY (`locationid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for localimg
-- ----------------------------
DROP TABLE IF EXISTS `localimg`;
CREATE TABLE `localimg`  (
  `localimgid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `imgtypeid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '当imgtype为1时与localdtl的id关联，当imgtype为2,3时与usercomment关联，与其多对一关联',
  `imgtype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1-首页图片 2-用户评论图片 3、用户广告图片',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-展示 1-不展示',
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片链接',
  PRIMARY KEY (`localimgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `lastsignintime` timestamp(0) NOT NULL COMMENT '每次扫描二维码插入或更新一下',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usercomment
-- ----------------------------
DROP TABLE IF EXISTS `usercomment`;
CREATE TABLE `usercomment`  (
  `usercommentid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户评论id',
  `userid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `localdtlid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址id',
  `comment` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论内容',
  `commenttype` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-地点评论  2-广告',
  PRIMARY KEY (`usercommentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usersignin
-- ----------------------------
DROP TABLE IF EXISTS `usersignin`;
CREATE TABLE `usersignin`  (
  `usersigninid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录记录id，每个地方存一条数据。',
  `userid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联用户表的userid',
  `localdtlid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联localdtl的localdtlid',
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` timestamp(0) NOT NULL COMMENT '最后更新时间',
  `signincount` bigint(20) DEFAULT NULL COMMENT '扫描二维码次数',
  PRIMARY KEY (`usersigninid`) USING BTREE,
  UNIQUE INDEX `usersignidx1`(`userid`, `localdtlid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usersignindtl
-- ----------------------------
DROP TABLE IF EXISTS `usersignindtl`;
CREATE TABLE `usersignindtl`  (
  `usersignindtlid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录记录id，每个地方存一条数据。',
  `usersignid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登录记录id',
  `userid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联用户表的userid',
  `localdtlid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联localdtl的localdtlid',
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` timestamp(0) NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`usersignindtlid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
