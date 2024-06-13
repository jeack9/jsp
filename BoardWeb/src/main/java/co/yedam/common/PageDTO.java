package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage; // 현재 페이지 기준 10개페이징 스타트, 엔드
	private boolean prev, next;
	private int currPage; // 현재페이지
	
	public PageDTO(int currpage, int totalCtn) {
		this.currPage = currpage; // 현재페이지
		this.endPage = (int) (Math.ceil(currpage / 10.0) * 10); // 10개의 페이지 버튼 제공
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)Math.ceil(totalCtn / 5.0); //실제 마지막 페이지번호
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
