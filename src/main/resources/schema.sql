CREATE SCHEMA IF NOT EXISTS test1;
CREATE SCHEMA IF NOT EXISTS post;

----------1
create table IF NOT EXISTS test1.womans
(
    id           bigserial not null,
    name        varchar(255),
    primary key (id)
);

TRUNCATE TABLE test1.womans;

insert into test1.womans (id, name)
values (1,'Wendy'), (2,'Brenda'), (3,'Carol'), (4,'Linda'), (5,'Betty'), (6,'Lisa');

-----------------2
create table IF NOT EXISTS test1.womans_daughters
(
    women_id           int8 not null,
    daughters_id        int8 not null
);

TRUNCATE TABLE test1.womans_daughters;

insert into test1.womans_daughters (women_id, daughters_id )
values (1,2), (1,3), (2,4), (2,5), (3,6);

------------3
create table IF NOT EXISTS test1.mans
(
    id           bigserial not null,
    name        varchar(255),
    primary key (id)
);

TRUNCATE TABLE test1.mans;

insert into test1.mans (id, name)
values (1,'Bob'), (2,'Mark'), (3,'Sten'), (4,'Dug'), (5,'Jo'), (6,'Itun');
-----------4

create table IF NOT EXISTS test1.womans_sons
(
    women_id           int8 not null,
    sons_id        int8 not null
);

TRUNCATE TABLE test1.womans_sons;

insert into test1.womans_sons (women_id, sons_id )
values (1,2), (1,3), (2,4), (2,5), (3,6);


