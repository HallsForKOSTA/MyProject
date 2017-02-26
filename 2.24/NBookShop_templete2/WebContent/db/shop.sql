--drop table customer_tb;
--drop table product_tb;
--drop table orderproduct_tb;
--drop table order_tb;

CREATE TABLE customer_tb(
userId varchar2(50) primary key,
name varchar2(100),
password varchar(100));

CREATE TABLE product_tb(
serialNo number PRIMARY KEY,
name VARCHAR2(100),
price NUMBER,
userLike NUMBER(1));

CREATE TABLE orderproduct_tb(
orderId number not null,
serialNo number not null,
CONSTRAINT order_product_pk PRIMARY KEY(orderId,serialNo)
);

CREATE TABLE order_tb(
orderId number primary key,
userId varchar2(50),
payment char(1),
shipAddress varchar2(256)
);

create sequence product_seq start with 1 increment by 1;
create sequence order_seq start with 1 increment by 1;

insert into customer_tb values('BookMania', '김현주', '1234');
insert into customer_tb values('bookstore', '하영화', '2424');

insert into product_tb values(product_seq.nextval, '자바를 배웁시다.', 15000, 4);
insert into product_tb values(product_seq.nextval, 'Android Programming', 45000, 3);
insert into product_tb values(product_seq.nextval, 'Spring MVC', 35000, 5);

insert into order_tb values(order_seq.nextval, 'BookMania', 'C', '서울시 금천구');
insert into order_tb values(order_seq.nextval, 'bookstore', 'R', '서울시 관악구');

commit;