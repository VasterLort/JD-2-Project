create table appdevice (
    id bigint not null auto_increment,
    deviceName varchar(255),
    country varchar(255),
    imei bigint,
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table appuser (
    id bigint not null auto_increment,
    email varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    password varchar(255),
    primary key (id)
) engine=InnoDB;

create table user_role (
        user_id bigint not null,
        roles varchar(255)
) engine=InnoDB;