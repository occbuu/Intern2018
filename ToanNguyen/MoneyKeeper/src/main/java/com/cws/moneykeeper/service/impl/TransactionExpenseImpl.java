package com.cws.moneykeeper.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cws.moneykeeper.dao.TransactionExpenseDao;
import com.cws.moneykeeper.model.TransactionExpense;
import com.cws.moneykeeper.service.TransactionExpenseService;

@Service(value = "transactionExpenseService")
@Transactional
public class TransactionExpenseImpl implements TransactionExpenseService {
	// region -- Fields --

	@Autowired
	private TransactionExpenseDao transactionExpenseDao;

	// end

	@Override
	public List<TransactionExpense> search1() {
		List<TransactionExpense> res = transactionExpenseDao.search1();
		return res;
	}

	@Override
	public List<TransactionExpense> search2() {
		List<TransactionExpense> res = transactionExpenseDao.search2();
		return res;
	}

	@Override
	public List<TransactionExpense> search3(String name) {
		List<TransactionExpense> res = transactionExpenseDao.search3(name);
		return res;
	}

	@Override
	public String save(TransactionExpense m) {
		Date d = new Date();
		m.setCreateDate(d);
		m.setStatus("ACT");

		TransactionExpense res = transactionExpenseDao.save(m);
		return res.getId() + "";
	}
}