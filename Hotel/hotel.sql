drop table hotel;

create table hotel(
	name varchar2(20) not null,
	phone char(13) primary key,
	pass number(20) not null
);

select * from hotel;