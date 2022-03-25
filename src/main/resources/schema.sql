create table t_book
(
    id integer auto_increment,
    name varchar(50),
    year integer,
    writer varchar(50),
    price integer,
    primary key(id)
);

create table t_library
(
    id integer auto_increment,
    library_name varchar(50),

    location varchar(50),

    primary key(id)
);