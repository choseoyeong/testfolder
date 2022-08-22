--<<그룹함수>>
-- null값을 건너뛰고 연산을 진행한다.

SELECT COUNT(*) FROM emp;
SELECT COUNT(-1) FROM emp;
SELECT COUNT(MGR) FROM emp;     --14
SELECT COUNT(COMM) FROM emp;    

-- emp 테이블에서 부서종류의 개수를 검색..COUNT()
SELECT COUNT(deptno) FROM emp;
SELECT COUNT(ALL(deptno)) FROM emp;
SELECT COUNT(DISTINCT(deptno)) FROM emp;  -- 중복제거. 순서유의

SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate)
FROM emp;


SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job='SALESMAN';


--emp 테이블에서 총 인원, 보너스 받는 인원수를 검색
SELECT COUNT(*) 총인원, COUNT(comm) 보너스받는인원, AVG(comm) 보너스평균1
FROM emp;   -- null을 제외하기 때문에 4로 나눔

SELECT COUNT(*) 총인원, COUNT(comm) 보너스받는인원, ROUND(AVG(NVL(comm,0))) 보너스평균2
FROM emp;  

SELECT COUNT(*) 총인원, COUNT(comm) 보너스받는인원,  AVG(comm) 보너스평균1, ROUND(AVG(NVL(comm,0))) 보너스평균2
FROM emp;  


SELECT comm FROM emp;

--GROUP BY절 :: 그룹을 세분화 시키는 기능
--SELECT절에서 그룹함수에 적용되지 않은 컬럼은 반드시 GROUP BY절 뒤에 명시되어야 한다.

-- 잘못됨. AVG는 전체 그룹을 대상으로하지만 dept는 GROUPING이 안됐음
--SELECT deptno, AVG(sal) FROM emp; 

-- 1)원래는 그룹이 하나
SELECT ROUND(AVG(sal)) FROM emp;

-- 2)지금은 세그룹. -> 그룹을 세분화. 여기서 더 세분화도 가능함
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

-- 3) 정렬
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
ORDER BY 1;     -- SELECT절의 첫번째 열 기준으로 정렬

-- 4) Alias
/*
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY DName
ORDER BY DName;     --Error. GROUP BY절 뒤에 Alias 사용하면 안됨!!
*/

-- 5) Alias :: ORDER BY절 뒤에는 Alias 사용하는 게 더 좋음
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
ORDER BY AvgSalary;   


-- 각 부서별로 인원수, 급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순서대로 출력
SELECT COUNT(*), AVG(sal), MIN(sal), MAX(sal), SUM(sal) 급여의합
FROM emp
GROUP BY deptno
ORDER BY 급여의합 DESC;

-- 업무별로 업무, 인원수, 급여의 평균, 급여의 합을 조회한다.
SELECT job, COUNT(*), AVG(sal), SUM(sal)
FROM emp
GROUP BY job;

-- 업무와 부서기준으로 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 조회한다.
SELECT deptno, job, COUNT(*), AVG(sal), SUM(sal)
FROM emp
GROUP BY job, deptno;

-- emp테이블에서 각 부서별 평균급여를 구하는데 그중에서 평균급여가 2000달러 이상인 사원의 평균급여를 검색..
-- ERROR. WHERE절에서는 그룹함수 사용할 수 없다.
-- 실행순서: FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
/*
SELECT dept, AVG(sal) 평균급여
FROM emp
WHERE AVG(sal) >= 2000
GROUP BY deptno;
*/

SELECT deptno, AVG(sal) 평균급여
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;


-- >> HAVING
-- 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 조회
SELECT deptno, COUNT(*), SUM(sal)
FROM emp
GROUP BY deptno
HAVING COUNT(*)>4;

--emp테이블에서 급여가 최대 2900 이상인 부서에 대해서 부서번호, 평균급여, 급여의 합을 조회한다.
SELECT deptno, AVG(sal), SUM(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)>2900;

SELECT job, AVG(sal), SUM(sal)
FROM emp
HAVING avg(sal) >= 3000
GROUP BY job;

SELECT deptno, AVG(sal)
FROM emp
WHERE job='CLERK'
GROUP BY deptno
HAVING AVG(sal) > 1000;


-- 부서 급여 합계 중 최대값을 조회한다.
SELECT MAX(SUM(sal))
FROM emp
GROUP BY deptno;


-- 입사년도별 인원수를 출력...입사년도, 인원수로 별칭 지정
SELECT SUBSTR(hiredate,1,2) 입사년도, COUNT(*) 인원수
FROM emp
GROUP BY SUBSTR(hiredate, 1, 2);

-- 20번 부서에서 가장 먼저 입사한 사원을 검색
SELECT MIN(hiredate)
FROM emp
GROUP BY deptno
HAVING deptno=20;

SELECT *
FROM emp
GROUP BY deptno;

-- <<ROLLUP>>
/*
 * 소그룹간의 합계를 계산하는 기능
 * GROUP BY절로 묶인 각각의 소그룹 합계와 전체 합계 모두를 구하는 기능
 * 보고서를 직성할 때 집합에서 통계 및 요약정보를 추출하는데 사용
 
 * GROUPING을 여러 단계로 했을 때 유용함
*/

SELECT deptno, COUNT(*), SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

-- 통계적인 내용을 알기 힘듦
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno, job;   

