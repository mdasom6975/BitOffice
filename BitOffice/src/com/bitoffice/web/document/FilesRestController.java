package com.bitoffice.web.document;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.document.FilesService;

@Controller
@RequestMapping("/document/*")
public class FilesRestController {
	
	@Autowired
	@Qualifier("fileServiceImpl")
	private FilesService filesService;
	
	public FilesRestController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="json/listFile")
	@ResponseBody
	public JSONObject listFile(@ModelAttribute("search") Search search, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		Map<String, Object> map = filesService.listAll(search);

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("list", map);
		jsonObject.put("resultPage", resultPage);
		
		return jsonObject;
		
	}

}
