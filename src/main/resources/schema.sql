CREATE SCHEMA IF NOT EXISTS test1;
CREATE SCHEMA IF NOT EXISTS post;

----------1
create table IF NOT EXISTS test1.womans
(
    id
    bigserial
    not
    null,
    name
    varchar
(
    255
),
    primary key
(
    id
)
    );

TRUNCATE TABLE test1.womans;

insert into test1.womans (id, name)
values (1, 'Wendy'),
       (2, 'Brenda'),
       (3, 'Carol'),
       (4, 'Linda'),
       (5, 'Betty'),
       (6, 'Lisa');

-----------------2
create table IF NOT EXISTS test1.womans_daughters
(
    women_id
    int8
    not
    null,
    daughters_id
    int8
    not
    null
);

TRUNCATE TABLE test1.womans_daughters;

insert into test1.womans_daughters (women_id, daughters_id)
values (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6);

------------3

create table IF NOT EXISTS test1.mans
(
    id
    bigserial
    not
    null,
    name
    varchar
(
    255
),
    info_id int8,
    primary key
(
    id
)
    );

TRUNCATE TABLE test1.mans;

insert into test1.mans (id, name, info_id)
values (1, 'Bob', 1),
       (2, 'Mark', 1),
       (3, 'Sten', 1),
       (4, 'Dug', 1),
       (5, 'Jo', 1),
       (6, 'Itun', 1);
-----------4

create table IF NOT EXISTS test1.womans_sons
(
    women_id
    int8
    not
    null,
    sons_id
    int8
    not
    null
);

TRUNCATE TABLE test1.womans_sons;

insert into test1.womans_sons (women_id, sons_id)
values (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6);

------------5


create table IF NOT EXISTS test1.mans_sons
(
    man_id
    int8
    not
    null,
    sons_id
    int8
    not
    null
);

TRUNCATE TABLE test1.mans_sons;

insert into test1.mans_sons (man_id, sons_id)
values (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (1, 6);


--------------6


create table IF NOT EXISTS test1.mans_daughters
(
    man_id
    int8
    not
    null,
    daughters_id
    int8
    not
    null
);

TRUNCATE TABLE test1.mans_daughters;

insert into test1.mans_daughters (man_id, daughters_id)
values (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (1, 6);

----------------7

create table IF NOT EXISTS test1.infos
(
    id
    bigserial
    not
    null,
    uuid1
    uuid,
    info1
    varchar
(
    255
),
    primary key
(
    id
)
    );

TRUNCATE TABLE test1.infos;

insert into test1.infos (id, uuid1, info1)
values (1, 'da55bbe1-c3cf-4842-96cb-b37aff127bb6', 'info1'),
       (2, '8195e7cb-ad64-4a89-80a4-b3481527557a', 'info1');


