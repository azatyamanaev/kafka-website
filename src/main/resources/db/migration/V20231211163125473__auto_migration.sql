create table answers
(
    id            int8 not null,
    text          varchar(255),
    type          varchar(255),
    question_id   int8 not null,
    respondent_id int8,
    primary key (id)
);

create table question_choices
(
    id          int8         not null,
    text        varchar(255) not null,
    answer_id   int8,
    question_id int8,
    primary key (id)
);

create table questions
(
    id          int8         not null,
    is_required boolean      not null,
    number      int4         not null,
    text        varchar(255) not null,
    type        varchar(255) not null,
    survey_id   int8         not null,
    primary key (id)
);

create table respondents
(
    id   int8 not null,
    name varchar(255),
    primary key (id)
);

create table survey_responses
(
    id              int8 not null,
    answer          varchar(255),
    respondent_name varchar(255),
    survey_question varchar(255),
    primary key (id)
);

create table surveys
(
    id          int8         not null,
    create_time timestamp,
    deleted     boolean      not null,
    description varchar(255) not null,
    name        varchar(255) not null,
    author_id   int8         not null,
    primary key (id)
);

create table users
(
    id            int8         not null,
    create_time   timestamp,
    deleted       boolean      not null,
    email         varchar(255) not null,
    last_access   timestamp,
    name          varchar(255) not null,
    password_hash varchar(255) not null,
    role          varchar(255) not null,
    primary key (id)
);
create sequence answers_seq start 1 increment 1;
create sequence question_choices_seq start 1 increment 1;
create sequence questions_seq start 1 increment 1;
create sequence respondents_seq start 1 increment 1;
create sequence survey_responses_seq start 1 increment 1;
create sequence surveys_seq start 1 increment 1;
create sequence users_seq start 1 increment 1;

alter table if exists answers
    add constraint FK3erw1a3t0r78st8ty27x6v3g1
    foreign key (question_id)
    references questions;

alter table if exists answers
    add constraint FKcofurhscvglw18behd29ev1h7
    foreign key (respondent_id)
    references respondents;

alter table if exists question_choices
    add constraint FKncnbdr2vmr0ar6bwiierl24su
    foreign key (answer_id)
    references answers;

alter table if exists question_choices
    add constraint FK77biojwg2xd8kc8a2odnx3ld4
    foreign key (question_id)
    references questions;

alter table if exists questions
    add constraint FKnf38uiy78c0g0tmo68btk3y0p
    foreign key (survey_id)
    references surveys;

alter table if exists surveys
    add constraint FKbp1og7ce6n9kud0tp5skxktil
    foreign key (author_id)
    references users;