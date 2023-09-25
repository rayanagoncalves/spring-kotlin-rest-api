create table user_role(
    id bigint not null auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    primary key(id),
    foreign key(user_id) references user(id),
    foreign key(role_id) references role(id)
);

INSERT INTO user_role values(1, 1, 1);