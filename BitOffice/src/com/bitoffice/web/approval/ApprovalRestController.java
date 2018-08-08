package com.bitoffice.web.approval;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bitoffice.common.Page;
import com.bitoffice.common.Search;
import com.bitoffice.service.domain.Approval;
import com.bitoffice.service.approval.ApprovalService;


//==> ȸ������ Controller
@Controller
@RequestMapping("/approval/*")
public class ApprovalRestController {
	
	///Field
	@Autowired
	@Qualifier("approvalServiceImpl")
	private ApprovalService approvalService;
	//setter Method ���� ����
		
	public ApprovalRestController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;	
	
	@RequestMapping( value="json/addApproval", method=RequestMethod.GET )
	public @ResponseBody int addApproval( @ModelAttribute("approval") Approval approval ) throws Exception{
		
		System.out.println("json/approval/addApproval : GET");
		
		int resultValue = approvalService.addApproval(approval);
		
		return resultValue;

	}

	
	@RequestMapping( value="json/addApproval", method=RequestMethod.POST )
	public @ResponseBody int addApproval( @ModelAttribute("approval") Approval approval, Model model) throws Exception {

		System.out.println("json/approval/addApproval : POST");
		//Business Logic
		
		//���� ����  
/*		if (approval.getFileName1() !=null ||approval.getFileName2() !=null || approval.getFileName3() !=null) {
	        FTPUpLoader upLoader = new FTPUpLoader();
	        ArrayList<String> list = new ArrayList<String>();       
	       
	        if (approval.getFileName1().length()!=0) {
	        	list.add(approval.getFileName1());
	        }

	        if (approval.getFileName2().length()!=0) {
	        	list.add(approval.getFileName2());
	        }
	        
	        if (approval.getFileName3().length()!=0) {
	        	list.add(approval.getFileName3());
	        }       
	        
	        boolean re = upLoader.sendFtpServer("192.168.0.48", 21, "myftp", "myftp", approval.getRegEmployeeNo(),"C:\\test\\", list);
	        
	        if(re){
	            System.out.println("FTPUpLoaderMain.java :: ���ε� ����");
	        }else{
	            System.out.println("FTPUpLoaderMain.java :: ���ε� ����");
	        }
        
		}*/
		
/*		String saveDir = "C:\\Upload\\Approval\\";
		//String saveDir = "../images/uploadFiles/";
		
		System.out.println("/addProduct");
		
		int i=1;
				for(MultipartFile file : approval.getMultiFile()){
			
			//long t = System.currentTimeMillis(); 
			//int r = (int)(Math.random()*1000000); 
			//String fileId =""+t+"::::"+r ;
			
			//System.out.println(file.getOriginalFilename()+fileId);
			System.out.println("getContentType:"+file.getContentType());
			//���� ���ε� �ִ�3��
			if (file.getContentType().contains("image")) {
				File f = new File(saveDir+file.getOriginalFilename());
				file.transferTo(f);
				System.out.println("/addApproval:file");
				
				if(i==1) {
					System.out.println("/addApproval:file="+file.getOriginalFilename());
					approval.setFileName1(file.getOriginalFilename());
				}
				if(i==2) {
					approval.setFileName2(file.getOriginalFilename());
				}				
				if(i==3) {
					approval.setFileName3(file.getOriginalFilename());
				}		

				i++;
			}
			
		}		*/
			
		int resultValue = approvalService.addApproval(approval);
		System.out.println("resultValue:"+resultValue);
		return resultValue;

	}
	

	@RequestMapping( value="json/getApproval/{approvalNo}", method=RequestMethod.GET )
	public @ResponseBody Approval getApproval( @PathVariable String approvalNo , Model model ) throws Exception {
		
		System.out.println("json/approval/getApproval : GET"+approvalNo);
		//Business Logic
		//Approval approval = approvalService.getApproval(serialNo);
		// Model �� View ����
		//model.addAttribute("approval", approval);
		
		return approvalService.getApproval(approvalNo);

	}
	
	@RequestMapping( value="json/getTotalCountStatus", method=RequestMethod.POST )
	public @ResponseBody int getTotalCountStatus( @ModelAttribute("approval") Approval approval, Model model ) throws Exception {
		
		System.out.println("json/approval/getCountApproval : POST:"+approval.getRegEmployeeNo());
		//Business Logic
		//Approval approval = approvalService.getApproval(serialNo);
		// Model �� View ����
		//model.addAttribute("approval", approval);
		System.out.println("��:"+approvalService.getTotalCountStatus(approval));
		return approvalService.getTotalCountStatus(approval);

	}	
	

	@RequestMapping( value="json/updateApproval", method=RequestMethod.GET )
	public @ResponseBody int updateApproval( @ModelAttribute("approval") Approval approval, Model model ) throws Exception{

		System.out.println("json/approval/updateApproval : GET");
		//Business Logic
		int resultValue = approvalService.updateApproval(approval);
		return resultValue;

	}

