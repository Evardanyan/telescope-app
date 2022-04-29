--liquibase formatted sql
--changeset aragasparyan:create-table-profile_project

CREATE TABLE `profile_project` (
  `profile_id` bigint NOT NULL,
  `project_id` bigint NOT NULL,
  KEY `idx_profile_project_project_id` (`project_id`),
  KEY `idx_profile_project_profile_id` (`profile_id`),
  CONSTRAINT `fk_profile_project_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `fk_profile_project_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table profile_project;