package com.cosy.sun.mail.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.cosy.sun.mail.module.MailBean;

@Component
public class Mail {
	
	@Autowired
	private JavaMailSender sender;
	
	private static final Logger logger = LoggerFactory.getLogger(Mail.class);
	
	public void sendSimpleMail(MailBean mailBean) {
	        try {
	            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	            //邮件发送人
	            simpleMailMessage.setFrom("");
	            //邮件接收人
	            simpleMailMessage.setTo(mailBean.getRecipient());
	            //邮件主题
	            simpleMailMessage.setSubject(mailBean.getSubject());
	            //邮件内容
	            simpleMailMessage.setText(mailBean.getContent());
	            sender.send(simpleMailMessage);
	        } catch (Exception e) {
	            logger.error("邮件发送失败", e.getMessage());
	        }
	    }
}

