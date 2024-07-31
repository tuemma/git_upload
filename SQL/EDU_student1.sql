create table test as select * from SQL_EMP;

CREATE TABLE TABLE1 
(
  COLUMN_A VARCHAR2(20) 
, COLUMN_B VARCHAR2(20) 
);

create table table2
(
  column_C VARCHAR2(20),
  column_D VARCHAR2(20)
);

/*顯示資料結構*/
desc SQL_EMP;  

select EMP_ID,EMP_NM from SQL_EMP;
select * from SQL_EMP;

/* P.K. & F.K. */
create table SQL_EMP_test(
 EMP_ID CHAR(8 byte) primary key,
 EMP_NM NVARCHAR2(20),
 ID VARCHAR2(10 byte),
 TEL VARCHAR2(10 byte),
 DEP NVARCHAR2(20));

create table SQL_CUSTOMER_test(
 ID VARCHAR2(10 byte) primary key,
 NAME NVARCHAR2(20),
 EMP CHAR(8 byte) references SQL_EMP_test(EMP_ID))

alter table SQL_CUSTOMER_test
 add foreign key (EMP) references SQL_EMP_test(EMP_ID);

create index SQL_EMP_INDEX1 on SQL_EMP_test(DEP) --新增索引

select EMP_ID as 編號, EMP_NM as 名稱 from SQL_EMP;


create table WATER1 as select * from SQL_TAOYUAN_WATER

select 
 SERIAL_NUMBER as 序號,
 HYDROGEN as 氫離子濃度指數,
 TURBIDITY as 濁度,
 CHLORINE as  自由有效餘氣 from WATER1;
 
/*邏輯運算子*/
select * from SQL_EMP
 where DEP='系統開發部' and EMP_NM like'王%';
 
select * from SQL_EMP
 where DEP='系統開發部' or DEP='開發系統部';
 
select * from SQL_EMP
 where
  (DEP='系統開發部' and EMP_NM like'王%')
 or
  (DEP='開發系統部' and EMP_NM like'孫%'):

/*特殊運算子*/
select * from CARS
 where MIN_PRICE between '300' and '600'
 
select * from CARS
 where MIN_PRICE in ('300','600')

select * from CARS
 where MIN_PRICE in ('300','600')
 
select * from CARS
 where MIN_PRICE in ('300','600')
 or PRICE='800'
 
select * from CARS
 where MANUFACTURER like'__y%'
 and (PRICE between '300' and '450') 

select * from SQL_EMP_test
 where ID is null
 and EMP_NM is not null
  
/*課堂練習5*/
select SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from SQL_TAOYUAN_WATER
 where HYDROGEN in ('7.5','8')
 and CHLORINE > '0.6'
 and PLACE = 'T22';
 
select SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from SQL_TAOYUAN_WATER
 where (SERIAL_NUMBER between '521' and '529') 
 or (CHLORINE in ('0.76','0.77','0.66')
  and HYDROGEN != '7.8' 
  and TURBIDITY = '0.6')


/*課堂練習6*/
select distinct PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from SQL_TAOYUAN_WATER
 where (SERIAL_NUMBER between '521' and '529') 
 or (CHLORINE in ('0.76','0.77','0.66')
  and HYDROGEN != '7.8' 
  and TURBIDITY = '0.6') order by TURBIDITY asc,SERIAL_NUMBER desc;
  
  
select EMP_NM,ID
 from SQL_EMP
UNION
select EMP_NM,ID
 from SQL_EMP
UNION
select EMP_NM,ID
 from SQL_EMP
 
select EMP_NM,ID
 from SQL_EMP
UNION ALL
select EMP_NM,ID
 from SQL_EMP
UNION ALL
select EMP_NM,ID
 from SQL_EMP;


/*課堂練習7*/
select PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from(
select distinct PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from SQL_TAOYUAN_WATER
 where (SERIAL_NUMBER between '521' and '529') 
 
UNION ALL
select distinct PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE
from SQL_TAOYUAN_WATER
 where CHLORINE in ('0.76','0.77','0.66')
  and HYDROGEN != '7.8' 
  and TURBIDITY = '0.6'
)
order by TURBIDITY asc,SERIAL_NUMBER desc

/*JOIN*/
select CUT.ID,CUT.NAME,EMP.EMP_NM
from SQL_CUSTOMER CUT
inner join SQL_EMP EMP on CUT.EMP=EMP.EMP_ID

select CUT.ID,CUT.NAME,EMP.EMP_NM
from SQL_CUSTOMER CUT
left join SQL_EMP EMP on CUT.EMP=EMP.EMP_ID

select CUT.ID,CUT.NAME,EMP.EMP_NM
from SQL_CUSTOMER CUT
right join SQL_EMP EMP on CUT.EMP=EMP.EMP_ID

select CUT.ID,CUT.NAME,EMP.EMP_NM
from SQL_CUSTOMER CUT
full join SQL_EMP EMP on CUT.EMP=EMP.EMP_ID


select CUT.NAME,EMP.EMP_NM,DEP.ADDR
from SQL_CUSTOMER CUT
left join SQL_EMP EMP on CUT.EMP=EMP.EMP_ID
left join SQL_DEP DEP on EMP.DEP=DEP.DEP

/*課堂練習8*/
select DATA.PLACE,DATA.SERIAL_NUMBER,DATA.HYDROGEN,DATA.TURBIDITY,DATA.CHLORINE,WS.WATER_PURIFICATION_PLANT,WS.WATER_SUPPLY,RE.TOWNSHIP
from(
select distinct PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE,WATER_SYSTEM
from SQL_TAOYUAN_WATER
 where (SERIAL_NUMBER between '521' and '529') 
 
UNION ALL
select distinct PLACE,SERIAL_NUMBER,HYDROGEN,TURBIDITY,CHLORINE,WATER_SYSTEM
from SQL_TAOYUAN_WATER
 where CHLORINE in ('0.76','0.77','0.66')
  and HYDROGEN != '7.8' 
  and TURBIDITY = '0.6'
)DATA
left join SQL_TAOYUAN_REGIONS RE on RE.SERIAL=DATA.PLACE
left join SQL_TAOYUAN_WATER_SYSTEM WS on WS.SERIAL=DATA.WATER_SYSTEM

order by TURBIDITY asc,SERIAL_NUMBER desc















