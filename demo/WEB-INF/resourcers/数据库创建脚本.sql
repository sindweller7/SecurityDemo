DROP SEQUENCE useridseq ;
CREATE SEQUENCE useridseq ;
DROP TABLE T_UEE_USER ;
/*======================= 创建user数据表 =======================*/
CREATE TABLE T_UEE_USER(
	userId			NUMBER(4)		PRIMARY KEY ,
	authId			NUMBER(4) ,
	username		VARCHAR(32)		NOT NULL ,
	password		VARCHAR(32)		NOT NULL ,
	age				NUMBER(4)	,
	money			NUMBER(10)	,
	description		VARCHAR(32)
) ;

INSERT INTO T_UEE_USER(userId,authId,username,password,age,money,description) VALUES (useridseq.nextval,1,'manager','123456',30,10000,'我是经理');
INSERT INTO T_UEE_USER(userId,authId,username,password,age,money,description) VALUES (useridseq.nextval,2,'smith','123456',29,50000,'我是职员smith');
INSERT INTO T_UEE_USER(userId,authId,username,password,age,money,description) VALUES (useridseq.nextval,2,'john','123456',29,50000,'我是职员john');