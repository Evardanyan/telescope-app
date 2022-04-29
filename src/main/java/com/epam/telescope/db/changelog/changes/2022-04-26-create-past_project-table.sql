--liquibase formatted sql
--changeset aragasparyan:create-table-past_project

CREATE TABLE `past_project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `company_url` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `database_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end` datetime(6) DEFAULT NULL,
  `job_position` varchar(255) DEFAULT NULL,
  `participation` varchar(255) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `technologies` varchar(255) DEFAULT NULL,
  `tools` varchar(255) DEFAULT NULL,
  `epam_project` bigint DEFAULT NULL,
  `profile_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_past_project_epam_project` (`epam_project`),
  KEY `idx_past_project_profile_id` (`profile_id`),
  CONSTRAINT `fk_past_project_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  CONSTRAINT `fk_past_project_project_id` FOREIGN KEY (`epam_project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table past_project;