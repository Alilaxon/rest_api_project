CREATE TABLE gifts
(
    id           SERIAL           NOT NULL,
    gift_name    VARCHAR(64)      NOT NULL,
    description  VARCHAR(64)      NOT NULL,
    price        INT              NOT NULL,
    duration     INT              NOT NULL,
    createDate   VARCHAR(64)      NOT NULL,
    lastUpdateDate VARCHAR(64)    NOT NULL ,
    tag_id     INT NOT NULL
    REFERENCES tags (id)  ON DELETE CASCADE,
    PRIMARY KEY (id)

);

CREATE TABLE tags (
    id SERIAL PRIMARY KEY    NOT NULL ,
    tag_name  VARCHAR(32)    NOT NULL

);
