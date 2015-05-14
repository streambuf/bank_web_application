DROP TABLE user_role;
DROP TABLE operation_currency_exchange;
DROP TABLE operation_transfer;
DROP TABLE payment_services;
DROP TABLE passport;
DROP TABLE bank_account;
DROP TABLE bank_user;
DROP TABLE bank_role;
DROP TABLE exchange_rate;
DROP TABLE organization;
DROP TABLE service;
DROP TABLE category_services;


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



CREATE TABLE bank_account (
  id NUMBER(19) NOT NULL,
  balance  NUMBER(12,4),
  currency VARCHAR(20) CHECK( currency IN ('RUBLE', 'EUROS', 'DOLLAR')),
  client_id NUMBER(10),
  PRIMARY KEY (id),
  FOREIGN KEY (client_id) REFERENCES bank_user (id) ON DELETE CASCADE

);

INSERT INTO bank_account (id, balance, currency, client_id)
select 4081781050000000068, 15231, 'RUBLE', 100000
from dual union all select  
4081797860150000027, 193, 'EUROS', 100000
from dual union all select  
4081784000125000124, 44, 'DOLLAR', 100000
from dual;

CREATE TABLE operation_transfer (
  id NUMBER(10) NOT NULL,
  account_identifier NUMBER(19),
  quantity_of_money NUMBER(12,4),
  operation_date DATE,
  bank_account_id NUMBER(19),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE
);

INSERT INTO operation_transfer (id, account_identifier, quantity_of_money, operation_date, bank_account_id)
select 1, 4081781050000000019,500, '10-may-2015',  4081781050000000068
from dual union all select  
2, 4081784000125006763,100, '10-may-2015',  4081784000125000124
from dual union all select  
3, 4081781050000000462,2470, '11-may-2015',  4081781050000000068
from dual;

CREATE TABLE exchange_rate (
  id NUMBER(10) NOT NULL,
  currency VARCHAR(20) CHECK( currency IN ('RUBLE', 'EUROS', 'DOLLAR')),
  nominal NUMBER(10),
  rate NUMBER(12,4),
  start_date DATE,
  PRIMARY KEY (id)
);

INSERT INTO exchange_rate (id, currency, nominal, rate, start_date)
select 1, 'RUBLE', 1, 1, '10-may-2015'
from dual union all select 
2, 'EUROS', 1, 56.8971, '11-may-2015'
from dual union all select 
3, 'DOLLAR', 1, 50.7511, '11-may-2015'
from dual union all select 
4, 'EUROS', 1, 56.9011, '12-may-2015'
from dual union all select 
5, 'DOLLAR', 1, 50.8012, '12-may-2015'
from dual;

CREATE TABLE operation_currency_exchange (
  id NUMBER(10) NOT NULL,
  quantity_of_money NUMBER(12,4),
  operation_date DATE,
  sender_bank_account_id NUMBER(19),
  payee_bank_account_id NUMBER(19),
  rate_id NUMBER(10),
  PRIMARY KEY (id),
  FOREIGN KEY (rate_id) REFERENCES exchange_rate (id) ON DELETE CASCADE,
  FOREIGN KEY (sender_bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE,
  FOREIGN KEY (payee_bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE
);


CREATE TABLE category_services (
  id NUMBER(10) NOT NULL,
  name VARCHAR2(200),
  logotype VARCHAR2(10),
  PRIMARY KEY (id)
);

INSERT INTO category_services (id, name, logotype)
select 1, 'ЖКХ', '1.png'
from dual union all select  
2, 'ГИБДД, налоги, пошлиы', '2.png'
from dual union all select  
3, 'Товары и услуги', '3.png'
from dual union all select  
4, 'Коммуникации', '4.png'
from dual;

CREATE TABLE service (
  id NUMBER(10) NOT NULL,
  name VARCHAR2(200),
  category_services_id NUMBER(10),
  PRIMARY KEY (id),
  FOREIGN KEY (category_services_id) REFERENCES category_services (id) ON DELETE CASCADE
);

INSERT INTO service (id, name, category_services_id)
select 1, 'Квартплата', 1
from dual union all select  
2, 'Электроэнергия', 1
from dual union all select  
3, 'Водоснабжения', 1
from dual union all select  
4, 'ЖЭКи', 1
from dual union all select  
5, 'Газ', 1
from dual union all select  
6, 'Теплоснабжение', 1
from dual union all select  
7, 'ГИБДД', 2
from dual union all select  
8, 'Федеральная налоговая служба', 2
from dual union all select  
9, 'Пенсионные фонды', 2
from dual union all select  
10, 'Фонды социального страхования', 2
from dual union all select  
11, 'Транспорт', 3
from dual union all select  
12, 'Здоровье', 3
from dual union all select  
13, 'Спорт и отдых', 3
from dual union all select  
14, 'Мобильная связь', 4
from dual union all select  
15, 'Интернет', 4
from dual union all select  
16, 'ТВ', 4
from dual union all select  
17, 'Домашний телефон', 4
from dual;


CREATE TABLE organization (
  id NUMBER(10) NOT NULL,
  name VARCHAR2(200),
  bank_account NUMBER(19),
  type_client_identifier VARCHAR2(50),
  logotype VARCHAR2(50),
  service_id NUMBER(10),
  PRIMARY KEY (id),
  FOREIGN KEY (service_id) REFERENCES service (id) ON DELETE CASCADE
);

INSERT INTO organization (id, name, bank_account, type_client_identifier, service_id, logotype)
select 1, 'Freedom', 4081781050000083420, 'Логин', 15, '1.jpg'
from dual union all select  
2, 'АТК', 4081781050000047264, 'Лицевой счет', 15, '2.png'
from dual union all select  
3, 'Интерсвязь', 4081781050000094814, 'Лицевой счет', 15, '3.png'
from dual union all select  
4, 'МТС', 4081781050000094811, 'Лицевой счет', 15, '4.jpg'
from dual union all select  
5, 'Мобилтелеком', 4081781050000094812, 'Логин', 15, '5.gif'
from dual;


CREATE TABLE payment_services (
  id NUMBER(10) NOT NULL,
  quantity_of_money NUMBER(12,4),
  operation_date DATE,
  organization_id NUMBER(19),
  bank_account_id NUMBER(10),
  client_identifier VARCHAR2(50),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE,
  FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE
);






