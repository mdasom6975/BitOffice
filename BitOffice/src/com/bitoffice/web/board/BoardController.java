package com.bitoffice.web.board;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.board.BoardService;
import com.bitoffice.service.domain.Board;
import com.bitoffice.service.domain.Employee;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	public BoardController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="addBoard", method=RequestMethod.GET)
	public String addBoard(Model model) throws Exception{
		
		System.out.println("/board/addBoard : GET");
		String menu="";
		menu ="addBoard";
		
		model.addAttribute("menu",menu);

		return  "forward:/board/board.jsp";
	}
	
	@RequestMapping(value="addBoard", method=RequestMethod.POST)
	public String addBoard(@ModelAttribute("board")Board board,HttpSession session) throws Exception {
		
		System.out.println("/board/addBoard : POST");
		
		System.out.println(board);
		String employeeNo = ((Employee)session.getAttribute("employee")).getEmployeeNo();
		
		System.out.println(employeeNo);
		
		board.setEmployeeNo(employeeNo);
		
//		String reTitle = board.getBoardTitle();
//		String reContent = board.getBoardContent();
//		
//		reTitle=URLDecoder.decode(reTitle, "UTF-8");
//		reContent=URLDecoder.decode(reContent,"UTF-8");
//		
//		board.setBoardTitle(reTitle);
//		board.setBoardContent(reContent);
		
		System.out.println("aaaaaaaaaa"+board);
		boardService.addBoard(board);
		
		return "redirect:/board/listBoard?orderby=";
		
	}
	
	@RequestMapping(value="getBoard", method=RequestMethod.GET)
	public String getBoard(@RequestParam("boardNo") int boardNo, Model model)throws Exception{
		
		System.out.println("/board/getBoard:GET");
		
		Board board = boardService.getBoard(boardNo);
		
		String reText = board.getBoardContent();
		reText=URLDecoder.decode(reText,"UTF-8");
		
		board.setBoardContent(reText);
		
		String menu="";
		menu ="getBoard";
		
		model.addAttribute("menu",menu);
		
		model.addAttribute("board", board);
		
		return "forward:/board/board.jsp";
	}
	
	@RequestMapping(value="listBoard")
	public String listBoard(@ModelAttribute("search") Search search, String orderby,Model model) throws Exception{
		
		System.out.println("/board/listBoard");
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		
		// Business logic 수행
		Map<String, Object> map = boardService.getBoardList(search, orderby);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		String menu="";
		menu ="listBoard";
		
		model.addAttribute("menu",menu);
		
		return "forward:/board/board.jsp";
		
		
	}
	
	@RequestMapping(value="updateBoard", method=RequestMethod.GET)
	public String updateBoard(@RequestParam("boardNo")int boardNo, Model model) throws Exception{
		
		System.out.println("/board/updateBoard : GET");
		
		Board board = boardService.getBoard(boardNo);
		
		String menu="";
		menu ="updateBoard";
		
		model.addAttribute("menu",menu);
		
		model.addAttribute("board", board);
		
		return "forward:/board/board.jsp";
	}
	
	@RequestMapping(value="updateBoard", method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board")Board board) throws Exception{
		
		System.out.println("/board/updateBoard : POST");
		
		boardService.updateBoard(board);
				
		return "redirect:/board/getBoard?boardNo="+board.getBoardNo();
	}
	
	
	@RequestMapping(value="deleteBoard")
	public String deleteBoard(@RequestParam("boardNo")int boardNo) throws Exception{
		
		boardService.delete(boardNo);
		
		return "redirect:/board/listBoard?orderby=";
	}
	
	@RequestMapping(value="countView")
	public String countView(@RequestParam("boardNo") int boardNo) throws Exception{
		
		System.out.println("/board/countView");
		
		boardService.countView(boardNo);
		
		return "redirect:/board/getBoard?boardNo="+boardNo;
	}

}
