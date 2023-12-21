create table answer_option_responses (
                                         id int8 not null,
                                         text varchar(255),
                                         answer_option_id int8 not null,
                                         question_response_id int8 not null,
                                         primary key (id)
);

create table answer_options (
                                id int8 not null,
                                is_correct boolean,
                                text varchar(255),
                                question_id int8 not null,
                                primary key (id)
);

create table question_responses (
                                    id int8 not null,
                                    question_id int8 not null,
                                    survey_response_id int8 not null,
                                    primary key (id)
);

create table questions (
                           id int8 not null,
                           is_required boolean not null,
                           number int4 not null,
                           text varchar(255) not null,
                           type varchar(255) not null,
                           survey_id int8 not null,
                           primary key (id)
);

create table respondents (
                             id int8 not null,
                             name varchar(255),
                             primary key (id)
);

create table survey_responses (
                                  id int8 not null,
                                  create_time timestamp,
                                  deleted boolean not null,
                                  respondent_name varchar(255),
                                  survey_id int8 not null,
                                  primary key (id)
);

create table surveys (
                         id int8 not null,
                         create_time timestamp,
                         deleted boolean not null,
                         description varchar(255) not null,
                         name varchar(255) not null,
                         author_id int8 not null,
                         primary key (id)
);

create table users (
                       id int8 not null,
                       create_time timestamp,
                       deleted boolean not null,
                       email varchar(255) not null,
                       last_access timestamp,
                       name varchar(255) not null,
                       password_hash varchar(255) not null,
                       role varchar(255) not null,
                       primary key (id)
);
create sequence answer_option_responses_seq start 1 increment 1;
create sequence answer_options_seq start 1 increment 1;
create sequence question_responses_seq start 1 increment 1;
create sequence questions_seq start 1 increment 1;
create sequence respondents_seq start 1 increment 1;
create sequence survey_responses_seq start 1 increment 1;
create sequence surveys_seq start 1 increment 1;
create sequence users_seq start 1 increment 1;

alter table if exists answer_option_responses
    add constraint FKisvdir8ysck6s2blg9ob8karp
    foreign key (answer_option_id)
    references answer_options;

alter table if exists answer_option_responses
    add constraint FKis87d0049duvefradtin0uegg
    foreign key (question_response_id)
    references question_responses;

alter table if exists answer_options
    add constraint FKfapodm8kfiu9a9a4o2r43rcgp
    foreign key (question_id)
    references questions;

alter table if exists question_responses
    add constraint FK4ulneyrjow4avkt2th38y138u
    foreign key (question_id)
    references questions;

alter table if exists question_responses
    add constraint FKavah6yej786pevqchsv3bt5ug
    foreign key (survey_response_id)
    references survey_responses;

alter table if exists questions
    add constraint FKnf38uiy78c0g0tmo68btk3y0p
    foreign key (survey_id)
    references surveys;

alter table if exists survey_responses
    add constraint FKg5uul15qxrqgdet2fa3wvdhj8
    foreign key (survey_id)
    references surveys;

alter table if exists surveys
    add constraint FKbp1og7ce6n9kud0tp5skxktil
    foreign key (author_id)
    references users;
