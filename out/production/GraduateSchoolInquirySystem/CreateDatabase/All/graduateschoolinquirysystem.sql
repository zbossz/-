/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 127.0.0.1:3306
 Source Schema         : graduateschoolinquirysystem

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/04/2022 15:16:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 211schoolinfo
-- ----------------------------
DROP TABLE IF EXISTS `211schoolinfo`;
CREATE TABLE `211schoolinfo`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '211',
  `allCoursesMin` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMean` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMax` decimal(4, 1) NULL DEFAULT NULL,
  `englishMin` decimal(4, 1) NULL DEFAULT NULL,
  `englishMean` decimal(4, 1) NULL DEFAULT NULL,
  `englishMax` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMin` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMean` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMax` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `reExamNumber` int NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 211schoolinfo
-- ----------------------------
INSERT INTO `211schoolinfo` VALUES (1, '合肥工业大学', '211', 355.0, 375.9, 425.0, 45.0, 66.3, 82.0, 60.0, 73.2, 83.0, 89.0, 115.4, 139.0, 94.0, 121.1, 141.0, 54);
INSERT INTO `211schoolinfo` VALUES (2, '安徽大学', '211', 305.0, 330.0, 395.0, 37.0, 60.0, 80.0, 57.0, 72.6, 87.0, 72.0, 104.3, 139.0, 64.0, 93.8, 115.0, 100);
INSERT INTO `211schoolinfo` VALUES (3, '南京航空航天大学', '211', 329.0, 352.4, 416.0, 50.0, 67.6, 84.0, 63.0, 71.3, 79.0, 78.0, 105.6, 136.0, 79.0, 107.9, 133.0, 30);
INSERT INTO `211schoolinfo` VALUES (4, '南京理工大学', '211', 285.0, 324.0, 408.0, 41.0, 63.7, 80.0, 55.0, 69.4, 77.0, 64.0, 99.8, 138.0, 62.0, 91.2, 125.0, 42);
INSERT INTO `211schoolinfo` VALUES (5, '苏州大学', '211', 332.0, 342.4, 349.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `211schoolinfo` VALUES (6, '贵州大学', '211', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 45);
INSERT INTO `211schoolinfo` VALUES (7, '西南交通大学', '211', 345.0, 364.7, 409.0, 43.0, 63.2, 73.0, 57.0, 66.1, 72.0, 78.0, 106.6, 134.0, 99.0, 102.0, 128.9, 145);
INSERT INTO `211schoolinfo` VALUES (8, '南昌大学', '211', 286.0, 316.5, 363.0, 44.0, 61.6, 82.0, 57.0, 67.6, 76.0, 64.0, 88.5, 123.0, 70.0, 99.0, 127.0, NULL);
INSERT INTO `211schoolinfo` VALUES (9, '暨南大学', '211', 314.0, NULL, 368.0, 42.0, 61.5, 80.0, 63.0, 72.5, 81.0, 65.0, 94.2, 118.0, 98.0, 106.7, 118.0, 27);
INSERT INTO `211schoolinfo` VALUES (10, '华南师范大学', '211', 317.0, 337.3, 377.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 31);
INSERT INTO `211schoolinfo` VALUES (11, '上海大学', '211', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `211schoolinfo` VALUES (12, '华东理工大学', '211', 306.0, 344.1, 406.0, 50.0, 61.6, 73.0, 53.0, 64.7, 76.0, 74.0, 102.0, 130.0, 96.0, 116.4, 137.0, NULL);
INSERT INTO `211schoolinfo` VALUES (13, '东华大学', '211', 340.0, 353.8, 381.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 22);

-- ----------------------------
-- Table structure for 211schoollist
-- ----------------------------
DROP TABLE IF EXISTS `211schoollist`;
CREATE TABLE `211schoollist`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolLoc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '211',
  `recruitNumber` int NULL DEFAULT NULL,
  `englishType` int NULL DEFAULT 1,
  `mathType` int NULL DEFAULT 1,
  `politicType` int NULL DEFAULT 1,
  `preProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 211schoollist
