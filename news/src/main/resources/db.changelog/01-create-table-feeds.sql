--создание таблицы объявлений
CREATE TABLE feeds
(
    id  serial PRIMARY KEY ,
    name TEXT,
    content TEXT,
    data TIMESTAMP,
    category_id INT
    --constraint fk_category foreign key (category_id) references categoryes (id)
);