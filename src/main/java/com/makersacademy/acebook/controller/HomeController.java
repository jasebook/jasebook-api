package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@Autowired
	private PostRepository postRepository;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}


}

