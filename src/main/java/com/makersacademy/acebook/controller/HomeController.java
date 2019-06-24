package com.makersacademy.acebook.controller;

import com.google.gson.JsonObject;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private PostRepository postRepository;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("/api/posts/desc", produces="application/json")
	@ResponseBody
	public String posts() {
		List<Post> allOrderByPostedTimeDesc = postRepository.findAllOrderByPostedTimeDesc();
		System.out.println(allOrderByPostedTimeDesc);
		return allOrderByPostedTimeDesc;
	}


}
