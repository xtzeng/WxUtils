package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xt.weixin.po.User;


public class PersistenceTest {

	
	@Test
	public void testSaveUser() {
		
	      ApplicationContext context = new ClassPathXmlApplicationContext(

          "applicationContext.xml");  

	      SessionFactory factory = (SessionFactory) context   
	                
          .getBean("sessionFactory");   //spring直接帮我们加载了hibernate.cgf.xml文件，让我们直接操作了sessionfactory。其实下面的事务管理我们也可以通过spring的来管理的。但是由于没写一个一个代理类所以就没写。

	      Session session = factory.openSession();

	      Transaction transaction = session.beginTransaction();

	      User u = new User();
	      
	      u.setName("pingfx");
	      u.setAge(111);

	      session.save(u);

	      transaction.commit();

	      session.close();


	}
}
