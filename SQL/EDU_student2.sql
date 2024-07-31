select DEPARTMENT_ID,count(EMPLOYEE_ID)
from EMPLOYEES
group by DEPARTMENT_ID

/*join DEPARTMENT*/
select distinct EE.DEPARTMENT_ID,DD.DEPARTMENT_NAME,count(EE.EMPLOYEE_ID)
from EMPLOYEES EE,DEPARTMENTS DD
where EE.DEPARTMENT_ID=DD.DEPARTMENT_ID
group by EE.DEPARTMENT_ID,DD.DEPARTMENT_NAME

/*�Ұ�m��9*/
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
-- truncate table SQL_EMP_HIS �M�����(����٦b)
--commit;
insert into SQL_EMP_HIS(EMP_ID,DEP,EMP_NM)
values('00056789','�t�ζ}�o��','��O�@')

insert into SQL_EMP_HIS
select EMP_ID,EMP_NM,null,TEL,'��T�O��'
from SQL_EMP
where EMP_ID = '00012345';

update SQL_EMP_HIS
set DEP = '��T�O��';
commit;

/*�Ұ�m��10*/
create table PRACTICE_EMP as select * from SQL_EMP
truncate table PRACTICE_EMP;

insert into PRACTICE_EMP(EMP_ID,EMP_NM,ID,TEL,DEP)
values('01900432','Emma','000','1234567','�Y��)

update PRACTICE_EMP
set ID='9000000'

delete from PRACTICE_EMP
where EMP_NM='Emma';

/*�l�d�߽m��*/
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
where SALARY < ANY�]select SALARY         -- < ANY:�p��̤j��
                    from EMPLOYEES        -- > ANY:�j��̤p��
                    where JOB_ID = 'IT_PROG')
and JOB_ID != 'IT_PROG'

select EMPLOYEE_ID,LAST_NAME,JOB_ID,SALARY
from EMPLOYEES
where SALARY < ALL�]select SALARY         -- < ALL:�p��̤p��
                    from EMPLOYEES        -- > ALL:�j��̤j��
                    where JOB_ID = 'IT_PROG')
and JOB_ID != 'IT_PROG';








