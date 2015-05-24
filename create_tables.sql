DROP TABLE user_role;
DROP TABLE operation_currency_exchange;
DROP TABLE operation_transfer;
DROP TABLE payment_services;
DROP TABLE credit_repayment;
DROP TABLE contribution;
DROP TABLE credit;
DROP TABLE passport;
DROP TABLE bank_account;
DROP TABLE bank_user;
DROP TABLE bank_role;
DROP TABLE exchange_rate;
DROP TABLE organization;
DROP TABLE service;
DROP TABLE category_services;
DROP TABLE contribution_rate;


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
100001,'Иванов', 'Иван', 'Иванович', '21-nov-1972', 423456789127, 'employee@mail.ru', 
'rus', 'Moscow', '89261334212', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100002,'Михалков', 'Михаил', 'Михайлович', '16-sep-1964', 323456789122, 'admin@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100004,'Светлаков', 'Юрий', 'Алексеевич', '16-sep-1964', 323456789123, 'svetlakov@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100005,'Колобков', 'Александр', 'Сергеевич', '16-sep-1964', 323456789124, 'ermakov@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100006,'Ефремов', 'Сергей', 'Владимирович', '16-sep-1964', 323456789125, 'efremov@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual union all select   
100007,'Людмилов', 'Иван', 'Михайлович', '16-sep-1964', 323456789126, 'ivanov@mail.ru', 
'rus', 'Moscow', '89261345432', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'
from dual;

CREATE TABLE user_role (
  role_id NUMBER REFERENCES bank_role(id),
  user_id NUMBER REFERENCES bank_user(id),
  PRIMARY KEY (role_id, user_id)
);

INSERT INTO user_role (role_id, user_id) VALUES(1, 100000 );
INSERT INTO user_role (role_id, user_id) VALUES(2, 100001 );
INSERT INTO user_role (role_id, user_id) VALUES(3, 100002 );

CREATE TABLE passport (
  id NUMBER(10) NOT NULL,
  series NUMBER(4),
  num NUMBER(6),
  date_of_issue DATE,
  issued_by VARCHAR2(500),
  PRIMARY KEY (id)
);

INSERT INTO passport (id, series, num, date_of_issue, issued_by) 
select 100000, 1234, 123456, '15-apr-2007', 'УФМС Москвы'
from dual union all select  
100001, 4142, 846578, '13-nov-2002', 'УФМС Москвы'
from dual union all select  
100002, 5313, 591049, '25-sep-2001', 'УФМС Москвы'
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

INSERT INTO OPERATION_CURRENCY_EXCHANGE (id, sender_bank_account_id, quantity_of_money, operation_date, payee_bank_account_id, rate_id)
select 1, 4081781050000000068, 500, '10-may-2015',  4081797860150000027, 5
from dual union all select  
2, 4081781050000000068, 100, '10-may-2015',  4081784000125000124, 4
from dual union all select  
3, 4081784000125000124, 70, '11-may-2015',  4081797860150000027, 5
from dual;


CREATE TABLE category_services (
  id NUMBER(10) NOT NULL,
  name VARCHAR2(200),
  logotype VARCHAR2(10),
  PRIMARY KEY (id)
);

INSERT INTO category_services (id, name, logotype)
select 1, 'ЖКХ', '1.png'
from dual union all select  
2, 'ГИБДД, налоги, пошлины', '2.png'
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
select 1, 'Водоснабжение', 1
from dual union all select  
2, 'Газ', 1
from dual union all select  
3, 'ЖЭКи', 1
from dual union all select  
4, 'Квартплата', 1
from dual union all select  
5, 'Теплоснабжение', 1
from dual union all select  
6, 'Элентроэнергия', 1
from dual union all select  
7, 'ГИБДД', 2
from dual union all select  
8, 'Пенсионные фонды', 2
from dual union all select  
9, 'Федеральная налоговая служба', 2
from dual union all select  
10, 'Фонды социального страхования', 2
from dual union all select  
11, 'Здоровье', 3
from dual union all select  
12, 'Спорт и отдых', 3
from dual union all select  
13, 'Транспорт', 3
from dual union all select  
14, 'Домашний телефон', 4
from dual union all select  
15, 'Интернет', 4
from dual union all select  
16, 'Мобильная связь', 4
from dual union all select  
17, 'ТВ', 4
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
3, 'ИНТЕРСВЯЗЬ', 4081781050000094814, 'Лицевой счет', 15, '3.png'
from dual union all select  
4, 'МТС', 4081781050000094811, 'Лицевой счет', 15, '4.jpg'
from dual union all select  
5, 'Burnet', 4081781050000094812, 'Логин', 15, '5.gif'
from dual;


