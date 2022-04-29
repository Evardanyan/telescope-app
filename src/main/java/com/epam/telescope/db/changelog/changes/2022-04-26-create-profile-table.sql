--liquibase formatted sql
--changeset aragasparyan:create-table-profile

CREATE TABLE `profile` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `general_info_id` bigint DEFAULT NULL,
  `personal_info_id` bigint DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_profile_general_info_id` (`general_info_id`),
  KEY `idx_profile_personal_info_id` (`personal_info_id`),
  CONSTRAINT `fk_profile_personal_info_id` FOREIGN KEY (`personal_info_id`) REFERENCES `personal_info` (`id`),
  CONSTRAINT `fk_profile_general_info_id` FOREIGN KEY (`general_info_id`) REFERENCES `general_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table profile;

--changeset aragasparyan:create-table-skill_level_map

CREATE TABLE `skill_level_map` (
  `profile_id` bigint NOT NULL,
  `level` int DEFAULT NULL,
  `skill` bigint NOT NULL,
  PRIMARY KEY (`profile_id`,`skill`),
  KEY `idx_skill_level_map_skill` (`skill`),
  CONSTRAINT `fk_skill_level_map_skill_id` FOREIGN KEY (`skill`) REFERENCES `skill` (`id`),
  CONSTRAINT `fk_skill_level_map_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table skill_level_map;