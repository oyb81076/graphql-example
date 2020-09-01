drop table if exists `book`;
CREATE TABLE `book`
(
    `id`          bigint(20)                              NOT NULL,
    `name`        varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `author_id`   bigint(20)                              NOT NULL,
    `classify_id` bigint(20)                              not null,
    `created`     datetime                                NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

create table book_classify
(
    `id`   bigint(20)   not null,
    `name` varchar(255) not null,
    primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

## 617964188509143040
drop table if exists author;
CREATE TABLE `author`
(
    `id`      bigint(20) NOT NULL,
    `name`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `type`    tinyint(4) NOT NULL,
    `created` datetime   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