CREATE TABLE payment_services (
  id NUMBER(10) NOT NULL,
  quantity_of_money NUMBER(12,4),
  operation_date DATE,
  organization_id NUMBER(19),
  bank_account_id NUMBER(19),
  client_identifier VARCHAR2(50),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE,
  FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE
);


CREATE TABLE credit (
  id NUMBER(10) NOT NULL,
  quantity_of_money NUMBER(12,4),
  annualPercentageRate NUMBER(12,4),
  start_date DATE,
  period NUMBER(10),
  bank_account_id NUMBER(19),
  place_of_work VARCHAR2(100),
  salary NUMBER(12,4),
  monthly_payment NUMBER(12,4),
  status VARCHAR(20) CHECK( status IN ('CONFIRMED', 'UNCONFIRMED', 'FINISHED')),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE
);

INSERT INTO credit (id, quantity_of_money, annualPercentageRate, start_date, period, bank_account_id, place_of_work, salary, monthly_payment, status)
select 1, 50000, 20, '10-may-2010', 12, 4081781050000000068, 'ATK', 35000, 4631.73, 'FINISHED'  
from dual union all select  
2, 100000, 20, '11-feb-2015', 24, 4081781050000000068, 'BBC', 55000, 5089.58, 'CONFIRMED'   
from dual union all select  
3, 90000, 20, '26-may-2015', 12, 4081781050000000068, 'MTC', 75000, 8337.11, 'UNCONFIRMED' 
from dual;

CREATE TABLE credit_repayment (
  id NUMBER(10) NOT NULL,
  quantity_of_money NUMBER(12,4),
  operation_date DATE,
  credit_id NUMBER(19),
  bank_account_id NUMBER(19),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE,
  FOREIGN KEY (credit_id) REFERENCES credit (id) ON DELETE CASCADE
);


CREATE TABLE contribution_rate (
  id NUMBER(10) NOT NULL,
  period VARCHAR(20) CHECK( period IN ('M1_6', 'M6_12', 'M12_24', 'M24_36')),
  quantity_of_money  VARCHAR(20) CHECK( quantity_of_money IN ('M100', 'M1000', 'M3000', 'M10000', 'M20000', 'M100000', 'M400000', 'M900000', 'M2000000')),
  currency VARCHAR(20) CHECK( currency IN ('RUBLE', 'EUROS', 'DOLLAR')),
  rate NUMBER(12,4),
  start_date DATE,
  PRIMARY KEY (id)
);

INSERT INTO contribution_rate (id, period, currency, quantity_of_money, rate, start_date)
select 1, 'M1_6', 'RUBLE', 'M1000', 7.25, SYSDATE
from dual union all select  
2, 'M6_12', 'RUBLE', 'M1000', 9.05, SYSDATE
from dual union all select  
3, 'M12_24', 'RUBLE', 'M1000', 8.20, SYSDATE
from dual union all select  
4, 'M24_36', 'RUBLE', 'M1000', 8.40, SYSDATE
from dual union all select  

5, 'M1_6', 'RUBLE', 'M100000', 7.70, SYSDATE
from dual union all select  
6, 'M6_12', 'RUBLE', 'M100000', 9.50, SYSDATE
from dual union all select  
7, 'M12_24', 'RUBLE', 'M100000', 8.65, SYSDATE
from dual union all select  
8, 'M24_36', 'RUBLE', 'M100000', 8.85, SYSDATE

from dual union all select  
9, 'M1_6', 'RUBLE', 'M400000', 7.95, SYSDATE
from dual union all select  
10, 'M6_12', 'RUBLE', 'M400000', 9.75, SYSDATE
from dual union all select  
11, 'M12_24', 'RUBLE', 'M400000', 8.90, SYSDATE
from dual union all select  
12, 'M24_36', 'RUBLE', 'M400000', 9.10, SYSDATE

from dual union all select  
13, 'M1_6', 'RUBLE', 'M900000', 8.25, SYSDATE
from dual union all select  
14, 'M6_12', 'RUBLE', 'M900000', 10.05, SYSDATE
from dual union all select  
15, 'M12_24', 'RUBLE', 'M900000', 9.20, SYSDATE
from dual union all select  
16, 'M24_36', 'RUBLE', 'M900000', 9.40, SYSDATE

from dual union all select  
17, 'M1_6', 'RUBLE', 'M2000000', 8.45, SYSDATE
from dual union all select  
18, 'M6_12', 'RUBLE', 'M2000000', 10.35, SYSDATE
from dual union all select  
19, 'M12_24', 'RUBLE', 'M2000000', 9.35, SYSDATE
from dual union all select  
20, 'M24_36', 'RUBLE', 'M2000000', 9.55, SYSDATE

