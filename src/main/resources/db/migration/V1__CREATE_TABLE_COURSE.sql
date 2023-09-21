CREATE TABLE course(
    id bigint not null auto_increment,
    name varchar2(50) not null,
    category varchar2(50) not null,
    primary key(id)
);

insert into course values(1, 'Kotlin', 'Programacao');
insert into course values(2, 'HTML', 'Front-end');