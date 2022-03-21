create table t_carte
(
    id integer auto_increment,
    Nume varchar(50),
    An integer,
    Scriitor varchar(50),
    Pret integer,
    primary key(id)
);

create table t_biblioteci
(
    id integer auto_increment,
    NumeBiblioteci varchar(50),

    Locatie varchar(50),

    primary key(id)
);