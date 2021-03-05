package com.rakuten.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.rakuten.entity.Customer;
public class EmpRespository {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("customerPU");
	public static void main(String[] args) {
		addCustomer();
		//readCustomer();
	}
	
	static void addCustomer() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer c1=new Customer(); //new state/ transient state ...
		c1.setCustId(112);
		c1.setCustName("dbc");
		c1.setEmail("dbc@gmail.com");
		em.persist(c1);  //saving in DB ..Managed state ....
		//c1.setEmail("abcd@gmail.com");
		em.getTransaction().commit();
		em.close();
		//c1.setEmail("xyz@gmail.com"); //Detached State ...
		System.out.println("Success ...");
	}
	
	static void readCustomer() {
		EntityManager em=emf.createEntityManager();
		Customer c=em.find(Customer.class, 999);
		if(c!=null) {
			System.out.println("Customer name is : "+c.getCustName());
			System.out.println("Email : "+c.getEmail());
		}
		else
			System.out.println("Customer not found ..");
		em.close();
	}
	
	static void updateCustomer() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer c=em.find(Customer.class,102);
		if(c!=null) {
			c.setEmail("prk@gmail.com");
			System.out.println("Record is updated");
		}
		else
			System.out.println("Customer not found ..");
		em.getTransaction().commit();
		em.close();
	}
	
	static void deleteCustomer() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer c=em.find(Customer.class,102);
		if(c!=null) {
			em.remove(c);
			System.out.println("Record is deleted");
		}
		else
			System.out.println("Customer not found ..");
		em.getTransaction().commit();
		em.close();
	}
}