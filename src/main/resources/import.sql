insert into role(id, name) values (1, 'USER')

insert into user(id, username, password, role_id) values (1, 'user', 123, 1)
insert into user(id, username, password, role_id) values (2, 'user2', 123, 1)

insert into teacher(id, name) values (1, 'Povinney Sergey Nickolaich')
insert into teacher(id, name) values (2, 'Pavlina Inna Sergeivna')
insert into teacher(id, name) values (3, 'Strogin Petr Markovich')
insert into teacher(id, name) values (4, 'Makushkina Ira Albertovna')
insert into teacher(id, name) values (5, 'Garbuch Igor')
insert into teacher(id, name) values (6, 'Slastina Anna')

insert into school(id, name, address, director_id) values (1, 'School 388', 'Ogorodney 6-2-71', '3')
insert into school(id, name, address, director_id) values (2, 'School 290', 'Stachek 12', '4')

insert into classroom(id, name, school_id, teacher_id) values (1, 'Letrature', 1, 1)
insert into classroom(id, name, school_id, teacher_id) values (2, 'Math', 1, 2)
insert into classroom(id, name, school_id, teacher_id) values (3, 'Biology', 1, 3)
insert into classroom(id, name, school_id, teacher_id) values (4, 'Phisics', 1, 4)

insert into activity(id, name, classroom_id, date) values (1, 'Reading book', 1, '2016-02-12')
insert into activity(id, name, classroom_id, date) values (2, 'Checking homework', 1, '2016-01-25')
insert into activity(id, name, classroom_id, date) values (3, 'Math visit', 2, '2016-01-22')
insert into activity(id, name, classroom_id, date) values (4, 'Picnik lanch', 2, '2016-02-29')
insert into activity(id, name, classroom_id, date) values (5, 'Math game', 2, '2016-02-29')

insert into user_classrooms(id, user_id, classroom_id) values (1, 1, 1)
insert into user_classrooms(id, user_id, classroom_id) values (2, 1, 2)
insert into user_classrooms(id, user_id, classroom_id) values (3, 2, 3)
insert into user_classrooms(id, user_id, classroom_id) values (4, 2, 4)