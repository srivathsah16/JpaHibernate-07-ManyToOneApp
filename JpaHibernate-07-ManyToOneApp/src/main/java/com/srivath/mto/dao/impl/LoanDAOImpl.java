package com.srivath.mto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.srivath.mto.dao.LoanDAO;
import com.srivath.mto.entities.Loan;

public class LoanDAOImpl implements LoanDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public void saveLoan(Loan loan) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		try {
			em.merge(loan);
			txn.commit();
			System.out.println("Loan and customer persisted into DB");
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public Loan fetchLoan(Integer loanId) {
		EntityManager em = factory.createEntityManager();
		Loan loan = em.find(Loan.class, loanId);
		em.close();
		return loan;
	}

	@Override
	public void deleteLoan(Integer loanId) {
		EntityManager em=factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Loan loan = em.find(Loan.class, loanId);
		txn.begin();
		try {
			em.remove(loan);
			txn.commit();
			System.out.println("Loan deleted from DB");
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
}
