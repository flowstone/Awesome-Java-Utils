package me.xueyao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 用于获取JPA操作数据库对象的工具类
 * @author XueYao
 *
 */
public class JPAUtils {
	//JPA的实体管理器工厂,相当于Hibernate的SessionFactory
	private static final EntityManagerFactory em;
	//使用静态代码块赋值
	static {
		//创建JPA的实体管理器工厂;该方法参数必须和persistence.xml
		em = Persistence.createEntityManagerFactory("myPersistence");
	}
	
	
	/**
	 * 获取实例管理器的工具方法
	 * @return
	 */
	public static EntityManager getEntityManager(){
		return em.createEntityManager();
	}
}
