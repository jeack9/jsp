package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// interface - 구현객체.
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student std = new Student();
		std.setStdNo("S0030");
		std.setStdName("안녕하세요");
		std.setPhone("010-000-000");
		std.setBldType("B");
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
		
		std.setPhone("123-000-789");
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
		mapper.updateStudent(std);
		sqlSession.commit();
		
		List<Student> list = 
							 //sqlSession.selectList("co.yedam.mapper.StudentMapper.selectStudent");
							 mapper.selectStudent();
		for(Student ele : list) {
			System.out.println(ele.toString());
		}
	}
}
