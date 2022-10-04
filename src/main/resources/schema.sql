use paymybuddy;

DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS connection;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS authority;

CREATE TABLE client
(
    id                       INT         NOT NULL AUTO_INCREMENT,
    name                     VARCHAR(45) NOT NULL,
    email                    VARCHAR(45) NOT NULL,
    password                 TEXT        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE connection
(
    client                   INT         NOT NULL,
    connect                  INT         NOT NULL,
    PRIMARY KEY (client, connect),
    FOREIGN KEY (client)     REFERENCES client (id),
    FOREIGN KEY (connect)    REFERENCES client (id)
);



CREATE TABLE authority
(
    id                       INT         NOT NULL AUTO_INCREMENT,
    name                     VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE role
(
    client                   INT    NOT NULL,
    authority                INT    NOT NULL,
    PRIMARY KEY (client , authority ),
    FOREIGN KEY (client)     REFERENCES client (id),
    FOREIGN KEY (authority)  REFERENCES authority (id)
);


CREATE TABLE account
(
    id                       INT            NOT NULL AUTO_INCREMENT,
    client                   INT            NOT NULL,
    balance                  DECIMAL(10,5)  NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client)     REFERENCES client(id)
);


CREATE TABLE transaction
(
    id                       INT           NOT NULL AUTO_INCREMENT,
    moment                   TIMESTAMP     NOT NULL,
    amount                   DECIMAL(10,5) NOT NULL,
    payer                    INT           NOT NULL,
    recipient                INT           NOT NULL,
    description              VARCHAR(45)   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (payer)      REFERENCES account(id),
    FOREIGN KEY (recipient)  REFERENCES account(id)
);