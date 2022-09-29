-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
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

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
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
--3. 사원번호, 이름 ,업무, 급여, 급여의 등급, 하한 값, 상한 값을 출력하라.
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
-- 4.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.

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
-- 5.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
‘SMTH의 매니저는 FORD이다’

select m.ename || '의 매니저는 ' || e.ename || '이다'
from emp e, emp m
where e.empno=m.mgr;

-- ===============================
select concat(e.ename,'의 매니저는 ' ,m.ename,'이다' )
from emp e join emp m on e.mgr=m.empno
order by e.mgr;


-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and m.empno = 7698;

-- ========================================
select e1.ename ename, e1.empno empno, e1.mgr, e2.ename
from  emp e1 JOIN  emp e2 ON  e1.mgr= e2.empno
WHERE e1.mgr='7698';

-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
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
-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.

select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');


-- 2.  ‘JONES’가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 출력하라.
select empno, ename, hiredate, sal
from emp
where deptno =( select deptno from emp where ename='JONES');

-- 3.  전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 출력하라.
select empno, ename, dname, hiredate, loc, sal
from emp, dept
where emp.deptno = dept.deptno and sal >=(select avg(sal) from emp);


-- 4. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 출력하라.

select empno, ename, dname, loc, sal
from emp e, dept d
where e.deptno = d.deptno and job in  ( select job from emp where deptno=10)
order by sal desc;

-- ===========================================
select e.empno, e.ename, d.dname, d.loc, sal
from emp e join dept d on e.deptno=d.deptno
where e.job  in (select job from emp where deptno=10)
Order by sal  desc;


-- 5.  10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 출력하라.
select empno, ename, hiredate, job, dname, loc
from emp e, dept d
where e.deptno = d.deptno 
and (e.deptno=10 and job not in (select job from emp  where deptno=30));


-- ===========================================================
select e.empno, e.ename, d.dname, hiredate, d.loc
from emp e join dept d on e.deptno=d.deptno
where e.deptno=10
and e.job not in (select job from emp where deptno=30);

--6.  ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));


-- 7.  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
select empno, ename, sal
from emp
where sal >( select max(sal) from emp where deptno=30);