from dual union all select  
21, 'M1_6', 'DOLLAR', 'M100', 1.50, SYSDATE
from dual union all select  
22, 'M6_12', 'DOLLAR', 'M100', 2.30, SYSDATE
from dual union all select  
23, 'M12_24', 'DOLLAR', 'M100', 3.10, SYSDATE
from dual union all select  
24, 'M24_36', 'DOLLAR', 'M100', 3.00, SYSDATE

from dual union all select  
25, 'M1_6', 'DOLLAR', 'M3000', 1.60, SYSDATE
from dual union all select  
26, 'M6_12', 'DOLLAR', 'M3000', 2.40, SYSDATE
from dual union all select  
27, 'M12_24', 'DOLLAR', 'M3000', 3.20, SYSDATE
from dual union all select  
28, 'M24_36', 'DOLLAR', 'M3000', 3.10, SYSDATE

from dual union all select  
29, 'M1_6', 'DOLLAR', 'M10000', 1.75, SYSDATE
from dual union all select  
30, 'M6_12', 'DOLLAR', 'M10000', 2.55, SYSDATE
from dual union all select  
31, 'M12_24', 'DOLLAR', 'M10000', 3.35, SYSDATE
from dual union all select  
32, 'M24_36', 'DOLLAR', 'M10000', 3.25, SYSDATE

from dual union all select  
33, 'M1_6', 'DOLLAR', 'M20000', 1.90, SYSDATE
from dual union all select  
34, 'M6_12', 'DOLLAR', 'M20000', 2.70, SYSDATE
from dual union all select  
35, 'M12_24', 'DOLLAR', 'M20000', 3.50, SYSDATE
from dual union all select  
36, 'M24_36', 'DOLLAR', 'M20000', 3.40, SYSDATE

from dual union all select  
37, 'M1_6', 'DOLLAR', 'M100000', 2.00, SYSDATE
from dual union all select  
38, 'M6_12', 'DOLLAR', 'M100000', 2.90, SYSDATE
from dual union all select  
39, 'M12_24', 'DOLLAR', 'M100000', 3.60, SYSDATE
from dual union all select  
40, 'M24_36', 'DOLLAR', 'M100000', 3.50, SYSDATE

from dual union all select  
41, 'M1_6', 'EUROS', 'M100', 1.10, SYSDATE
from dual union all select  
42, 'M6_12', 'EUROS', 'M100', 1.65, SYSDATE
from dual union all select  
43, 'M12_24', 'EUROS', 'M100', 2.15, SYSDATE
from dual union all select  
44, 'M24_36', 'EUROS', 'M100', 1.95, SYSDATE

from dual union all select  
45, 'M1_6', 'EUROS', 'M3000', 1.20, SYSDATE
from dual union all select  
46, 'M6_12', 'EUROS', 'M3000', 1.80, SYSDATE
from dual union all select  
47, 'M12_24', 'EUROS', 'M3000', 2.30, SYSDATE
from dual union all select  
48, 'M24_36', 'EUROS', 'M3000', 2.10, SYSDATE

from dual union all select  
49, 'M1_6', 'EUROS', 'M10000', 1.30, SYSDATE
from dual union all select  
50, 'M6_12', 'EUROS', 'M10000', 1.95, SYSDATE
from dual union all select  
51, 'M12_24', 'EUROS', 'M10000', 2.45, SYSDATE
from dual union all select  
52, 'M24_36', 'EUROS', 'M10000', 2.25, SYSDATE

from dual union all select  
53, 'M1_6', 'EUROS', 'M20000', 1.40, SYSDATE
from dual union all select  
54, 'M6_12', 'EUROS', 'M20000', 2.10, SYSDATE
from dual union all select  
55, 'M12_24', 'EUROS', 'M20000', 2.60, SYSDATE
from dual union all select  
56, 'M24_36', 'EUROS', 'M20000', 2.40, SYSDATE

from dual union all select  
57, 'M1_6', 'EUROS', 'M100000', 1.50, SYSDATE
from dual union all select  
58, 'M6_12', 'EUROS', 'M100000', 2.20, SYSDATE
from dual union all select  
59, 'M12_24', 'EUROS', 'M100000', 2.74, SYSDATE
from dual union all select  
60, 'M24_36', 'EUROS', 'M100000', 2.55, SYSDATE

from dual;

CREATE TABLE contribution (
  id NUMBER(10) NOT NULL,
  payment_procedure VARCHAR(20) CHECK( payment_procedure IN ('CAPITALIZATION', 'TRANSFER')),
  quantity_of_money NUMBER(12,4),
  start_date DATE,
  period NUMBER(10),
  bank_account_id NUMBER(19),
  contribution_rate_id NUMBER(19),
  PRIMARY KEY (id),
  FOREIGN KEY (bank_account_id) REFERENCES bank_account (id) ON DELETE CASCADE,
  FOREIGN KEY (contribution_rate_id) REFERENCES contribution_rate (id) ON DELETE CASCADE
);



