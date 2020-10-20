package com.raoSystem.daoConnection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDAO {
	private static StandardServiceRegistry standardServiceRegistory;
	private static SessionFactory sessionFactory;
	static {
		if(sessionFactory==null) {
			try {
				standardServiceRegistory = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources metaDataSource = new MetadataSources(standardServiceRegistory);
				Metadata metaData = metaDataSource.getMetadataBuilder().build();
				sessionFactory=metaData.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if(standardServiceRegistory!=null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistory);
				}
			}
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
