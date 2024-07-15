package com.srivath.mto.dao;

import com.srivath.mto.entities.Loan;

public interface LoanDAO {

	void saveLoan(Loan loan);

	Loan fetchLoan(Integer loanId);

	void deleteLoan(Integer loanId);
}
