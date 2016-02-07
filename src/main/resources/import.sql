insert into role(id, name) values (1, 'USER')

insert into user(id, username, password, role_id) values (1, 'user', 123, 1)


insert into school(id, name, address, director) values (1, 'School 388', 'Ogorodney 6-2-71', 'Gorbunova S')
insert into school(id, name, address, director) values (2, 'School 290', 'Stachek 12', 'Vlasova N')

insert into teacher(id, name) values (1, 'Povinney Sergey Nickolaich')
insert into teacher(id, name) values (2, 'Pavlina Inna Sergeivna')

insert into classroom(id, name, school_id, teacher_id) values (1, 'Letrature', 1, 1)
insert into classroom(id, name, school_id, teacher_id) values (2, 'Math', 1, 2)

insert into activity(id, name, classroom_id, date) values (1, 'Reading book', 1, '2016-02-12')
insert into activity(id, name, classroom_id, date) values (2, 'Checking homework', 1, '2016-01-25')