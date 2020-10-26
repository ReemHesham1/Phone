CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_contacts` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `emergency_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmo0c5ro6kunnfq71x4bcwb9eh` (`user_id`),
  CONSTRAINT `FKmo0c5ro6kunnfq71x4bcwb9eh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `phone_numbers` (
  `id` bigint NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `contact_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi08v90a5ws6y969y6aqijo1f3` (`contact_id`),
  CONSTRAINT `FKi08v90a5ws6y969y6aqijo1f3` FOREIGN KEY (`contact_id`) REFERENCES `user_contacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `emails` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKehaldslmttktgq05t00yoicsn` (`contact_id`),
  CONSTRAINT `FKehaldslmttktgq05t00yoicsn` FOREIGN KEY (`contact_id`) REFERENCES `user_contacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

