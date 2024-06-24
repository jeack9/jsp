package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoard;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CenterChart;
import co.yedam.web.CenterInfo;
import co.yedam.web.ChartForm;
import co.yedam.web.CheckIdAjax;
import co.yedam.web.EditAjax;
import co.yedam.web.GetBoard;
import co.yedam.web.JoinForm;
import co.yedam.web.JoinMember;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.Logout;
import co.yedam.web.MainControl;
import co.yedam.web.MapForm;
import co.yedam.web.MemberAddAjax;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberList;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.PublicData;
import co.yedam.web.RemoveAjax;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveForm;
import co.yedam.web.RemoveReply;
import co.yedam.web.ScriptForm;
import co.yedam.web.StudentForm;
import co.yedam.web.TotalCnt;
import co.yedam.web.UpdateBoard;
import co.yedam.web.replyList;

// front -> 요청 url -> 실행컨트롤 매칭.
//객체생성 -> init -> service -> destroy
public class FrontController extends HttpServlet{
	private Map<String, Control> map; // url, control
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		// 학생정보등록
		map.put("/studentForm.do", new StudentForm()); // 등록화면
		map.put("/addStudent.do", new AddStudent()); // 정보 db에 저장
		
		// 게시글목록
		map.put("/boardList.do", new BoardList());
		map.put("/boardForm.do", new BoardForm()); // 글등록화면
		map.put("/addBoard.do", new AddBoard()); //글등록
		map.put("/removeForm.do", new RemoveForm()); // 글삭제화면
		map.put("/removeBoard.do", new RemoveBoard()); // 글삭제
		map.put("/modifyForm.do", new ModifyForm()); // 글수정화면
		map.put("/updateBoard.do", new UpdateBoard()); //글수정
		map.put("/getBoard.do", new GetBoard()); //단건 조회
		
		//로그인
		map.put("/loginForm.do", new LoginForm()); // 로그인화면
		map.put("/login.do", new LoginControl()); // 로그인
		map.put("/logout.do", new Logout()); //로그아웃
		//회원가입
		map.put("/joinForm.do", new JoinForm());// 회원가입화면
		// 파일업로드
		map.put("/joinMember.do", new JoinMember()); // 회원가입
		
		//관리자용
		map.put("/memberList.do", new MemberList()); // 회원목록
		
		// 자바스크립트
		map.put("/script.do", new ScriptForm());
		
		// ajax 연습
		map.put("/ajax.do", new AjaxForm());
		map.put("/membersAjax.do", new MemberAjax());
		map.put("/addAjax.do", new MemberAddAjax());
		map.put("/checkIdAjax.do", new CheckIdAjax());
		map.put("/removeAjax.do", new RemoveAjax());
		map.put("/editAjax.do", new EditAjax());
		
		// 댓글
		map.put("/replyListJson.do", new replyList()); // 댓글 조회
		map.put("/removeReply.do", new RemoveReply()); // 댓글 삭제
		map.put("/addReply.do", new AddReply()); // 댓글 등록
		map.put("/replyTotalCnt.do", new TotalCnt()); // 댓글 전체 수
		
		// 공공데이터
		map.put("/publicData.do", new PublicData());
		
		// 카카오맵 
		map.put("/map.do", new MapForm());
		
		// json 문자열 -> db insert
		map.put("/centerInfo.do", new CenterInfo());
		
		// 센터 차트
		map.put("/chartForm.do", new ChartForm());
		map.put("/centerChart.do", new CenterChart());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // 서버정보를 뺀 url
		System.out.println("uri: " + uri); // /BoardWeb/main.do
		String context = req.getContextPath(); // project name => /BoardWeb
		System.out.println("context: " + context);
		String page = uri.substring(context.length());
		System.out.println("page: " + page);
		
		Control result = map.get(page);
		result.exec(req, resp);
		System.out.println("result: " + result);
	}
}
