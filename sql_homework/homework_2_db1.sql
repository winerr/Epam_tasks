create database if not exists students;

use students;

create table if not exists `subject`(
	`id` int auto_increment primary key,
    `subject` varchar(30) not null,
    `control` enum('exam', 'test') not null,
    `number_of_semester` int not null,
    `teacher` varchar(50) not null 
);

create table if not exists `groups`(
	`group_code` varchar(10) not null primary key,
    `specialty` varchar(35) not null
);

create table if not exists `student`(
	`id` int auto_increment primary key,
    `first_name` varchar(30) not null,
    `last_name` varchar(30) not null,
    `second_name` varchar(30) not null,
    `year_of_birth` date not null,
    `year_of_receipt` date not null,
    `address` varchar(150), 
    `rank` int not null,
    `photo` mediumblob default null,
    `autobiography` mediumblob default null,
    `scholarship size` int not null,
    `group_code` varchar(10) not null,
    constraint fk_student_group
    foreign key (`group_code`) references `groups`(`group_code`)
);

create table if not exists `progress`(
	`id` int auto_increment primary key,
    `first_module` int,
    `second_module` int,
    `semester_rating_100` int,
    `semester_rating_5` int    
);

create table if not exists `student_subject_progress`(
	`student_id` int not null,
	`subject_id` int not null,
	`progress_id` int not null,
    primary key(`student_id`, `subject_id`, `progress_id`),
    constraint fk_student_subject_progress_student_id
		foreign key(`student_id`) 
		references `student`(`id`),
    constraint fk_student_subject_progress_subject_id
		foreign key(`subject_id`) 
		references `subject`(`id`),
	constraint fk_student_subject_progress_progress_id
		foreign key(`progress_id`) 
		references `progress`(`id`)    
);


insert into `subject` (`subject`, `control`, `number_of_semester`, `teacher`) 
	values 
		( 'math', 'exam', 1, 'Tsapovska' ),
		( 'Comp. gra.', 'test', 1, 'Demkiv' ),
        ( 'Optica', 'exam', 2, 'kyshnir' ),
        ( 'Economic', 'test', 3, 'Kvak' );
        
insert into `groups` (`group_code`, `specialty`)
	values 
		('FEI-1','Computer science'),
		('FEI-2','Computer science'),
		('FEI-3','Computer science'),
		('FEI-4','Computer science'),
		('FEM-1','Micro and nanosystem technology'),
		('FEM-2','Micro and nanosystem technology');
        
insert into `student` (`first_name`, `last_name`, `second_name`, `year_of_birth`, `year_of_receipt`, `address`, `rank`, `photo`, `autobiography`, `scholarship size`, `group_code`)
	values
		('Dmytro', 'Vertepnyi', 'Olegovych', '1997.07.10', '2014.08.01', 'Stryisca street', 7, default, default, 1300, 'FEI-4'),
		('Petrov', 'Petro', 'Petrovych', '1998.03.19', '2015.08.01', 'Pasichna street', 9, default, default, 1300, 'FEI-3'),
		('Ivanov', 'Ivan', 'Ivanovych', '1999.11.30', '2016.08.01', 'Pasichna street', 3, default, default, 1300, 'FEM-2');
        
insert into `progress` 
	values 
		(1, 30, 40, 85, 4),
		(2, 25, 55, 91, 5),
		(3, 19, 31, 61, 3),
		(4, 32, 28, 71, 4),
		(5, 30, 20, 61, 3),
		(6, 28, 42, 81, 4);
    
insert into `student_subject_progress`
	values
		(1, 1, 2),
		(1, 2, 4),
		(2, 3, 1),
		(2, 4, 3),
		(3, 2, 5),
		(3, 3, 6)
				












