create table survey_responses (
    id int8 generated by default as identity,
    answer varchar(255),
    respondent_name varchar(255),
    survey_question varchar(255),
    primary key (id)
);