-- инициализация базы данных "vida_db" (пустая база данных с таким именем должна быть предварительно создана)

-- удаление таблиц
DROP TABLE IF EXISTS "data";
DROP TABLE IF EXISTS "task";
DROP TABLE IF EXISTS "property";
DROP TABLE IF EXISTS "factor_value";
DROP TABLE IF EXISTS "factor";
DROP TABLE IF EXISTS "animal";
DROP TABLE IF EXISTS "username";
DROP TABLE IF EXISTS "organization";

-- создание таблиц
CREATE TABLE "organization"
(
	"id"         SERIAL  PRIMARY KEY,
	"name"       TEXT    NOT NULL,
	"individual" BOOLEAN NOT NULL,
	"area"       REAL    NOT NULL
);

CREATE TABLE "username"
(
    "id"            SERIAL  PRIMARY KEY,
    "firstname"     TEXT    NOT NULL,
    "surname"       TEXT    NOT NULL,
    "lostname"      TEXT    NOT NULL,
    "status"        TEXT    NOT NULL,
    "group"         INT     NOT NULL,
    "login"         TEXT    NOT NULL UNIQUE,
    "password"      TEXT    NOT NULL
);

CREATE TABLE "animal"
(
    "id"            SERIAL  PRIMARY KEY,
    "name"          TEXT    NOT NULL
);

CREATE TABLE "factor"
(
    "id"            SERIAL  PRIMARY KEY,
    "animal_id"     INT     NOT NULL REFERENCES "animal" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "name"          TEXT    NOT NULL
);

CREATE TABLE "factor_value"
(
    "id"             SERIAL  PRIMARY KEY,
    "factor_id"      INT     NOT NULL REFERENCES "factor" ON UPDATE RESTRICT ON DELETE CASCADE,
    "name"           TEXT    NOT NULL
);

CREATE TABLE "property"
(
    "id"             SERIAL  PRIMARY KEY,
    "animal_id"      INT     NOT NULL REFERENCES "animal" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "name"           TEXT    NOT NULL
);

CREATE TABLE "task"
(
    "id"                   SERIAL  PRIMARY KEY,
    "data"                 DATE     NOT NULL,
    "username_id"          INT     NOT NULL REFERENCES "username" ON UPDATE RESTRICT ON DELETE CASCADE,
    "name"                 TEXT    NOT NULL,
    "organization_id"      INT     NOT NULL REFERENCES "organization" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "property_id"          INT     NOT NULL REFERENCES "property" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "factor_id"            INT     NOT NULL REFERENCES "factor" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "influence_proportion" FLOAT   NOT NULL,
    "veracity"             BOOLEAN NOT NULL
);

CREATE TABLE "data"
(
    "id"              SERIAL PRIMARY KEY,
    "task_id"         INT    NOT NULL REFERENCES "task" ON UPDATE RESTRICT ON DELETE CASCADE,
    "factor_value_id" INT    NOT NULL REFERENCES "factor_value" ON UPDATE RESTRICT ON DELETE RESTRICT,
    "value"           FLOAT  NOT NULL
);

-- заполнение таблиц
INSERT INTO "organization"
("id","name"               , "individual", "area") VALUES
(1,  'Иванов'             , true        , 1.2   ),
(2,  'ООО «Рога и Копыта»', false       , 5.6   ),
(3,  'Колхоз «Заря»'      , false       , 8.9   );
SELECT setval('organization_id_seq', 3);

INSERT INTO "username"
("id", "firstname", "surname", "lostname", "status", "group" , "login",  "password" ) VALUES
(1,    'Иван',      'Иванов',  'Иванович', 'аспирант', 4,      'abc',    '123' ),
(2,    'Петр',      'Петров',  'Петрович', 'аспирант', 5,      'cba',    '321'),
(3,    'Сергей',    'Сергеев', 'Сергеевич','студент',  4,      'xyz',    '456'),
(4,    'Игорь',     'Игорев',  'Игоревич', 'аспирант', 5,      'zyx',    '654');
SELECT setval('username_id_seq', 4);

INSERT INTO "animal"
("id", "name") VALUES
(1   , 'коровы'),
(2   , 'свиньи'),
(3   , 'куры');
SELECT setval('animal_id_seq', 3);

INSERT INTO "factor"
("id", "animal_id", "name") VALUES
(1   , 1,           'линия ч/п коров' ),
(2   , 1,           'порода коров'    ),
(3   , 2,           'порода свиней'   ),
(4   , 3,           'кросс кур'       );
SELECT setval('factor_id_seq', 4);

