package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.context.request.*;
import com.example.demo.Matrix;

@RequestMapping(value = "/")
public class Controller {

	Matrix matrix = new Matrix(3, 3);

	@RequestMapping(value = "/")
	public String home(@RequestParam(name = "matrix", required = false) int a[][], Model model) {
		matrix.createRandomMatrix();
		model.addAttribute("matrix", a);

		model.addAttribute("col", matrix.getNoCols());
		model.addAttribute("row", matrix.getNoRows());
		return "home";
	}

}
