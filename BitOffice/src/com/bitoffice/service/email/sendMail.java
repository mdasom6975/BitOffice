package com.bitoffice.service.email;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {
	
	public static String emailPassword(String employeeNo,String email) throws IOException {
				System.out.println("들어왔나!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				final String user = "aaaaa@gmail.com"; //발신자의 이메일 아이디를 입력
				final String password="aaaaaa"; //발신자의 이메일 패스워드를 입력
				
				//임시 비밀번호 생성을 위한 변수선언
				String tPassword = "";
			
				Properties prop = new Properties();
				
				//"mail.smtp.host"은 이메일 발송을 처리해줄 STMP 서버를 나타냅니다.gmail을 SMTP서버로 사용할 경우 "smtp.gmail.com" 으로 설정, naver를 SMTP서버로 사용할 경우 "smtp.naver.com" 으로 설정합니다.
				prop.put("mail.smtp.host", "smtp.gmail.com"); 
				 //"mail.smtp.port "은 SMTP서버와 통신하는 포트를 말하는데 gmail일 경우 587를 Naver의 경우 465을 사용한다는데...
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				//아래 소스쓰면 에러
				//		prop.put("mail.smtp.ssl.enable", "true");
				//그래서 아래 두줄로 추가
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.transport.protocol", "smtp");
				prop.put("mail.smtp.socketFactory.fallback", "true");
//				prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				
				
				//SMTP 서버의 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
				Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
						
					}
				});
				
				//Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메세지를 작성한다.
				//Transport 클래스를 사용하여 작성한 메세지를 전달한다.
				
				try {
					MimeMessage message = new MimeMessage(session);
					
					message.setFrom(new InternetAddress(user));
					//수신자 메일 주소
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					
					//메일제목
					message.setSubject("비트 오피스 임시 비밀번호 발송 안내 메일");
					
					int random = (int)(Math.random() * 1000000) + 100000;
					
					System.out.println(random);
					
					tPassword=Integer.toString(random);
					SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					//메일 내용 입력
					//message.setText(  tPassword  + " 로 로그인 해주세요. 로그인 후 반드시 비밀번호는 재설정하시길 바랍니다.");
					
					message.setContent("<html>\r\n" + 
							"<head>\r\n" + 
							"	<title>BitOffice</title>\r\n" + 
							"</head>\r\n" + 
							"\r\n" + 
							"<body>\r\n" + 
							"\r\n" + 
							"\r\n" + 
							"<p style=\"border:1px solid #999;padding:10px;text-align: center;width:600px;\">\r\n" + 
							"<a href=\"http://192.168.0.33:8080/\"><img src=\"https://blogfiles.pstatic.net/MjAxODA4MTFfMTUg/MDAxNTMzOTY3NTcyOTM2.bn08xbGg3b38DjImKWoCy_SDwGKQTQGBjv7mp51_2GUg.Ec4t4cSDSq7XORCOjhzLhpCIpTftEQ25A70xsxc7p_gg.PNG.jino_ya/email.PNG\" width=\"600\"/></a><br/>\r\n" + 
							"<br/>\r\n" + 
							"<br/>\r\n" + 
							"<strong>임시 비밀번호 안내 메일입니다.</strong><br/>\r\n" + 
							"<br/>\r\n" + 
							"<br/>\r\n" + 
							"임시 비밀번호 : \r\n" +tPassword+
							"<br/>\r\n" + 
							"<br/>\r\n" + 
							"해당 번호로 로그인 후 반드시 비밀번호를 변경 해주세요.\r\n" + 
							"</p>\r\n" + 
							"\r\n" + 
							"</body>\r\n" + 
							"</html>", "text/html; charset=EUC-KR");
					
					//send Message
					Transport.send(message); // 전송
					System.out.println("발송된 임시 비밀번호 :::::::::"+tPassword);
					System.out.println("message sent successfully!!!!!!!!!!!!!!!!!");
				} catch(AddressException e) {
					e.printStackTrace();
					return "실패";
				} catch(MessagingException e){
					e.printStackTrace();
					return "실패";
				}
		return tPassword;
	}
	
	

}
