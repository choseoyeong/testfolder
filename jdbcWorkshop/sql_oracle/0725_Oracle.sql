SELECT * FROM emp;
-- <비교연산자 page 34> ------------------------------
/*
emp 테이블에서 sal가 2500~3500 사이에 들어있는 사원의 이름과 sal을 검색
*/
SELECT ename, sal FROM emp WHERE sal>=2500 AND sal<=3500;
-- BETWEEN은 lower AND higher 순
SELECT ename, sal FROM emp WHERE BETWEEN 2500 AND 3500; -- O
SELECT ename, sal FROM emp WHERE BETWEEN 3500 AND 2500; -- X

--<IN 연산자> ------------------------------
/*
emp 테이블에서 사원번호가 7369이거나 7521이거나 7782인 사원을 검색
*/
--1 STEP //성능 최악 -> 하나하나 DB에 ACCESS
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;
--2 STEP
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7782;
--3 STEP
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

/*
emp 테이블에서 사원번호가 7369가 아니고 7521도 아니고 7782도 아닌 사원을 검색
*/
--2 STEP
SELECT * FROM emp WHERE empno!=7369 AND empno<>7521 AND empno!=7782;
--3 STEP
SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

--<와일드카드와 like 연산자> ------------------------------
-- like 연산자: 특정한 단어가 포함된 데이터를 검색할 때 사용
-- 와일드카드: %(하나 이상의 글자), _(한 글자)
/*
emp 테이블에서 이름이 S로 시작되는 사원을 검색하고 JOB도 출력해라
*/
SELECT ename, job FROM emp WHERE ename LIKE 'S%';

/*
emp 테이블에서 이름에 S가 포함된 사원을 검색하고 JOB도 출력해라
*/
SELECT ename, job FROM emp WHERE ename LIKE '%S%';

/*
emp 테이블에서 이름 중 2번째 알파벳이 M인 사원을 검색하고 JOB도 출력해라
*/
SELECT ename, job FROM emp WHERE ename LIKE '_M%';

/*
emp 테이블에서 입사년도가 80년도임 사원을 검색
*/
SELECT ename, job, hiredate FROM emp WHERE hiredate LIKE '81%';










