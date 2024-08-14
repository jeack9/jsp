package com.yedam.app.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@AllArgsConstructor
public class BookController {
	private BookService bookSvc;
	
	// 도서목록페이지
	@GetMapping("/bookList")
	public String bookList(Model model) {
		model.addAttribute("books", bookSvc.bookList());
		return "book/bookList";
	}
	
	// 도서등록페이지
	@GetMapping("/bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookNo", bookSvc.getLastNo());
		return "book/bookForm";
	}
	// 도서등록 처리
	@PostMapping("/bookInsert")
	public String addBookProcess(BookVO bookVO) {
		bookSvc.insertBook(bookVO);
		return "redirect:/bookList";
	}
	// 도서대여현황조회 페이지
	@GetMapping("/rentList")
	public String rentList(Model model) {
		model.addAttribute("rents", bookSvc.rentList());
		return "book/rentList";
	}
	
}