-- 통계적 내용 보기 쉬움
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);   --순서 따라 결과 다름




-- <<JOIN>> -------
SELECT * FROM emp;
SELECT * FROM dept;

-- 1) CARTESIAN PRODUCT(join 조건을 안줬기 때문)
-- 14*4 = 56라인 출력됨. 
-- but 14라인 출력하고싶음
SELECT * FROM emp, dept; 

-- 2) 조인조건을 지정
-- EQUI JOIN
SELECT * FROM emp, dept
WHERE emp.deptno=dept.deptno; --컬럼명을 직접 명시. 불필요한 컬럼명이 노출되지 않도록

-- 3) 조인조건을 지정 + 컬럼명을 구체적으로 명시
/*
SELECT empno, ename, deptno, dname, loc  -- ERROR. deptno가 어떤 table 것인지 애매함
FROM emp, dept
WHERE emp.deptno=dept.deptno;    
-- -> SELECT에 컬럼명을 명시하게 되면 모든 컬럼에 대해 FROM의 모든 table을 탐색함 --> 성능 최악 
-- -> 그러므로 SELECT에 컬럼 적을 때 table도 명시해야 함
*/

-- 4) 조인조건을 지정 + 컬럼명을 구체적으로 명시 + 컬럼명 앞에 테이블을 지정
SELECT emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc 
FROM emp, dept
WHERE emp.deptno=dept.deptno;    

-- 5) 조인조건을 지정 + 컬럼명을 구체적으로 명시 + 컬럼명 앞에 테이블을 지정 + 테이블 Alias(간단하게)
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE e.deptno=d.deptno;   


-- 사원이름, 급여, 부서번호, 부서위치 출력. 단, 급여가 2000달러 이상이고 30번 부서에 한해서만 출력
SELECT e.ename, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno AND sal>=2000 AND e.deptno=30;



-- NON-EQUI JOIN
SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM salgrade s, emp e
WHERE e.sal >= s.losal AND e.sal<=s.hisal;



-- >> OUTER JOIN
-- A, B테이블을 JOIN할 경우 조건에 맞지 않는 데이터도 표시하고 싶을 때 사용.
-- 따로 명시하지 않으면 INNER JOIN(공통적인 컬럼만 표시)
SELECT e.ename, e.deptno "부서번호1", d.deptno "부서번호2", d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno;
--/////////////////////////////////////////
-- 아래 둘다 결과는 같음
--1) --> 더 간단해서 많이 쓰임
SELECT e.ename, e.deptno "부서번호1", d.deptno "부서번호2", d.dname
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;     -- '+'는 데이터가 부족한 쪽에 붙여야 함

--2)
--RIGHT JOIN
SELECT e.ename, e.deptno "부서번호1", d.deptno "부서번호2", d.dname
FROM emp e RIGHT OUTER JOIN dept d  -- LEFT/RIGHT OUTER JOIN은 데이터가 많은 쪽에 사용
ON e.deptno=d.deptno;               -- 'ON' 사용

--emp테이블과 dept테이블에서 dept 테이블에 있는 모든 자료를 
    -- 사원번호, 이름, 업무, emp테이블의 부서번호, dept 테이블의 부서번호, 부서명을 출력하라.
SELECT e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- 급여를 2000보다 많이 받는 사원들의 이름, 급여, 부서번호, 부서명 조회 결과에는 모든 부서 테이블 기준 outer조인한다
SELECT e.ename, e.sal, e.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno AND e.sal>2000;

-- 아래 결과 확인(중요함)
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND e.sal(+) > 2000;


-- LEFT JOIN
-- 원하는 결과 안나옴
SELECT (e.ename||'의 매니저는 '||m.ename||'입니다.')INFO
FROM emp e, emp m       -- 하나의 table을 2개로 쪼갠다.
WHERE e.mgr=m.empno;    

SELECT (e.ename||'의 매니저는 '||m.ename||'입니다.') INFO
FROM emp e, emp m       
WHERE e.mgr=m.empno(+);

SELECT (e.ename||'의 매니저는 '||m.ename||'입니다.') INFO
FROM emp e LEFT OUTER JOIN emp m       
ON e.mgr=m.empno;



-- FULL OUTER JOIN
-- 두 테이블 모두 한가지씩 이상의 부족한 데이터를 가지고 있는 경우
CREATE TABLE outera (sawonid number(3));   -- 50이 없음
CREATE TABLE outerb (sawonid number(3));   -- 40이 없음

INSERT INTO outera VALUES(10);
INSERT INTO outera VALUES(20);
INSERT INTO outera VALUES(30);
INSERT INTO outera VALUES(40);

INSERT INTO outerb VALUES(10);
INSERT INTO outerb VALUES(20);
INSERT INTO outerb VALUES(30);
INSERT INTO outera VALUES(50);

SELECT sawonid FROM outera FULL OUTER JOIN outerb USING(sawonid);


-- SELF JOIN
/*
1. 특정사원의 상사 이름을 검색
2. 먼저 특정사원을 EMP 테이블에서 검색...BLAKE
3. BLAKE에 대한 상사번호를 검색..7839
-----------------------
4. 7839에 해당하는 사원번호를 검색
5. 해당 사원번호의 이름을 검색
*/
SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m
WHERE e.mgr=m.empno;

SELECT e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr=m.empno
AND e.ename='BLAKE';










