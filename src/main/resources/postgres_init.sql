DROP TABLE IF EXISTS game_state;


CREATE TABLE IF NOT EXISTS game_state
(
    value VARCHAR(64) NOT NULL,
    PRIMARY KEY (value)
);

----------------------------------------
--Table question
----------------------------------------
CREATE TABLE IF NOT EXISTS question
(
    id         BIGSERIAL,
    text       VARCHAR(256) NULL,
    game_state VARCHAR(64)  NOT NULL,
    PRIMARY KEY (id)
);
----------------------------------------
--Table answer
----------------------------------------
CREATE TABLE IF NOT EXISTS answer
(
    id               BIGSERIAL,
    text             VARCHAR(256) NULL,
    questionId       INT          NOT NULL,
    next_question_id INT          NULL,
    PRIMARY KEY (id)
);
----------------------------------------
--Data for table game_state
----------------------------------------
START TRANSACTION;
INSERT INTO game_state (value)
VALUES ('PLAY'),
       ('WIN'),
       ('LOST');
COMMIT;

SELECT * FROM game_state;

