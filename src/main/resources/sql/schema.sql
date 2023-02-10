CREATE TABLE IF NOT EXISTS vote
(
    id           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email        VARCHAR(225) NOT NULL UNIQUE,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE IF NOT EXISTS topping
(
    id   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(225) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS vote_detail
(
    vote_id    BIGINT NOT NULL,
    topping_id BIGINT NOT NULL,

    CONSTRAINT `FK_VOTE_DETAIL__VOTE`
        FOREIGN KEY (vote_id)
            REFERENCES vote (ID),

    CONSTRAINT `FK_VOTE_DETAIL__TOPPING`
        FOREIGN KEY (topping_id)
            REFERENCES topping (ID),

    PRIMARY KEY (vote_id, topping_id)
);

INSERT IGNORE INTO vote(email)
VALUES ('antonspirchonak@gmail.com')
ON DUPLICATE KEY UPDATE id = id;

INSERT IGNORE INTO topping(name)
VALUES ('CORN'),
       ('MEAT'),
       ('PINEAPPLE')
ON DUPLICATE KEY UPDATE id = id;

INSERT IGNORE INTO vote_detail
VALUES (1, 2),
       (1, 1),
       (1, 3)
ON DUPLICATE KEY UPDATE vote_id = vote_id;