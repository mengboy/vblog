CREATE TABLE tb_comment(
comment_id INT(20) PRIMARY KEY auto_increment,
article_id INT(20),
parent_id INT(20) DATETIME NOT NULL DEFAULT 0,
user_id INT(20),
comment_ip VARCHAR(25),
comment_author VARCHAR(30),
comment_text text,
comment_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
comment_email VARCHAR(30),
comment_status VARCHAR(20),
CONSTRAINT `article_id_comfk` FOREIGN KEY (`article_id`) REFERENCES `tb_article` (`article_id`),
CONSTRAINT `user_id_comfk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
)

CREATE TABLE tb_menu(
menuId int(5) PRIMARY KEY auto_increment,
menuTitle VARCHAR(20),
menuLiId VARCHAR(20),
menuUrl VARCHAR(70),
menuLevel INT(1),
menuParent INT(5),
)
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel) VALUES ('文章', 'article', '#', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('所有文章', 'article', '/admin/content/list_article', '2', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('撰写文章', 'article', '/admin/content/edit_article', '2', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('分类', 'article', '/admin/content/category', '2', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('标签', 'article', '/admin/content/tag', '2', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('评论', 'article', '/admin/comment', '2', '1');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel) VALUES ('页面', 'page', '#', '1');

INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('所有页面', 'page', '/admin/list_page', '2', '5');
INSERT INTO tb_menu (menuTitle, menuLiId, menuUrl, menuLevel, menuParent) VALUES ('新建页面', 'page', '/admin/new_page', '2', '5');


CREATE create table tb_user (
  user_id int(20) PRIMARY KEY auto_increment,
  user_name VARCHAR(25),
  user_rname VARCHAR(25),
  user_password VARCHAR(25),
  user_salt VARCHAR(25),
  user_email VARCHAR(25),
  user_mobile VARCHAR(25),
  user_role INT(1),
  content_count INT(20),
  comment_count INT(20),
  user_created DATE
)


CREATE TABLE tb_article(
article_id int(20) PRIMARY KEY auto_increment,
article_title VARCHAR(20),
article_text text,
article_summary VARCHAR(500),
article_markdown int(1),
article_module VARCHAR(20),
user_id int(20),
article_author VARCHAR(20),
article_view int(20) NOT NULL DEFAULT 0,
article_created DATE NOT NULL,
article_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
article_keywords VARCHAR(25),
article_desc VARCHAR(25),
article_status VARCHAR (20),
article_comment_enable VARCHAR(10) NOT NULL DEFAULT 'open',
CONSTRAINT `user_id_ibfk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`)
)


CREATE TABLE tb_taxonomy(
tax_id int(20) PRIMARY KEY auto_increment,
tax_title VARCHAR(25),
tax_text VARCHAR(500),
tax_slug VARCHAR(25),
tax_type VARCHAR(25),
tax_content_module VARCHAR(25),
tax_content_count INT(20) NOT NULL DEFAULT 0,
tax_parent_id INT(20)
)

CREATE TABLE tb_content_tax(
id INT(20),
article_id INT(20),
tax_id INT(20),
CONSTRAINT `article_id_ibfk` FOREIGN KEY (`article_id`) REFERENCES `tb_article` (`article_id`),
CONSTRAINT `tax_id_ibfk` FOREIGN KEY (`tax_id`) REFERENCES `tb_taxonomy` (`tax_id`)
)

