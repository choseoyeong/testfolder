-- ##################  ���ڿ� �Լ� �ǽ� ######################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.
SELECT * 
FROM emp
WHERE UPPER(ename) LIKE '%S%';

-- 2) ��� �������� �̸��� ù���ڸ� �빮�ڷ� �����Ͽ� ����϶�.
SELECT INITCAP(ename)
FROM emp;

-- 3) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,1,3), sal
FROM emp;

-- 4) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT LOWER(SUBSTR(ename,1,3))
FROM emp
WHERE LENGTH(ename)>=6;

-- 5) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.
SELECT ename, LPAD(sal, 6, '*')
FROM emp;

-- 6) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.
insert into emp values(8001,'   PARK   ', 'IT' ,  7900 , '21/11/10', 20000,1000,10);
select * from emp;
-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT *
FROM emp
WHERE ename='PARK';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT *
FROM emp
WHERE TRIM(ename)='PARK';


-- ##################  ���� �Լ� �ǽ� ######################
-- 1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(sal*0.15, 2) ȸ��
FROM emp
WHERE sal BETWEEN 1500 AND 3000;
 

-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ����� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
SELECT ename, sal, FLOOR(sal*0.05) ������
FROM emp
WHERE sal>=2000;
  

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)
SELECT empno, ename, sal, CEIL(comm*1.5) BONUS
FROM emp
WHERE comm IS NOT NULL AND comm<>0;


-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
SELECT ename, hiredate, hiredate+100 "100�� ���� ��", sal
FROM emp;

-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate, ADD_MONTHS(hiredate, 6) "6���� ���� ��¥", sal
FROM emp;


-- 3) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
-- select ename, hiredate, trunc(sysdate-hiredate) �ٹ��ϼ� from emp;

SELECT ename, hiredate, CEIL(sysdate-TO_DATE(hiredate, 'RR/MM/DD')) �ٹ��ϼ�
FROM emp;

-- 4) ������ �̸�, �ټӳ���� ���Ͽ� ����϶�.
SELECT ename, CEIL(MONTHS_BETWEEN(SYSDATE,TO_DATE(hiredate, 'RR/MM/DD'))/12) �ټӳ��
FROM emp;


-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 1) ��� ������ �̸��� �Ի����� ��1996-5-14���� ���·� ��� �϶�.
SELECT ename, CONCAT(CONCAT(TO_CHAR(hiredate, 'YYYY-'), LTRIM(TO_CHAR(HIREDATE, 'MM'), '0')),
                    TO_CHAR(HIREDATE, '-DD')) �Ի���
FROM emp;

-- 2) ��� ������ �̸��� �Ի��� ������ ����϶�.
-- select ename, to_char(hiredate,'DAY') �Ի���� from emp;
SELECT ename, TO_CHAR(hiredate, 'DAY') �Ի����
FROM emp;


-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- 1)  ��� ������ �̸�, �޿�, Ŀ�̼��� ����϶�. ��, comm�� null�̸� 0���� ����϶�.
SELECT ename, sal, NVL(comm, 0)
FROM emp;



