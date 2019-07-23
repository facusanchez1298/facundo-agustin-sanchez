create database if not exists topic_4;

create table if not exists student(
registration_number int not null auto_increment,
first_name varchar (10),
last_name varchar (10),
date_of_birth date,
primary key(registration_number));

create table if not exists teacher(
id_teacher int not null auto_increment,
first_name varchar(10),
last_name varchar(10),
date_of_birth dateTime,
primary key(id_teacher));

create table if not exists course(
id_course integer not null auto_increment,
name varchar(20),
assigned_teacher integer,
 primary key(id_course),
foreign key(assigned_teacher) references teacher(id_teacher)
);

create table if not exists scheduleTime(
id_course integer,
day_on_week varchar(15),
start_time time,
end_time time,
foreign key(id_course) references course(id_course)
);

create table if not exists teacher_course(
id_course integer,
id_teacher integer,
primary key(id_course, id_teacher),
foreign key(id_course) references course(id_course),
foreign key(id_teacher) references teacher(id_teacher)
);
	
create table if not exists student_course(
id_course integer,
registration_number integer,
partial_1 float,
partial_2 float,
partial_3 float,
final float,
primary key(id_course, registration_number),
foreign key(id_course) references course(id_course),
foreign key(registration_number) references student(registration_number)
);

#comento todo por que sino me lo agrega indefinidamente

#agregamos profesores:
#insert into teacher values (null, 'facu', 'sanchez', '1998-02-01');
#insert into teacher values (null, 'gaston', 'sanchez', '1999-07-12');
#insert into teacher values (null, 'ramiro', 'sanchez', '2001-03-05');
#select * from teacher;

#agregamos cursos:
#insert into course values(null, "matematicas", 1);
#insert into course values(null, "lengua", 2);
#insert into course values(null, "historia", 3);
#select * from course; 

#agregamos los alumnos:
#insert into student values (null, "felipe", "perez", "1997-04-03");
#insert into student values (null, "juan", "lopez", "2000-03-14");
#insert into student values (null, "pedrito", "martinez", "1990-05-04");
#insert into student values (null, "carlos", "pelegrino", "1997-04-12");
#insert into student values (null, "luis", "lopez", "1995-04-23");
#insert into student values (null, "gustavo", "reyes", "1994-02-5");
#insert into student values (null, "pedro", "antonio", "1999-03-12");
#insert into student values (null, 'facu', 'sanchez', '1998-02-01');
#insert into student values (null, 'gaston', 'sanchez', '1999-07-12');
#insert into student values (null, 'ramiro', 'sanchez', '2001-03-05');
#select * from student;

#insert into student_course(id_course, registration_number) values (2,1);
#insert into student_course(id_course, registration_number) values (2,2);
#insert into student_course(id_course, registration_number) values (2,3);
#insert into student_course(id_course, registration_number) values (2,4);
#insert into student_course(id_course, registration_number) values (2,5);
#insert into student_course(id_course, registration_number, final) values (2,6, 8);
#insert into student_course(id_course, registration_number, final) values (2,7, 6);
#select * from student_course;

select course.name as 'course',
 concat(teacher.first_name, "  ", teacher.last_name) as 'teacher',
 concat(student.first_name, "  ", student.last_name) as 'student' 
 from course, student, teacher, student_course
 where course.assigned_teacher = teacher.id_teacher and
 course.id_course = 2 and
 student.registration_number = student_course.registration_number and
 course.id_course = student_course.id_course;


#insert into scheduletime values (2, 'lunes', '13:30', '14:30');
#insert into scheduletime values (2, 'martes', '13:30', '14:30');
#insert into scheduletime values (2, 'viernes', '13:30', '14:30');
#insert into scheduletime values (4, 'lunes', '13:30', '14:30');
#insert into scheduletime values (4, 'jueves', '14:30', '16:30');
#select * from scheduletime;

select teacher.first_name as 'nombre',
	   teacher.last_name as 'apellido',
       scheduletime.day_on_week as 'dia',
       scheduletime.start_time as 'inicio',
       scheduletime.end_time as 'final',
       course.name as 'course'
       from course,scheduletime,teacher
where scheduletime.id_course = course.id_course 
and   course.assigned_teacher = teacher.id_teacher
and   teacher.id_teacher = 1;

