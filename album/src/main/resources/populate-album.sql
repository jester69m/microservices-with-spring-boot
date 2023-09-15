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

CREATE TABLE `albums` (
    `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `user_id` bigint(19) unsigned DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by` bigint(19) unsigned DEFAULT NULL,
    `updated_by` bigint(19) unsigned DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `photos` (
    `id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `url` varchar(255) NOT NULL,
    `thumbnail_url` varchar(255) NOT NULL,
    `album_id` bigint(19) unsigned DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by` bigint(19) unsigned DEFAULT NULL,
    `updated_by` bigint(19) unsigned DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_album` (`album_id`),
    CONSTRAINT `fk_album` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;