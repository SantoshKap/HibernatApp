package com.st;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.st.bean.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration conf=new Configuration();
    	conf.configure();
    	ServiceRegistry ser=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf=conf.buildSessionFactory(ser);
    	Session session=sf.openSession();
    	
    	Employee emp=new Employee();
    	emp.setEmployeeId(101);
    	emp.setEmployeeName("Teju");
    	Transaction tx=session.beginTransaction();
    	
    	session.save(emp);
    	
    	tx.commit();
    	
    	session.close();
    }
}
