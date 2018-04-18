package com.boraji.tutorial.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hello")
   public String Add(@RequestParam("m") int m, @RequestParam("n") int n, @RequestParam("path") String path, @RequestParam("path_2") String path_2, Model model) throws Exception {
      model.addAttribute("m", m);
      model.addAttribute("n", n);
      
      if (path == "")
      {
    	  path = "E:\\matrix.txt";
      }
      
      if (path_2 == "")
      {
    	  path_2 = "E:\\matrix.txt";
      }  
      
      model.addAttribute("path", path);
      model.addAttribute("path_2", path_2);
      
      MyMatrix k = new MyMatrix (m,n,path);
      k.CreateAndSave();
      ReadMatrix l = new ReadMatrix(path_2); 
      model.addAttribute("show", l.Show());

      return "hello";
   }
}
