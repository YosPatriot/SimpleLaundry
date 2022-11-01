/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : simple

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 01/11/2022 16:25:31
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
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cucian
-- ----------------------------
INSERT INTO `cucian` VALUES (87, 10072, 1, '2022-10-29 01:45:00', '2022-10-29', NULL, 3, 'Menunggu Pembayaran');
INSERT INTO `cucian` VALUES (88, 10074, 1, '2022-10-29 01:47:30', '2022-10-29', '2022-10-29', 2, 'Selesai');
INSERT INTO `cucian` VALUES (89, 10075, 1, '2022-10-29 01:47:39', '2022-10-30', NULL, 2, 'Menunggu Pembayaran');
INSERT INTO `cucian` VALUES (90, 10076, 2, '2022-10-29 16:23:45', '2022-10-30', '2022-10-29', 2, 'Selesai');
INSERT INTO `cucian` VALUES (91, 10077, 1, '2022-11-01 14:35:07', '2022-11-01', '2022-11-01', 2, 'Selesai');
INSERT INTO `cucian` VALUES (92, 10078, 1, '2022-11-01 15:27:55', NULL, NULL, 2, 'Menunggu Antrian');

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
) ENGINE = InnoDB AUTO_INCREMENT = 10080 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (10039, 'vvxcvxcvxcvx', 'svvzsad', 's222', 'Member', NULL);
INSERT INTO `customer` VALUES (10042, '1sdas', 'asdd', 'gg', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10043, '1sdas', 'asdd', 'gg', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10044, 'Dera Ag', '3123', '2321', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10045, 'gbbcx', 'sdfggg', 'sdffsdf', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10046, 'nmm,m,mn,', 'ssss', '213123', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10047, 'sadasd', 'asdasdasd', 'xzc', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10048, 'dasd', 'xasd', 'z', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10049, 'sgggggg', 'sefasdasdsadsda', 'asdawwvzxa', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10050, 'zxc', 'se', 'asda', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10051, 'zxcdd', 'se', 'asda', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10052, 'zxcsdq1', 'sefasdasdsad', 'asdaww', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10053, 'zxczs', 'asdasd', 'sad', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10054, 'zxczs', 'asdasd', 'sadvvzx', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10055, 'zxczssdsd', 'asdasd', 'sadvvzx', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10056, 'czxczxc', 'sezxczxc', 'asda', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10057, 'xzczxbbbbbbbb zxcsdq1', 'sefasdasdsad', 'asdaww', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10058, 'zxcdd zxcvzxczxc', 'se', 'asda', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10059, 'aas', 'dd', '22', 'Member', '2022-10-29');
INSERT INTO `customer` VALUES (10060, 'c', 'xzasd', 'sd', 'Member', '2022-10-29');
INSERT INTO `customer` VALUES (10061, 'sd', 'asdas', 'da', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10062, 'cbm]lpdfmg[sdmfsadf', 'aaasdfsdf', 'cvncvnxcv', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10063, 'zxczxasd', 'dd', '22', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10064, 'asd', 'asdddas', 'zxc', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10065, 'hhhhhh', 'sdasd', '232', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10066, 'sd', 'dasd', 'aas', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10067, 'hhhhhjjasd', 'dasd', 'aas', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10068, 'vzx', 'dasdas', 'sss', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10069, 'ffasds', 'dasdas', 'sss', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10070, 'ololol', 'ssdds', 'ss', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10071, 'aahhh', 'zxc', 'xc', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10072, 'ihhh', 'zxczxczx', 'xczx', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10073, 'hhhhhh', 'asds', 'aaa', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10074, 'lololololololo', 'asds', 'aaa', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10075, '45555', 'asds', 'aaa', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10076, 'asdasd', 'asd', 'zxxzc', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10077, 'sdaxx', 'dasdas', 'ddx', 'Non-Member', NULL);
INSERT INTO `customer` VALUES (10078, 'vvv', 'daa', 'ss', 'Non-Member', '2022-11-01');
INSERT INTO `customer` VALUES (10079, 'addd', 'dddd', 'ddd', 'Member', '2022-11-01');

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
INSERT INTO `jeniscuci` VALUES (1, 'Jas', 20000);
INSERT INTO `jeniscuci` VALUES (2, '22', 3123);
INSERT INTO `jeniscuci` VALUES (4, '2222', 3123);

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
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaksi
-- ----------------------------
INSERT INTO `transaksi` VALUES (42, 78, '40000.0', '0.0', '40000.0', '2022-10-28', 'Lunas');
INSERT INTO `transaksi` VALUES (43, 79, '40000.0', '0.0', '40000.0', '2022-10-28', 'Lunas');
INSERT INTO `transaksi` VALUES (44, 80, '40000.0', '0.0', '40000.0', '2022-10-28', 'Lunas');
INSERT INTO `transaksi` VALUES (45, 81, '40000.0', '0.0', '40000.0', '2022-10-28', 'Belum Lunas');
INSERT INTO `transaksi` VALUES (46, 82, '40000.0', '0.0', '40000.0', '2022-10-28', 'Belum Lunas');
INSERT INTO `transaksi` VALUES (47, 83, '40000.0', '0.0', '40000.0', '2022-10-29', 'Lunas');
INSERT INTO `transaksi` VALUES (48, 84, '40000.0', '0.0', '40000.0', '2022-10-29', 'Belum Lunas');
INSERT INTO `transaksi` VALUES (49, 85, '40000.0', '0.0', '40000.0', '2022-10-29', 'Lunas');
INSERT INTO `transaksi` VALUES (50, 86, '40000.0', '0.0', '40000.0', '2022-10-29', 'Lunas');
INSERT INTO `transaksi` VALUES (51, 87, '60000.0', '0.0', '60000.0', '2022-11-01', 'Lunas');
INSERT INTO `transaksi` VALUES (52, 88, '40000.0', '0.0', '40000.0', '2022-10-29', 'Lunas');
INSERT INTO `transaksi` VALUES (53, 89, '40000.0', '0.0', '40000.0', '2022-10-29', 'Belum Lunas');
INSERT INTO `transaksi` VALUES (54, 90, '6246.0', '0.0', '6246.0', '2022-10-29', 'Lunas');
INSERT INTO `transaksi` VALUES (55, 91, '40000.0', '0.0', '40000.0', '2022-11-01', 'Lunas');
INSERT INTO `transaksi` VALUES (56, 92, '40000.0', '0.0', '40000.0', '2022-11-01', 'Lunas');

SET FOREIGN_KEY_CHECKS = 1;
