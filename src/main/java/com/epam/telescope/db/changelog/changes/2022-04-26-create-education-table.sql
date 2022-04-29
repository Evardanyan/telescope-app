--liquibase formatted sql
--changeset aragasparyan:create-table-education

CREATE TABLE `education` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `college` varchar(255) DEFAULT NULL,
  `degree` int DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `graduation_year` int DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `is_incomplete` bit(1) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `profile_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_education_profile_id` (`profile_id`),
  CONSTRAINT `fk_education_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table education;
