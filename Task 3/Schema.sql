create table product (
    id serial unique not null,
    name char(50) not null,
    cost integer check(cost > -1)
);
insert into product (name, cost) values ('milk', 129);
insert into product (name, cost) values ('dont milk', 921);
insert into product (name, cost) values ('chocolate', 19);