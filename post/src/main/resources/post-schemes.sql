UNLOCK TABLES;

DROP TABLE IF EXISTS `post_tag`;
DROP TABLE IF EXISTS `tags`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `comments`;
DROP TABLE IF EXISTS `posts`;
DROP TABLE IF EXISTS `photos`;
DROP TABLE IF EXISTS `albums`;
DROP TABLE IF EXISTS `todos`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `geo`;

CREATE TABLE `tags` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(19) unsigned NOT NULL,
  `updated_by` bigint(19) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `posts` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `user_id` bigint(19) unsigned DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(19) unsigned DEFAULT NULL,
  `updated_by` bigint(19) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `post_tag` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint(19) unsigned NOT NULL,
  `tag_id` bigint(19) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_posttag_post_id` (`post_id`),
  KEY `fk_posttag_tag_id` (`tag_id`),
  CONSTRAINT `fk_posttag_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `fk_posttag_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comments` (
  `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `post_id` bigint(19) unsigned DEFAULT NULL,
  `user_id` bigint(19) unsigned DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(19) unsigned NOT NULL,
  `updated_by` bigint(19) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_post` (`post_id`),
  CONSTRAINT `fk_comment_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


