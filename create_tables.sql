DROP TABLE passport;
DROP TABLE bank_account;
DROP TABLE client;

CREATE TABLE client (
  id NUMBER(10) NOT NULL,
  surname VARCHAR2(50),
  first_name VARCHAR2(50),
  patronymic VARCHAR2(50),
  sex VARCHAR2(10), -- (male, female)
  date_of_birth DATE,
  tin NUMBER(10), -- TIN - Taxpayer Identification Number
  email VARCHAR2(50),
  citizenship VARCHAR2(100),
  address VARCHAR2(100),
  phone VARCHAR2(50),
  PRIMARY KEY (id)
);

CREATE TABLE passport (
  id NUMBER(10) NOT NULL,
  series NUMBER(10),
  num NUMBER(10),
  date_of_issue DATE,
  issued_by VARCHAR2(500),
  client_id INTEGER,
  PRIMARY KEY (id, client_id),
  FOREIGN KEY(client_id) REFERENCES client(id) 
);

CREATE TABLE bank_account (
  id NUMBER(10) NOT NULL,
  bank_identifier NUMBER(10),
  sum_of_money NUMBER(10),
  valuta VARCHAR2(500),
  client_id INTEGER,
  PRIMARY KEY (id, client_id),
  FOREIGN KEY (client_id) REFERENCES client (id)
);


-- autoincrements for tables
DROP SEQUENCE client_seq;
CREATE SEQUENCE client_seq;

CREATE OR REPLACE TRIGGER client_autoincrement 
BEFORE INSERT ON client
FOR EACH ROW

BEGIN
  SELECT client_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

DROP SEQUENCE passport_seq;
CREATE SEQUENCE passport_seq;

CREATE OR REPLACE TRIGGER passport_autoincrement 
BEFORE INSERT ON passport
FOR EACH ROW

BEGIN
  SELECT passport_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

DROP SEQUENCE bank_account_seq;
CREATE SEQUENCE bank_account_seq;

CREATE OR REPLACE TRIGGER bank_account_autoincrement 
BEFORE INSERT ON bank_account
FOR EACH ROW

BEGIN
  SELECT bank_account_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/
