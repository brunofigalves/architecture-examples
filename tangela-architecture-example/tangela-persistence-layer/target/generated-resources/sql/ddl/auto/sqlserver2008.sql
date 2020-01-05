
    drop table EXAMPLE;

    drop table hibernate_sequence;

    create table EXAMPLE (
       id bigint not null,
        VALUE varchar(50),
        primary key (id)
    );

    create table hibernate_sequence (
       next_val bigint
    );

    insert into hibernate_sequence values ( 1 );
