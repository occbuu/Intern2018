package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_expense", schema = "public")
public class TransactionExpense extends TransactionType implements Serializable {

	// region -- Fields --

	// end

	// region -- Get set --

	// end

	// region -- Methods --

	// end
}