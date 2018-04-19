package com.tri.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tri.model.*;
import com.tri.req.*;
import com.tri.res.*;

@RestController
@RequestMapping("/")
public class MyController {
	@Autowired
	private Matrix mat;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody MyRequest body) {
		SingleResult res = new SingleResult();
		Random ran = new Random();
		int c = body.get_c(), r = body.get_r();
		mat.setC(c);
		mat.setR(r);
		mat.getInit(ran);
		// mat = new Matrix(c, r, ran);
		res.setStatus("Success");
		res.setResult(mat.getDataForString());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "save", method = RequestMethod.GET)
	public ResponseEntity<?> save() {
		SingleResult res = new SingleResult();
		res.setStatus("Success");
		String msg = "";
		if (mat != null) {
			msg = mat.save();
		} else {
			res.setStatus("Fail");
			msg = "Please click create!";
		}
		if (!msg.equals("Success")) {
			res.setMessage(msg);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping("read")
	public ResponseEntity<?> read(@RequestBody MyRequest body) {
		SingleResult res = new SingleResult();
		res.setResult("Success");
//		if (mat == null) {
//			mat = new Matrix();
//		}
		mat.setC(body.get_c());
		mat.setR(body.get_r());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
