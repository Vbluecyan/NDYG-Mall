CREATE DATABASE IF NOT EXISTS NDYG DEFAULT CHARSET utf8;

USE NDYG;

CREATE TABLE IF NOT EXISTS `user`(
    `user_id` VARCHAR(10) COMMENT "用户ID 自定义",
    `password` CHAR(32) NOT NULL COMMENT "MD5密码",
    `nickname` VARCHAR(10) DEFAULT "时尚达人" NOT NULL COMMENT "昵称",
    `sex` CHAR(1) DEFAULT "" NOT NULL COMMENT "性别",
    `profile_photo` VARCHAR(500) DEFAULT "assets/profile_photo/default.jpg" COMMENT "头像",
    `member` TINYINT DEFAULT 0 COMMENT "是否会员：0 是 1 非,注：member是mysql保留字，sql语句中要把member加反引号",
    `shipping_address` VARCHAR(100) DEFAULT ""  COMMENT "收货地址",
    `favorites` VARCHAR(1400) DEFAULT ""  COMMENT "收藏 最多100",
    `suitcase` VARCHAR(140) DEFAULT ""  COMMENT "衣箱 最多10",
    PRIMARY KEY ( `user_id` )
);

CREATE TABLE IF NOT EXISTS `brand`(
    `brand_id` MEDIUMINT UNSIGNED AUTO_INCREMENT COMMENT "品牌ID",
    `brand_name` VARCHAR(15) NOT NULL COMMENT "品牌名",
    `details` VARCHAR(500) COMMENT "详情",
    PRIMARY KEY ( `brand_id` )
);

INSERT INTO `brand` (`brand_name`) VALUES ("李宁Lining");
INSERT INTO `brand` (`brand_name`) VALUES ("安踏Anta");
INSERT INTO `brand` (`brand_name`) VALUES ("特步XTEP");
INSERT INTO `brand` (`brand_name`) VALUES ("361度");
INSERT INTO `brand` (`brand_name`) VALUES ("匹克PEAK");
INSERT INTO `brand` (`brand_name`) VALUES ("鸿星尔克ERKE");
INSERT INTO `brand` (`brand_name`) VALUES ("贵人鸟");
INSERT INTO `brand` (`brand_name`) VALUES ("其他");

CREATE TABLE IF NOT EXISTS `category`(
    `category_id` MEDIUMINT UNSIGNED AUTO_INCREMENT COMMENT "品类ID",
    `category_name` VARCHAR(15) NOT NULL COMMENT "品类名",
    PRIMARY KEY ( `category_id` )
);

INSERT INTO `category` (`category_name`) VALUES ("上衣");
INSERT INTO `category` (`category_name`) VALUES ("T恤");
INSERT INTO `category` (`category_name`) VALUES ("卫衣");
INSERT INTO `category` (`category_name`) VALUES ("衬衫");
INSERT INTO `category` (`category_name`) VALUES ("西服");
INSERT INTO `category` (`category_name`) VALUES ("风衣");
INSERT INTO `category` (`category_name`) VALUES ("大衣");
INSERT INTO `category` (`category_name`) VALUES ("毛衣/针织衫");
INSERT INTO `category` (`category_name`) VALUES ("羽绒服/棉服");
INSERT INTO `category` (`category_name`) VALUES ("套装");
INSERT INTO `category` (`category_name`) VALUES ("夹克/外套");
INSERT INTO `category` (`category_name`) VALUES ("长裤");
INSERT INTO `category` (`category_name`) VALUES ("裙子");
INSERT INTO `category` (`category_name`) VALUES ("连体裤");
INSERT INTO `category` (`category_name`) VALUES ("背心/马甲");
INSERT INTO `category` (`category_name`) VALUES ("中裤/短裤");
INSERT INTO `category` (`category_name`) VALUES ("其他");

CREATE TABLE IF NOT EXISTS `style`(
    `style_id` MEDIUMINT UNSIGNED AUTO_INCREMENT COMMENT "风格ID",
    `style_name` VARCHAR(15) NOT NULL COMMENT "风格名",
    PRIMARY KEY ( `style_id` )
);

INSERT INTO `style` (`style_name`) VALUES ("奢侈精选");
INSERT INTO `style` (`style_name`) VALUES ("气质优雅");
INSERT INTO `style` (`style_name`) VALUES ("甜美可爱");
INSERT INTO `style` (`style_name`) VALUES ("个性时尚");
INSERT INTO `style` (`style_name`) VALUES ("经典牛仔");
INSERT INTO `style` (`style_name`) VALUES ("街头潮流");
INSERT INTO `style` (`style_name`) VALUES ("夜店派对");
INSERT INTO `style` (`style_name`) VALUES ("舒适休闲");
INSERT INTO `style` (`style_name`) VALUES ("度假旅行");
INSERT INTO `style` (`style_name`) VALUES ("经典大气");
INSERT INTO `style` (`style_name`) VALUES ("其他");

