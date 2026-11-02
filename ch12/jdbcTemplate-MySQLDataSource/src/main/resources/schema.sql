create table if not exists product(
    id int auto_increment primary key,
    productname varchar(50) not null,
    price double not null
);