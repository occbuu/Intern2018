package com.mymatrix.oop.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymatrix.oop.utl.Matrix;

@Controller
@RequestMapping("/aabb")

public class MainController {
	
	@RequestMapping("")
	public String index() {
		return "addNum";
	}

	@PostMapping("/createMatrix")
	public String Add(@RequestParam("a") int m, @RequestParam("b") int n, @RequestParam("path") String path,
			@RequestParam("path2") String path2, Map<String, Object> model) throws Exception {

		Matrix k = new Matrix(m, n, path);
		String showMatrix = readMatrix(k.getData(), m, n);
		model.put("matrix", showMatrix);
		String showMatrix2 = k.read(path2);
		model.put("matrix2", showMatrix2);
		k.save();
		return "matrixList";
	}

	private String readMatrix(int[][] a, int m, int n) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				str.append(a[i][j] + " ");
			}
			str.append("<br/>");
		}
		return str.toString();
	}

}
