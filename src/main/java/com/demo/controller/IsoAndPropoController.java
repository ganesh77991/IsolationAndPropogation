package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.IsoAndPropoDao;
import com.demo.model.Employee;
@Controller
@ResponseBody
public class IsoAndPropoController {

	@Autowired
	IsoAndPropoDao dao;
	
	
	@RequestMapping("/test")
	public String test() {
		
		return dao.toString();
	}
	
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String regiester(@RequestBody Employee emp) {
		
		Employee employee=dao.reg(emp);
		
		return employee.getId()+" data saved successfully...";
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody Employee emp) {
		
		Employee employee=dao.update(emp);
		
		return employee.getId()+"data is updated";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		dao.delete(id);
		
		return id+"deleted successfully...";
	}
	
	@RequestMapping("/getall")
	public List<Employee> getData() {
		
		return dao.getAll();
	}
}
