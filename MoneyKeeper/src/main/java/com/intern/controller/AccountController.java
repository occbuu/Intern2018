package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.Account;
import com.intern.req.AccountReq;
import com.intern.req.SearchAccountReq;
import com.intern.rsp.SingleRes;
import com.intern.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	// region -- Fields --

	@Autowired
	private AccountService ser;

	// end

	// region -- Methods --

	@PostMapping("/")
	public ResponseEntity<?> getAllAccountOfOwner(@RequestBody SearchAccountReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String name = req.getName();
			String owner = req.getOwner();
			List<Account> result = ser.findAccountLikeName(name, owner);
			rsp.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody AccountReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String name = req.getName();
			String owner = req.getOwner();
			String accountType = req.getAccountType();
			String note = req.getNote();
			double ini = req.getIni();
			double rmn = req.getRmn();
			Account newAccount = new Account();
			newAccount.setAccountType(accountType);
			newAccount.setName(name);
			newAccount.setNote(note);
			newAccount.setIni(ini);
			newAccount.setRmn(rmn);
			newAccount.setOwner(owner);
			ser.save(newAccount);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}
