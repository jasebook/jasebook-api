package com.makersacademy.acebook.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import com.makersacademy.acebook.repository.PostRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;
import java.util.Properties;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	public void postHasContent() {
		LocalDateTime now = LocalDateTime.now();
		Post post = new Post("hello", now);
		assertThat(post.getContent(), containsString("hello"));
	}

	@Test
	public void test() {
		Post alex = new Post("alex", LocalDateTime.now());

		// when
		Post found = postRepository.save(alex);

		// then
		Post tan = new Post("tan", LocalDateTime.now());
		postRepository.save(tan);

		long i = 1;
		Optional<Post> byId = postRepository.findById(i);

		assertThat(byId.get(), equalTo(alex));
	}

}
