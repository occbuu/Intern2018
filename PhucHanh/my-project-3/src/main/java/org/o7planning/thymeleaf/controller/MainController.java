package org.o7planning.thymeleaf.controller;

import java.util.Map;

import org.o7planning.thymeleaf.model.Matrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/aabb")
public class MainController {

	@RequestMapping("")
	public String index() {
		return "addNum";
	}

	@PostMapping("/createMatrix")
	public String Add(@RequestParam("a") int m, @RequestParam("b") int n, @RequestParam("path") String path,
			 @RequestParam("path2") String path2,Map<String, Object> model) throws Exception {
		// model.addAttribute("x", m);
		// model.addAttribute("x", n);
		//
		// if (path_2 == "") {
		// path_2 = "E:\\matrix.txt";
		// }
		//
		// model.addAttribute("path", path);
		// model.addAttribute("path_2", path_2);
		//
		// Matrix k = new Matrix(m, n, path);
		// k.RandomizeAndSave();
		// Read l = new Read(path_2);
		// model.addAttribute("show", l.Show());
		Matrix k = new Matrix(m, n, path);
		String showMatrix = readMatrix(k.getMatrix(), m, n);
		model.put("matrix", showMatrix);
		String showMatrix2 = k.Read(path2);
		model.put("matrix2", showMatrix2);
		k.Save();
		return "matrixList";
	}
	private String readMatrix(int[][] a,int m, int n) {
		StringBuilder str = new StringBuilder();
		for(int i =0 ; i<m;i++) {
			for(int j = 0; j<n;j++) {
				str.append(a[i][j] + " ");
			}
			str.append("<br/>");
		}
		return str.toString();
	}
}
