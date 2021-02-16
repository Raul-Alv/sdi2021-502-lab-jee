package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Controller
public class ProfessorsController {

	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/professor/list")
	public String getList(Model model) {
		model.addAttribute("professorList", professorService.getProfessors());
		return "professor/list";
	}
	
	@RequestMapping(value="/professor/add", method=RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor professor) {
		professorService.addProfessor(professor);
		//professorService.addProfessor(new Professor("32165488M", "Carla", "Perez Iglesias", "Informatica"));
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/professor/details/{dni}" )
	public String getDetail(Model model, @ModelAttribute String dni) {
		model.addAttribute("professor", professorService.getProfessor(dni));
		return "professor/details";
	}
	
	@RequestMapping("/professor/delete/{dni}" )
	public String deletePorfessor(@ModelAttribute String dni) {
		professorService.deleteProfessor(dni);
		return "redirect:/mark/list";
	}
	@RequestMapping(value="/professor/add")
	public String getProfessor(){
		return "professor/add";
	}
}
