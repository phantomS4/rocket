create table `user` (
    `id`        bigint(20)  not null auto_increment primary key ,
    `name`      char(128)   not null default '',
    `mobile`    char(128)   not null,
    `type`      int(1)      not null default 0,
    `password`  char(128)   not null,

    unique `u_mobile_type` (`mobile`, `type`)
);

create table `item` (
    `id`        bigint(20)  not null auto_increment primary key ,
    `name`      char(128)   not null ,
    `price`     decimal(10, 2)  not null ,
    `image`     text   not null ,

    unique `u_name` (`name`)
);

create table `bill` (
    `id`        bigint(20)  not null auto_increment primary key ,
    `user_id`   bigint(20)  not null ,
    `amount`    decimal(10, 2)  not null ,
    `status`    char(20)    not null default 'PROCESSING',
    `items`     text        not null ,

    index `index__user_id` (`user_id`)
);

DROP TABLE IF EXISTS SPRING_SESSION_ATTRIBUTES;
DROP TABLE IF EXISTS SPRING_SESSION;
CREATE TABLE SPRING_SESSION (
                                PRIMARY_ID CHAR(36) NOT NULL,
                                SESSION_ID CHAR(36) NOT NULL,
                                CREATION_TIME BIGINT NOT NULL,
                                LAST_ACCESS_TIME BIGINT NOT NULL,
                                MAX_INACTIVE_INTERVAL INT NOT NULL,
                                EXPIRY_TIME BIGINT NOT NULL,
                                PRINCIPAL_NAME VARCHAR(100),
                                CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
) ENGINE=INNODB ROW_FORMAT=DYNAMIC;

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
                                           SESSION_PRIMARY_ID CHAR(36) NOT NULL,
                                           ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
                                           ATTRIBUTE_BYTES BLOB NOT NULL,
                                           CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
                                           CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
) ENGINE=INNODB ROW_FORMAT=DYNAMIC;