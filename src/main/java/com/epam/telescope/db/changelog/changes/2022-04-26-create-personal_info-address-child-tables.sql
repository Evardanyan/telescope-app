--liquibase formatted sql
--changeset aragasparyan:create-table-personal_info

CREATE TABLE `personal_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) DEFAULT NULL,
  `driver_license` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `governmental_id` varchar(255) DEFAULT NULL,
  `native_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `remote_work_possibility` bit(1) DEFAULT NULL,
  `t_shirt_size` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table personal_info;

--changeset aragasparyan:create-table-address

CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `building` int DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `is_primary` bit(1) DEFAULT NULL,
  `post_offic_box` int DEFAULT NULL,
  `room` int DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `territory` varchar(255) DEFAULT NULL,
  `zip_code` int DEFAULT NULL,
  `personal_info_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_address_personal_info_id` (`personal_info_id`),
  CONSTRAINT `fk_address_personal_info_id` FOREIGN KEY (`personal_info_id`) REFERENCES `personal_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table address;

--changeset aragasparyan:create-table-child

CREATE TABLE `child` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `personal_info_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_child_personal_info_id` (`personal_info_id`),
  CONSTRAINT `fk_child_personal_info_id` FOREIGN KEY (`personal_info_id`) REFERENCES `personal_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

--rollback drop table child;

