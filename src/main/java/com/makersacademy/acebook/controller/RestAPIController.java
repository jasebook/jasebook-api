package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

	@Autowired
	private PostRepository postRepository;
	@RequestMapping(
			value = "findall",
			method = RequestMethod.GET,
			produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
			headers = "Accept=application/json"
	)
	public ResponseEntity<Iterable<Post>> getPostsSort() {
		try {
			return new ResponseEntity<>(postRepository.findAllOrderByPostedTimeDesc(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
//	@RequestMapping(value = "/api/posts", method = GET)
//	public Post getPosts() {
//		List<Post> allOrderByPostedTimeDesc = postRepository.findAllOrderByPostedTimeDesc();
//		return new ResponseEntity<Iterable<Post>>;
//	}

}