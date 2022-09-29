-- 1) emp ���̺� ������ Ȯ���ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp;

-- 2) �μ���ȣ�� 20���� �μ��� ��� �� �����ȣ, �̸�, ������ ����ϼ���.
SELECT empno, ename, sal 
FROM emp 
WHERE deptno=20;


-- 3) �����ȣ�� 7521�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����ϼ���
SELECT ename, hiredate, deptno 
FROM emp 
WHERE empno=7521;


-- 4) �̸��� JONES�� ����� ��� ������ ����ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp 
WHERE ename='JONES';

-- 5) ������ MANAGER�� ����� ��� ������ ����ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp 
WHERE job='MANAGER';

-- 6)������ MANAGER�� �ƴ� ����� ��� ������ ����ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp 
WHERE job<>'MANAGER';

-- 7) �޿��� $1000 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����ϼ���
SELECT ename, sal, deptno
FROM emp
WHERE sal>=1000;

-- 8) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����ϼ���.
SELECT ename, job, sal
FROM emp
WHERE sal>1600 AND sal<3000;

-- 9) �Ի����� 80�⵵�� ����� ��� ������ ����ϼ���
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE hiredate LIKE '80%';

-- 10) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE TO_DATE(hiredate, 'YY/MM/DD') < TO_DATE('811209', 'YY/MM/DD');

-- 11) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �޿��� ����ϼ���.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename LIKE 'S%';


-- 12) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE ename LIKE '%S%';

-- 13) Ŀ�̼��� NULL�� ����� ������ ����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE comm IS NULL;

-- 14) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE comm IS NOT NULL;

--15) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����ϼ���.
SELECT ename, job, sal
FROM emp
WHERE deptno=30 AND sal>=1500;

-- 16) �μ���ȣ�� 30�� ��� �� �����ȣ ������ �����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE deptno=30
ORDER BY empno;

-- 17) �޿��� ���� ������ �����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY sal desc;

-- 18) �μ���ȣ�� ASCENDING ������ �� �޿��� ���� ��� ������  ����ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
ORDER BY deptno, sal DESC;

-- 19) emp Table���� �̸�, �޿�, Ŀ�̼� �ݾ�(sal*comm/100), �Ѿ�(sal + comm)��  ���Ͽ� �Ѿ��� ���� ������ ����ϼ���. 
-- ��, Ŀ�̼��� NULL�� ����� �����Ѵ�.
SELECT ename, sal, sal*comm/100 "Ŀ�̼� �ݾ�", sal+comm �Ѿ�  
FROM emp
WHERE comm IS NOT NULL
ORDER BY �Ѿ� DESC;

-- 20)  10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� ����ϼ���.
SELECT ename, sal, sal*1.13 "���ʽ� �ݾ�", deptno  
FROM emp
WHERE deptno=10;

