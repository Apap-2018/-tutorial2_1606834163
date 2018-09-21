package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false) Integer param1 , @RequestParam(value = "b", required = false) Integer param2, Model model) {
		String hasil="";
		if(param1 == null) {
			param1=0;
		}
		if(param2 == null) {
			param2=0;
		}
		if(param1 == 0 && param2 == 0 || param1 == 1 && param2 == 1) {
			hasil = "hm";
		}
		else {
			String hasilSem ="";
			if(param1 == 0 || param1 ==1) {
				for (int i=0; i<param2 ; i++) {
					hasilSem += "hm ";
				}
				hasil = hasilSem;
			}
			else {
				String hm ="h";
				for (int i = 0; i < param1; i++) {
					hm += "m";
				}
				
				for (int i = 0; i< param2; i++) {
					hasilSem += hm + " ";
				}
				
				hasil = hasilSem;
			}
			
		}
		model.addAttribute("hasil", hasil);
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		return "generator";
		
	}

}
