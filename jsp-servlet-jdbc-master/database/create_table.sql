use newsqlservlet02102020;

CREATE TABLE role(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL,
createddate TIMESTAMP NULL,
modifeddate TIMESTAMP NULL,
createdby VARCHAR(255) NULL,
modifiedby VARCHAR(255) NULL
);

CREATE TABLE user(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(150) NOT NULL,
password VARCHAR(150) NOT NULL,
fullname VARCHAR(150) NULL,
status int NOT NULL,
roleid bigint NOT NULL,
createddate TIMESTAMP NULL,
modifeddate TIMESTAMP NULL,
createdby VARCHAR(255) NULL,
modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE news(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
title  VARCHAR(255) NULL,
thumbnail VARCHAR(150) NOT NULL,
shortdecription TEXT NOT NULL,
content TEXT NOT NULL,
categoryid bigint NOT NULL,
createddate TIMESTAMP NULL,
modifeddate TIMESTAMP NULL,
createdby VARCHAR(255) NULL,
modifiedby VARCHAR(255) NULL
);

CREATE TABLE category(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL,
createddate TIMESTAMP NULL,
modifeddate TIMESTAMP NULL,
createdby VARCHAR(255) NULL,
modifiedby VARCHAR(255) NULL
);
ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);

CREATE TABLE comments(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
content TEXT NOT NULL,
userid bigint NOT NULL,
newsid bigint NOT NULL,
createddate TIMESTAMP NULL,
modifeddate TIMESTAMP NULL,
createdby VARCHAR(255) NULL,
modifiedby VARCHAR(255) NULL
);
ALTER TABLE commnent ADD CONSTRAINT fk_comment_user FOREIGN KEY (userid) REFERENCES user(id);
ALTER TABLE commnent ADD CONSTRAINT fk_comment_news FOREIGN KEY (newsid) REFERENCES news(id);