	@RequestMapping( value="json/updateApproval", method=RequestMethod.POST )
	public @ResponseBody int updateApproval( @ModelAttribute("approval") Approval approval, Model model , HttpSession session) throws Exception{

		System.out.println("/approval/updateApproval : POST");
		
		//���� ����  
/*		if (approval.getFileName1() !=null ||approval.getFileName2() !=null || approval.getFileName3() !=null) {
	        FTPUpLoader upLoader = new FTPUpLoader();
	        ArrayList<String> list = new ArrayList<String>();       
	       
	        if (approval.getFileName1().length()!=0) {
	        	list.add(approval.getFileName1());
	        }

	        if (approval.getFileName2().length()!=0) {
	        	list.add(approval.getFileName2());
	        }
	        
	        if (approval.getFileName3().length()!=0) {
	        	list.add(approval.getFileName3());
	        }	        
	        
	        boolean re = upLoader.sendFtpServer("192.168.0.48", 21, "myftp", "myftp", approval.getModEmployeeNo(),"C:\\test\\", list);
	        
	        if(re){
	            System.out.println("FTPUpLoaderMain.java :: ���ε� ����");
	        }else{
	            System.out.println("FTPUpLoaderMain.java :: ���ε� ����");
	        }
        
		}*/
		
		//Business Logic	
		int resultValue = approvalService.updateApproval(approval);
		return resultValue;

	}
	
	@RequestMapping( value="json/updateApprovalStatus", method=RequestMethod.POST )
	public @ResponseBody int updateApprovalStatus( @ModelAttribute("approval") Approval approval, Model model , HttpSession session) throws Exception{

		System.out.println("/approval/updateApprovalStatus : POST");
		//Business Logic
		int resultValue = approvalService.updateApprovalStatus(approval);
		return resultValue;

	}	

	
	@RequestMapping( value="json/deleteApproval", method=RequestMethod.POST )
	public @ResponseBody int deleteApproval( @ModelAttribute("approval") Approval approval) throws Exception{

		System.out.println("json/approval/deleteApproval : POST");
		//Business Logic
		int resultValue =approvalService.deleteApproval(approval);
	
		return resultValue;
	}		
	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
	public @ResponseBody void checkDuplication( @RequestParam("serialNo") String serialNo , Model model ) throws Exception{
		
		System.out.println("json/approval/checkDuplication : POST");
		//Business Logic
		boolean result=approvalService.checkDuplication(serialNo);
		// Model �� View ����
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("serialNo", serialNo);

	}

	
	@RequestMapping( value="json/listApproval", method=RequestMethod.GET)
	public @ResponseBody void listApproval( @ModelAttribute("search") Search search , @ModelAttribute("approval") Approval approval , Model model , HttpServletRequest request) throws Exception{
		
		System.out.println("json/approval/listApproval : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic ����
		Map<String , Object> map=approvalService.getApprovalList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model �� View ����
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);


	}
	

	public class FTPUpLoader {
	    /**
	     * 
	     * @param ip         ftp����ip
	     * @param port       ftp����port
	     * @param id         �����id
	     * @param password   �����password 
	     * @param folder     ftp����������������
	     * @param files      ���ε�list
	     * @return
	     */
	    public boolean sendFtpServer(String ip, int port, String id, String password,

	                          String folder,String localPath, ArrayList<String> files) {
	        boolean isSuccess = false;
	        FTPClient ftp = null;
	        int reply;
	        try {
	            ftp = new FTPClient();

	             ftp.setControlEncoding("UTF-8");
	            ftp.connect(ip, port);
	            System.out.println("Connected to " + ip + " on "+ftp.getRemotePort());
	            
	            // After connection attempt, you should check the reply code to verify
	            // success.
	            reply = ftp.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftp.disconnect();
	                System.err.println("FTP server refused connection.");
	                System.exit(1);
	            }
	            
	            if(!ftp.login(id, password)) {
	                ftp.logout();
	                throw new Exception("ftp ������ �α������� ���߽��ϴ�.");
	            }
	            
	            ftp.setFileType(FTP.BINARY_FILE_TYPE);
	            ftp.enterLocalPassiveMode();
	            

	            System.out.println(ftp.printWorkingDirectory());
	            try{
	                ftp.makeDirectory(folder);
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            ftp.changeWorkingDirectory(folder);
	            System.out.println(ftp.printWorkingDirectory());
	            
	            
	            for(int i = 0; i < files.size(); i++) {

	                 String sourceFile = localPath + files.get(i);   
	                 
	                 System.out.println(files.get(i)+"==sourceFile=="+sourceFile);
	                 
	                File uploadFile = new File(sourceFile);
	                FileInputStream fis = null;
	                try {
	                    fis = new FileInputStream(uploadFile);
	                    System.out.println(sourceFile + " : ���۽��� = >");
	                    isSuccess = ftp.storeFile(files.get(i), fis);
	                    System.out.println(sourceFile + " : ���۰�� = >" + isSuccess);
	                } catch(IOException e) {
	                    e.printStackTrace();
	                    isSuccess = false;
	                } finally {
	                    if (fis != null) {
	                        try {fis.close(); } catch(IOException e) {}
	                    }
	                }//end try
	            }//end for
	            
	            ftp.logout();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (ftp != null && ftp.isConnected()) {
	                try { ftp.disconnect(); } catch (IOException e) {}
	            }
	        }
	        return isSuccess;
	    }

	}



	
	
}