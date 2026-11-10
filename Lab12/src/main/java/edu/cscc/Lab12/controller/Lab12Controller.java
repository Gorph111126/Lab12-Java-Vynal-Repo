package edu.cscc.Lab12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.cscc.Lab12.model.VinalRecord;
import edu.cscc.Lab12.repository.VinalRecordRepository;
import jakarta.validation.Valid;

/*
 * @author Alexander Granville
 * @version 4/28/24
 */

@Controller
public class Lab12Controller {
	@Autowired
	VinalRecordRepository repo;
	

	//get /records
	@GetMapping("/records")
	public String getAllRecords(Model model) {
		var vinal = repo.findAll();
		model.addAttribute("allRecords", vinal);
		return "allRecordsPage";
	}
	
	
	//get /records/{id}
	@GetMapping("/records/{id}")
	public String getSingleRecord(@PathVariable long id, Model model) {
		model.addAttribute("oneRecord", repo.findById(id).get());
		return "recordPage";
	}
	//post /records - create new record
	@PostMapping("/records")
	public String postProfile(@Valid @ModelAttribute("newRecord")VinalRecord newRecord, BindingResult bResult) {
		if (bResult.hasErrors()) {
			System.out.println("Can't Validate");
			return "addNewRecordPage";
		}else {
			VinalRecord thisRecord = repo.save(newRecord);
			System.out.println("Validated + Created");
			return "redirect:/records/" + thisRecord.getId();
		}
	}
	

	
	//get /add-records
	@GetMapping("/add-record")
	public String allowNewRecordInput (Model model) {
	model.addAttribute("newRecord", new VinalRecord());
		return "addNewRecordPage";
	}
}
