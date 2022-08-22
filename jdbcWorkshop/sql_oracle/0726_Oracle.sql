--0726
-- >> 단일행 함수

--문자함수 substr()
-- emp테이블에서 업무 중에서 SALESMAN 업무를 SALES만 출력되도록 문자열 추출
SELECT DISTINCT substr('SALESMAN', 1, 5)
FROM emp;

-- emp테이블에서 부서번호가 10번 부서인 사원의 입사일 중 월만 추출해서 출력
-- 사원이름, 업무, 부서번호, "입사한 월"
SELECT ename, job, deptno, SUBSTR(hiredate, 4, 2) "입사한 월"
FROM emp;
WHERE deptno=10;

-- SUBSTR 3번째 인자 없으면 끝까지 출력됨
-- 테이블이 필요 없을 때 'dual' 사용하면 됨.(FROM 생략하면 안됨)
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

-- 뒤쪽의 문자열을 추출할 때 유용함
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual; -- 'or' 출력됨
SELECT SUBSTR('HelloWorld', -1, 1) FROM dual;




-- LOWER(), INITCAP()
SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename)='scott';

-- emp테이블에서 blake라는 사람의 사원번호, 부서번호, 이름을 출력
--- 이때 첫번째 글자가 대문자가 출력되도록
SELECT empno, deptno, INITCAP(ename)
FROM emp
WHERE ename=UPPER('blake');

-- INSTR()
-- INSTR ( [문자열], [찾을 문자 값], [찾기를 시작할 위치(1,-1)], [찾은 결과의 순번(1...n)] )
-- https://gent.tistory.com/22
-- 사원의 이름 마지막 6번째 철자가 'R'인 사원의 이름을 검색
SELECT ename FROM emp
WHERE INSTR(ename, 'R')=6;  -- INSTR은 특정 글자의 INDEX를 리턴

-- !!! 시험나옴 !!!
-- emp테이블에서 사원의 이름이 'S'로 끝나는 사원의 이름, 업무, 입사일을 출력
-- SUBSTR(), INSTR(), LIKE 3가지 방법 모두 이용해서 작성
SELECT ename, job, hiredate
FROM emp
WHERE SUBSTR(ename, -1, 1)='S';

SELECT ename, job, hiredate
FROM emp
WHERE INSTR(ename, 'S', -1, 1)=length(ename);   --결과값으로 음수 지원 안하는듯

SELECT ename, job, hiredate
FROM emp
WHERE ename LIKE '%S';


--concat()
SELECT empno, ename, job, CONCAT(empno, ename) ename,
CONCAT(ename, empno) e_empno, CONCAT(ename, job) e_job
FROM emp;


--LPAD, RPAD
-- 27000$, 자릿수 조정 등에 사용됨
SELECT LPAD('abc', 6, '*') FROM dual;
SELECT RPAD('abc', 6, '*') FROM dual;



--LTRIM, RTRIM, TRIM
-- 공백 제거 시 많이 사용됨
SELECT LTRIM('aaababaaa', 'a') FROM dual;
SELECT LTRIM('aaababaaa', 'aa') FROM dual;
SELECT RTRIM('aaababaaa', 'a') FROM dual;
--SELECT TRIM('aaababaaa', 'a') FROM dual;    --안됨
SELECT TRIM('a' from 'aaababaaa') FROM dual;

SELECT TRIM('    bab     ') FROM dual;
SELECT TRIM('    ba b     ') FROM dual;     -- 가운데 공백은 제거 안됨

--가운데 공백을 제거하려면 어떻게 해야할까? -> replace 사용한다.
-- REPLACE(문자열, 찾는 문자, 바꿀 문자)
SELECT REPLACE('   ba b    ', ' ', '') FROM dual;



-- 숫자 함수
SELECT ROUND(45.926, 2) FROM dual;  --45.93. 소수 2번째 자리까지 출력(3번째에서 반올림)
SELECT ROUND(45.926) FROM dual; --46. ROUND(45.926, 0)과 동일
SELECT ROUND(45.926, -1) FROM dual; --50
SELECT ROUND(45.926, -2) FROM dual; --0  --> 헷갈림

SELECT TRUNC(45.926, 2) FROM dual; --45.92
SELECT TRUNC(45.926) FROM dual; --45
SELECT TRUNC(45.926, -1) FROM dual; --40


-- 날짜 함수
/*
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 - 날짜 = 기간(숫자)
*/

SELECT sysdate FROM dual;
SELECT sysdate+100 FROM dual;
SELECT sysdate-1 FROM dual;


SELECT ('2022-07-18')-sysdate FROM dual;
SELECT TRUNC(ABS(TO_DATE('2022-07-18', 'YYYY-MM-DD')-sysdate)) FROM dual; --함수 중첩


-- 여러분이 지금까지 살아온 일생을 구하세요
SELECT SYSDATE-TO_DATE('1999-10-17', 'YYYY-MM-DD') FROM dual;

-- emp테이블에서 현재까지의 근무일수가 몇 주 몇 일인지 구하라
SELECT ename, hiredate, sysdate, sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD') "근무 일수", 
    TRUNC((sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD'))/7) WEEK, 
    ROUND(mod(sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD'), 7)) DAYS
FROM emp;

SELECT ename, hiredate, sysdate, sysdate-TO_DATE(hiredate, 'RR-MM-DD') "근무 일수", 
    TRUNC((sysdate-TO_DATE(hiredate, 'RR-MM-DD'))/7) WEEK, 
    ROUND(mod(sysdate-TO_DATE(hiredate, 'RR-MM-DD'), 7)) DAYS
FROM emp;



-- !!!여기부터 나오는 것 중 1문제 시험 나옴!!!!(교재 p69~p77)
-- emp테이블에서 10번 부서원이 현재까지의 근무 월수를 계산하여 조회한다.
SELECT ename, hiredate, sysdate, 
    MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR-MM-DD')) m_between,
    TRUNC(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR-MM-DD'))) t_between
FROM emp
WHERE deptno=10
ORDER BY m_between DESC;

--emp테이블에서 10번 부서원의 입사 일자로부터 5개월이 지난 후 날짜를 계산하여 출력하여라.
SELECT ename, hiredate, sysdate, ADD_MONTHS(hiredate, 5) a_month
FROM emp
WHERE deptno=10
ORDER BY hiredate DESC;

--오늘 날짜가 1년 중 몇번째 주인지 조회한다.(1월1일부터 첫째 일요일까지를 1주차로 한다)
SELECT TO_CHAR(sysdate, 'WW') test
FROM dual;

-- emp테이블에서 20번 부서 중 입사 일자를 '1998년 1월 1일'의 형태로 출력하여라
SELECT ename, hiredate, CONCAT('19', to_char(hiredate, 'YY"년" MM"월" DD"일"')) t_kor
FROM emp
WHERE deptno=20;

-- '201407'이라는 년월을 표시하는 문자값에서 15개월 후의 년을 문자로 표시해본다.
SELECT to_char(ADD_MONTHS(TO_DATE('201407', 'YYYYMM'), 15), 'YYMMDD') test1
FROM dual;

--각 사원들의 이름, 입사일, 입사일로부터 여섯 달 경과 후 첫번째 일요일의 날짜를 
--년도 4자리/월 2자리/일자 형태로 나오도록 조회
SELECT ename, hiredate, 
    TO_CHAR(NEXT_DAY(ADD_MONTHS(TO_DATE(hiredate, 'RR/MM/DD'), 6),1), 'RRRR/MM/DD') "Next 6 MONTHS"
FROM emp;










