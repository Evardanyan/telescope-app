--liquibase formatted sql
--changeset aragasparyan:create-table-project

CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `project_code` varchar(255) DEFAULT NULL,
  `project_health` int DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table project;

--changeset aragasparyan:create-table-project_technology

CREATE TABLE `project_technology` (
  `project_id` bigint NOT NULL,
  `skill_id` bigint NOT NULL,
  PRIMARY KEY (`project_id`,`skill_id`),
  KEY `idx_training_course_profile_id` (`skill_id`),
  CONSTRAINT `fk_project_technology_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `fk_project_technology_skill_id` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table project_technology;