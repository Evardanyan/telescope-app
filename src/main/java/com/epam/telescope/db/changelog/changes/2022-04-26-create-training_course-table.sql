--liquibase formatted sql
--changeset aragasparyan:create-table-training_course

CREATE TABLE `training_course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `end` datetime(6) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `requirements` varchar(255) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `technologies` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL,
  `profile_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_training_course_profile_id` (`profile_id`),
  CONSTRAINT `fk_training_course_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table training_course;