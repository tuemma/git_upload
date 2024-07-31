select DEPARTMENT_ID,count(EMPLOYEE_ID)
from EMPLOYEES
group by DEPARTMENT_ID

/*join DEPARTMENT*/
select distinct EE.DEPARTMENT_ID,DD.DEPARTMENT_NAME,count(EE.EMPLOYEE_ID)
from EMPLOYEES EE,DEPARTMENTS DD
where EE.DEPARTMENT_ID=DD.DEPARTMENT_ID
group by EE.DEPARTMENT_ID,DD.DEPARTMENT_NAME

/*課堂練習9*/
select  distinct PLACE,count(PLACE),max(CHLORINE),min(CHLORINE),sum(HYDROGEN),avg(TURBIDITY)
from SQL_TAOYUAN_WATER
where PLACE in ('T40','T44','T16')
group by  PLACE ;

select distinct RE.TOWNSHIP,count(WA.PLACE),avg(WA.TURBIDITY)
from SQL_TAOYUAN_REGIONS RE
left join SQL_TAOYUAN_WATER WA on WA.PLACE=RE.SERIAL
group by RE.TOWNSHIP
having avg(WA.TURBIDITY)>0.7;

/*INSERT,UPDATE,DELETE*/
create table SQL_EMP_HIS as select * from SQL_EMP
-- truncate table SQL_EMP_HIS 清空欄位(表格還在)
--commit;
insert into SQL_EMP_HIS(EMP_ID,DEP,EMP_NM)
values('00056789','系統開發部','曾O婷')

insert into SQL_EMP_HIS
select EMP_ID,EMP_NM,null,TEL,'資訊板塊'
from SQL_EMP
where EMP_ID = '00012345';

update SQL_EMP_HIS
set DEP = '資訊板塊';
commit;

/*課堂練習10*/
create table PRACTICE_EMP as select * from SQL_EMP
truncate table PRACTICE_EMP;

insert into PRACTICE_EMP(EMP_ID,EMP_NM,ID,TEL,DEP)
values('01900432','Emma','000','1234567','吃喝)

update PRACTICE_EMP
set ID='9000000'

delete from PRACTICE_EMP
where EMP_NM='Emma';

/*子查詢練習*/
select LAST_NAME,JOB_ID,SALARY
from EMPLOYEES
where JOB_ID = (select JOB_ID 
                from EMPLOYEES
                where EMPLOYEE_ID = 141)
and SALARY > (select SALARY
              from EMPLOYEES
              where EMPLOYEE_ID = 143);
              
select LAST_NAME,JOB_ID,SALARY
from EMPLOYEES
where SALARY = (select min(SALARY) from EMPLOYEES);

/*ANY,ALL*/
select EMPLOYEE_ID,LAST_NAME,JOB_ID,SALARY
from EMPLOYEES
where SALARY < ANY（select SALARY         -- < ANY:小於最大值
                    from EMPLOYEES        -- > ANY:大於最小值
                    where JOB_ID = 'IT_PROG')
and JOB_ID != 'IT_PROG'

select EMPLOYEE_ID,LAST_NAME,JOB_ID,SALARY
from EMPLOYEES
where SALARY < ALL（select SALARY         -- < ALL:小於最小值
                    from EMPLOYEES        -- > ALL:大於最大值
                    where JOB_ID = 'IT_PROG')
and JOB_ID != 'IT_PROG';








