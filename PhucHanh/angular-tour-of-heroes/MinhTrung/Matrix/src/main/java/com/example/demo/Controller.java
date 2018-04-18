package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/")
public class Controller {
	Matrix matrix;

	@RequestMapping(value = "/")
	public String home(@RequestParam(name = "matrix", required = false) int a[][], Model model) {
		matrix.createRandomMatrix();
		model.addAttribute("matrix", a);

		model.addAttribute("col", matrix.getCols());
		model.addAttribute("row", matrix.getRows());
		return "home";
	}

}
