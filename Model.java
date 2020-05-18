package rest.model;

import rest.model.entity.EClient;
import rest.model.entity.EUser;
import rest.model.entity.EAd;

import java.util.List;

import java.sql.*;


import javax.annotation.Resource;   
import javax.sql.DataSource;

import javax.naming.InitialContext;   


import javax.persistence.*;
import javax.transaction.*;


public class Model implements IModel
{  
	@PersistenceUnit(unitName = "local_pg_test_PersistenceUnit")
    private EntityManagerFactory entityManagerFactory;
   
    @Resource
    private UserTransaction userTransaction;
    
    public void get_ad(EAd ad, String user_data) {
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		try
		{
			userTransaction.begin();
		}
		catch (Exception e) {}
		entityManager.joinTransaction();
		ad = entityManager.find(EAd.class, user_data);
		try
		{
			userTransaction.commit();
		}
		catch (Exception e) {}
    }
    
    public String get_next_ad_id() {
		Long max_id;
		int cur_id;
		String str_id;
		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManager();
		try
		{
			userTransaction.begin();
		}
		catch (Exception e) {}
		entityManager.joinTransaction();
		Query query = entityManager.createQuery("SELECT COUNT(a) FROM ADSS a");
		max_id = (Long)query.getSingleResult();
		max_id = max_id + 1;
		cur_id = Math.toIntExact(max_id);
		str_id = Integer.toString(cur_id);
		try
		{
			userTransaction.commit();
		}
		catch (Exception e) {}
		return str_id;
    }
    
    public void add_ad(EAd ad) throws Exception {
		try 
		{
			EntityManager entityManager;
			try {
				entityManager = entityManagerFactory.createEntityManager();
			}
			catch (Exception e) {
				throw new Exception("Error while Entity Manager initializing: " + e.getMessage()); 
			}	 
			try {
				userTransaction.begin();
				entityManager.joinTransaction();				
				entityManager.persist(ad);
				userTransaction.commit();
			} catch (Exception e) {}
		} 
		catch (Exception e) 
		{
			throw new Exception("Error while JPA operating: " + e.getMessage());
		}
    }
	
}