CREATE TABLE IF NOT EXISTS `clothing`(
    `clothing_id` VARCHAR(13) COMMENT "服装ID 机器时间",
    `date` DATE NOT NULL COMMENT "上架日期",
    `inventory` MEDIUMINT UNSIGNED NOT NULL COMMENT "库存数",
    `title` VARCHAR(50) NOT NULL COMMENT "标题",
    `picture` VARCHAR(300) NOT NULL COMMENT "图片 最多6",
    `price` INT UNSIGNED COMMENT "单租价格/天",
    `sex` CHAR(1) NOT NULL COMMENT "性别",
    `size` VARCHAR(20) NOT NULL COMMENT "尺寸：XS,S,M,L,XL,XXL,",
    `brand_id` MEDIUMINT UNSIGNED NOT NULL COMMENT "品牌ID",
    `category_id` MEDIUMINT UNSIGNED NOT NULL COMMENT "品类ID",
    `style_id` MEDIUMINT UNSIGNED NOT NULL COMMENT "风格ID",
    `texture` VARCHAR(15) DEFAULT "其他" COMMENT "材质",
    `thickness` VARCHAR(2) DEFAULT "其他" COMMENT "厚薄",
    `elastic` VARCHAR(2) DEFAULT "其他" COMMENT "弹力",
    `colour` VARCHAR(3) COMMENT "颜色",
    `season` VARCHAR(2) COMMENT "季节",
    `sales` MEDIUMINT UNSIGNED DEFAULT 0 COMMENT "月销量",
    `source` TINYINT DEFAULT 0 COMMENT "来源：0 自营 1 用户",
    PRIMARY KEY ( `clothing_id` ),
    FOREIGN KEY(`brand_id`) REFERENCES `brand`(`brand_id`),
    FOREIGN KEY(`category_id`) REFERENCES `category`(`category_id`),
    FOREIGN KEY(`style_id`) REFERENCES `style`(`style_id`)
);

CREATE TABLE IF NOT EXISTS `order`(
    `order_id` VARCHAR(13) COMMENT "订单ID 机器时间",
    `user_id` VARCHAR(10) NOT NULL COMMENT "用户ID",
    `clothing_id` VARCHAR(13) NOT NULL COMMENT "服装ID",
    `money` INT UNSIGNED COMMENT "单租交易价格",
    `creation_datetime` DATETIME NOT NULL COMMENT "创建时间",
    `finish_datetime` DATETIME COMMENT "成交时间",
    `expectant_return_date` DATE NOT NULL COMMENT "预期归还时间",
    `actual_return_date` DATE COMMENT "实际归还时间",
    `comment_picture` VARCHAR(300) COMMENT "评价图片 最多6",
    `comment_text` VARCHAR(200) COMMENT "评价文本 最多200",
    PRIMARY KEY ( `order_id` ),
    FOREIGN KEY(`user_id`) REFERENCES `user`(`user_id`),
    FOREIGN KEY(`clothing_id`) REFERENCES `clothing`(`clothing_id`)
);

CREATE TABLE IF NOT EXISTS `home`(
    `home_id` MEDIUMINT UNSIGNED AUTO_INCREMENT COMMENT "主页ID",
    `navigation_left` VARCHAR(100) NOT NULL COMMENT "左导航",
    `navigation_bar` VARCHAR(50) NOT NULL COMMENT "导航栏",
    `sideshow` VARCHAR(300) NOT NULL COMMENT "轮播图 最多6",
    `recommend` VARCHAR(340) NOT NULL COMMENT "推荐 最多24",
    PRIMARY KEY ( `home_id` )
); 

INSERT INTO `home` (`navigation_left`,`navigation_bar`,`sideshow`) VALUES ("上衣,T恤,卫衣,衬衫,西服,风衣,大衣,长裤,裙子,连体裤,",
"奢侈精选,气质优雅,甜美可爱,个性时尚,经典牛仔,街头潮流,舒适休闲,度假旅游",
"assets/sideshow/sideshow1.jpg,assets/sideshow/sideshow2.jpg,assets/sideshow/sideshow3.jpg,assets/sideshow/sideshow4.jpg,assets/sideshow/sideshow5.jpg,");






