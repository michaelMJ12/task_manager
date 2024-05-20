create table if not exists users
(
    id SERIAL PRIMARY KEY,
    first_name   varchar(100) not null,
    last_name    varchar(100) not null,
    middle_name  varchar(100),
    email       varchar(45)  not null,
    phone       varchar(15),
    password    varchar(150) not null,
    enabled     boolean default true,
    created_by   integer      not null,
    created_at   timestamp    not null,
    modified_by  integer,
    modified_at  timestamp
    );

create table if not exists role
(
    id SERIAL PRIMARY KEY,
    name varchar(45) not null
    );

create table if not exists users_role
(
    user_id integer not null references users (id) on update cascade on delete cascade,
    role_id integer not null references role (id) on update cascade on delete cascade
    );


CREATE TABLE IF NOT EXISTS access_token
(
    token         text NOT NULL primary key,
    refresh_token text NOT NULL,
    created_at    timestamp without time zone       NOT NULL,
    expiry_date   timestamp without time zone       NOT NULL
);

CREATE TABLE IF NOT EXISTS refresh_token
(
    token       text  not null primary key,
    created_at  timestamp without time zone       NOT NULL,
    expiry_date timestamp without time zone       NOT NULL
);



CREATE TABLE team_table (
                 id SERIAL PRIMARY KEY,
                 first_name character varying(100),
                 last_name character varying(100),
                 middle_name character varying(100),
                 department character varying(100),
                 task_name character varying(100),
                 task_date date,
                 task_time time,
                 task_comment character varying(100),
                 email character varying(100),
                 created_by   integer      not null,
                 created_at   timestamp    not null,
                 modified_by  integer,
                 modified_at  timestamp

);

CREATE TABLE task_table (

                  id SERIAL PRIMARY KEY,
                  task_description character varying(100),
                  task_status character varying(100),
                  category character varying(100),
                  task_assign_to character varying(100),
                  percentage_complete character varying(100),
                  task_start_date date,
                  task_finish_date date,
                  task_hours_duration time,
                  task_date_duration date,
                  created_by   integer      not null,
                  created_at   timestamp    not null,
                  modified_by  integer,
                  modified_at  timestamp

);


CREATE TABLE project_manage_table(

                  id SERIAL PRIMARY KEY,
                  first_name character varying(100),
                  middle_name character varying(100),
                  last_name character varying(100),
                  department character varying(100),
                  assign_project_name character varying(100),
                  project_status character varying(100),
                  project_complete character varying(100),
                  project_start_date date,
                  project_finish_date date,
                  created_by   integer      not null,
                  created_at   timestamp    not null,
                  modified_by  integer,
                  modified_at  timestamp



);