--liquibase formatted sql
--changeset aragasparyan:create-table-general_info

CREATE TABLE `general_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `job_function` varchar(255) DEFAULT NULL,
  `job_function_level` int DEFAULT NULL,
  `job_status` int DEFAULT NULL,
  `production_category` int DEFAULT NULL,
  `uid` bigint DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_manager` varchar(255) DEFAULT NULL,
  `primary_skill_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_general_info_primary_skill_id` (`primary_skill_id`),
  CONSTRAINT `fk_general_info_skill_id` FOREIGN KEY (`primary_skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- rollback drop table general_info;

--changeset aragasparyan:create-table-language_level_map

CREATE TABLE `language_level_map` (
  `general_info_id` bigint NOT NULL,
  `level` int DEFAULT NULL,
  `language` int NOT NULL,
  PRIMARY KEY (`general_info_id`,`language`),
  CONSTRAINT `fk_language_level_map_general_info_id` FOREIGN KEY (`general_info_id`) REFERENCES `general_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- rollback drop table language_level_map;
