
    drop table EXAMPLE if exists;

    drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

    create table EXAMPLE (
       id bigint not null,
        VALUE varchar(50),
        primary key (id)
    );
