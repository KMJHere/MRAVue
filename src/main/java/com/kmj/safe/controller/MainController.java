package com.kmj.safe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.kmj.safe.service.MainService;

import org.springframework.ui.Model;

@Controller
public class MainController {
	@Autowired 
	MainService mainService;
	
	@RequestMapping("/")
	public String loadMain(Model model) {
		return "main";
	}
}