INSERT INTO "factor_value"
("id","factor_id", "name" )VALUES
(1,    1,           'мелвуд'),
(2,    1,           'прелюде'),
(3,    1,           'цветик'),
(4,    2,           'черно-пестрая'),
(5,    2,           'Голштинская'),
(6,    2,           'шотландская'),
(7,    3,           'въетнамская'),
(8,    3,           'дюрок'),
(9,    4,           'КОББ'),
(10,   4,           'леггорн');
SELECT setval('factor_value_id_seq', 10);

INSERT INTO "property"
("id","animal_id" , "name" )VALUES
(1,    1,            'удой,кг'),
(2,    1,            'содержание жира ,%'),
(3,    2,            'живая масса,кг'),
(4,    3,            'яйценоскость,шт');
SELECT setval('property_id_seq', 4);

INSERT INTO "task"
("id","data",       "username_id", "name",         "organization_id", "property_id", "factor_id", "influence_proportion", "veracity" )VALUES
(1,   '2024-02-01',  1,            'учебная',       1,                 1,             1,           3.81943782,             false),
(2,   '2024-02-01',  2,            'экзамен',       2,                 3,             2,           50.4,                   true),
(3,   '2024-02-01',  3,            'тренировочная', 3,                 2,             1,           84.11,                  true);
SELECT setval('task_id_seq', 3);

INSERT INTO "data"
("task_id", "factor_value_id", "value" ) VALUES
(1,          1,                 4528   ),
(1,          1,                 4200   ),
(1,          1,                 4390   ),
(1,          1,                 5226   ),
(1,          1,                 6626   ),
(1,          1,                 3598   ),
(1,          1,                 5282   ),
(1,          1,                 5459   ),
(1,          1,                 6660   ),
(1,          2,                 5900   ),
(1,          2,                 4000   ),
(1,          2,                 5075   ),
(1,          2,                 5096   ),
(1,          2,                 6734   ),
(1,          2,                 5885   ),
(1,          2,                 5912   ),
(1,          2,                 5225   ),
(1,          2,                 6229   ),
(1,          3,                 4280   ),
(1,          3,                 6750   ),
(1,          3,                 5786   ),
(1,          3,                 7155   ),
(1,          3,                 4523   ),
(1,          3,                 5652   ),
(1,          3,                 4564   ),
(1,          3,                 3568   ),
(1,          3,                 4689   ),
(2,          4,                 34     ),
(2,          4,                 28     ),
(2,          4,                 29     ),
(2,          4,                 33     ),
(2,          4,                 35     ),
(2,          4,                 34     ),
(2,          4,                 32     ),
(2,          4,                 34     ),
(2,          4,                 31     ),
(2,          5,                 38     ),
(2,          5,                 40     ),
(2,          5,                 35     ),
(2,          5,                 37     ),
(2,          5,                 40     ),
(2,          5,                 36     ),
(2,          5,                 39     ),
(2,          5,                 35     ),
(2,          5,                 31     ),
(2,          6,                 37     ),
(2,          6,                 37     ),
(2,          6,                 42     ),
(2,          6,                 40     ),
(2,          6,                 38     ),
(2,          6,                 35     ),
(2,          6,                 37     ),
(2,          6,                 37     ),
(2,          6,                 36     ),
(3,          1,                 17.5   ),
(3,          1,                 13.1   ),
(3,          1,                 18.3   ),
(3,          1,                 12.9   ),
(3,          1,                 14.7   ),
(3,          1,                 15.5   ),
(3,          1,                 16.1   ),
(3,          1,                 18.8   ),
(3,          1,                 19.4   ),
(3,          2,                 23.9   ),
(3,          2,                 19.8   ),
(3,          2,                 27.5   ),
(3,          2,                 23.5   ),
(3,          2,                 25.4   ),
(3,          2,                 20.5   ),
(3,          2,                 21.4   ),
(3,          2,                 24.3   ),
(3,          2,                 23.7   ),
(3,          3,                 25.2   ),
(3,          3,                 29.7   ),
(3,          3,                 34.0   ),
(3,          3,                 28.7   ),
(3,          3,                 27.9   ),
(3,          3,                 32.0   ),
(3,          3,                 29.5   ),
(3,          3,                 32.8   ),
(3,          3,                 27.9   );