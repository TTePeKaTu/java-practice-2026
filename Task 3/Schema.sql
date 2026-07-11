create table product (
    id serial unique not null,
    name char(50) not null,
    cost integer check(cost > -1)
);