-- ----------------------------
INSERT INTO `211schoollist` VALUES (1, '合肥工业大学', '安徽', '211', 54, 1, 1, 1, '850', '操作系统&&计算机网络&&数据库系统');
INSERT INTO `211schoollist` VALUES (2, '安徽大学', '安徽', '211', 100, 1, 1, 1, '834', '数据库原理&&计算机组成原理');
INSERT INTO `211schoollist` VALUES (3, '南京航空航天大学', '江苏', '211', 25, 1, 1, 1, '829', '离散数学与编译原理&&口试');
INSERT INTO `211schoollist` VALUES (4, '南京理工大学', '江苏', '211', 30, 1, 1, 1, '877', 'c++程序设计&&编译原理与算法设计');
INSERT INTO `211schoollist` VALUES (5, '苏州大学', '江苏', '211', 2, 1, 1, 1, '872', 'python程序设计&&口试');
INSERT INTO `211schoollist` VALUES (6, '贵州大学', '贵州', '211', 39, 1, 1, 1, '408', '英语口语&&数据库&&数据结构&&操作系统&&程序设计');
INSERT INTO `211schoollist` VALUES (7, '西南交通大学', '四川', '211', 28, 1, 1, 1, '840', '程序设计&&电子技术基础&&计算机组成原理');
INSERT INTO `211schoollist` VALUES (8, '南昌大学', '江西', '211', 31, 1, 1, 1, '408', '离散数学&&数据库系统概论&&计算机组织与结构');
INSERT INTO `211schoollist` VALUES (9, '暨南大学', '广东', '211', 14, 1, 1, 1, '848', 'C语言程序设计');
INSERT INTO `211schoollist` VALUES (10, '华南师范大学', '广东', '211', 23, 1, 1, 1, '925', '程序设计');
INSERT INTO `211schoollist` VALUES (11, '上海大学', '上海', '211', 41, 1, 1, 1, '408', 'C++程序设计&&编译原理');
INSERT INTO `211schoollist` VALUES (12, '华东理工大学', '上海', '211', 37, 1, 1, 1, '815', 'null');
INSERT INTO `211schoollist` VALUES (13, '东华大学', '上海', '211', 21, 1, 1, 1, '854', '综合考核');

-- ----------------------------
-- Table structure for 985schoolinfo
-- ----------------------------
DROP TABLE IF EXISTS `985schoolinfo`;
CREATE TABLE `985schoolinfo`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '985',
  `allCoursesMin` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMean` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMax` decimal(4, 1) NULL DEFAULT NULL,
  `englishMin` decimal(4, 1) NULL DEFAULT NULL,
  `englishMean` decimal(4, 1) NULL DEFAULT NULL,
  `englishMax` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMin` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMean` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMax` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `reExamNumber` int NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 985schoolinfo
-- ----------------------------
INSERT INTO `985schoolinfo` VALUES (1, '中国科学技术大学', '985', 381.0, 398.4, 428.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 48);
INSERT INTO `985schoolinfo` VALUES (2, '南京大学', '985', 383.0, 401.1, 441.0, 52.0, 72.1, 83.0, 60.0, 71.7, 83.0, 99.0, 128.3, 144.0, 118.0, 129.2, 139.0, 24);
INSERT INTO `985schoolinfo` VALUES (3, '东南大学', '985', 365.0, 379.0, 406.0, 62.0, 71.8, 85.0, 65.0, 73.0, 80.0, 112.0, 125.5, 145.0, 94.0, 109.8, 121.0, 22);
INSERT INTO `985schoolinfo` VALUES (4, '四川大学', '985', 333.0, 352.0, 389.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `985schoolinfo` VALUES (5, '电子科技大学', '985', 341.0, 367.4, 341.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `985schoolinfo` VALUES (6, '中山大学', '985', 336.0, 355.5, 391.0, 58.0, 72.1, 85.0, 67.0, 75.7, 83.0, 71.0, 100.0, 122.0, 92.0, 107.8, 127.0, 83);
INSERT INTO `985schoolinfo` VALUES (7, '华南理工大学', '985', 347.0, 362.0, 390.0, 53.0, 72.7, 86.0, 66.0, 75.0, 84.0, 94.0, 108.4, 129.0, 91.0, 105.8, 120.0, 68);
INSERT INTO `985schoolinfo` VALUES (8, '上海交通大学', '985', 392.0, 409.9, 440.0, 57.0, 76.0, 85.0, 65.0, 70.3, 76.0, 108.0, 133.6, 148.0, 117.0, 130.0, 142.0, 21);
INSERT INTO `985schoolinfo` VALUES (9, '同济大学', '985', 346.0, 377.1, 426.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for 985schoollist
-- ----------------------------
DROP TABLE IF EXISTS `985schoollist`;
CREATE TABLE `985schoollist`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolLoc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '985',
  `recruitNumber` int NULL DEFAULT NULL,
  `englishType` int NULL DEFAULT 1,
  `mathType` int NULL DEFAULT 1,
  `politicType` int NULL DEFAULT 1,
  `preProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 985schoollist
