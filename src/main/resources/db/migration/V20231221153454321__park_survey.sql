insert into surveys (id, deleted, description, name, author_id)
values (nextval('surveys_seq'), false, 'Просим принять участие неравнодушных граждан в опросе по благоустройству ЦПКиО им. Горького',
        'Благоустройство Центрального парка культуры и отдыха им. Горького', -1);

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 1,'Возраст респондента:', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'до 18 лет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'от 19 до 40 лет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'от 41 до 60 лет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'более 60 лет.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 2,'Пол респондента:', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'мужской;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'женский.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 3,'Категория респондента:', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'школьник;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'студент;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'рабочий,служащий', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'безработный;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'пенсионер.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 4,'Как долго Вы проживаете в городе Казань?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'не проживаю;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'всю жизнь;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'более 10 лет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'5-10 лет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'менее 5 лет.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 5,'Где Вы предпочитаете отдыхать?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'дома;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'в Центральном парке культуры и отдыха им. Горького;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'в торговом центре;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'за городом;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нигде.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 6,'Ваше любимое место отдыха в Центральном парке культуры и отдыха им. Горького?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'воркаут-зона;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'фонтан;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'центральная аллея парка;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'стадион;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'детская площадка.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 7,'Как, на Ваш взгляд, изменилось ситуация с благоустройством и озеленением парка за последние 3 года?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'улучшилась;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'ухудшилась;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'не изменилась;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 8,'Знакомы ли Вы с дальнейшим планом развития парка?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'да;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет, но хотелось бы ознакомиться;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет, не интересуюсь.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 9,'Как часто Вы совершаете пешие прогулки по парку?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'часто;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'редко;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'не совершаю.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 10,'В какие часы, по Вашему мнению, в парке наблюдается наибольшее количество людей, совершающих прогулки?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'8:00 - 12:00;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'12:00 - 15:00;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'15:00 - 18:00;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'18:00 - 21:00;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'21:00 - 00:00.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 11,'Считаете ли Вы, что Центральный парк культуры и отдыха им. Горького является визитной карточкой республики?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'да;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 12,'Как часто Вы бываете в парке?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'каждый день;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'2-5 раз в неделю;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'1 раз в неделю;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'редко;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'не бываю.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 13,'С какой целью Вы бываете в парке?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'живу рядом;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'учусь/работая рядом;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'отдыхаю.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 14,'Оцените озеленение парка в целом.', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'превосходное;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'хорошее;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'плохое;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'отвратительное.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 15,'По Вашему мнению, детский городок парка привлекателен?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'да;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 16,'Хотели бы Вы видеть обновленный детский городок в парке?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'да;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'без разницы.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 17,'По Вашему мнению, обустройство воркаут-площадки на территории парка...', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'хорошая идея;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'плохая идея;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'без разницы;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 18,'Какой стиль озеленения Вы предпочитаете?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'пейзажный (все элементы дизайна размещаются в свободной порядке, как это происходит в естественной среде, линии плавные);', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'регулярный (симметричное расположение всех элементов, выдерживаются строгие геометрические линии);', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'смешанный стиль (сочетание регулярного и пейзажного стилей).', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 19,'Какие малые архитектурные формы Вам нравятся больше всего?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'скульптуры, фонтаны, перголы;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'беседки, павильоны;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'топиарные фигуры.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 20,'Какой вид озеленения Вы предпочитаете?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Живые изгороди, рядовые посадки, стриженные деревья и кустарники;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Групповые посадки, беспорядочно посаженные деревья, приближенность к природе, крона естественной формы.', currval('questions_seq'));

       insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 21,'Каких видов озеленения, по Вашему мнению, не хватает в Национальном парке?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'газонов;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'цветников;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'кустарников;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'деревьев;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'вертикального озеленения, топиарные фигуры.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 22,'Устраивает ли Вас освещение Центрального парка культуры и отдыха им. Горького?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Да, полностью устраивает;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Устраивает, но не во всех частях парка;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Нет, не устраивает.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 23,'Какой для Вас наиболее предпочтительный ПРИРОДНЫЙ материал, который может использоваться в благоустройстве центра парка?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'дерево;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'камень;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'другое', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 24,'Какой для Вас наиболее предпочтительный СИНТЕТИЧЕСКИЙ материал, который может использоваться в благоустройстве воркаут-площадки? (можно выбрать несколько вариантов)', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'брусчатка;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'кирпич;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'металл;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'прорезиненные покрытия;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'другое', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 25,'Вы принимали участие или хотели бы принять участие в мероприятиях, посвященных благоустройству парка?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Принимал(а) участие;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хотел(а) бы принять участие в мероприятиях;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Не принимал(а) участие;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Не знаю / затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 26,'Наиболее предпочтительная форма участия в благоустройстве парка для Вас - это:', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Привлечение денежных средств;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Привлечение жителей на общественных началах;', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Не знаю / затрудняюсь ответить.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 27,'Ваши предложения по благоустройству парка:', 'INPUT', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), null, null, currval('questions_seq'));