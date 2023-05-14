INSERT INTO gifts
VALUES (default,'giftN1','very good gift',1000,7,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN2','Not good gift',2000,14,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN3','very bad gift',3000,21,'10.01.2023','12.01.2023');
INSERT INTO gifts
VALUES (default,'giftN4','not bad gift',4000,28,'10.01.2023','12.01.2023');

INSERT INTO tags
VALUES (default,'red');
INSERT INTO tags
VALUES (default,'yellow');
INSERT INTO tags
VALUES (default,'green');
INSERT INTO tags
VALUES (default,'black');

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