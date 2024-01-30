-- инициализация базы данных "vida_db" (пустая база данных с таким именем должна быть предварительно создана)

-- удаление таблиц
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
    "login"         TEXT    NOT NULL,
    "password"      TEXT    NOT NULL
);

-- заполнение таблиц
INSERT INTO "organization"
("name"               , "individual", "area") VALUES
('Иванов'             , true        , 1.2   ),
('ООО «Рога и Копыта»', false       , 5.6   ),
('Колхоз «Заря»'      , false       , 8.9   );

INSERT INTO "username"
("firstname", "surname", "lostname", "status", "group" , "login",  "password" ) VALUES
('Иван',      'Иванов',  'Иванович', 'аспирант', 4,      'abc',    '123' ),
('Петр',      'Петров',  'Петрович', 'аспирант', 5,      'cba',    '321'),
('Сергей',    'Сергеев', 'Сергеевич','студент',  4,      'xyz',    '456'),
('Игорь',     'Игорев',  'Игоревич', 'аспирант', 5,      'zyx',    '654');
