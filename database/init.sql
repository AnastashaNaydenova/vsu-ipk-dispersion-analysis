-- удаление таблиц
DROP TABLE IF EXISTS "organization";

-- создание таблиц
CREATE TABLE "organization"
(
	"id"         SERIAL  PRIMARY KEY,
	"name"       TEXT    NOT NULL,
	"individual" BOOLEAN NOT NULL,
	"area"       REAL    NOT NULL
);

-- заполнение таблиц
INSERT INTO "organization"
("name"               , "individual", "area") VALUES
('Иванов'             , true        , 1.2   ),
('ООО "Рога и Копыта"', false       , 5.6   ),
('Колхоз "Заря"'      , false       , 8.9   );
