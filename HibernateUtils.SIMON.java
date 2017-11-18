package me.xueyao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sf;
	
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * 每次获取新的session
	 * @return
	 */
	public static Session openSession() {
		return sf.openSession();
	}
	
	/**
	 * 获取当前线程里的Session的公共方法
	 * @return
	 */
	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}
}
