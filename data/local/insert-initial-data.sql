-- Social

CREATE TABLE IF NOT EXISTS `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `first_address` varchar(500) DEFAULT NULL,
  `second_address` varchar(500) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `company`
  ADD CONSTRAINT `company_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`);

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `confirmation_token` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `vkontakte_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `social_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `vkontakte_profile`
  ADD CONSTRAINT `vkontakte_profile_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `self_description` text NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `job_position` varchar(255) NOT NULL,
  `location_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `company_id` (`company_id`),
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `user_profile`
  ADD CONSTRAINT `user_profile_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_profile_company_fk` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `user_profile_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`);

-- Event

CREATE TABLE IF NOT EXISTS `hall` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `location_id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `hall`
  ADD CONSTRAINT `hall_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`);

CREATE TABLE IF NOT EXISTS `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `hall_id` bigint(20) NOT NULL,
  `internal_location` varchar(500) NOT NULL,
  `place_count` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hall_id` (`hall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `room`
  ADD CONSTRAINT `room_hall_fk` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`);

CREATE TABLE IF NOT EXISTS `hall_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `hall_event_type` varchar(255) NOT NULL DEFAULT 'Conference',
  `hall_id` bigint(20) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `time_slot_in_minutes` bigint(20) NOT NULL DEFAULT 5,
  `registration_start_time` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hall_id` (`hall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `hall_event`
  ADD CONSTRAINT `hall_event_hall_fk` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`);

