CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `password` varchar(255),
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `info` (
  `user_id` int PRIMARY KEY,
  `DOB` date,
  `Address` varchar(255),
  `Phone_number` varchar(255),
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `flag_lookup` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `value` varchar(255)
);

CREATE TABLE `type_lookup` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `value` varchar(255)
);

CREATE TABLE `data` (
  `user_id` int,
  `flag_id` int,
  `type_id` int,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `amount` int,
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  FOREIGN KEY (`flag_id`) REFERENCES `flag_lookup` (`id`),
  FOREIGN KEY (`type_id`) REFERENCES `type_lookup` (`id`)
);
