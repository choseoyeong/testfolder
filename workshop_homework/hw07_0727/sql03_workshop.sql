--#################### ������ �Լ� �ǽ� ###################
-- 1) �̸��� 'adams' �� ������ �޿��� �Ի����� ��ȸ�Ͻÿ�.
SELECT sal, hiredate
FROM emp
WHERE LOWER(ename)='adams';


-- 2) 'Adams�� �Ի����� 95/11/02 �̰�, �޿��� 3000 �Դϴ�.' �̷� ������ ���������� ��ȸ�Ͻÿ�.
SELECT ('�Ի����� ' || hiredate || '�̰�, �޿��� ' || sal || ' �Դϴ�.') ��������
FROM emp
WHERE LOWER(ename)='adams';


-- 3) �̸��� 5���� ������ �������� �̸�, �޿�, �Ի����� ��ȸ�Ͻÿ�.
SELECT ename, sal, hiredate
FROM emp
WHERE LENGTH(ename)<=5;


-- 4) 1987 �⵵�� �Ի��� ������ �̸�, �Ի����� ��ȸ�Ͻÿ�.
SELECT ename, hiredate
FROM emp
WHERE SUBSTR(hiredate,1,2)='87';

-- 5) 7�� �̻� ��� �ټ��� �������� �̸�, �Ի���, �޿�, �ٹ������� ��ȸ�Ͻÿ�.
SELECT ename, hiredate, sal, 
    ROUND(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR/MM/DD'))/12) �ٹ�����
FROM emp
WHERE ROUND(MONTHS_BETWEEN(sysdate, TO_DATE(hiredate, 'RR/MM/DD'))/12)>=7;


-- ##################  �׷� �Լ� �ǽ� ######################
-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ����� ����, �Ҽ��� ���ڸ��� ǥ��), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT TRUNC(AVG(sal), 1) �������, MAX(sal), MIN(sal), COUNT(*)�ο���
FROM emp
GROUP BY deptno
HAVING deptno=30;

-- 2) �� �μ��� �޿��� ���(�ݿø�, �����κи� ǥ��ǵ���), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT ROUND(AVG(sal),0) �޿����, MAX(sal), MIN(sal), COUNT(*) �ο���
FROM emp
GROUP BY deptno;


-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno, job, COUNT(*) �ο���
FROM emp
GROUP BY deptno, job;

-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT job, COUNT(*) �ο���
FROM emp
GROUP BY job
HAVING COUNT(*)>=2;


-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT FLOOR(AVG(sal)) ��տ���, SUM(sal) ��ü����, MAX(sal) �ְ����, MIN(sal) ��������
FROM emp
GROUP BY deptno
ORDER BY ��տ��� DESC;


-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������, �޿��հ踦 ����϶�.
-- ��, �μ��� �޿��հ赵 ���� ����϶�.
SELECT deptno, job, SUM(sal) �޿��հ�
FROM emp
GROUP BY ROLLUP(deptno, job);


-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno, COUNT(*) 
FROM emp 
GROUP BY deptno
HAVING COUNT(*) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧���� 
--   ��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)<>MIN(sal);


--10) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
--   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
--   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
--   �μ����� ��µǵ��� �ؾ� �Ѵ�.
SELECT deptno, AVG(sal) ��ձ޿�
FROM (SELECT *
    FROM emp
    WHERE deptno in (10,20,30) AND sal >= 2500 AND sal <=5000)
GROUP BY deptno
HAVING AVG(sal) >= 2000 
ORDER BY ��ձ޿� DESC;


