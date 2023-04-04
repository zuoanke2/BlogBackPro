/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : blogend

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 03/04/2023 22:54:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blogid` int NOT NULL AUTO_INCREMENT,
  `authorid` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`blogid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` (`blogid`, `authorid`, `title`, `content`) VALUES (1, 1, 'blog1', 'blog1 test content');
INSERT INTO `blog` (`blogid`, `authorid`, `title`, `content`) VALUES (2, 1, 'modify blog2 title test', 'modify blog2 content test');
INSERT INTO `blog` (`blogid`, `authorid`, `title`, `content`) VALUES (4, 4, 'blog3', 'blog3 test content');
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `blogid` int DEFAULT NULL,
  `authorid` int DEFAULT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
INSERT INTO `comment` (`commentid`, `comment`, `blogid`, `authorid`) VALUES (1, 'modify comment test3', 1, 1);
INSERT INTO `comment` (`commentid`, `comment`, `blogid`, `authorid`) VALUES (2, 'comment test2', 1, 1);
INSERT INTO `comment` (`commentid`, `comment`, `blogid`, `authorid`) VALUES (3, 'comment test3', 1, 1);
INSERT INTO `comment` (`commentid`, `comment`, `blogid`, `authorid`) VALUES (4, 'user2\'s comment', 1, 2);
INSERT INTO `comment` (`commentid`, `comment`, `blogid`, `authorid`) VALUES (6, 'user4\'s comment', 1, 4);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`userid`, `username`, `password`, `token`) VALUES (1, 'user1', 'password1', '5xB7hsEW');
INSERT INTO `user` (`userid`, `username`, `password`, `token`) VALUES (4, 'admin', 'admin', 'wr4i1o7p');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
