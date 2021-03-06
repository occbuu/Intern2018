package com.intern.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.Transaction;
import com.intern.model.TransactionIdentity;
import com.intern.req.SearchReq;
import com.intern.req.TransactionReq;
import com.intern.rsp.SingleRes;
import com.intern.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	// region -- Fields --

	@Autowired
	private TransactionService ser;

	// end

	// region -- Methods --

	@PostMapping("/")
	public ResponseEntity<?> searchTransaction(@RequestBody SearchReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String owner = req.getOwner();
			String searchString = req.getSearchString();
			List<Transaction> lstResult = ser.searchTransaction(owner, searchString);
			rsp.setResult(lstResult);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TransactionReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String owner = req.getOwner();
			String accountType = req.getAccountType();
			String transactionType = req.getTransactionType();
			String type = req.getType();
			Double price = req.getPrice();
			String note = req.getNote();
			String person = req.getPerson();
			Transaction newTransaction = new Transaction();
			newTransaction.setNote(note);
			newTransaction.setPerson(person);
			newTransaction.setPrice(price);
			newTransaction.setTransactionType(transactionType);
			newTransaction.setType(type);
			newTransaction.setAccountType(accountType);
			TransactionIdentity transactionIdentity = new TransactionIdentity(new Date(), owner);
			newTransaction.setTransactionIdentity(transactionIdentity);
			ser.save(newTransaction);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/detail")
	public ResponseEntity<?> detail(@RequestBody TransactionReq req) {
		SingleRes rsp = new SingleRes();

		try {
			Date dateTransaction = req.getDateTransaction();
			String owner = req.getOwner();
			Transaction temp = ser.detailTransactionByDateTransaction(dateTransaction, owner);
			if (temp == null) {
				rsp.setMessage("Transaction doesn't exists in DB.");
				rsp.setCallStatus("Fail");
			} else {
				rsp.setResult(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PutMapping("/detail")
	public ResponseEntity<?> update(@RequestBody TransactionReq req) {
		SingleRes rsp = new SingleRes();

		try {
			Date dateTransaction = req.getDateTransaction();
			String owner = req.getOwner();
			String accountType = req.getAccountType();
			String note = req.getNote();
			String transactionType = req.getTransactionType();
			String type = req.getType();
			double price = req.getPrice();
			String person = req.getPerson();
			Transaction temp = new Transaction();
			temp.setNote(note);
			temp.setPerson(person);
			temp.setPrice(price);
			temp.setTransactionType(transactionType);
			temp.setType(type);
			temp.setAccountType(accountType);
			TransactionIdentity transactionIdentity = new TransactionIdentity();
			transactionIdentity.setOwner(owner);
			transactionIdentity.setDateTransaction(dateTransaction);
			temp.setTransactionIdentity(transactionIdentity);
			temp = ser.update(temp);
			if (temp == null) {
				rsp.setMessage("Transaction doesn't exists in DB.");
				rsp.setCallStatus("Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@DeleteMapping("/detail")
	public ResponseEntity<?> delete(@RequestBody TransactionReq req) {
		SingleRes rsp = new SingleRes();

		try {
			Date dateTransaction = req.getDateTransaction();
			String owner = req.getOwner();
			TransactionIdentity transactionIdentity = new TransactionIdentity();
			transactionIdentity.setDateTransaction(dateTransaction);
			transactionIdentity.setOwner(owner);
			Transaction temp = ser.delete(transactionIdentity);
			if (temp == null) {
				rsp.setMessage("Transaction doesn't exists in DB.");
				rsp.setCallStatus("Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}