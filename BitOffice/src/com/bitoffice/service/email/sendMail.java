package com.bitoffice.service.email;

import java.io.IOException;
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
				System.out.println("���Գ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				final String user = "mdasom6975@gmail.com"; //�߽����� �̸��� ���̵� �Է�
				final String password="mdasom6975@"; //�߽����� �̸��� �н����带 �Է�
				
				//�ӽ� ��й�ȣ ������ ���� ��������
				String tPassword = "";
			
				Properties prop = new Properties();
				
				//"mail.smtp.host"�� �̸��� �߼��� ó������ STMP ������ ��Ÿ���ϴ�.gmail�� SMTP������ ����� ��� "smtp.gmail.com" ���� ����, naver�� SMTP������ ����� ��� "smtp.naver.com" ���� �����մϴ�.
				prop.put("mail.smtp.host", "smtp.gmail.com"); 
				 //"mail.smtp.port "�� SMTP������ ����ϴ� ��Ʈ�� ���ϴµ� gmail�� ��� 587�� Naver�� ��� 465�� ����Ѵٴµ�...
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				//�Ʒ� �ҽ����� ����
				//		prop.put("mail.smtp.ssl.enable", "true");
				//�׷��� �Ʒ� ���ٷ� �߰�
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.transport.protocol", "smtp");
				prop.put("mail.smtp.socketFactory.fallback", "true");
//				prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				
				
				//SMTP ������ ������ ����� ������ ������� Session Ŭ������ �ν��Ͻ� ����
				Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
						
					}
				});
				
				//Message Ŭ������ ��ü�� ����Ͽ� �����ڿ� ����, ������ �޼����� �ۼ��Ѵ�.
				//Transport Ŭ������ ����Ͽ� �ۼ��� �޼����� �����Ѵ�.
				
				try {
					MimeMessage message = new MimeMessage(session);
					
					message.setFrom(new InternetAddress(user));
					//������ ���� �ּ�
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					
					//��������
					message.setSubject("��Ʈ ���ǽ� �ӽ� ��й�ȣ �߼� �ȳ� ����");
					
					int random = (int)(Math.random() * 1000000) + 100000;
					
					System.out.println(random);
					
					tPassword=Integer.toString(random);
					
					//���� ���� �Է�
					//message.setText(  tPassword  + " �� �α��� ���ּ���. �α��� �� �ݵ�� ��й�ȣ�� �缳���Ͻñ� �ٶ��ϴ�.");
					
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
							"<strong>�ӽ� ��й�ȣ �ȳ� �����Դϴ�.</strong><br/>\r\n" + 
							"<br/>\r\n" + 
							"<br/>\r\n" + 
							"�ӽ� ��й�ȣ : \r\n" +tPassword+
							"<br/>\r\n" + 
							"<br/>\r\n" + 
							"�ش� ��ȣ�� �α��� �� �ݵ�� ��й�ȣ�� ���� ���ּ���.\r\n" + 
							"</p>\r\n" + 
							"\r\n" + 
							"</body>\r\n" + 
							"</html>", "text/html; charset=EUC-KR");
					
					//send Message
					Transport.send(message); // ����
					System.out.println("�߼۵� �ӽ� ��й�ȣ :::::::::"+tPassword);
					System.out.println("message sent successfully!!!!!!!!!!!!!!!!!");
				} catch(AddressException e) {
					e.printStackTrace();
					return "����";
				} catch(MessagingException e){
					e.printStackTrace();
					return "����";
				}
		return tPassword;
	}
	
	

}
