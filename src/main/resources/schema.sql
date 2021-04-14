CREATE SCHEMA IF NOT EXISTS test1;
CREATE SCHEMA IF NOT EXISTS post;


create table IF NOT EXISTS test1.womans
(
    id           bigserial not null,
    name        varchar(255),
    primary key (id)
);

TRUNCATE TABLE test1.womans;

insert into test1.womans (id, name)
values (1,'Wendy'), (2,'Brenda'), (3,'Carol'), (4,'Linda'), (5,'Betty'), (6,'Lisa');


create table IF NOT EXISTS test1.womans_daughters
(
    women_id           int8 not null,
    daughters_id        int8 not null
);

TRUNCATE TABLE test1.womans_daughters;

insert into test1.womans_daughters (women_id, daughters_id )
values (1,2), (1,3), (2,4), (2,5), (3,6);


