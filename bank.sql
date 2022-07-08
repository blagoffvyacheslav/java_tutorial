CREATE DATABASE bank;

CREATE TABLE IF NOT EXISTS duration
(
    duration_id SERIAL,
    name        VARCHAR(30) NOT NULL,
    weight      NUMERIC(2, 2) DEFAULT 0.0,
    PRIMARY KEY (duration_id)
    );

CREATE TABLE IF NOT EXISTS occupation
(
    occupation_id SERIAL,
    name          VARCHAR(30) NOT NULL,
    duration_id   INT,
    PRIMARY KEY (occupation_id, duration_id),
    FOREIGN KEY (duration_id) REFERENCES duration
    );

CREATE TABLE IF NOT EXISTS customer
(
    customer_id   SERIAL,
    first_name    VARCHAR(30)  NOT NULL,
    last_name     VARCHAR(30)  NOT NULL,
    password      VARCHAR(255) NOT NULL,
    city          VARCHAR(15)  NOT NULL,
    mobileno      CHAR(10)     NOT NULL,
    occupation_id INT,
    duration_id   INT,
    dob           DATE         NOT NULL,
    married       BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (customer_id),
    FOREIGN KEY (occupation_id, duration_id) REFERENCES occupation
    );

CREATE TABLE IF NOT EXISTS account
(
    account_number  CHAR(20) UNIQUE,
    customer_id     INT,
    balance NUMERIC(10, 2) DEFAULT 0.0,
    account_status  VARCHAR(10) NOT NULL,
    PRIMARY KEY (account_number),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
    );



CREATE TABLE IF NOT EXISTS loan_tariff
(
    loan_tariff_id SERIAL,
    name           VARCHAR(15)   NOT NULL,
    coeff          NUMERIC(2, 2) NOT NULL,
    PRIMARY KEY (loan_tariff_id)
    );


CREATE TABLE IF NOT EXISTS loan
(
    customer_id    INT,
    loan_tariff_id INT,
    loan_amount    NUMERIC(6, 2) NOT NULL,
    PRIMARY KEY (customer_id, loan_tariff_id),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    FOREIGN KEY (loan_tariff_id) REFERENCES loan_tariff (loan_tariff_id)
    );


CREATE TABLE IF NOT EXISTS transaction_type
(
    transaction_type_id SERIAL,
    name                VARCHAR(15) NOT NULL,
    PRIMARY KEY (transaction_type_id)
    );

CREATE TABLE IF NOT EXISTS transaction
(
    transaction_id      BIGINT,
    account_number      CHAR(20),
    customer_id         INT,
    transaction_type_id INT,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_number) REFERENCES account (account_number),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    FOREIGN KEY (transaction_type_id) REFERENCES transaction_type (transaction_type_id)
    );

