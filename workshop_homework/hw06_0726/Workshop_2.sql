-- ##################  ���ڿ� �Լ� �ǽ� ######################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.


-- 2) ��� �������� �̸��� ù���ڸ� �빮�ڷ� �����Ͽ� ����϶�.



-- 3) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.


-- 4) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.



-- 5) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.



-- 6) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.
insert into emp values(8001,'   PARK   ', 'IT' ,  7900 , '21/11/10', 20000,1000,10);
select * from emp;
-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
 

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
 


-- ##################  ���� �Լ� �ǽ� ######################
-- 1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.

 

-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ����� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.

  

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)



-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.

-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�

-- 3) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
select ename, hiredate, trunc(sysdate-hiredate) �ٹ��ϼ� from emp;

-- 4) ������ �̸�, �ټӳ���� ���Ͽ� ����϶�.



-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 1) ��� ������ �̸��� �Ի����� ��1996-5-14���� ���·� ��� �϶�.


-- 2) ��� ������ �̸��� �Ի��� ������ ����϶�.
select ename, to_char(hiredate,'DAY') �Ի���� from emp;



-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- 1)  ��� ������ �̸�, �޿�, Ŀ�̼��� ����϶�. ��, comm�� null�̸� 0���� ����϶�.



