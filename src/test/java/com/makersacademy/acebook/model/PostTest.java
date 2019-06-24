package com.makersacademy.acebook.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDateTime;

public class PostTest {

	@Test
	public void postHasContent() {
		LocalDateTime now = LocalDateTime.now();
		Post post = new Post("hello", now);
		assertThat(post.getContent(), containsString("hello"));
	}

}
