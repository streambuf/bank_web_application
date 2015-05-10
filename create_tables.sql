DROP TABLE user_role;
DROP TABLE passport;
DROP TABLE bank_account;
DROP TABLE bank_user;
DROP TABLE bank_role;
DROP TABLE currency;


CREATE TABLE bank_role (
  id NUMBER(10) NOT NULL,
  name VARCHAR(20) CHECK( name IN ('ROLE_CLIENT', 'ROLE_EMPLOYEE', 'ROLE_ADMIN')),
  PRIMARY KEY (id)
);

INSERT INTO bank_role VALUES( 1, 'ROLE_CLIENT' );
INSERT INTO bank_role VALUES( 2, 'ROLE_EMPLOYEE' );
INSERT INTO bank_role VALUES( 3, 'ROLE_ADMIN' );

CREATE TABLE bank_user (
  id NUMBER(10) NOT NULL,
  lname VARCHAR2(50),
  fname VARCHAR2(50),
  patronymic VARCHAR2(50),
  date_of_birth DATE,
  tin NUMBER(12), -- TIN - Taxpayer Identification Number
  email VARCHAR2(50),
  citizenship VARCHAR2(100),
  address VARCHAR2(100),
  phone VARCHAR2(50),
  password VARCHAR2(64),
  PRIMARY KEY (id)
);

INSERT INTO bank_user (id,lname, fname, patronymic, date_of_birth, tin, email,
citizenship, address, phone, password)
select 100000,'Моисеев', 'Максим', 'Алексеевич', '15-apr-1993', 123456789126, 'streambuf@mail.ru', 
'rus', 'Moscow', '89269262626', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100001,'Смирнов', 'Иван', 'Васильевич', '21-nov-1972', 423456789127, 'employee@mail.ru', 
'rus', 'Moscow', '89261334212', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100002,'Дятлов', 'Виталй', 'Михайлович', '16-sep-1964', 323456789122, 'admin@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual;

CREATE TABLE user_role (
  id NUMBER(10) NOT NULL,
  role_id NUMBER REFERENCES bank_role(id),
  user_id NUMBER REFERENCES bank_user(id),
  PRIMARY KEY (id, role_id, user_id)
);

INSERT INTO user_role VALUES( 1, 1, 100000 );
INSERT INTO user_role VALUES( 1, 1, 100001 );
INSERT INTO user_role VALUES( 1, 1, 100002 );

CREATE TABLE passport (
  id NUMBER(10) NOT NULL,
  series NUMBER(4),
  num NUMBER(6),
  date_of_issue DATE,
  issued_by VARCHAR2(500),
  PRIMARY KEY (id)
);

INSERT INTO passport (id, series, num, date_of_issue, issued_by) 
select 100000, 1234, 123456, '15-apr-2007', 'УФМС Твери'
from dual union all select  
100001, 4142, 846578, '13-nov-2002', 'УФМС Твери'
from dual union all select  
100002, 5313, 591049, '25-sep-2001', 'УФМС Твери'
from dual;

CREATE TABLE currency (
  id NUMBER(10) NOT NULL,
  name VARCHAR(20) CHECK( name IN ('RUBLE', 'EUROS', 'DOLLAR')),
  PRIMARY KEY (id)
);

INSERT INTO currency VALUES( 1, 'RUBLE' );
INSERT INTO currency VALUES( 2, 'EUROS' );
INSERT INTO currency VALUES( 3, 'DOLLAR' );

CREATE TABLE bank_account (
  id NUMBER(10) NOT NULL,
  bank_identifier NUMBER(12),
  balance NUMBER(10),
  currency_id INTEGER,
  client_id INTEGER,
  PRIMARY KEY (id, client_id),
  FOREIGN KEY (client_id) REFERENCES bank_user (id) ON DELETE CASCADE,
  FOREIGN KEY (currency_id) REFERENCES currency (id)
);

INSERT INTO bank_account (id, bank_identifier, balance, currency_id, client_id)
select 1, 123456789123, 15231, 1, 100000
from dual union all select  
2, 123456789124, 193, 2, 100000
from dual union all select  
3, 123456789125, 44, 3, 100000
from dual;