CREATE TABLE IF NOT EXISTS `participant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `hall_event_id` bigint(20) NOT NULL,
  `system_photo_filename` varchar(255) NOT NULL,
  `public_photo_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `hall_event_id` (`hall_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `participant`
  ADD CONSTRAINT `participant_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `participant_hall_event_fk` FOREIGN KEY (`hall_event_id`) REFERENCES `hall_event` (`id`);

CREATE TABLE IF NOT EXISTS `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hall_event_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `partner_role` varchar(255) NOT NULL,
  `custom_role_name` varchar(255) NOT NULL,
  `system_logo_filename` varchar(255) NOT NULL,
  `public_logo_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hall_event_id` (`hall_event_id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `partner`
  ADD CONSTRAINT `partner_hall_event_fk` FOREIGN KEY (`hall_event_id`) REFERENCES `hall_event` (`id`),
  ADD CONSTRAINT `partner_company_fk` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

CREATE TABLE IF NOT EXISTS `comment_author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `hall_event_id` bigint(20) NOT NULL,
  `system_photo_filename` varchar(255) NOT NULL,
  `public_photo_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `hall_event_id` (`hall_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `comment_author`
  ADD CONSTRAINT `comment_author_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `comment_author_hall_event_fk` FOREIGN KEY (`hall_event_id`) REFERENCES `hall_event` (`id`);

CREATE TABLE IF NOT EXISTS `event_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_author_id` bigint(20) NOT NULL,
  `event_comment_type` varchar(255) NOT NULL DEFAULT 'BeforeComment',
  `comment_text` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `comment_author_id` (`comment_author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `event_comment`
  ADD CONSTRAINT `event_comment_comment_author_fk` FOREIGN KEY (`comment_author_id`) REFERENCES `comment_author` (`id`);

CREATE TABLE IF NOT EXISTS `event_subscription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hall_event_id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hall_event_id` (`hall_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `event_subscription`
  ADD CONSTRAINT `event_subscription_hall_event_fk` FOREIGN KEY (`hall_event_id`) REFERENCES `hall_event` (`id`);

-- Content

CREATE TABLE IF NOT EXISTS `talk_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event` varchar(500) NOT NULL,
  `branch` varchar(500) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `speakers` text NOT NULL,
  `room_event_type` varchar(255) NOT NULL DEFAULT 'Report',
  `minimal_time_in_minutes` bigint(20) NOT NULL,
  `maximal_time_in_minutes` bigint(20) NOT NULL,
  `presentation_url` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `other_conferences` text DEFAULT NULL,
  `key_technologies` text NOT NULL,
  `reporter_wishes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `talk_request`
  ADD CONSTRAINT `talk_request_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS `event_branch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `system_picture_filename` varchar(255) NOT NULL,
  `public_picture_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `branch_leader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `system_photo_filename` varchar(255) NOT NULL,
  `public_photo_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `branch_leader`
  ADD CONSTRAINT `branch_leader_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

CREATE TABLE IF NOT EXISTS `speaker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `system_photo_filename` varchar(255) NOT NULL,
  `public_photo_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `speaker`
  ADD CONSTRAINT `speaker_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `speaker_company_fk` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

CREATE TABLE IF NOT EXISTS `speciality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `hall_event_id` bigint(20) NOT NULL,
  `system_picture_filename` varchar(255) NOT NULL,
  `public_picture_filename` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hall_event_id` (`hall_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `speciality`
  ADD CONSTRAINT `speciality_hall_event_fk` FOREIGN KEY (`hall_event_id`) REFERENCES `hall_event` (`id`);

CREATE TABLE IF NOT EXISTS `room_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `description` text DEFAULT NULL,
  `room_event_type` varchar(255) NOT NULL DEFAULT 'Report',
  `room_id` bigint(20) NOT NULL,
  `start_time_slot` bigint(20) NOT NULL,
  `time_slot_quantity` bigint(20) NOT NULL,
  `event_branch_id` bigint(20) NOT NULL,
  `talk_request_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  KEY `event_branch_id` (`event_branch_id`),
  KEY `talk_request_id` (`talk_request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `room_event`
  ADD CONSTRAINT `room_event_room_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `room_event_event_branch_fk` FOREIGN KEY (`event_branch_id`) REFERENCES `event_branch` (`id`),
  ADD CONSTRAINT `room_event_talk_request_fk` FOREIGN KEY (`talk_request_id`) REFERENCES `talk_request` (`id`);

CREATE TABLE IF NOT EXISTS `creative_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creative_material_type` varchar(255) NOT NULL DEFAULT 'Slides',
  `room_event_id` bigint(20) NOT NULL,
  `title` varchar(500) NOT NULL,
  `url` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `room_event_id` (`room_event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `creative_material`
  ADD CONSTRAINT `creative_material_room_event_fk` FOREIGN KEY (`room_event_id`) REFERENCES `room_event` (`id`);

-- Many to many

CREATE TABLE IF NOT EXISTS `event_branch_leader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_branch_id` bigint(20) NOT NULL,
  `branch_leader_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `event_branch_id` (`event_branch_id`),
  KEY `branch_leader_id` (`branch_leader_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `event_branch_leader`
  ADD CONSTRAINT `event_branch_leader_event_branch_fk` FOREIGN KEY (`event_branch_id`) REFERENCES `event_branch` (`id`),
  ADD CONSTRAINT `event_branch_leader_branch_leader_fk` FOREIGN KEY (`branch_leader_id`) REFERENCES `branch_leader` (`id`);

CREATE TABLE IF NOT EXISTS `room_event_speaker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_event_id` bigint(20) NOT NULL,
  `speaker_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `room_event_id` (`room_event_id`),
  KEY `speaker_id` (`speaker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `room_event_speaker`
  ADD CONSTRAINT `room_event_speaker_room_event_fk` FOREIGN KEY (`room_event_id`) REFERENCES `room_event` (`id`),
  ADD CONSTRAINT `room_event_speaker_speaker_fk` FOREIGN KEY (`speaker_id`) REFERENCES `speaker` (`id`);

CREATE TABLE IF NOT EXISTS `room_event_speciality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_event_id` bigint(20) NOT NULL,
  `speciality_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `room_event_id` (`room_event_id`),
  KEY `speciality_id` (`speciality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `room_event_speciality`
  ADD CONSTRAINT `room_event_speciality_room_event_fk` FOREIGN KEY (`room_event_id`) REFERENCES `room_event` (`id`),
  ADD CONSTRAINT `room_event_speciality_speciality_fk` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`);
