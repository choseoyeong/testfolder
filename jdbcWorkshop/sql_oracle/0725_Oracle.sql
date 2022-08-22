SELECT * FROM emp;
-- <�񱳿����� page 34> ------------------------------
/*
emp ���̺��� sal�� 2500~3500 ���̿� ����ִ� ����� �̸��� sal�� �˻�
*/
SELECT ename, sal FROM emp WHERE sal>=2500 AND sal<=3500;
-- BETWEEN�� lower AND higher ��
SELECT ename, sal FROM emp WHERE BETWEEN 2500 AND 3500; -- O
SELECT ename, sal FROM emp WHERE BETWEEN 3500 AND 2500; -- X

--<IN ������> ------------------------------
/*
emp ���̺��� �����ȣ�� 7369�̰ų� 7521�̰ų� 7782�� ����� �˻�
*/
--1 STEP //���� �־� -> �ϳ��ϳ� DB�� ACCESS
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;
--2 STEP
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7782;
--3 STEP
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

/*
emp ���̺��� �����ȣ�� 7369�� �ƴϰ� 7521�� �ƴϰ� 7782�� �ƴ� ����� �˻�
*/
--2 STEP
SELECT * FROM emp WHERE empno!=7369 AND empno<>7521 AND empno!=7782;
--3 STEP
SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

--<���ϵ�ī��� like ������> ------------------------------
-- like ������: Ư���� �ܾ ���Ե� �����͸� �˻��� �� ���
-- ���ϵ�ī��: %(�ϳ� �̻��� ����), _(�� ����)
/*
emp ���̺��� �̸��� S�� ���۵Ǵ� ����� �˻��ϰ� JOB�� ����ض�
*/
SELECT ename, job FROM emp WHERE ename LIKE 'S%';

/*
emp ���̺��� �̸��� S�� ���Ե� ����� �˻��ϰ� JOB�� ����ض�
*/
SELECT ename, job FROM emp WHERE ename LIKE '%S%';

/*
emp ���̺��� �̸� �� 2��° ���ĺ��� M�� ����� �˻��ϰ� JOB�� ����ض�
*/
SELECT ename, job FROM emp WHERE ename LIKE '_M%';

/*
emp ���̺��� �Ի�⵵�� 80�⵵�� ����� �˻�
*/
SELECT ename, job, hiredate FROM emp WHERE hiredate LIKE '81%';










