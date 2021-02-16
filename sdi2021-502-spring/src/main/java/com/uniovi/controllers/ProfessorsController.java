package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorsController {

	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/professor/list")
	public String getList() {
		return professorService.getProfessors().toString();
	}
	
	@RequestMapping(value="/professor/add")
	public String setProfessor(@ModelAttribute Professor professor) {
		professorService.addProfessor(professor);
		return "Ok";
	}
	
	@RequestMapping("/professor/details/{dni}" )
	public String getDetail(@ModelAttribute String dni) {
		return professorService.getProfessor(dni).toString();

	}
	
	@RequestMapping("/professor/delete/{dni}" )
	public String deletePorfessor(@ModelAttribute String dni) {
		professorService.deleteProfessor(dni);
		return "Ok";
	}
}
