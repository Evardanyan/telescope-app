--liquibase formatted sql
--changeset emintermkrtchyan:create-table-email_confirmation_token

CREATE TABLE `email_confirmation_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `confirmed_at` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `expires_at` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  `profile_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_email_confirmation_token_profile_id` (`profile_id`),
  CONSTRAINT `fk_email_confirmation_token_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table email_confirmation_token;

--changeset emintermkrtchyan:alter-table-profile

ALTER TABLE `profile`
ADD COLUMN `is_enabled` BIT(1) NULL DEFAULT NULL AFTER `password`;

--rollback ALTER TABLE `profile` DROP COLUMN `is_enabled`;
