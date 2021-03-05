package com.rakuten.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.rakuten.entity.Customer;

public class EmpRespository {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("EmployeePU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		Customer c1=new Customer();
		c1.setCustId(101);
		c1.setCustName("Ashish");
		c1.setEmail("ashish@gmail.com");
		em.persist(c1);  //sving in DB ..
		em.getTransaction().commit();
		System.out.println("Success ...");
		
	}
}