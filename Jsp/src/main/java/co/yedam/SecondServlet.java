package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 제어의 역전(Inversion Of Control)
// url -> tomcat -> 객체 -> init -> service -> destroy
// 서블릿의 생명주기
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet{
	
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
}
