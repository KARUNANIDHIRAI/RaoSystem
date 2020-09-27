package com.raoSystem.daoConnection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDAO {
	private static StandardServiceRegistry SSR;
	private static SessionFactory SF;
	static {
		if(SF==null) {
			try {
				SSR = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources MDS = new MetadataSources(SSR);
				Metadata MD = MDS.getMetadataBuilder().build();
				SF=MD.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if(SSR!=null) {
					StandardServiceRegistryBuilder.destroy(SSR);
				}
			}
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SF;
	}


}
