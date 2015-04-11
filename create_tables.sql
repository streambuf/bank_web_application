DROP TABLE passport;
DROP TABLE bank_account;
DROP TABLE client;
DROP TABLE Employees;

create table Employees (
      id  NUMBER(10) NOT NULL,
      age NUMBER(10),
      name varchar2(255),
      salary NUMBER(10,2),
      PRIMARY KEY (id)
);

CREATE TABLE client (
  id NUMBER(10) NOT NULL,
  lname VARCHAR2(50),
  fname VARCHAR2(50),
  patronymic VARCHAR2(50),
  date_of_birth DATE,
  tin NUMBER(10), -- TIN - Taxpayer Identification Number
  email VARCHAR2(50),
  citizenship VARCHAR2(100),
  address VARCHAR2(100),
  phone VARCHAR2(50),
  PRIMARY KEY (id)
);

INSERT INTO client (id, lname, fname, patronymic, date_of_birth, tin, email,
citizenship, address, phone)
VALUES(1, 'Mois', 'Maxim', 'patronymic', '30-nov-08', 123, 'email@mail.ru',
'rus', 'Moscow', '823423452544325');

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
  balance NUMBER(10),
  valuta VARCHAR2(500),
  client_id INTEGER,
  PRIMARY KEY (id, client_id),
  FOREIGN KEY (client_id) REFERENCES client (id)
);




-- autoincrements for tables
--DROP SEQUENCE client_seq;
--CREATE SEQUENCE client_seq;
--
--CREATE OR REPLACE TRIGGER client_autoincrement 
--BEFORE INSERT ON client
--FOR EACH ROW
--
--BEGIN
--  SELECT client_seq.NEXTVAL
--  INTO   :new.id
--  FROM   dual;
--END;
--/
--
--DROP SEQUENCE passport_seq;
--CREATE SEQUENCE passport_seq;
--
--CREATE OR REPLACE TRIGGER passport_autoincrement 
--BEFORE INSERT ON passport
--FOR EACH ROW
--
--BEGIN
--  SELECT passport_seq.NEXTVAL
--  INTO   :new.id
--  FROM   dual;
--END;
--/
--
--DROP SEQUENCE bank_account_seq;
--CREATE SEQUENCE bank_account_seq;
--
--CREATE OR REPLACE TRIGGER bank_account_autoincrement 
--BEFORE INSERT ON bank_account
--FOR EACH ROW
--
--BEGIN
--  SELECT bank_account_seq.NEXTVAL
--  INTO   :new.id
--  FROM   dual;
--END;
--/
