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
	
}