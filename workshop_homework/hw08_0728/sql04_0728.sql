-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
SELECT e.deptno, d.dname, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno=d.deptno;



-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT d.dname, e.ename
FROM emp e, dept d
WHERE e.deptno=d.deptno AND e.ename='SMITH';



--  ### Non Equi join ###
--3. 사원번호, 이름 ,업무, 급여, 급여의 등급, 하한 값, 상한 값을 출력하라.
SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM emp e, salgrade s;

 
-- ### outer join ###
-- 4.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno;


-- ###self join###
-- 5.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라.
‘SMTH의 매니저는 FORD이다’
SELECT e.ename||'의 매니저는 '||m.ename||'이다.'
FROM emp e, emp m
WHERE e.mgr=m.empno AND e.ename='SMITH';


-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
SELECT e.ename, e.empno, m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr=m.empno AND e.mgr=7698;



-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno AND (e.job IN ('MANAGER', 'CLERK'));



-- ### SubQuery ###
-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.
SELECT e.ename, d.dname, e.sal, e.job
FROM emp e, dept d
WHERE e.deptno=d.deptno 
AND e.job=(SELECT job
            FROM emp
            WHERE ename='SMITH') 
AND e.ename<>'SMITH';


-- 2.  ‘JONES’가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 출력하라.
SELECT deptno, empno, ename, hiredate, sal
FROM emp 
WHERE deptno=(SELECT deptno
            FROM emp
            WHERE ename='JONES');



-- 3.  전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 출력하라.
SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno=d.deptno
AND e.sal > (SELECT AVG(sal)
            FROM emp);


-- 4. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 출력하라.
SELECT e.empno, e.ename, d.dname, d.loc, e.sal
FROM emp e, dept d
WHERE e.deptno=d.deptno
AND e.job IN (SELECT job
            FROM dept
            WHERE deptno=10)
ORDER BY e.sal DESC;

-- 5.  10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 출력하라.
SELECT e.empno, e.ename, d.dname, e.hiredate, d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
AND e.deptno=10
AND e.job NOT IN (SELECT job
                FROM emp
                WHERE deptno=30);



--6.  ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT sal
              FROM emp
              WHERE ename IN ('KING', 'JAMES'));




-- 7.  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal)
            FROM emp
            WHERE deptno=30);