-- ----------------------------
INSERT INTO `985schoollist` VALUES (1, '中国科学技术大学', '安徽', '985', 48, 1, 1, 1, '408', '英语口试&&c/c++&&');
INSERT INTO `985schoollist` VALUES (2, '南京大学', '江苏', '985', 20, 1, 1, 1, '408', 'c++程序设计&&口试&&离散数学&&编译原理');
INSERT INTO `985schoollist` VALUES (3, '东南大学', '江苏', '985', 17, 1, 1, 1, '935', 'c++程序设计&&口试');
INSERT INTO `985schoollist` VALUES (4, '四川大学', '四川', '985', 66, 1, 1, 1, '874', 'C语言&&综合测试');
INSERT INTO `985schoollist` VALUES (5, '电子科技大学', '四川', '985', 110, 1, 1, 1, '820', 'C语言');
INSERT INTO `985schoollist` VALUES (6, '中山大学', '广东', '985', 15, 1, 1, 1, '408', '数据结构&&计算机组成原理&&操作系统&&计算机网络');
INSERT INTO `985schoollist` VALUES (7, '华南理工大学', '广东', '985', 24, 1, 1, 1, '408', '高级语言程序设计C++&&数据结构&&算法分析与设计');
INSERT INTO `985schoollist` VALUES (8, '上海交通大学', '上海', '985', 18, 1, 1, 1, '408', 'null');
INSERT INTO `985schoollist` VALUES (9, '同济大学', '上海', '985', 48, 1, 1, 1, '408', '英语口试听力&&计算机与智能技术');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adminPassword` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '321',
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'root-zzy', 'zzy321');

-- ----------------------------
-- Table structure for normalschoolinfo
-- ----------------------------
DROP TABLE IF EXISTS `normalschoolinfo`;
CREATE TABLE `normalschoolinfo`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'normal',
  `allCoursesMin` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMean` decimal(4, 1) NULL DEFAULT NULL,
  `allCoursesMax` decimal(4, 1) NULL DEFAULT NULL,
  `englishMin` decimal(4, 1) NULL DEFAULT NULL,
  `englishMean` decimal(4, 1) NULL DEFAULT NULL,
  `englishMax` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMin` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMean` decimal(4, 1) NULL DEFAULT NULL,
  `politicsMax` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `firstProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMin` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMean` decimal(4, 1) NULL DEFAULT NULL,
  `secondProfessionalMax` decimal(4, 1) NULL DEFAULT NULL,
  `reExamNumber` int NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of normalschoolinfo
-- ----------------------------
INSERT INTO `normalschoolinfo` VALUES (1, '安徽师范大学', 'normal', 276.0, 309.7, 349.0, 38.0, 52.9, 76.0, 59.0, 78.0, 99.0, 59.0, 78.0, 99.0, 88.0, 110.2, 134.0, 29);
INSERT INTO `normalschoolinfo` VALUES (2, '安徽农业大学', 'normal', 281.0, 281.0, 281.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `normalschoolinfo` VALUES (3, '安徽工业大学', 'normal', 264.0, 298.8, 349.0, 39.0, 55.0, 79.0, 59.0, 68.4, 79.0, 61.0, 81.9, 108.0, 62.0, 93.6, 133.0, 25);
INSERT INTO `normalschoolinfo` VALUES (4, '安徽理工大学', 'normal', 265.0, 300.0, 383.0, 38.0, 52.2, 70.0, 55.0, 66.7, 78.0, 56.0, 78.0, 125.0, 83.0, 103.2, 126.0, 40);
INSERT INTO `normalschoolinfo` VALUES (5, '江苏大学', 'normal', 305.0, 339.5, 401.0, 38.0, 57.5, 75.0, 57.0, 67.1, 79.0, 70.0, 87.7, 128.0, 94.0, 127.4, 142.0, 51);
INSERT INTO `normalschoolinfo` VALUES (6, '南京工业大学', 'normal', 282.0, 315.0, 352.0, 40.0, 51.0, 69.0, 66.0, 68.4, 72.0, 77.0, 85.0, 100.0, 98.0, 111.7, 134.0, 3);
INSERT INTO `normalschoolinfo` VALUES (7, '南京信息工程大学', 'normal', 327.0, 349.8, 413.0, 39.0, 59.7, 81.0, 51.0, 67.7, 79.0, 70.0, 96.3, 135.0, 113.0, 126.2, 139.0, 56);
INSERT INTO `normalschoolinfo` VALUES (8, '南京邮电大学', 'normal', 334.0, 358.2, 426.0, 43.0, 63.8, 87.0, 57.0, 69.3, 80.0, 70.0, 103.3, 137.0, 102.0, 121.9, 140.0, 64);
INSERT INTO `normalschoolinfo` VALUES (9, '苏州科技大学', 'normal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (10, '贵州师范大学', 'normal', 254.0, 284.6, 338.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (11, '成都理工大学', 'normal', 265.0, 298.4, 373.0, 37.0, 55.0, 70.0, 45.0, 62.9, 70.0, 57.0, 76.1, 128.0, 76.0, 104.9, 127.0, 43);
INSERT INTO `normalschoolinfo` VALUES (12, '西南科技大学', 'normal', 263.0, 293.0, 337.0, 38.0, 49.5, 58.0, 49.0, 64.7, 77.0, 65.0, 74.9, 98.0, 67.0, 103.9, 128.0, 8);
INSERT INTO `normalschoolinfo` VALUES (13, '成都信息工程大学', 'normal', 277.0, 310.9, 351.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 14);
INSERT INTO `normalschoolinfo` VALUES (14, '成都大学', 'normal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (15, '西华大学', 'normal', 282.0, 312.6, 344.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13);
INSERT INTO `normalschoolinfo` VALUES (16, '四川轻化工大学', 'normal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (17, '江西师范大学', 'normal', 273.0, NULL, 321.0, 45.0, NULL, 61.0, 66.0, NULL, 67.0, 68.0, NULL, 109.0, 77.0, NULL, 101.0, 2);
INSERT INTO `normalschoolinfo` VALUES (18, '南昌航空大学', 'normal', 267.0, 286.0, 325.0, 48.0, 56.0, 69.0, 51.0, 57.0, 60.0, 60.0, 79.0, 97.0, 80.0, 95.0, 110.0, 4);
INSERT INTO `normalschoolinfo` VALUES (19, '江西理工大学', 'normal', 285.0, 323.0, 387.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20);
INSERT INTO `normalschoolinfo` VALUES (20, '华东交通大学', 'normal', 268.0, 291.0, 321.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4);
INSERT INTO `normalschoolinfo` VALUES (21, '东华理工大学', 'normal', 297.0, 347.9, 415.0, 37.0, 52.0, 74.0, 44.0, 63.0, 77.0, 84.0, 115.0, 135.0, 87.0, 119.0, 140.0, 4);
INSERT INTO `normalschoolinfo` VALUES (22, '江西农业大学', 'normal', 280.0, 324.0, 361.0, 47.0, 57.0, 62.0, 52.0, 61.0, 64.0, 60.0, 86.0, 112.0, 108.0, 121.0, 130.0, NULL);
INSERT INTO `normalschoolinfo` VALUES (23, '华南农业大学', 'normal', 267.0, 313.4, 394.0, 45.0, 62.8, 87.0, 58.0, 69.1, 80.0, 63.0, 85.2, 134.0, 57.0, 96.3, 125.0, NULL);
INSERT INTO `normalschoolinfo` VALUES (24, '南方科技大学', 'normal', 263.0, 329.5, 418.0, 40.0, 61.4, 80.0, 54.0, 68.9, 80.0, 58.0, 94.2, 141.0, 68.0, 105.1, 134.0, NULL);
INSERT INTO `normalschoolinfo` VALUES (25, '深圳大学', 'normal', 295.0, 333.4, 369.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (26, '广州大学', 'normal', 267.0, 305.2, 364.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `normalschoolinfo` VALUES (27, '上海理工大学', 'normal', 277.0, 305.1, 369.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 30);
INSERT INTO `normalschoolinfo` VALUES (28, '上海海洋大学', 'normal', 265.0, 296.3, 343.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12);
INSERT INTO `normalschoolinfo` VALUES (29, '上海海事大学', 'normal', 274.0, 317.1, 388.0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for normalschoollist
-- ----------------------------
DROP TABLE IF EXISTS `normalschoollist`;
CREATE TABLE `normalschoollist`  (
  `schoolId` int NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolLoc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'normal',
  `recruitNumber` int NULL DEFAULT NULL,
  `englishType` int NULL DEFAULT 1,
  `mathType` int NULL DEFAULT 1,
  `politicType` int NULL DEFAULT 1,
  `preProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `reProfessionalCourses` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`schoolId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of normalschoollist
-- ----------------------------
INSERT INTO `normalschoollist` VALUES (1, '安徽师范大学', '安徽', 'normal', 29, 1, 1, 1, '896', '计算机网络');
INSERT INTO `normalschoollist` VALUES (2, '安徽农业大学', '安徽', 'normal', 1, 1, 1, 1, '408', '口试');
INSERT INTO `normalschoollist` VALUES (3, '安徽工业大学', '安徽', 'normal', 25, 1, 1, 1, '861', 'c/c++&&口试');
INSERT INTO `normalschoollist` VALUES (4, '安徽理工大学', '安徽', 'normal', 35, 1, 1, 1, '841', '数据库系统原理&&c&&计算机网络');
INSERT INTO `normalschoollist` VALUES (5, '江苏大学', '江苏', 'normal', 36, 1, 1, 1, '851', '操作系统&&计算机网络');
INSERT INTO `normalschoollist` VALUES (6, '南京工业大学', '江苏', 'normal', 3, 1, 1, 1, '828', 'c/c++程序设计&&口试');
INSERT INTO `normalschoollist` VALUES (7, '南京信息工程大学', '江苏', 'normal', 43, 1, 1, 1, '822', '数据结构&&口试');
INSERT INTO `normalschoollist` VALUES (8, '南京邮电大学', '江苏', 'normal', 42, 1, 1, 1, '811', '数据结构&&操作系统');
INSERT INTO `normalschoollist` VALUES (9, '苏州科技大学', '江苏', 'normal', 18, 1, 1, 1, '820', '数据结构&&计算机网络');
INSERT INTO `normalschoollist` VALUES (10, '贵州师范大学', '贵阳', 'normal', 12, 1, 1, 1, '408', '数据库理论与技术&&计算机网络&&通信原理');
INSERT INTO `normalschoollist` VALUES (11, '成都理工大学', '四川', 'normal', 24, 1, 1, 1, '859', 'C语言&&计算机能力测试');
INSERT INTO `normalschoollist` VALUES (12, '西南科技大学', '四川', 'normal', 20, 1, 1, 1, '814', '程序设计能力');
INSERT INTO `normalschoollist` VALUES (13, '成都信息工程大学', '四川', 'normal', 23, 1, 1, 1, '807', '数据结构');
INSERT INTO `normalschoollist` VALUES (14, '成都大学', '四川', 'normal', NULL, 1, 1, 1, '', '');
INSERT INTO `normalschoollist` VALUES (15, '西华大学', '四川', 'normal', 22, 1, 1, 1, '823&&824', '数据库原理&&计算机网络');
INSERT INTO `normalschoollist` VALUES (16, '四川轻化工大学', '四川', 'normal', NULL, 1, 1, 1, NULL, NULL);
INSERT INTO `normalschoollist` VALUES (17, '江西师范大学', '江西', 'normal', 16, 1, 1, 1, '408', '数据库基础');
INSERT INTO `normalschoollist` VALUES (18, '南昌航空大学', '江西', 'normal', NULL, 1, 1, 1, '961', '数据结构');
INSERT INTO `normalschoollist` VALUES (19, '江西理工大学', '江西', 'normal', 21, 1, 1, 1, '873', '数据库系统概论&&C语言');
INSERT INTO `normalschoollist` VALUES (20, '华东交通大学', '江西', 'normal', NULL, 1, 1, 1, '829', '数据库原理');
INSERT INTO `normalschoollist` VALUES (21, '东华理工大学', '江西', 'normal', NULL, 1, 1, 1, '811', '数据结构&&C语言&&高数&&数据库系统概论');
INSERT INTO `normalschoollist` VALUES (22, '江西农业大学', '江西', 'normal', NULL, 1, 1, 1, '815', '数据库原理及应用');
INSERT INTO `normalschoollist` VALUES (23, '华南农业大学', '广东', 'normal', 5, 1, 1, 1, '408', '英语口语&&操作系统&&数据库原理&&计算机网络');
INSERT INTO `normalschoollist` VALUES (24, '南方科技大学', '广东', 'normal', 6, 1, 1, 1, '408', 'null');
INSERT INTO `normalschoollist` VALUES (25, '深圳大学', '广东', 'normal', 47, 1, 1, 1, '408', 'C语言程序设计');
INSERT INTO `normalschoollist` VALUES (26, '广州大学', '广东', 'normal', 282, 1, 1, 1, '408', 'C语言程序设计');
INSERT INTO `normalschoollist` VALUES (27, '上海理工大学', '上海', 'normal', 24, 1, 1, 1, '848', '数据库原理或计算机网络');
INSERT INTO `normalschoollist` VALUES (28, '上海海洋大学', '上海', 'normal', 18, 1, 1, 1, '408', '数据库原理&&面对对象程序设计语言');
INSERT INTO `normalschoollist` VALUES (29, '上海海事大学', '上海', 'normal', 75, 1, 1, 828, '408', '离散数学&&数据库原理');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentId` int NOT NULL AUTO_INCREMENT,
  `studentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `studentPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123',
  `schoolName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `schoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cameFrom` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dreamSchoolType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dreamSchoolLoc` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dreamSchoolName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'zzy', '123', '苏州大学应用技术学院', '普本', '安徽', '211', '安徽', '合肥工业大学');
INSERT INTO `student` VALUES (2, 'yx', '123', '苏州大学应用技术学院', '普本', '贵州', '211', '贵州', '贵州大学');
INSERT INTO `student` VALUES (3, 'zyx', '123', '苏州大学应用技术学院', '普本', '江苏', '985', '上海', '上海交通大学');
INSERT INTO `student` VALUES (4, 'hhf', '123', '苏州大学应用技术学院', '普本', '江苏', '211', '江苏', '南京理工大学');
INSERT INTO `student` VALUES (5, 'wyh', '123', '苏州大学应用技术学院', '普本', '四川', '211', '四川', '四川大学');
INSERT INTO `student` VALUES (6, 'zzc', '123', '苏州大学应用技术学院', '普本', '广东', '211', '广东', '华南理工大学');
INSERT INTO `student` VALUES (7, 'szy', '123', '苏州大学应用技术学院', '普本', '江苏', '211', '江苏', '南京航空航天大学');
INSERT INTO `student` VALUES (8, 'xjl', '123', '苏州大学应用技术学院', '普本', '江西', '211', '江西', '南昌大学');

SET FOREIGN_KEY_CHECKS = 1;
