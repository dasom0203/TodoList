
-- shin.todo definition

CREATE TABLE `todo` (
  `TODO_NUM` int NOT NULL AUTO_INCREMENT,
  `TODO_CONTENT` varchar(200) NOT NULL,
  `TODO_STATUS` enum('완료','미완료') NOT NULL DEFAULT '미완료',
  `TODO_IMPORTANT` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`TODO_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;



-- shin.`member` definition

CREATE TABLE `member` (
  `MEMBER_ID` varchar(255) NOT NULL,
  `MEMBER_PASSWORD` varchar(50) NOT NULL,
  `MEMBER_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
