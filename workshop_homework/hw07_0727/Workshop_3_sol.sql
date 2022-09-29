--#################### 단일행 함수 실습 ###################
-- 1) 이름이 'adam' 인 직원의 급여와 입사일을 조회하시오.
select ename, sal, hiredate
from  emp 
where ename = 'ADAMS'
order by ename;

select ename, sal, hiredate
from  emp 
where lower(ename) = 'adams'
order by ename ;

-- 2) 'Adam의 입사일은 95/11/02 이고, 급여는 3000 입니다.' 이런 식으로 직원
       정보를 조회하시오.
select  ename||'의 입사일은 '|| hiredate ||' 이고, 급여는 '|| sal  || ' 입니다.'
from emp; 

-- 3) 이름이 5글자 이하인 직원들의 이름, 급여, 입사일을 조회하시오.
select ename, sal, hiredate
from emp
where length(ename) <= 5;


-- 4) 1987 년도에 입사한 직원의 이름, 입사일을 조회하시오.
SELECT ENAME, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE,'YY') = '87';

select ename, sal, to_date(hiredate,'RR/MM/DD') "입사일"
from emp
where to_char(to_date(hiredate,'RR/MM/DD'),'yyyy')='1987';

-- 5) 7년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무년차를 조회하시오.
SELECT ename, hiredate, sal, TRUNC(TRUNC(sysdate-TO_DATE(hiredate))/365) 근무년차
FROM emp
WHERE TRUNC(TRUNC(sysdate-TO_DATE(hiredate))/365) > 7;


select ename, hiredate, sal, trunc(months_between(sysdate,to_date(hiredate,'RR-MM-DD')) /12) "근무년차"
from emp
where trunc(months_between(sysdate,to_date(hiredate,'RR-MM-DD')) /12)>=7;



-- ##################  그룹 함수 실습 ######################
-- 1)  30번 부서 월급의 평균(소수2자리 아래 올림), 최고, 최저, 인원수를 구하여 출력하라.
SELECT TRUNC(AVG(sal),1), MAX(sal), MIN(sal), COUNT(-1)
FROM emp
WHERE deptno = 30
GROUP BY deptno;

-- 2) 각 부서별 급여의 평균(소수이하 반올림), 최고, 최저, 인원수를 구하여 출력하라.
SELECT deptno, ROUND(AVG(sal)), MAX(sal), MIN(sal), COUNT(-1)
FROM emp
GROUP BY deptno;


-- 3) 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 출력하라.
select deptno, job, count(*)
from emp
group by deptno, job 
order by deptno;

SELECT deptno, job, COUNT(-1)
FROM emp
GROUP BY deptno, job
order by deptno;

-- 4) 같은 업무를 하는 사람의 수가 2명 이상인 업무와 인원수를  출력하라.
select job, count(*)
from emp
group by job
having count(*)>=2;


-- 5) 각 부서별 평균 월급(소수이하 버림), 전체 월급, 최고 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하라. 
select trunc(avg(sal)) 평균, sum(sal), max(sal), min(sal)
from emp
group by deptno
order by "평균 월급" desc;


-- 6) 각 부서별 같은 업무를 하는 사람의 급여의 합계를 구하여 부서번호,업무명, 급여합계를 출력하라.
-- 단, 부서별 급여합계도 같이 출력하라.

select deptno, job, sum(sal)
from emp
group by rollup(deptno, job)
order by deptno;


-- 7) 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
select deptno , count(*) 
from  emp 
group by deptno
having count(*) >= 5;

-- 8)  각 부서별 최대급여와 최소급여를 조회하시오.
   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 
   조회결과에서 제외시킨다.
select deptno ,max(sal), min(sal), count(*)
from  emp
group by deptno
having max(sal) <> min(sal);


--10) 부서가 10, 20, 30 번인 직원들 중에서 급여를 2500 이상 5000 이하를 받는
   직원들을 대상으로 부서별 평균 급여를 조회하시오.
   다, 평균급여가 2000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
   부서먼저 출력되도록 해야 한다.
 select deptno, avg(nvl(sal,0)) "평균 급여"
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having  avg(nvl(sal,0))>= 2000 
 order by 2 desc  ;

 select deptno, avg(nvl(sal,0)) "평균 급여"
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having  avg(nvl(sal,0))>= 2000 
 order by "평균 급여" desc  ;