
create table if not exists answer_option_responses (
                                         id int8 not null,
                                         text varchar(255),
                                         answer_option_id int8 not null,
                                         question_response_id int8 not null,
                                         primary key (id)
);

create table if not exists answer_options (
                                id int8 not null,
                                is_correct boolean,
                                text varchar(255),
                                question_id int8 not null,
                                primary key (id)
);

create table if not exists question_responses (
                                    id int8 not null,
                                    question_id int8 not null,
                                    survey_response_id int8 not null,
                                    primary key (id)
);

alter table if exists survey_responses
    add column create_time timestamp;

alter table if exists survey_responses
    add column deleted boolean not null;

alter table if exists survey_responses
    add column survey_id int8 not null;

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

alter table if exists survey_responses
    add constraint FKg5uul15qxrqgdet2fa3wvdhj8
    foreign key (survey_id)
    references surveys;
