-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.
select d.deptno, d.dname, e.ename, e.sal
from emp e, dept d
where e.deptno=d.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.
select dname
from dept
where deptno=(select deptno from emp where ename='SMITH');

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';
-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';

--  ### Non Equi join ###
--3. �����ȣ, �̸� ,����, �޿�, �޿��� ���, ���� ��, ���� ���� ����϶�.
select e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where e.sal between losal and hisal;

select empno, ename, job, sal, grade, losal, hisal
from emp, salgrade
where sal >= losal and sal<=hisal;

select empno, ename, job, sal, grade, losal, hisal
from emp, salgrade
where sal between losal and hisal;
 
 -- ======================================== 
  select ename, job, sal, grade, losal, hisal
  FROM   emp  JOIN   salgrade   on  sal>= losal AND sal<=hisal;
  
-- ### outer join ###
-- 4.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.

select e.ename, e.deptno, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno(+);

select  ename, d.deptno, dname, sal
from emp e, dept d
where  d.deptno = e.deptno(+);

-- ========================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e right join dept d  on e.deptno =d.deptno;

select d.deptno, d.dname, e.ename, e.sal 
from emp e right outer join dept d  on e.deptno =d.deptno;



-- ###self join###
-- 5.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�
��SMTH�� �Ŵ����� FORD�̴١�

select m.ename || '�� �Ŵ����� ' || e.ename || '�̴�'
from emp e, emp m
where e.empno=m.mgr;

-- ===============================
select concat(e.ename,'�� �Ŵ����� ' ,m.ename,'�̴�' )
from emp e join emp m on e.mgr=m.empno
order by e.mgr;


-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and m.empno = 7698;

-- ========================================
select e1.ename ename, e1.empno empno, e1.mgr, e2.ename
from  emp e1 JOIN  emp e2 ON  e1.mgr= e2.empno
WHERE e1.mgr='7698';

-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and (  job='MANAGER' or job='CLERK');

select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and  job in ('MANAGER' ,'CLERK');

-- ========================================
  select empno, ename, job, deptno, dname
  FROM   emp   JOIN dept   USING (deptno)
  WHERE  job ='MANAGER' or job='CLERK'  ;


-- ### SubQuery ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.

select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');


-- 2.  ��JONES���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.
select empno, ename, hiredate, sal
from emp
where deptno =( select deptno from emp where ename='JONES');

-- 3.  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���, �Ի���, ����, �޿��� ����϶�.
select empno, ename, dname, hiredate, loc, sal
from emp, dept
where emp.deptno = dept.deptno and sal >=(select avg(sal) from emp);


-- 4. 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �μ���,����, �޿��� �޿��� ���� ������ ����϶�.

select empno, ename, dname, loc, sal
from emp e, dept d
where e.deptno = d.deptno and job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 5.  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���, �Ի���, ������ ����϶�.
select empno, ename, hiredate, job, dname, loc
from emp e, dept d
where e.deptno = d.deptno 
and (e.deptno=10 and job not in (select job from emp  where deptno=30));


-- ===========================================================
select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

--6.  ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 7.  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


