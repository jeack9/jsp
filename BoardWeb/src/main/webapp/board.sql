
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
VALUES (board_seq.nextval, 'JSP 혼란', '열심히 하자', 'user01');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, '제목이다', '내용이다', 'user00');
INSERT INTO board_tbl (board_no, title, content, writer)
VALUES (board_seq.nextval, 'Servlet', '서블릿내용', 'user08');
commit;
select *
from board_tbl
order by 1;