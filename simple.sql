/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100425
 Source Host           : localhost:3306
 Source Schema         : simple

 Target Server Type    : MySQL
 Target Server Version : 100425
 File Encoding         : 65001

 Date: 09/11/2022 15:40:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `UserId` int NOT NULL,
  `Username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `RoleId` int NULL DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 'Admin', 'Admin', 1);

-- ----------------------------
-- Table structure for cucian
-- ----------------------------
DROP TABLE IF EXISTS `cucian`;
CREATE TABLE `cucian`  (
  `IdCucian` int NOT NULL AUTO_INCREMENT,
  `IdCustomer` int NULL DEFAULT NULL,
  `IdJenisCuci` int NULL DEFAULT NULL,
  `Tgl_Masuk` datetime NULL DEFAULT current_timestamp,
  `Selesai` date NULL DEFAULT NULL,
  `Tgl_Keluar` date NULL DEFAULT NULL,
  `Berat` int NULL DEFAULT NULL,
  `Status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdCucian`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cucian
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `IdCustomer` int NOT NULL AUTO_INCREMENT,
  `Nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `NoHP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Keterangan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `CreatedAt` date NULL DEFAULT current_timestamp,
  PRIMARY KEY (`IdCustomer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10082 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for jeniscuci
-- ----------------------------
DROP TABLE IF EXISTS `jeniscuci`;
CREATE TABLE `jeniscuci`  (
  `IdJenisCuci` int NOT NULL AUTO_INCREMENT,
  `JenisCuci` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Harga` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdJenisCuci`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jeniscuci
-- ----------------------------

-- ----------------------------
-- Table structure for karyawan
-- ----------------------------
DROP TABLE IF EXISTS `karyawan`;
CREATE TABLE `karyawan`  (
  `IdKaryawan` int NOT NULL AUTO_INCREMENT,
  `Nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `NoHp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Jabatan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `UserId` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdKaryawan`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of karyawan
-- ----------------------------

-- ----------------------------
-- Table structure for transaksi
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi`  (
  `IdTrx` int NOT NULL AUTO_INCREMENT,
  `IdCucian` int NULL DEFAULT NULL,
  `Subtotal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Diskon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `GrandTotal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Tanggal` date NULL DEFAULT current_timestamp,
  `StatusTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdTrx`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaksi
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
