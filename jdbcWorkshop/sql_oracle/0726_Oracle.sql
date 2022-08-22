--0726
-- >> ������ �Լ�

--�����Լ� substr()
-- emp���̺��� ���� �߿��� SALESMAN ������ SALES�� ��µǵ��� ���ڿ� ����
SELECT DISTINCT substr('SALESMAN', 1, 5)
FROM emp;

-- emp���̺��� �μ���ȣ�� 10�� �μ��� ����� �Ի��� �� ���� �����ؼ� ���
-- ����̸�, ����, �μ���ȣ, "�Ի��� ��"
SELECT ename, job, deptno, SUBSTR(hiredate, 4, 2) "�Ի��� ��"
FROM emp;
WHERE deptno=10;

-- SUBSTR 3��° ���� ������ ������ ��µ�
-- ���̺��� �ʿ� ���� �� 'dual' ����ϸ� ��.(FROM �����ϸ� �ȵ�)
SELECT SUBSTR('HelloWorld', 6) FROM dual;
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

-- ������ ���ڿ��� ������ �� ������
SELECT SUBSTR('HelloWorld', -4, 2) FROM dual; -- 'or' ��µ�
SELECT SUBSTR('HelloWorld', -1, 1) FROM dual;




-- LOWER(), INITCAP()
SELECT empno, ename, deptno
FROM emp
WHERE LOWER(ename)='scott';

-- emp���̺��� blake��� ����� �����ȣ, �μ���ȣ, �̸��� ���
--- �̶� ù��° ���ڰ� �빮�ڰ� ��µǵ���
SELECT empno, deptno, INITCAP(ename)
FROM emp
WHERE ename=UPPER('blake');

-- INSTR()
-- INSTR ( [���ڿ�], [ã�� ���� ��], [ã�⸦ ������ ��ġ(1,-1)], [ã�� ����� ����(1...n)] )
-- https://gent.tistory.com/22
-- ����� �̸� ������ 6��° ö�ڰ� 'R'�� ����� �̸��� �˻�
SELECT ename FROM emp
WHERE INSTR(ename, 'R')=6;  -- INSTR�� Ư�� ������ INDEX�� ����

-- !!! ���質�� !!!
-- emp���̺��� ����� �̸��� 'S'�� ������ ����� �̸�, ����, �Ի����� ���
-- SUBSTR(), INSTR(), LIKE 3���� ��� ��� �̿��ؼ� �ۼ�
SELECT ename, job, hiredate
FROM emp
WHERE SUBSTR(ename, -1, 1)='S';

SELECT ename, job, hiredate
FROM emp
WHERE INSTR(ename, 'S', -1, 1)=length(ename);   --��������� ���� ���� ���ϴµ�

SELECT ename, job, hiredate
FROM emp
WHERE ename LIKE '%S';


--concat()
SELECT empno, ename, job, CONCAT(empno, ename) ename,
CONCAT(ename, empno) e_empno, CONCAT(ename, job) e_job
FROM emp;


--LPAD, RPAD
-- 27000$, �ڸ��� ���� � ����
SELECT LPAD('abc', 6, '*') FROM dual;
SELECT RPAD('abc', 6, '*') FROM dual;



--LTRIM, RTRIM, TRIM
-- ���� ���� �� ���� ����
SELECT LTRIM('aaababaaa', 'a') FROM dual;
SELECT LTRIM('aaababaaa', 'aa') FROM dual;
SELECT RTRIM('aaababaaa', 'a') FROM dual;
--SELECT TRIM('aaababaaa', 'a') FROM dual;    --�ȵ�
SELECT TRIM('a' from 'aaababaaa') FROM dual;

SELECT TRIM('    bab     ') FROM dual;
SELECT TRIM('    ba b     ') FROM dual;     -- ��� ������ ���� �ȵ�

--��� ������ �����Ϸ��� ��� �ؾ��ұ�? -> replace ����Ѵ�.
-- REPLACE(���ڿ�, ã�� ����, �ٲ� ����)
SELECT REPLACE('   ba b    ', ' ', '') FROM dual;



