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
	
}
