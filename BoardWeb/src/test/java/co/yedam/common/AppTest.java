package co.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper;

public class AppTest {	
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
		List<Map<String, Object>> list = mapper.centerBySido();
		for(Map<String, Object> map : list) {
			Set<String> keyset = map.keySet();
			System.out.println(map.get("sido") + " - " + map.get("cnt"));
			System.out.println("-----------------------------");
//			for(String key : keyset) {
//				System.out.println(key + " " + map.get(key));
//			}
		}
		
		// interface에 구현해 메소드가 하나만 있는 인터페이스: 함수형 인터페이스
//		mapper.selectList(201).forEach(new Consumer<ReplyVO>() {
//			public void accept(ReplyVO t) {
//				System.out.println(t);
//			};
//		});
		// 위에 표현식을 람다표현식으로 변경
//		mapper.selectList(201).forEach(reply -> System.out.println(reply));
	}
}
