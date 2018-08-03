package com.bitoffice.web.board;

import java.io.File;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.board.BoardService;


@RestController
@RequestMapping("/board/*")
public class BoardRestController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService boardService;
	
	
	public BoardRestController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@ResponseBody
	@RequestMapping(value="/json/imageUpload")
	
	public JSONObject imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("/json/imageUpload");
		
		//참고 소스 : https://m.blog.naver.com/heartflow89/221097971475
		
		//한글처리를 위한
		response.setContentType("text/html;charset=utf-8");
		// 업로드할 폴더 경로 
		String realFolder = request.getSession().getServletContext().getRealPath("/uploadFiles");

		//폴더가 없을 경우 폴더 생성
			File dir = new File(realFolder);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			UUID uuid = UUID.randomUUID();

		// 업로드할 파일 이름
		String org_filename = file.getOriginalFilename();
		String str_filename =  uuid.toString()+org_filename;
		
		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);

		String filepath = realFolder + "/"+ str_filename;
		System.out.println("파일경로 : " + filepath);

		File f = new File(dir,str_filename );
		
		file.transferTo(f);
		
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("url","/uploadFiles/"+str_filename);

		System.out.println(jsonObject);
			
		return jsonObject;
	}
	
	@RequestMapping(value="json/listBoard")
	@ResponseBody
	public JSONObject  listBoard(@ModelAttribute("search") Search search, String orderby)throws Exception{
		
		System.out.println("json/listBoard");
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		orderby="";
		// Business logic 수행
		Map<String, Object> map = boardService.getBoardList(search, orderby);
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("list", map);
		jsonObject.put("resultPage", resultPage);
		return jsonObject;
	}


}
