CREATE TABLE user(
    id bigint not null auto_increment,
    name varchar2(50) not null,
    email varchar2(50) not null,
    primary key(id)
);

insert into user values(1, 'Ana da Silva', 'ana@email.com');