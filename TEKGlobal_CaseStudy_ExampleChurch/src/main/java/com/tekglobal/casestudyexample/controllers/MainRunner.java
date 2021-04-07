package com.tekglobal.casestudyexample.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tekglobal.casestudyexample.models.Attendance;
import com.tekglobal.casestudyexample.models.Tithe;

public class MainRunner {

	public static void main(String[] args) {
		Tithe t1 = new Tithe();
		Attendance a1 = new Attendance();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEKGlobal_CaseStudy_Example");
		EntityManager em = emf.createEntityManager();
		
		
				
		
//		t1 = em.find(Tithe.class, 1L);
		
//		t1.getDateCollected();
//		System.out.println(t1.toString());
		

		a1 = em.find(Attendance.class, 4L);
		System.out.println(a1.toString());
		

	}

}
