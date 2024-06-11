
DROP TABLE board_tbl purge;
DROP SEQUENCE board_seq;
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
VALUES (board_seq.nextval, 'JSP ȥ��', '������ ����', 'user01');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, '�����̴�', '�����̴�', 'user00');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'Servlet', '��������', 'user08');
commit;
select *
from board_tbl
order by 1;