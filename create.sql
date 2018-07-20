/*Only ORACLE*/
CREATE TABLE users (
         id                INTEGER NOT NULL ,
         name       VARCHAR2(255) NOT NULL) tablespace wmsdb_ts;
	 
	 
	 CREATE SEQUENCE  seq_users START WITH 1 increment BY 1 MAXVALUE 2147483647 CYCLE NOCACHE ORDER;
	 
	 create or replace trigger tseq_users before insert on users
referencing NEW as newest for each row when (newest.id is NULL)
begin
	select seq_users.nextval into :newest.id from dual;
end tseq_users;
