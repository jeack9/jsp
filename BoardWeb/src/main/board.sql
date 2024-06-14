DROP TABLE board_tbl purge;
DROP SEQUENCE board_seq;
-- ȸ�����̵�/��й�ȣ/�̸�/����
CREATE TABLE member_tbl(
  user_id VARCHAR2(20) PRIMARY KEY,
  user_pw VARCHAR2(20) NOT NULL,
  user_name VARCHAR2(100) NOT NULL,
  responsibility VARCHAR2(10) DEFAULT 'User' -- User/Admin
);
INSERT INTO member_tbl(user_id, user_pw, user_name)
VALUES ('user01', '1111', 'ȫ�浿');
INSERT INTO member_tbl(user_id, user_pw, user_name)
VALUES ('user02', '1111', '��μ�');
INSERT INTO member_tbl(user_id, user_pw, user_name)
VALUES ('user03', '1111', '�ڼ���');
INSERT INTO member_tbl(user_id, user_pw, user_name, responsibility)
VALUES ('user99', '1111', '�ֹμ�', 'Admin');

SELECT *
FROM member_tbl; 

CREATE TABLE board_tbl(
  board_no NUMBER,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(500) NOT NULL,
  writer VARCHAR2(30) NOT NULL,
  click_cnt NUMBER default 0,
  creation_date DATE default SYSDATE
);
CREATE SEQUENCE board_seq;
ALTER TABLE board_tbl add constraint board_pk primary key(board_no);
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'JSP', 'jsp ���', 'user01');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, '��Ʈ��', '��Ʈ�� ��', 'user00');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'Servlet', '���� �߿�', 'user08');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'sql', 'sql �߿�', 'user05');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'javascript', '�ڹٽ�ũ��Ʈ �߿�', 'user05');


INSERT INTO board_tbl (board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from board_tbl;

UPDATE board_tbl
SET title = board_no || '-' ||  title;

commit;

select *
from board_tbl
order by 1;

-- 1�������� 5��
SELECT b.*
FROM(SELECT ROWNUM rn, a.*
     FROM (SELECT *
           FROM board_tbl
           order by board_no) a
     where ROWNUM <= (:page * 5) ) b
WHERE b.rn > (:page - 1) * 5;

-- ������ ����
SELECT count(*)
FROM board_tbl;

-- �˻����
SELECT b.*
FROM(SELECT ROWNUM rn, a.*
     FROM (SELECT *
           FROM board_tbl
           WHERE title like '%a%'
           order by board_no DESC) a
     where ROWNUM <= (:page * 5) ) b
WHERE b.rn > (:page - 1) * 5;

select * 
from member_tbl;