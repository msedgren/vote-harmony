-- DDL used to generate the DB needed for this API.

CREATE TABLE room
(
    id INTEGER not null auto_increment primary key,
    external_id UUID not null default random_uuid(),
    name varchar2(50) unique not null,
    description varchar2(150) unique not null,
);

CREATE INDEX ON room (external_id);

CREATE TABLE voter
(
    id INTEGER not null auto_increment primary key,
    external_id UUID not null default random_uuid(),
    name varchar2(50) unique not null,
);

CREATE INDEX ON voter (external_id);

CREATE TABLE room_voter
(
    user_id INTEGER,
    room_id INTEGER,

    foreign key (user_id) references name
    foreign key (room_id) references name
);

CREATE INDEX ON room_voter (user_id, room_id);
