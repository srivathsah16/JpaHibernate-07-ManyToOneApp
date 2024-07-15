package com.srivath.mto.test;

import com.srivath.mto.dao.LoanDAO;
import com.srivath.mto.dao.impl.LoanDAOImpl;
import com.srivath.mto.entities.Customer;
import com.srivath.mto.entities.Loan;

public class TestApp {
	public static void main(String[] args) {
		LoanDAO dao=new LoanDAOImpl();
		
		/*
		 * invoke saveLoan()
		 */
		Loan pLoan = new Loan();
		pLoan.setLoanId(12323);
		pLoan.setLoanType("PERSONAL");
		pLoan.setAmount(34000.0);
		
		Loan hLoan = new Loan();
		hLoan.setLoanId(34325);
		hLoan.setLoanType("HOME");
		hLoan.setAmount(56000.0);
		
		Loan eLoan = new Loan();
		eLoan.setLoanId(67687);
		eLoan.setLoanType("EDUCATION");
		eLoan.setAmount(78000.0);
		
		Customer customer=new Customer();
		customer.setCustomerId(1323);
		customer.setCustomerName("A");
		
		pLoan.setCustomer(customer);
		hLoan.setCustomer(customer);
		eLoan.setCustomer(customer);
		
		dao.saveLoan(pLoan);
		dao.saveLoan(hLoan);
		dao.saveLoan(eLoan);
		
		/*
		 * invoke fetchLoan()
		 */
//		Loan loan=dao.fetchLoan(12323);
//		System.out.println(loan);
//		System.out.println(loan.getCustomer());
		
		/*
		 * invoke deleteLoan()
		 */
//		dao.deleteLoan(67687);
	}
}
