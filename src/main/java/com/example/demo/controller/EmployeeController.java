package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	

	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/addEmp")
	public ModelAndView addEmp(Employee emp,MultipartFile file) {
		String status = "Added Successfully";
		try {
			System.out.println("from our  "+file.getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Employee check = repo.findByname(emp.getName());
		String prefix ="data:image/jpg;base64,";
		String encoded = "";
		
		if(check == null) {
			
			try {
				
				 encoded = new String(Base64.encodeBase64(file.getBytes()),"UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			emp.setImage(prefix+encoded);
			repo.save(emp);
			
		}else {
			status = "Already Exists";
		}
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("status",status);
		
		return mv;
		
	}
	
	@RequestMapping("/employee")
	@ResponseBody
	public String getAllEmployee() {
		
		return repo.findAll().toString();
	}
	
	@RequestMapping("/employee/{id}")
	@ResponseBody
	public String getEmployee(@PathVariable("id") int id) {
		
	return repo.findById(id).toString();
	}
	
	@RequestMapping("/profile")
	public ModelAndView getprofile(@RequestParam("id") int id) {
		Employee profile = repo.findByEmpid(id);
		
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("pic",profile.getImage());
		
		return mv;
	}
	
	
	
}
