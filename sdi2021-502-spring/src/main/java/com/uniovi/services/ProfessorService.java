package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorsRepository;
	
	public List<Professor> getProfessors(){
		List<Professor> professors = new ArrayList<Professor>();
		professorsRepository.findAll().forEach(professors::add);
		return professors;

	}
	
	public Professor getProfessor(String dni){
		return professorsRepository.findById(dni).get();
	}
	
	public void addProfessor(Professor professors){
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		professorsRepository.save(professors);
	}
	
	public void deleteProfessor(String dni){
		professorsRepository.deleteById(dni);
	}
}
