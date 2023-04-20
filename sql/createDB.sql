DROP TABLE IF EXISTS gifts_tags;
DROP TABLE IF EXISTS gifts;
DROP TABLE IF EXISTS tags;


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
    createDate   VARCHAR(64)      NOT NULL,
    lastUpdateDate VARCHAR(64)    NOT NULL ,

    PRIMARY KEY (id)

);



CREATE TABLE gifts_tags (
    id SERIAL NOT NULL ,
    gift_id INT REFERENCES gifts (id) ON DELETE CASCADE ,
    tag_id INT REFERENCES tags (id) ON DELETE CASCADE ,
    PRIMARY KEY (id)
);

INSERT INTO tags
VALUES (default,'red');
INSERT INTO tags
VALUES (default,'yellow');
INSERT INTO tags
VALUES (default,'green');
INSERT INTO tags
VALUES (default,'black');

INSERT INTO gifts
VALUES (default,'giftN1','very good gift',1000,7,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN2','Not good gift',2000,14,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN3','very bad gift',3000,21,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN4','not bad gift',4000,28,'10.01.2023','12.01.2023');

INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN1'),
        (SELECT id FROM tags WHERE tag_name ='red'));

INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN1'),
        (SELECT id FROM tags WHERE tag_name ='green'));

INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN1'),
        (SELECT id FROM tags WHERE tag_name ='green'));

INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN2'),
        (SELECT id FROM tags WHERE tag_name ='red'));
INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN3'),
        (SELECT id FROM tags WHERE tag_name ='red'));

INSERT INTO gifts_tags
VALUES (DEFAULT,(SELECT id FROM gifts WHERE gift_name ='giftN4'),
        (SELECT id FROM tags WHERE tag_name ='red'));




