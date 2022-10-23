/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : simple

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 24/10/2022 00:53:08
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
  `Tgl_Masuk` datetime NULL DEFAULT NULL,
  `Estimasi` date NULL DEFAULT NULL,
  `Tgl_Keluar` datetime NULL DEFAULT NULL,
  `Berat/Qty/Meter` int NULL DEFAULT NULL,
  `Status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdCucian`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cucian
-- ----------------------------
INSERT INTO `cucian` VALUES (1, 10000, 1, '2022-10-19 13:10:28', '2022-10-25', '2022-10-26 13:10:35', 1, 'Menunggu Antrian');

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
  PRIMARY KEY (`IdCustomer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (10000, 'fasdasdasdssds', 'ffasff', 'ffdsd', 'Member');
INSERT INTO `customer` VALUES (10001, 'gasdf', 'sdf', 'aasd', 'Member');

-- ----------------------------
-- Table structure for jeniscuci
-- ----------------------------
DROP TABLE IF EXISTS `jeniscuci`;
CREATE TABLE `jeniscuci`  (
  `IdJenisCuci` int NOT NULL AUTO_INCREMENT,
  `JenisCuci` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Harga` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdJenisCuci`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jeniscuci
-- ----------------------------
INSERT INTO `jeniscuci` VALUES (1, 'Jas', 20000);
INSERT INTO `jeniscuci` VALUES (2, 'Karpet', 10000);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of karyawan
-- ----------------------------
INSERT INTO `karyawan` VALUES (1000, '2222', 'ss', 's', 'ssd', 'sddddd', 1);
INSERT INTO `karyawan` VALUES (1001, '22312', '222', '1123', '1222', '332', NULL);
INSERT INTO `karyawan` VALUES (1003, '2222', '222', '1123', '1222', '332', NULL);

-- ----------------------------
-- Table structure for transaksi
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi`  (
  `IdTrx` int NOT NULL,
  `IdCucian` int NULL DEFAULT NULL,
  `Subtotal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Diskon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `GrandTotal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Tanggal` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `StatusTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdTrx`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaksi
-- ----------------------------
INSERT INTO `transaksi` VALUES (1, 1, '50000', '10000', '40000', '2022-10-23 14:05:51', 'Belum Lunas');

SET FOREIGN_KEY_CHECKS = 1;
