CREATE TABLE users
(
    id           SERIAL           NOT NULL,
    name         VARCHAR(32)      NOT NULL,
    description  VARCHAR(32)      NOT NULL,
    price        INT              NOT NULL,
    duration     INT              NOT NULL,
    createDate   VARCHAR(32)      NOT NULL,
    lastUpdateDate VARCHAR(32)    NOT NULL ,
    tag_id     INT NOT NULL
        REFERENCES tags (id) ON DELETE CASCADE,
    PRIMARY KEY (id)

);

CREATE TABLE tags (
    id SERIAL NOT NULL ,
    name  VARCHAR(32)      NOT NULL

);
