package com.cws.moneykeeper.service;

import java.util.List;

import com.cws.moneykeeper.model.TransactionExpense;

public interface TransactionExpenseService {
	List<TransactionExpense> search1();

	List<TransactionExpense> search2();

	List<TransactionExpense> search3(String name);

	String save(TransactionExpense m);
}