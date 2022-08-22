--<<�׷��Լ�>>
-- null���� �ǳʶٰ� ������ �����Ѵ�.

SELECT COUNT(*) FROM emp;
SELECT COUNT(-1) FROM emp;
SELECT COUNT(MGR) FROM emp;     --14
SELECT COUNT(COMM) FROM emp;    

-- emp ���̺��� �μ������� ������ �˻�..COUNT()
SELECT COUNT(deptno) FROM emp;
SELECT COUNT(ALL(deptno)) FROM emp;
SELECT COUNT(DISTINCT(deptno)) FROM emp;  -- �ߺ�����. ��������

SELECT MIN(ename), MAX(ename), MIN(hiredate), MAX(hiredate)
FROM emp;


SELECT AVG(sal), MAX(sal), MIN(sal), SUM(sal)
FROM emp
WHERE job='SALESMAN';


--emp ���̺��� �� �ο�, ���ʽ� �޴� �ο����� �˻�
SELECT COUNT(*) ���ο�, COUNT(comm) ���ʽ��޴��ο�, AVG(comm) ���ʽ����1
FROM emp;   -- null�� �����ϱ� ������ 4�� ����

SELECT COUNT(*) ���ο�, COUNT(comm) ���ʽ��޴��ο�, ROUND(AVG(NVL(comm,0))) ���ʽ����2
FROM emp;  

SELECT COUNT(*) ���ο�, COUNT(comm) ���ʽ��޴��ο�,  AVG(comm) ���ʽ����1, ROUND(AVG(NVL(comm,0))) ���ʽ����2
FROM emp;  


SELECT comm FROM emp;

--GROUP BY�� :: �׷��� ����ȭ ��Ű�� ���
--SELECT������ �׷��Լ��� ������� ���� �÷��� �ݵ�� GROUP BY�� �ڿ� ��õǾ�� �Ѵ�.

-- �߸���. AVG�� ��ü �׷��� ������������� dept�� GROUPING�� �ȵ���
--SELECT deptno, AVG(sal) FROM emp; 

-- 1)������ �׷��� �ϳ�
SELECT ROUND(AVG(sal)) FROM emp;

-- 2)������ ���׷�. -> �׷��� ����ȭ. ���⼭ �� ����ȭ�� ������
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

-- 3) ����
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
ORDER BY 1;     -- SELECT���� ù��° �� �������� ����

-- 4) Alias
/*
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY DName
ORDER BY DName;     --Error. GROUP BY�� �ڿ� Alias ����ϸ� �ȵ�!!
*/

-- 5) Alias :: ORDER BY�� �ڿ��� Alias ����ϴ� �� �� ����
SELECT deptno DName, ROUND(AVG(sal)) AvgSalary
FROM emp
GROUP BY deptno
ORDER BY AvgSalary;   


-- �� �μ����� �ο���, �޿��� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� �޿��� ���� ���� ������� ���
SELECT COUNT(*), AVG(sal), MIN(sal), MAX(sal), SUM(sal) �޿�����
FROM emp
GROUP BY deptno
ORDER BY �޿����� DESC;

-- �������� ����, �ο���, �޿��� ���, �޿��� ���� ��ȸ�Ѵ�.
SELECT job, COUNT(*), AVG(sal), SUM(sal)
FROM emp
GROUP BY job;

-- ������ �μ��������� �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ��ȸ�Ѵ�.
SELECT deptno, job, COUNT(*), AVG(sal), SUM(sal)
FROM emp
GROUP BY job, deptno;

-- emp���̺��� �� �μ��� ��ձ޿��� ���ϴµ� ���߿��� ��ձ޿��� 2000�޷� �̻��� ����� ��ձ޿��� �˻�..
-- ERROR. WHERE�������� �׷��Լ� ����� �� ����.
-- �������: FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY
/*
SELECT dept, AVG(sal) ��ձ޿�
FROM emp
WHERE AVG(sal) >= 2000
GROUP BY deptno;
*/

SELECT deptno, AVG(sal) ��ձ޿�
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;


-- >> HAVING
-- �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ��ȸ
SELECT deptno, COUNT(*), SUM(sal)
FROM emp
GROUP BY deptno
HAVING COUNT(*)>4;

--emp���̺��� �޿��� �ִ� 2900 �̻��� �μ��� ���ؼ� �μ���ȣ, ��ձ޿�, �޿��� ���� ��ȸ�Ѵ�.
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


-- �μ� �޿� �հ� �� �ִ밪�� ��ȸ�Ѵ�.
SELECT MAX(SUM(sal))
FROM emp
GROUP BY deptno;


-- �Ի�⵵�� �ο����� ���...�Ի�⵵, �ο����� ��Ī ����
SELECT SUBSTR(hiredate,1,2) �Ի�⵵, COUNT(*) �ο���
FROM emp
GROUP BY SUBSTR(hiredate, 1, 2);

-- 20�� �μ����� ���� ���� �Ի��� ����� �˻�
SELECT MIN(hiredate)
FROM emp
GROUP BY deptno
HAVING deptno=20;

SELECT *
FROM emp
GROUP BY deptno;

-- <<ROLLUP>>
/*
 * �ұ׷찣�� �հ踦 ����ϴ� ���
 * GROUP BY���� ���� ������ �ұ׷� �հ�� ��ü �հ� ��θ� ���ϴ� ���
 * ������ ������ �� ���տ��� ��� �� ��������� �����ϴµ� ���
 
 * GROUPING�� ���� �ܰ�� ���� �� ������
*/

