
-- SpringREST > db.sql

select * from tblAddress;

insert into tblAddress (seq, name, age, gender, address, regdate)
    values (seqAddress.nextVal, '가가가', 20, 'm', '서울시 동대문구 휘경동', default);