create table IF NOT EXISTS users (
  id                    uuid,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table IF NOT EXISTS roles (
  id                    uuid,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE IF NOT EXISTS users_roles (
  user_id               uuid not null,
  role_id               uuid not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (id, name)
values
('b66d5172-ef34-4909-82cf-ab6fd5ded52a', 'ROLE_USER'), ('10000000-0000-4000-8000-000000000000', 'ROLE_ADMIN');

insert into users (id, username, password, email)
values
('b66d5172-ef34-4909-82cf-ab6fd5ded52a', 'user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('10000000-0000-4000-8000-000000000000', 'admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values
('b66d5172-ef34-4909-82cf-ab6fd5ded52a', 'b66d5172-ef34-4909-82cf-ab6fd5ded52a'),
('10000000-0000-4000-8000-000000000000', '10000000-0000-4000-8000-000000000000');