package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.StudentService;
import co.yedam.service.StudentServiceImpl;
import co.yedam.vo.Student;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student student = new Student();
		student.setStdNo(req.getParameter("sno"));
		student.setStdName(req.getParameter("sname"));
		student.setPhone(req.getParameter("phone"));
		student.setBldType(req.getParameter("btype"));
		
		StudentService svc = new StudentServiceImpl();
		
		if(svc.addStudent(student)) {
			System.out.println("정상등록..");
			resp.sendRedirect("main.do");
		}else {
			System.out.println("등록실패!");
			req.setAttribute("message", "처리중 오류가 발생하였습니다.");
			req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		}
	}// exec()

}
