insert into surveys (id, deleted, description, name, author_id)
values (nextval('surveys_seq'), false, 'Просим принять участие неравнодушных граждан в опросе по благоустройству города Казань',
        'Благоустройство города Казань', -1);

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 1,'Ваш пол?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Жен.', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Муж.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 2,'Ваш возраст?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'До 20 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'21-30 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'31-45 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'46-60 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Старше 60 лет.', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 3,'Сколько лет Вы проживаете в Казани?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'До 5 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'5 - 15 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'15 - 25 лет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Более 25 лет', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 4,'Ваша оценка социально-экономической ситуации в городе', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Благополучная', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Нормальная', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Удовлетворительная', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Кризисная', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Катастрофическая', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Затрудняюсь ответить', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 5,'Дайте Вашу оценку развитию местных СМИ* ', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 6,'Дайте Вашу оценку работе городского транспорта', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 7,'Дайте Вашу оценку Энергообеспечению', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 8,'Дайте Вашу оценку Теплоснабжению', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 9,'Дайте Вашу оценку Водоснабжению', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 10,'Дайте Вашу оценку Обеспечению условий для занятий физкультурой и спортом', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 11,'Дайте Вашу оценку Развитию культурной жизни', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 12,'Дайте Вашу оценку Освещению улиц', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 13,'Дайте Вашу оценку Качеству образования', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 14,'Дайте Вашу оценку Условиям для развития предпринимательства', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 15,'Дайте Вашу оценку Безопасности', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 16,'Дайте Вашу оценку Благоустройству улиц, дворов', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 17,'Дайте Вашу оценку Экологической обстановке', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 18,'Дайте Вашу оценку Обеспеченности жильем', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 19,'Дайте Вашу оценку Медицинскому обслуживанию', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 20,'Дайте Вашу оценку Обеспечению мест в детских дошкольных учреждениях', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 21,'Дайте Вашу оценку Состоянию дорог', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Отлично', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хорошо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Средне', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Плохо', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Очень плохо', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 22,'Что нужно сделать в первую очередь, чтобы улучшить жизнь в городе?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Санитарная очистка города', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Улучшение состояния коммунальной и инженерной инфраструктуры', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Ремонт дорог и тротуаров', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Благоустройство и озеленение города', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Улучшение работы транспорта', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Улучшение системы здравоохранения', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Улучшение системы образования', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Улучшение имиджа города, создание туристического продукта', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Повышение патриотизма горожан, экологическое воспитание жителей города', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 23,'Источники получения информации о работе местных органов власти', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Из встреч с представителями администрации и Городского Совета', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Сами обращались в администрацию или в Совет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'По слухам', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'От друзей, знакомых, сослуживцев', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Из радиопередач', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Из Интернета', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Из сообщений местных газет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Из передач местного телевидения', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Не интересуюсь информацией о работе администрации и Совета', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 24,'Как, по Вашему мнению, живут казанцы в сравнении с жителями других регионов?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'В Казани люди живут лучше, чем в других регионах', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'У всех условия примерно одинаковые', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'В нашем регионе люди живут хуже, чем в других регионах', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Затрудняюсь с ответом', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 25,'Хотите ли Вы уехать из Казани?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Да, в Москву или Санкт-Петербург', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Да, в другой регион России', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Хочу, но у меня нет такой возможности', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Да, в другую страну', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Никуда не хочу уезжать', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 26,'Какими конкурентными преимуществами, на Ваш взгляд, обладает Воркута?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Историческое наследие', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Промышленный потенциал', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Богатство природных ресурсов', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Спортивный и культурный потенциал', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Территориальная близость к Волге', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Уникальность природы, нетронутость территорий', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 27,'Какие Вы видите приоритетные направления развития города ?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Создание комфортной городской среды и развитие инфраструктуры', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Развитие туристической сферы', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Формирование высокого уровня культуры и сознательности горожан', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Расширение международных связей города и развитие межмуниципального сотрудничества', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Создание условий для привлечения инвестиций и формирование благоприятного делового климата', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 28,'Какую роль, по Вашему мнению, играет в экономической и политической жизни города молодёжь?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Не оказывает серьезного влияния', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Принимает активное участие в жизни города', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Оказывает влияние через общественные организации, политические партии', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Оказывает влияние на проведение государственной молодёжной политики', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Работает в органах государственной власти и местного самоуправления', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Участвует в экономическом развитии города', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Совершает акты беспорядка и вандализма в городе', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Затрудняюсь ответить', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 29,'Считаете ли Вы себя патриотом Казани?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Да', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Скорее да, чем нет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Скорее нет, чем да', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'нет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Затрудняюсь ответить', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 30,'Чем готовы помочь развитию города?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Участвовать в субботниках', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Участвовать в городских мероприятиях на безвозмездной основе', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Делать добровольные денежные взносы на реализацию конкретных задач', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Оказывать помощь нуждающимся', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Ничем', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 31,'Хотели бы Вы участвовать в разработке стратегии развития города?', 'RADIO', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Да', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Нет', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Затрудняюсь ответить', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 32,'Какие по Вашему мнению общие цели могут сплотить казанцев?', 'MULTI', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), false,'Благоустройство города', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Охрана детства, забота о детях', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Совершенствование системы ЖКХ', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Проведение общегородских мероприятий, культурно-массовых акций, праздников', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Борьба за чистоту города, город без мусора', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Забота о старших – пенсионерах, инвалидах, ветеранах', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Развитие туризма, туристической инфраструктуры', currval('questions_seq')),
       (nextval('answer_options_seq'), false,'Никакие цели сплотить не могут, это – утопия, каждый за себя', currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 33,'Каким бы Вы хотели видеть город через 10-15 лет? Опишите в нескольких словах.', 'INPUT', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), null, null, currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 34,'Предложите свой вариант брендового названия Казани или укажите наиболее подходящий уже существующий (для примера : «Казань – спортивная столица»)', 'INPUT', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), null, null, currval('questions_seq'));

insert into questions (id, is_required, number, text, type, survey_id)
values (nextval('questions_seq'), true, 35,'Если Вы считаете, что мы не учли некоторые важные для городского округа проблемы, если у Вас есть дополнительные предложения и пожелания, то мы будем признательны, если Вы выскажите их здесь.', 'INPUT', currval('surveys_seq'));

insert into answer_options (id, is_correct, text, question_id)
values (nextval('answer_options_seq'), null, null, currval('questions_seq'));