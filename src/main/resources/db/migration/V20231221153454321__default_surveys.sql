insert into surveys (id, deleted, description, name, author_id)
values (nextval('surveys_seq'), false, 'Просим принять участие неравнодушных граждан в опросе по благоустройству ЦПКиО им. Горького',
        'Благоустройство Центрального парка культуры и отдыха им. Горького', -1);
--        (nextval('surveys_seq'), false, 'Просим принять участие неравнодушных граждан в опросе по благоустройству города Казань',
--         'Благоустройство города Казань', -1);

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 1, 'Возраст респондента', 'RADIO', currval('surveys_seq'));