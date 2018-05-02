package com.cws.moneykeeper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cws.moneykeeper.model.TransactionExpense;

public interface TransactionExpenseDao extends CrudRepository<TransactionExpense, Integer> {
	@Query("FROM TransactionExpense a WHERE a.idParent = 0")
	public List<TransactionExpense> search1();

	@Query(nativeQuery = true, value = "SELECT * FROM public.transaction_expense WHERE id_parent = 0")
	public List<TransactionExpense> search2();

	@Query("FROM TransactionExpense a WHERE (a.name IS NULL OR :name = '' OR UPPER(a.name) LIKE CONCAT('%', :name, '%'))")
	public List<TransactionExpense> search3(@Param("name") String name);
}