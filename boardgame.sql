CREATE DATABASE board_game;

use board_game;

DROP TABLE IF EXISTS games;

CREATE TABLE games (
                       id int(100) auto_increment,
                       name varchar(100) not null,
                       playtime varchar(100) not null,
                       type varchar(100) not null,
                       primary key (id)
);
