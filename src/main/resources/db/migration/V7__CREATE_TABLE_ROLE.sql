CREATE TABLE role(
 id bigint not null auto_increment,
 name varchar2(50) not null,
 primary key (id)
);

insert into role values(1, 'READ_WRITE');