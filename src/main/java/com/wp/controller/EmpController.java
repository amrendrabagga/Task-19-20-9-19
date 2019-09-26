package com.wp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entity.Emp;
import com.wp.service.EmpCRUDService;

@Controller
public class EmpController {

	@Autowired
	EmpCRUDService empCRUDService;
	
	@RequestMapping("home")
	public String showHome() {
		return "index.jsp";
	}
	@RequestMapping("/dataentry")
	public ModelAndView showDataEntryForm() {
		ModelAndView mv = new ModelAndView("EmpEntry");
		Emp emp = new Emp();
		mv.addObject("emp", emp);
		
		return mv;
	}
	
	@RequestMapping("SaveEmp")
	public ModelAndView saveEmp(@Validated @ModelAttribute("emp") Emp empModel,BindingResult bindingResult) {
		 
		ModelAndView mv ;
		if(bindingResult.hasErrors()) {
			mv = new ModelAndView("EmpEntry");
			Optional<FieldError> opt = Optional.ofNullable(bindingResult.getFieldError("eno"));
			if(opt.isPresent())
				if(opt.get().getCode().equals("typeMismatch"))
				bindingResult.rejectValue("eno", "emp.eno", "invalid number");//custom message for error in eno
			return mv;
		}
			
		mv= new ModelAndView("success");
		Emp emp = new Emp();
		emp.setEno(empModel.getEno());
		emp.setEname(empModel.getEname());
		emp.setDesignation(empModel.getDesignation());
		emp.setSalary(empModel.getSalary());
		emp.setDept(empModel.getDept());
		
		empCRUDService.saveEmp(emp);
		return mv;
		
	}
	
	@RequestMapping("datafetch")
	public ModelAndView fetchAllEmp() {
		List<Emp> list = empCRUDService.getAllEmp();

		ModelAndView mv = new ModelAndView("DisplayEmp");
		mv.addObject("empList",list);
		
		return mv;	
	}
	@RequestMapping("datasearch")
	public String fetchEmp() {
		return "SearchEmp";
	}
	@PostMapping("GetEmp")
	public ModelAndView searchEmp(@RequestParam("eno") int eno) {
		Emp emp = empCRUDService.searchEmp(eno);
		ModelAndView mv = new ModelAndView("SearchEmp");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@GetMapping("updateEmp")//first get request
	public ModelAndView updateDelete(@RequestParam int eno) {
		Emp emp = empCRUDService.searchEmp(eno);
		ModelAndView mv=new ModelAndView("update");
		mv.addObject("emp",emp);
		List<String> departments = new ArrayList<>();
		departments.add("SDE");departments.add("HR");departments.add("Engineer");
		departments.add("System Architecture");departments.add("DEV OPS");
		mv.addObject("depts", departments);
		return mv;	
	}
	
	@PostMapping("UpdateEmp")//form submission for updation
	public ModelAndView updateEmp(@ModelAttribute("emp") @Validated Emp empModel,BindingResult bindingResult) {
		System.out.println("hello from controleer ==============");
		ModelAndView mv=null;
		if(bindingResult.hasErrors()) {
			System.out.println("hello from controller");
			mv = new ModelAndView("update");
			List<String> departments = new ArrayList<>();
			departments.add("SDE");departments.add("HR");departments.add("Engineer");
			departments.add("System Architecture");departments.add("DEV OPS");
			mv.addObject("depts", departments);
	        
//			bindingResult.rejectValue("salary", "emp.salary", "invalid number");
			return mv;
		}
		mv = new ModelAndView("redirect:datafetch");
		System.out.println(empModel);
		empCRUDService.updateEmp(empModel);
		
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteEmp(@RequestParam("eno") int eno) {
		ModelAndView mv = new ModelAndView("redirect:datafetch");
		Emp emp = empCRUDService.searchEmp(eno);
		System.out.println(emp.getEno());
		mv.addObject("empInfo",emp);
		empCRUDService.deleteEmp(emp);
		
		return mv;
	}
	@ExceptionHandler({Exception.class})//this is show error page whenever any exception is encountered in this controller
	private String numberError(Exception e,Model model)
	{
		model.addAttribute("msg", e.getClass().getSimpleName());
	   return "error";//this will render to error page that display exception type
	}
}
