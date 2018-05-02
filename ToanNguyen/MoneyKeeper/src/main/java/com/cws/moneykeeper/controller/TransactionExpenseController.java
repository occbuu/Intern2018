package com.cws.moneykeeper.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cws.moneykeeper.model.TransactionExpense;
import com.cws.moneykeeper.req.BaseReq;
import com.cws.moneykeeper.req.TransactionExpenseReq;
import com.cws.moneykeeper.rsp.BaseRsp;
import com.cws.moneykeeper.rsp.MultipleRsp;
import com.cws.moneykeeper.rsp.SingleRsp;
import com.cws.moneykeeper.service.TransactionExpenseService;

@RestController
@RequestMapping("/TransactionExpense")
public class TransactionExpenseController {
	// region -- Fields --

	@Autowired
	private TransactionExpenseService transactionExpenseService;

	// end

	@RequestMapping(value = "/search1", method = RequestMethod.GET)
	public ResponseEntity<?> search(@RequestHeader HttpHeaders header) {
		MultipleRsp res = new MultipleRsp();

		try {
			// Handle
			List<TransactionExpense> tmp = transactionExpenseService.search1();

			// Set data
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("count", tmp.size());
			data.put("data", tmp);
			data.put("toan", "OKKK");
			res.setResult(data);
		} catch (Exception ex) {
			res.setCallstatus("error");
			res.setMessage(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/search2", method = RequestMethod.GET)
	public ResponseEntity<?> search2(@RequestHeader HttpHeaders header) {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			List<TransactionExpense> tmp = transactionExpenseService.search2();

			// Set data
			res.setResult(tmp);
		} catch (Exception ex) {
			res.setCallstatus("error");
			res.setMessage(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/search3", method = RequestMethod.POST)
	public ResponseEntity<?> search2(@RequestHeader HttpHeaders header, @RequestBody BaseReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String keyword = req.getKeyword();

			// Handle
			List<TransactionExpense> tmp = transactionExpenseService.search3(keyword);

			// Set data
			res.setResult(tmp);
		} catch (Exception ex) {
			res.setCallstatus("error");
			res.setMessage(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestHeader HttpHeaders header, @RequestBody TransactionExpenseReq req) {
		BaseRsp res = new BaseRsp();

		try {
			// Get data
			int id = req.getId();
			String name = req.getName();
			String note = req.getNote();

			// Convert data req -> model
			TransactionExpense m = new TransactionExpense();
			m.setId(id);
			m.setName(name);
			m.setNote(note);

			// Handle
			String tmp = transactionExpenseService.save(m);

			// Set data
			res.setMessage(tmp);
		} catch (Exception ex) {
			res.setCallstatus("error");
			res.setMessage(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