SELECT deptno, COUNT(*), SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

-- ������� ������ �˱� ����
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno, job;   

-- ����� ���� ���� ����
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);   --���� ���� ��� �ٸ�




-- <<JOIN>> -------
SELECT * FROM emp;
SELECT * FROM dept;

-- 1) CARTESIAN PRODUCT(join ������ ����� ����)
-- 14*4 = 56���� ��µ�. 
-- but 14���� ����ϰ����
SELECT * FROM emp, dept; 

-- 2) ���������� ����
-- EQUI JOIN
SELECT * FROM emp, dept
WHERE emp.deptno=dept.deptno; --�÷����� ���� ���. ���ʿ��� �÷����� ������� �ʵ���

-- 3) ���������� ���� + �÷����� ��ü������ ���
/*
SELECT empno, ename, deptno, dname, loc  -- ERROR. deptno�� � table ������ �ָ���
FROM emp, dept
WHERE emp.deptno=dept.deptno;    
-- -> SELECT�� �÷����� ����ϰ� �Ǹ� ��� �÷��� ���� FROM�� ��� table�� Ž���� --> ���� �־� 
-- -> �׷��Ƿ� SELECT�� �÷� ���� �� table�� ����ؾ� ��
*/

-- 4) ���������� ���� + �÷����� ��ü������ ��� + �÷��� �տ� ���̺��� ����
SELECT emp.empno, emp.ename, emp.deptno, dept.dname, dept.loc 
FROM emp, dept
WHERE emp.deptno=dept.deptno;    

-- 5) ���������� ���� + �÷����� ��ü������ ��� + �÷��� �տ� ���̺��� ���� + ���̺� Alias(�����ϰ�)
SELECT e.empno, e.ename, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE e.deptno=d.deptno;   


-- ����̸�, �޿�, �μ���ȣ, �μ���ġ ���. ��, �޿��� 2000�޷� �̻��̰� 30�� �μ��� ���ؼ��� ���
SELECT e.ename, e.sal, e.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno AND sal>=2000 AND e.deptno=30;



-- NON-EQUI JOIN
SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM salgrade s, emp e
WHERE e.sal >= s.losal AND e.sal<=s.hisal;



-- >> OUTER JOIN
-- A, B���̺��� JOIN�� ��� ���ǿ� ���� �ʴ� �����͵� ǥ���ϰ� ���� �� ���.
-- ���� ������� ������ INNER JOIN(�������� �÷��� ǥ��)
SELECT e.ename, e.deptno "�μ���ȣ1", d.deptno "�μ���ȣ2", d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno;
--/////////////////////////////////////////
-- �Ʒ� �Ѵ� ����� ����
--1) --> �� �����ؼ� ���� ����
SELECT e.ename, e.deptno "�μ���ȣ1", d.deptno "�μ���ȣ2", d.dname
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;     -- '+'�� �����Ͱ� ������ �ʿ� �ٿ��� ��

--2)
--RIGHT JOIN
SELECT e.ename, e.deptno "�μ���ȣ1", d.deptno "�μ���ȣ2", d.dname
FROM emp e RIGHT OUTER JOIN dept d  -- LEFT/RIGHT OUTER JOIN�� �����Ͱ� ���� �ʿ� ���
ON e.deptno=d.deptno;               -- 'ON' ���

--emp���̺�� dept���̺��� dept ���̺� �ִ� ��� �ڷḦ 
    -- �����ȣ, �̸�, ����, emp���̺��� �μ���ȣ, dept ���̺��� �μ���ȣ, �μ����� ����϶�.
SELECT e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- �޿��� 2000���� ���� �޴� ������� �̸�, �޿�, �μ���ȣ, �μ��� ��ȸ ������� ��� �μ� ���̺� ���� outer�����Ѵ�
SELECT e.ename, e.sal, e.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno AND e.sal>2000;

-- �Ʒ� ��� Ȯ��(�߿���)
SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND e.sal(+) > 2000;


-- LEFT JOIN
-- ���ϴ� ��� �ȳ���
SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�.')INFO
FROM emp e, emp m       -- �ϳ��� table�� 2���� �ɰ���.
WHERE e.mgr=m.empno;    

SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�.') INFO
FROM emp e, emp m       
WHERE e.mgr=m.empno(+);

SELECT (e.ename||'�� �Ŵ����� '||m.ename||'�Դϴ�.') INFO
FROM emp e LEFT OUTER JOIN emp m       
ON e.mgr=m.empno;



-- FULL OUTER JOIN
-- �� ���̺� ��� �Ѱ����� �̻��� ������ �����͸� ������ �ִ� ���
CREATE TABLE outera (sawonid number(3));   -- 50�� ����
CREATE TABLE outerb (sawonid number(3));   -- 40�� ����

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
1. Ư������� ��� �̸��� �˻�
2. ���� Ư������� EMP ���̺��� �˻�...BLAKE
3. BLAKE�� ���� ����ȣ�� �˻�..7839
-----------------------
4. 7839�� �ش��ϴ� �����ȣ�� �˻�
5. �ش� �����ȣ�� �̸��� �˻�
*/
SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m
WHERE e.mgr=m.empno;

SELECT e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr=m.empno
AND e.ename='BLAKE';










