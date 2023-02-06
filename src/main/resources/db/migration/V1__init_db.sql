create table User
(
    id        bigint              not null primary key,
    firstName varchar(255)        not null,
    lastName  varchar(255)        not null,
    username  varchar(255) unique not null,
    password  varchar(255)        not null -- WHAT!? NOT ENCRYPTED!? ;-)
);

create table Address
(
    id       bigint               not null primary key,
    address1 varchar(255)        not null,
    address2  varchar(255),
    city      varchar(255)       not null,
    state varchar(100)           not null,
    postal varchar(10)           not null,
    FOREIGN KEY (id)
        REFERENCES user (id)
        ON DELETE CASCADE
);


insert into User
    (id, firstName, lastName, username, password)
values (1, 'Phil', 'Ingwell', 'PhilIngwell', 'Password123') ,
    (2, 'Anna', 'Conda', 'AnnaConda', 'Password234');

insert into Address
    (id, address1, address2, city, state, postal)
values ( 1, 'adds 1', 'adds 2', 'canton', 'mi', 48185-000);
