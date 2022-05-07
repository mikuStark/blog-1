delete from users_roles
delete from users
delete from roles

insert into users(user_id, login, password_hash, lock) values ('1', 'test', '', false)
insert into roles(role_id, "name") values ('1', 'USER')
insert into users_roles(user_id, role_id) values ('1', '1')