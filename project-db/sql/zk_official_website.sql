/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : zk_official_website

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 08/04/2021 16:01:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zk_admin
-- ----------------------------
DROP TABLE IF EXISTS `zk_admin`;
CREATE TABLE `zk_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '管理员名称',
  `password` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '管理员密码',
  `last_login_ip` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近一次登录时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '\'' COMMENT '头像图片',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `role_ids` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '[]' COMMENT '角色列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_admin
-- ----------------------------
INSERT INTO `zk_admin` VALUES (1, 'admin123', '$2a$10$.rEfyBb/GURD9P2p0fRg/OAJGloGNDkJS4lY0cQHeqDgsbdTylBpu', '0:0:0:0:0:0:0:1', '2021-04-08 15:38:55', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2018-02-01 00:00:00', '2021-04-08 15:38:55', 0, '[1]');
INSERT INTO `zk_admin` VALUES (4, 'promotion123', '$2a$10$wDZLOLLnzZ1EFZ3ldZ1XFOUWDEX6TnQCUFdJz4g.PoMaLTzS8TjWq', '0:0:0:0:0:0:0:1', '2021-04-08 10:59:55', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:16:59', '2021-04-08 10:59:55', 0, '[3]');
INSERT INTO `zk_admin` VALUES (5, 'mall123', '$2a$10$aCtsc4rG6KmxQ59.IkYse.oRyKuwQoU2CPCmxSdB.d5nXq6aw/z4O', '0:0:0:0:0:0:0:1', '2021-04-08 11:14:25', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:17:25', '2021-04-08 11:14:25', 0, '[2]');
INSERT INTO `zk_admin` VALUES (6, 'mall1234', '$2a$10$aCtsc4rG6KmxQ59.IkYse.oRyKuwQoU2CPCmxSdB.d5nXq6aw/z4O', '0:0:0:0:0:0:0:1', '2021-04-08 10:52:11', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2019-01-07 15:17:25', '2021-04-08 10:52:11', 0, '[3]');

-- ----------------------------
-- Table structure for zk_log
-- ----------------------------
DROP TABLE IF EXISTS `zk_log`;
CREATE TABLE `zk_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '管理员',
  `ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '管理员地址',
  `type` int(11) NULL DEFAULT NULL COMMENT '操作分类',
  `action` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作动作',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '操作状态',
  `result` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作结果，或者成功消息，或者失败消息',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '补充信息',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_log
-- ----------------------------
INSERT INTO `zk_log` VALUES (1, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2019-12-08 19:12:40', '2019-12-08 19:12:40', 0);
INSERT INTO `zk_log` VALUES (43, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 10:39:32', '2021-03-26 10:39:32', 0);
INSERT INTO `zk_log` VALUES (44, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 10:42:08', '2021-03-26 10:42:08', 0);
INSERT INTO `zk_log` VALUES (45, 'admin123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-03-26 11:52:38', '2021-03-26 11:52:38', 0);
INSERT INTO `zk_log` VALUES (46, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 13:38:13', '2021-03-26 13:38:13', 0);
INSERT INTO `zk_log` VALUES (47, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-03-26 16:21:50', '2021-03-26 16:21:50', 0);
INSERT INTO `zk_log` VALUES (48, '匿名用户', '0:0:0:0:0:0:0:1', 1, '登录', 0, '认证失败', '', '2021-04-07 15:08:18', '2021-04-07 15:08:18', 0);
INSERT INTO `zk_log` VALUES (49, '匿名用户', '0:0:0:0:0:0:0:1', 1, '登录', 0, '认证失败', '', '2021-04-07 15:12:23', '2021-04-07 15:12:23', 0);
INSERT INTO `zk_log` VALUES (50, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-07 15:16:46', '2021-04-07 15:16:46', 0);
INSERT INTO `zk_log` VALUES (51, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-07 15:34:11', '2021-04-07 15:34:11', 0);
INSERT INTO `zk_log` VALUES (52, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-07 15:41:59', '2021-04-07 15:41:59', 0);
INSERT INTO `zk_log` VALUES (53, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-07 15:42:02', '2021-04-07 15:42:02', 0);
INSERT INTO `zk_log` VALUES (54, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:07:31', '2021-04-08 10:07:31', 0);
INSERT INTO `zk_log` VALUES (55, 'admin123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:17:26', '2021-04-08 10:17:26', 0);
INSERT INTO `zk_log` VALUES (56, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:17:32', '2021-04-08 10:17:32', 0);
INSERT INTO `zk_log` VALUES (57, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:18:36', '2021-04-08 10:18:36', 0);
INSERT INTO `zk_log` VALUES (58, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:21:09', '2021-04-08 10:21:09', 0);
INSERT INTO `zk_log` VALUES (59, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:23:02', '2021-04-08 10:23:02', 0);
INSERT INTO `zk_log` VALUES (60, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:24:06', '2021-04-08 10:24:06', 0);
INSERT INTO `zk_log` VALUES (61, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:34:02', '2021-04-08 10:34:02', 0);
INSERT INTO `zk_log` VALUES (62, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:39:49', '2021-04-08 10:39:49', 0);
INSERT INTO `zk_log` VALUES (63, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:40:07', '2021-04-08 10:40:07', 0);
INSERT INTO `zk_log` VALUES (64, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:43:19', '2021-04-08 10:43:19', 0);
INSERT INTO `zk_log` VALUES (65, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:45:19', '2021-04-08 10:45:19', 0);
INSERT INTO `zk_log` VALUES (66, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:48:56', '2021-04-08 10:48:56', 0);
INSERT INTO `zk_log` VALUES (67, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:49:19', '2021-04-08 10:49:19', 0);
INSERT INTO `zk_log` VALUES (68, 'mall1234', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:49:30', '2021-04-08 10:49:30', 0);
INSERT INTO `zk_log` VALUES (69, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:49:47', '2021-04-08 10:49:47', 0);
INSERT INTO `zk_log` VALUES (70, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:51:36', '2021-04-08 10:51:36', 0);
INSERT INTO `zk_log` VALUES (71, 'mall1234', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:52:11', '2021-04-08 10:52:11', 0);
INSERT INTO `zk_log` VALUES (72, 'mall1234', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 10:59:35', '2021-04-08 10:59:35', 0);
INSERT INTO `zk_log` VALUES (73, 'promotion123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 10:59:55', '2021-04-08 10:59:55', 0);
INSERT INTO `zk_log` VALUES (74, 'promotion123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 11:00:05', '2021-04-08 11:00:05', 0);
INSERT INTO `zk_log` VALUES (75, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:13:15', '2021-04-08 11:13:15', 0);
INSERT INTO `zk_log` VALUES (76, 'mall123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:14:25', '2021-04-08 11:14:25', 0);
INSERT INTO `zk_log` VALUES (77, 'mall123', '0:0:0:0:0:0:0:1', 1, '退出', 1, '', '', '2021-04-08 11:22:56', '2021-04-08 11:22:56', 0);
INSERT INTO `zk_log` VALUES (78, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:23:01', '2021-04-08 11:23:01', 0);
INSERT INTO `zk_log` VALUES (79, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:37:10', '2021-04-08 11:37:10', 0);
INSERT INTO `zk_log` VALUES (80, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 11:39:52', '2021-04-08 11:39:52', 0);
INSERT INTO `zk_log` VALUES (81, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 13:50:01', '2021-04-08 13:50:01', 0);
INSERT INTO `zk_log` VALUES (82, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:27:22', '2021-04-08 15:27:22', 0);
INSERT INTO `zk_log` VALUES (83, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:30:22', '2021-04-08 15:30:22', 0);
INSERT INTO `zk_log` VALUES (84, 'admin123', '192.168.0.131', 1, '登录', 1, '', '', '2021-04-08 15:35:18', '2021-04-08 15:35:18', 0);
INSERT INTO `zk_log` VALUES (85, 'admin123', '0:0:0:0:0:0:0:1', 1, '登录', 1, '', '', '2021-04-08 15:38:55', '2021-04-08 15:38:55', 0);

-- ----------------------------
-- Table structure for zk_permission
-- ----------------------------
DROP TABLE IF EXISTS `zk_permission`;
CREATE TABLE `zk_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `permission` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_permission
-- ----------------------------
INSERT INTO `zk_permission` VALUES (1, 1, '*', '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `zk_permission` VALUES (2, 2, 'admin:category:read', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (3, 2, 'admin:category:update', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (4, 2, 'admin:category:delete', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (5, 2, 'admin:category:create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (6, 2, 'admin:category:list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (7, 2, 'admin:brand:create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (8, 2, 'admin:brand:list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (9, 2, 'admin:brand:delete', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (10, 2, 'admin:brand:read', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (11, 2, 'admin:brand:update', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 1);
INSERT INTO `zk_permission` VALUES (12, 3, 'admin:ad:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (13, 3, 'admin:ad:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (14, 3, 'admin:ad:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (15, 3, 'admin:ad:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (16, 3, 'admin:ad:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (17, 3, 'admin:groupon:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (18, 3, 'admin:groupon:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (19, 3, 'admin:groupon:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (20, 3, 'admin:groupon:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (21, 3, 'admin:groupon:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (22, 3, 'admin:topic:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (23, 3, 'admin:topic:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (24, 3, 'admin:topic:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (25, 3, 'admin:topic:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (26, 3, 'admin:topic:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (27, 3, 'admin:coupon:list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (28, 3, 'admin:coupon:delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (29, 3, 'admin:coupon:read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (30, 3, 'admin:coupon:create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (31, 3, 'admin:coupon:update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 1);
INSERT INTO `zk_permission` VALUES (32, 2, 'admin:web:mangement', '2021-04-08 11:10:15', '2021-04-08 11:10:17', 1);
INSERT INTO `zk_permission` VALUES (33, 2, 'admin:role:update', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (34, 2, 'admin:role:delete', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (35, 2, 'admin:role:read', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (36, 2, 'admin:role:permission:get', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (37, 2, 'admin:role:create', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (38, 2, 'admin:role:list', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (39, 2, 'admin:role:permission:update', '2021-04-08 11:42:28', '2021-04-08 11:42:28', 1);
INSERT INTO `zk_permission` VALUES (40, 2, 'admin:role:update', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (41, 2, 'admin:role:delete', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (42, 2, 'admin:role:read', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (43, 2, 'admin:role:permission:get', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (44, 2, 'admin:role:create', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (45, 2, 'admin:role:list', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (46, 2, 'admin:role:permission:update', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (47, 2, 'admin:web:mangement', '2021-04-08 11:42:31', '2021-04-08 11:42:31', 0);
INSERT INTO `zk_permission` VALUES (48, 3, 'admin:web:mangement', '2021-04-08 11:42:34', '2021-04-08 11:42:34', 1);
INSERT INTO `zk_permission` VALUES (49, 3, 'admin:role:update', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (50, 3, 'admin:role:delete', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (51, 3, 'admin:role:read', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (52, 3, 'admin:role:permission:get', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (53, 3, 'admin:role:create', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (54, 3, 'admin:role:list', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (55, 3, 'admin:role:permission:update', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (56, 3, 'admin:web:mangement', '2021-04-08 11:52:09', '2021-04-08 11:52:09', 1);
INSERT INTO `zk_permission` VALUES (57, 3, 'admin:web:mangement', '2021-04-08 11:52:58', '2021-04-08 11:52:58', 0);

-- ----------------------------
-- Table structure for zk_role
-- ----------------------------
DROP TABLE IF EXISTS `zk_role`;
CREATE TABLE `zk_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `desc` varchar(1023) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_UNIQUE`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_role
-- ----------------------------
INSERT INTO `zk_role` VALUES (1, '超级管理员', '所有模块的权限', 1, '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `zk_role` VALUES (2, '商场管理员', '只有商场模块的操作权限', 1, '2019-01-01 00:00:00', '2019-01-07 15:15:12', 0);
INSERT INTO `zk_role` VALUES (3, '推广管理员', '只有推广模块的操作权限', 1, '2019-01-01 00:00:00', '2019-01-07 15:15:24', 0);

-- ----------------------------
-- Table structure for zk_storage
-- ----------------------------
DROP TABLE IF EXISTS `zk_storage`;
CREATE TABLE `zk_storage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的唯一索引',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型',
  `size` int(11) NOT NULL COMMENT '文件大小',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件访问链接',
  `add_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件存储表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zk_storage
-- ----------------------------
INSERT INTO `zk_storage` VALUES (12, 'sl9q336i0u1ew2p7kv8m.jpg', 'fc2a95acfbf7421f9cbf496b77801292.jpg', 'image/jpeg', 16108, 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg', '2021-04-08 15:39:03', '2021-04-08 15:39:03', 0);

SET FOREIGN_KEY_CHECKS = 1;