-- ���� �Լ�
SELECT ROUND(45.926, 2) FROM dual;  --45.93. �Ҽ� 2��° �ڸ����� ���(3��°���� �ݿø�)
SELECT ROUND(45.926) FROM dual; --46. ROUND(45.926, 0)�� ����
SELECT ROUND(45.926, -1) FROM dual; --50
SELECT ROUND(45.926, -2) FROM dual; --0  --> �򰥸�

SELECT TRUNC(45.926, 2) FROM dual; --45.92
SELECT TRUNC(45.926) FROM dual; --45
SELECT TRUNC(45.926, -1) FROM dual; --40


-- ��¥ �Լ�
/*
��¥ + ���� = ��¥
��¥ - ���� = ��¥
��¥ - ��¥ = �Ⱓ(����)
*/

SELECT sysdate FROM dual;
SELECT sysdate+100 FROM dual;
SELECT sysdate-1 FROM dual;


SELECT ('2022-07-18')-sysdate FROM dual;
SELECT TRUNC(ABS(TO_DATE('2022-07-18', 'YYYY-MM-DD')-sysdate)) FROM dual; --�Լ� ��ø


-- �������� ���ݱ��� ��ƿ� �ϻ��� ���ϼ���
SELECT SYSDATE-TO_DATE('1999-10-17', 'YYYY-MM-DD') FROM dual;

-- emp���̺��� ��������� �ٹ��ϼ��� �� �� �� ������ ���϶�
SELECT ename, hiredate, sysdate, sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD') "�ٹ� �ϼ�", 
    TRUNC((sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD'))/7) WEEK, 
    ROUND(mod(sysdate-TO_DATE(CONCAT('19',hiredate), 'YYYY-MM-DD'), 7)) DAYS
FROM emp;

SELECT ename, hiredate, sysdate, sysdate-TO_DATE(hiredate, 'RR-MM-DD') "�ٹ� �ϼ�", 
    TRUNC((sysdate-TO_DATE(hiredate, 'RR-MM-DD'))/7) WEEK, 
    ROUND(mod(sysdate-TO_DATE(hiredate, 'RR-MM-DD'), 7)) DAYS
FROM emp;



-- !!!������� ������ �� �� 1���� ���� ����!!!!(���� p69~p77)
-- emp���̺��� 10�� �μ����� ��������� �ٹ� ������ ����Ͽ� ��ȸ�Ѵ�.
SELECT ename, hiredate, sysdate, 
    MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR-MM-DD')) m_between,
    TRUNC(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR-MM-DD'))) t_between
FROM emp
WHERE deptno=10
ORDER BY m_between DESC;

--emp���̺��� 10�� �μ����� �Ի� ���ڷκ��� 5������ ���� �� ��¥�� ����Ͽ� ����Ͽ���.
SELECT ename, hiredate, sysdate, ADD_MONTHS(hiredate, 5) a_month
FROM emp
WHERE deptno=10
ORDER BY hiredate DESC;

--���� ��¥�� 1�� �� ���° ������ ��ȸ�Ѵ�.(1��1�Ϻ��� ù° �Ͽ��ϱ����� 1������ �Ѵ�)
SELECT TO_CHAR(sysdate, 'WW') test
FROM dual;

-- emp���̺��� 20�� �μ� �� �Ի� ���ڸ� '1998�� 1�� 1��'�� ���·� ����Ͽ���
SELECT ename, hiredate, CONCAT('19', to_char(hiredate, 'YY"��" MM"��" DD"��"')) t_kor
FROM emp
WHERE deptno=20;

-- '201407'�̶�� ����� ǥ���ϴ� ���ڰ����� 15���� ���� ���� ���ڷ� ǥ���غ���.
SELECT to_char(ADD_MONTHS(TO_DATE('201407', 'YYYYMM'), 15), 'YYMMDD') test1
FROM dual;

--�� ������� �̸�, �Ի���, �Ի��Ϸκ��� ���� �� ��� �� ù��° �Ͽ����� ��¥�� 
--�⵵ 4�ڸ�/�� 2�ڸ�/���� ���·� �������� ��ȸ
SELECT ename, hiredate, 
    TO_CHAR(NEXT_DAY(ADD_MONTHS(TO_DATE(hiredate, 'RR/MM/DD'), 6),1), 'RRRR/MM/DD') "Next 6 MONTHS"
FROM emp;










