package com.cosy.sun.test.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.mail.DemoMailApplication;
import com.cosy.sun.mail.mail.Mail;
import com.cosy.sun.mail.module.MailBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoMailApplication.class)
public class DemoMailTest {

	@Autowired
	private Mail mail;
	
	@Test
	public void test() {
		MailBean mailBean = new MailBean();
		mailBean.setContent("aaaa");
		mailBean.setRecipient("");
		mailBean.setSubject("mailTest");
		mail.sendSimpleMail(mailBean);
	}
	
}
