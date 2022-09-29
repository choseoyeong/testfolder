--#################### ������ �Լ� �ǽ� ###################
-- 1) �̸��� 'adam' �� ������ �޿��� �Ի����� ��ȸ�Ͻÿ�.
select ename, sal, hiredate
from  emp 
where ename = 'ADAMS'
order by ename;

select ename, sal, hiredate
from  emp 
where lower(ename) = 'adams'
order by ename ;

-- 2) 'Adam�� �Ի����� 95/11/02 �̰�, �޿��� 3000 �Դϴ�.' �̷� ������ ����
       ������ ��ȸ�Ͻÿ�.
select  ename||'�� �Ի����� '|| hiredate ||' �̰�, �޿��� '|| sal  || ' �Դϴ�.'
from emp; 

-- 3) �̸��� 5���� ������ �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
select ename, sal, hiredate
from emp
where length(ename) <= 5;


-- 4) 1987 �⵵�� �Ի��� ������ �̸�, �Ի����� ��ȸ�Ͻÿ�.
SELECT ENAME, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE,'YY') = '87';

select ename, sal, to_date(hiredate,'RR/MM/DD') "�Ի���"
from emp
where to_char(to_date(hiredate,'RR/MM/DD'),'yyyy')='1987';

-- 5) 7�� �̻� ��� �ټ��� �������� �̸�, �Ի���, �޿�, �ٹ������� ��ȸ�Ͻÿ�.
SELECT ename, hiredate, sal, TRUNC(TRUNC(sysdate-TO_DATE(hiredate))/365) �ٹ�����
FROM emp
WHERE TRUNC(TRUNC(sysdate-TO_DATE(hiredate))/365) > 7;


select ename, hiredate, sal, trunc(months_between(sysdate,to_date(hiredate,'RR-MM-DD')) /12) "�ٹ�����"
from emp
where trunc(months_between(sysdate,to_date(hiredate,'RR-MM-DD')) /12)>=7;



-- ##################  �׷� �Լ� �ǽ� ######################
-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT TRUNC(AVG(sal),1), MAX(sal), MIN(sal), COUNT(-1)
FROM emp
WHERE deptno = 30
GROUP BY deptno;

-- 2) �� �μ��� �޿��� ���(�Ҽ����� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal)), MAX(sal), MIN(sal), COUNT(-1)
FROM emp
GROUP BY deptno;


-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
select deptno, job, count(*)
from emp
group by deptno, job 
order by deptno;

SELECT deptno, job, COUNT(-1)
FROM emp
GROUP BY deptno, job
order by deptno;

-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
select job, count(*)
from emp
group by job
having count(*)>=2;


-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
select trunc(avg(sal)) ���, sum(sal), max(sal), min(sal)
from emp
group by deptno
order by "��� ����" desc;


-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������, �޿��հ踦 ����϶�.
-- ��, �μ��� �޿��հ赵 ���� ����϶�.

select deptno, job, sum(sal)
from emp
group by rollup(deptno, job)
order by deptno;


-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
select deptno , count(*) 
from  emp 
group by deptno
having count(*) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧���� 
   ��ȸ������� ���ܽ�Ų��.
select deptno ,max(sal), min(sal), count(*)
from  emp
group by deptno
having max(sal) <> min(sal);


--10) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�.
 select deptno, avg(nvl(sal,0)) "��� �޿�"
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having  avg(nvl(sal,0))>= 2000 
 order by 2 desc  ;

 select deptno, avg(nvl(sal,0)) "��� �޿�"
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having  avg(nvl(sal,0))>= 2000 
 order by "��� �޿�" desc  ;