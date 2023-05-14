CREATE TABLE tags (
                      id SERIAL PRIMARY KEY    NOT NULL ,
                      tag_name  VARCHAR(32)    NOT NULL

);


CREATE TABLE gifts
(
    id           SERIAL           NOT NULL,
    gift_name    VARCHAR(64)      NOT NULL,
    description  VARCHAR(64)      NOT NULL,
    price        INT              NOT NULL,
    duration     INT              NOT NULL,
    create_Date   VARCHAR(64)      NOT NULL,
    last_Update_Date VARCHAR(64)    NOT NULL ,

    PRIMARY KEY (id)

);



CREATE TABLE gifts_tags (
                            id SERIAL NOT NULL ,
                            gift_id INT REFERENCES gifts (id) ON DELETE CASCADE ,
                            tag_id INT REFERENCES tags (id) ON DELETE CASCADE ,
                            PRIMARY KEY (id)
);