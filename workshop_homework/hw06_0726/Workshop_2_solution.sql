-- ##################  ���ڿ� �Լ� �ǽ� ######################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.
select * from emp where lower(ename) like '%s%';

-- 2) ��� �������� �̸��� ù���ڸ� �빮�ڷ� �����Ͽ� ����϶�.
select ename, initcap(ename)  from emp;


-- 3) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
select empno, substr(ename,1,3), sal  from emp;

-- 4) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
select ename,  lower(substr(ename, 1,3)) 
from emp
where  length(ename) >=6;


-- 5) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.
select  ename, lpad(sal, 6,'*') from emp;


-- 6) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.
insert into emp values(8001,'   PARK   ', 'IT' ,  7900 , '21/11/10', 20000,1000,10);
select * from emp;

-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
  select * from emp  where  ename='PARK';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
 select * from emp  where  trim(ename)='PARK';


-- ##################  ���� �Լ� �ǽ� ######################

-- 1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
select ename, sal, round(sal*0.15, 2) ȸ�� 
from emp
where sal between 1500 and 3000;
 

-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
select ename, sal,  trunc(sal*0.05) ������
from emp
where sal>=2000;
  

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)
 select empno, ename, sal, ceil(comm*1.5) ���ʽ�
from emp
where  comm is not null and comm != 0;



-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
select ename, hiredate, hiredate+100 "100�� ���� ��", sal   from emp;

-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
select hiredate, add_months(hiredate,6) "6���� ���� ��¥" , sal  from emp;

-- 3) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
select ename, hiredate, trunc(sysdate-hiredate) �ٹ��ϼ� from emp;

-- 4) ������ �̸�, �ټӳ���� ���Ͽ� ����϶�.
select ename, round(months_between(sysdate, hiredate) /12) �ټӳ�� from emp;
select ename, round((sysdate-hiredate) /365) �ټӳ�� from emp;



-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 1) ��� ������ �̸��� �Ի����� ��1996-5-14���� ���·� ��� �϶�.
select ename, hiredate from emp;
SELECT ename, TO_CHAR(TO_DATE(hiredate, 'RR/MM/DD'), 'FMYYYY-MM-DD') �Ի��� FROM emp;

-- 2) ��� ������ �̸��� �Ի��� ������ ����϶�.
select ename, to_char(hiredate,'DAY') �Ի���� from emp;




-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- 1)  ��� ������ �̸�, �޿�, Ŀ�̼��� ����϶�. ��, comm�� null�̸� 0���� ����϶�.
select ename, sal, nvl(comm,0) Ŀ�̼� from emp;
select ename, sal, nvl(comm,0), coalesce(comm,0) from emp;

