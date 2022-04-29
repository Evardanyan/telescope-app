--liquibase formatted sql
--changeset aragasparyan:create-table-skill

CREATE TABLE `skill` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- rollback drop table skill;
