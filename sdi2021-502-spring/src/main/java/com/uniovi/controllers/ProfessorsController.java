package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.entities.User;
import com.uniovi.services.ProfessorService;
import com.uniovi.validators.AddProfessorValidator;

@Controller
public class ProfessorsController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private AddProfessorValidator professorValidator;
	
	@RequestMapping("/professor/list")
	public String getList(Model model) {
		model.addAttribute("professorList", professorService.getProfessors());
		return "professor/list";
	}
	
	@RequestMapping(value="/professor/add", method=RequestMethod.GET)
	public String setProfessor(Model model) {
		model.addAttribute("professor", new Professor());
		return "professor/add";
	}
	
	@RequestMapping(value="/professor/add", method=RequestMethod.POST)
	public String setProfessor(@Validated Professor professor, BindingResult result) {
		professorValidator.validate(professor, result);
		if(result.hasErrors()) {
			return "professor/add";
		}
		professorService.addProfessor(professor);
		//professorService.addProfessor(new Professor("32165488M", "Carla", "Perez Iglesias", "Informatica"));
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/professor/details/{id}" )
	public String getDetail(Model model, @PathVariable long id) {
		model.addAttribute("professor", professorService.getProfessor(id));
		return "professor/details";
	}
	
	@RequestMapping("/professor/delete/{dni}" )
	public String deletePorfessor(@ModelAttribute long id) {
		professorService.deleteProfessor(id);
		return "redirect:/mark/list";
	}
	@RequestMapping(value="/professor/add")
	public String getProfessor(){
		return "professor/add";
	}
	
	@RequestMapping(value="/professor/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		Professor professor = professorService.getProfessor(id);
		model.addAttribute("professor", professor);
		return "professor/edit";
	}
	
	@RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Professor professor){
		Professor original = professorService.getProfessor(id);
		original.setNombre(professor.getNombre());
		original.setApellidos(professor.getApellidos());
		original.setCategoria(professor.getCategoria());
		professorService.addProfessor(original);
		return "redirect:/professor/details/"+id;
	}
}
